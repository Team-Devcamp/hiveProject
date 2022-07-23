// tab menu
const tabList = document.querySelectorAll('.tab_menu .list li');
const contents = document.querySelectorAll('.tab_menu .cont_area .cont')
let activeCont = ''; // 현재 활성화 된 컨텐츠 (기본:#tab1 활성화)

for(var i = 0; i < tabList.length; i++){
    tabList[i].querySelector('.btn').addEventListener('click', function(e){
        e.preventDefault();
        for(var j = 0; j < tabList.length; j++){
            // 나머지 버튼 클래스 제거
            tabList[j].classList.remove('is_on');

            // 나머지 컨텐츠 display:none 처리
            contents[j].style.display = 'none';
        }
        // 버튼 관련 이벤트
        this.parentNode.classList.add('is_on');

        // 버튼 클릭시 컨텐츠 전환
        activeCont = this.getAttribute('href');
        document.querySelector(activeCont).style.display = 'block';
    });
}

$(function (){
    /* hide tab menu */
    $('#tab2').hide();
    $('#tab3').hide();
    $('#tab4').hide();
    $('.product-detail-form').hide();

    let option1 = $('.form-select-wrap').children();
    let option2 = $('.form-select-wrap').children().next();

    option2.attr('disabled',true);

    option1.change(function(){
        option2.attr('disabled',false);
    });

    option2.change(function(){
        showSelectedOption();

        option1.children().prop('selected',false);
        option2.attr('disabled',true);
    });
});

/* 선택상품 정보 보여주기*/
function showSelectedOption(){
    let selectedProduct = $('.product-detail-form').html();

    let option1 = $('.form-select-wrap').children().val();
    let option2 = $('.form-select-wrap').children().next().val();

    //중복 추가X
    for (let i = 0; i < $('.product-detail-list-container').children().length; i++) {
        if (option1 == $('.pro dd[name=detail_option1]').eq(i).html() && option2 == $('.pro dd[name=detail_option2]').eq(i).html()) {
            return;
        }
    }

    let pdlContainer = $('.product-detail-list-container');
    pdlContainer.append(selectedProduct);
    pdlContainer.children().addClass('pro');

    $('.product-detail-list-container').children().last().children().next().children('dd#detail_option1').html(option1);
    $('.product-detail-list-container').children().last().children().next().children('dd#detail_option2').html(option2);
    totalPrice = totalPrice + price;
    $('#total_price').html(totalPrice);

}

/* 상품 원가 */
let price = Number($('.product-detail-form').children().children().last().children().last().children('#cost').html());
let totalPrice = 0;

/* 주문 수량 변화 */
$('.product-detail-list-container').on('click','#minus-button',function (){
    let qty = Number($(this).next().val());
    let subTotalPrice = qty * price;

    if(qty!=1){
        $('#minus-button').attr('disabled',false);
        $(this).next().val(qty-1);

        qty = Number($(this).next().val());
        subTotalPrice = qty * price;
        totalPrice = totalPrice - price;

        $(this).parent().parent().parent().parent().last().parent().children().last().children().last().children('#cost').html(subTotalPrice);
        $('#total_price').html(totalPrice);
    }
    else{
        return;
    }
});

$('.product-detail-list-container').on('click','#plus-button',function (){
    const MAX_QTY = 5; //최대구매수량 제한

    let qty = Number($(this).prev().val());
    let subTotalPrice = qty * price;

    if($(this).prev().val()!=MAX_QTY){
        $('#plus-button').attr('disabled',false);
        $(this).prev().val(qty+1);

        qty = Number($(this).prev().val());
        subTotalPrice = qty * price;
        totalPrice = totalPrice + price;

        $(this).parent().parent().parent().parent().last().parent().children().last().children().last().children('#cost').html(subTotalPrice);
        $('#total_price').html(totalPrice);
    }
    else{
        alert("한번에 최대 구매수량은 5개 입니다.");
        return;
    }

});

$('.product-detail-list-container').on('click','#delProBtn',function () {
    $(this).parent().parent().remove();
    totalPrice = totalPrice - Number($(this).parent().parent().children().last().children().last().children('#cost').html());
    $('#total_price').html(totalPrice);
});

$('#orderBtn').on('click',function(){
    let cnt = $('.pro').get();

    let qty = $('.pro input[name=quantity]').length;
    var qtyArr = new Array(qty);

    let option_color = $('.pro dd[name=detail_option1]').get();
    let option_size = $('.pro dd[name=detail_option2]').get();
    let subTotalPrice = $('.pro span[name=cost]').get();

    let colorArr = new Array(cnt);;
    let sizeArr = new Array(cnt);;
    let subTotalPriceArr = new Array(cnt);;
    let product_title = $('.product-title').html();

    for(var i=0; i<cnt.length; i++){
        qtyArr[i] = $('.pro input[name=quantity]').eq(i).val();
        console.log(qtyArr[i]+' '+ option_color[i].innerHTML+' '+option_size[i].innerHTML+' '+subTotalPrice[i].innerHTML);
        console.log();
        colorArr[i] = option_color[i].innerHTML;
        sizeArr[i] = option_size[i].innerHTML;
        subTotalPriceArr[i] = subTotalPrice[i].innerHTML;
    }//for

    if($('#total_price').html()!=0){
        var form = $('<form></form>');
        form.attr('action','/purchase/page')
        form.attr('method','post')
        form.appendTo('body');
        form.append($('<input type="hidden" value="'+qtyArr+'" name=qty>'));
        form.append($('<input type="hidden" value="'+colorArr+'" name=option_color>'));
        form.append($('<input type="hidden" value="'+sizeArr+'" name=option_size>'));
        form.append($('<input type="hidden" value="'+subTotalPriceArr+'" name=subTotalPrice>'));
        form.append($('<input type="hidden" value="'+totalPrice+'" name=total_price>'));
        form.append($('<input type="hidden" value="'+product_title+'" name=product_title>'));
        form.submit();
    }else{
        alert("상품을 선택해주세요.");
    }

});