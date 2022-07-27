
$(function(){
   $('#my_request_message').hide();
   sessionStorage.setItem('user_email', $('input[name=user_email]').val());
   if(window.sessionStorage.getItem('user_email')!=null){
      $.ajax({
         type: 'get',
         url: '/purchase/purchaser',
         success:function(data){
            console.log(data)
            $('#user_name').val(data.user_name);
            $('#b_tel').val(data.user_phone);
            $('#user_email').val(data.user_email);
         }
      });
   }else{
      // alert("주문자정보없음");
   }
});

$('#request_message').on('change',function(){
   let requestMsg = $('#request_message option:selected').val();
   if(requestMsg=='직접 입력'){
      $('#my_request_message').show();
   }else{
      $('#my_request_message').hide();
   }

});

//DAUM 우편번호
function checkPost() {
   new daum.Postcode({
      oncomplete: function(data) {
         var addr = ''; // 주소 변수

         if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            addr = data.roadAddress;
         } else { // 사용자가 지번 주소를 선택했을 경우(J)
            addr = data.jibunAddress;
         }
         document.getElementById('zipcode').value = data.zonecode;
         document.getElementById("address").value = addr;
         document.getElementById("address_detail").focus();
      }
   }).open();
}

$('#changeAddr').on('click',function(){
   // window.open('/mypage/address/list', "_blank", "width=500,height=700");
});