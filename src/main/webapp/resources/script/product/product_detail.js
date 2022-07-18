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

    /* 상위옵션 선택시 하위옵션 활성화 */
    option1.change(function(){
        option2.attr('disabled',false);
    });

    /* 하위옵션 선택시 선택상품 정보보기 & 옵션 초기화 */
    option2.change(function(){
        showSelectedOption();

        option1.children().prop('selected',false);
        // option2.attr('selected','option:first');
        option2.attr('disabled',true);
    });
});
/* 동적요소 처리시 & 고정영역으로잡기
$('.form-select-wrap').on('click',function(){
        $(this).children().next().attr('disabled',true);
});*/

/* 선택상품 정보 보여주기*/
function showSelectedOption(){
    let selectedProduct = $('.product-detail-form').html();

    let option1 = $('.form-select-wrap').children().val();
    let option2 = $('.form-select-wrap').children().next().val();

    let pdlContainer = $('.product-detail-list-container');
    pdlContainer.append(selectedProduct);
    pdlContainer.children().addClass('pro');

    $('.product-detail-list-container').children().last().children().next().children('dd#datail_option1').html(option1);
    $('.product-detail-list-container').children().last().children().next().children('dd#datail_option2').html(option2);
}

/* 상품 원가 */
let price = Number($('.product-detail-form').children().children().last().children().last().children('#cost').html());

/* 주문 수량 변화 */
$('.product-detail-list-container').on('click','#minus-button',function (){
    let qty = Number($(this).next().val());
    let subTotalPrice = qty * price;

    if(qty!=1){
        $('#minus-button').attr('disabled',false);
        $(this).next().val(qty-1);

        qty = Number($(this).next().val());
        subTotalPrice = qty * price;
        $(this).parent().parent().parent().parent().last().parent().children().last().children().last().children('#cost').html(subTotalPrice);
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

        //증가된 수량값 다시 읽어오기
        qty = Number($(this).prev().val());
        subTotalPrice = qty * price;
        $(this).parent().parent().parent().parent().last().parent().children().last().children().last().children('#cost').html(subTotalPrice);
    }
    else{
        alert("한번에 최대 구매수량은 5개 입니다.");
        return;
    }
});

/* 주문페이지로 이동 */
$('#orderBtn').on('click',function(){
    location.href='/purchase/page';
});