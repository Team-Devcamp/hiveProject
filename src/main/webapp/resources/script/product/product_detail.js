/* hide tab menu */
$(function (){
    $('#tab2').hide();
    $('#tab3').hide();
    $('#tab4').hide();
    $('.product-detail-form').hide();
});

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

/* 상위옵션 선택시 하위옵션 활성화 */
$(function(){

    let option1 = $('.form-select-wrap').children();
    let option2 = $('.form-select-wrap').children().next();

    option2.attr('disabled',true);

    option1.change(function(){
        option2.attr('disabled',false);
    });

    /* 하위옵션 선택시 선택상품 정보보기 & 옵션 초기화 */
    option2.change(function(){
        showSelectedOption();
        // alert("초기화해줘");

        option1.children().prop('selected',false);
        // option2.attr('selected','option:first');
        option2.attr('disabled',true);
    });
});
/*$(function(){
    $('.form-select-wrap').children().next().attr('disabled',true);

    $('.form-select-wrap').children().change(function(){
        $(this).next().attr('disabled',false);
    });

    /!* 하위옵션 선택시 옵션 초기화 *!/
    $('.form-select-wrap').children().next().change(function(){
        $(this).next().attr('disabled',false);
    });
});*/
/* 동적요소 처리시 & 고정영역으로
$('.form-select-wrap').on('click',function(){
        $(this).children().next().attr('disabled',true);
});*/


/* 선택상품 정보 보여주기*/
/*function showSelectedOption(){ //기존코드
    // $('.form-select-wrap').children().next().change(function(){
        $('.product-detail').show();
        // alert($('.form-select option:selected').val());
        let option1 = $('.form-select-wrap').children().val();
        let option2 = $('.form-select-wrap').children().next().val();
        // alert(option1 +' '+option2);
        $('#datail_option1').html(option1);
        $('#datail_option2').html(option2);
    // });
}*/

function showSelectedOption(){ //수정코드
    let selectedProduct = $('.product-detail-form').html();

    alert(selectedProduct);

    let option1 = $('.form-select-wrap').children().val();
    let option2 = $('.form-select-wrap').children().next().val();
    alert(option1 +' '+option2);

    let pdlContainer = $('.product-detail-list-container');
    pdlContainer.append(selectedProduct);
    pdlContainer.children().addClass('pro');
    // $('.pro #datail_option2').html(option2);

    $('.product-detail-list-container').children().last().children().next().children('dd#datail_option1').html(option1);
    $('.product-detail-list-container').children().last().children().next().children('dd#datail_option2').html(option2);

}



/* 상품 원가 */
const price = Number($('#sum_price').children().html());

/* 주문 수량 변화 */
$('.combo-box #minus-button').on('click',function(){
    let qty = Number($(this).next().val());
    let totalPrice = qty * price;

    if(qty!=1){
        $('#minus-button').attr('disabled',false);
        $('#minus-button').next().val(qty-1);

        qty = Number($(this).next().val());
        totalPrice = qty * price;
        $('#sum_price').html(totalPrice);
        // alert("수량감소"+ qty +"*"+ price +"="+totalPrice);
    }
    else{
        return;
    }
});

$('.plus-button').on('click',function(){
    let qty = Number($(this).prev().val());
    let totalPrice = qty * price;
    // alert("기본수량"+ qty +"*"+ price +"="+totalPrice);

    if($(this).prev().val()==5){
        alert("한번에 최대 구매수량은 5개 입니다.");
        $('#plus-button').attr('disabled',true);
    }
    else{
        $('#plus-button').attr('disabled',false);
        $(this).prev().val(qty+1);

        //증가된 수량값 다시 읽어오기
        qty = Number($(this).prev().val());
        totalPrice = qty * price;
        $('#sum_price').html(totalPrice);
        // alert("수량증가"+ qty +"*"+ price +"="+totalPrice);
    }
});

$('.stats-likes').hover(function(){
    $(this).attr('src','./img/javascript_on.jpg');
}, function(){
    $(this).attr('src','./img/javascript.jpg');
});

$('#orderBtn').on('click',function(){
    location.href='/purchase/page';
});
