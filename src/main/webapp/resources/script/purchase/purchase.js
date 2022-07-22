
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
      alert("로그인안했네? 주문자정보없음");
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
         // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

         // 각 주소의 노출 규칙에 따라 주소를 조합한다.
         // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
         var addr = ''; // 주소 변수
         var extraAddr = ''; // 참고항목 변수

         //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
         if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            addr = data.roadAddress;
         } else { // 사용자가 지번 주소를 선택했을 경우(J)
            addr = data.jibunAddress;
         }
         // 우편번호와 주소 정보를 해당 필드에 넣는다.
         document.getElementById('zipcode').value = data.zonecode;
         document.getElementById("address").value = addr;
         // 커서를 상세주소 필드로 이동한다.
         document.getElementById("address_detail").focus();
      }
   }).open();
}