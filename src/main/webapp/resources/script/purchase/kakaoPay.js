$(function(){
    $('#purchaseBtn').on('click',function(){

        if($('#user_name').val()==null){
            alert("이름을 입력하세요");
        }
        if($('#b_tel').val()==null){
            alert("주문자번호를 입력하세요");
        }
        if($('#user_email').val()==null){
            alert("이메일을 입력하세요");
        }

        if($('#receiver_name').val()==null){
            alert("수령인 성함을 입력하세요");
        }
        if($('#address_detail').val()==null){
            alert("상세주소를 입력하세요");
        }
        if($('#receiver_phone').val()==null){
            alert("수령인 전화번호를 입력하세요");
        }


        if(!confirm("상품을 주문하시겠습니까?")){
            return;
        }
        else{

        $.ajax({
            url: '/pay/kakaoPay',
            dataType: 'json',
            success:function(data){
                // alert(data.tid);
                var box=data.next_redirect_pc_url;
                window.open(box, "_blank", "width=500,height=700");
            },
            error:function(err){
                alert(err);
            }
        });//ajax
        }
    });//onclick
});
