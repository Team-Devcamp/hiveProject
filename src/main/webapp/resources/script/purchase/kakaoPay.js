$(function(){
    $('#purchaseBtn').on('click',function(){
        if(!confirm("상품을 주문하시겠습니까?")){
            return;
        }
        else{

        $.ajax({
            url: '/pay/kakaoPay',
            dataType: 'json',
            success:function(data){
                // alert(data.tid);
                var box=data.next_redirect_mobile_url;
                window.open(box, "_blank", "width=500,height=700");
            },
            error:function(err){
                alert(err);
            }
        });//ajax
        }
    });//onclick
});
