<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>FAQ</title>
    <link href="<c:url value='/css/faq/faq.css'/>" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<!-- Header -->

<section class="faq">
    <div class="page-title">
        <div class="container">
            <h3>자주묻는 질문</h3>
        </div>
        <div class="small-page-title">
            * 문의 전에 꼭 자주묻는 질문을 확인해주세요.
        </div>
    </div>

    <div class="faq-content">
        <div class="faq-title">
            <h2>취소/환불/교환 관련</h2>
        </div>

        <div>
            <ul>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>주문을 취소하고 싶어요!</div>
                    <div class="li-div">
                        주문은 [MY 페이지] 메뉴에서 직접 취소 가능합니다.<br><br><br>
                        - 결제대기/결제완료/상품준비중 : 고객님께서 직접 주문취소 가능한 상태<br><br>
                        - 배송준비중 : 스토어 배송 준비 기간으로 결제일로부터 3영업일(주말/공휴일 제외)간 즉시 주문취소 불가 상태
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>상품을 환불하고 싶어요!</div>
                    <div class="li-div">
                        교환/반품 모두 하이버 APP 내의 [교환/환불요청] 버튼을 클릭 후 진행 가능합니다.<br><br><br>
                        - 환불을 원하실 경우 [교환/환불요청] ▶ [사유:환불] 접수로 진행 바랍니다.<br><br><br>
                        - 환불/교환 요청 접수 시 자동택배 회수 시스템이 제공되지 않습니다.<br><br>
                        각 스토어마다 환불 및 교환의 규정에 차이가 있을 수 있어 구매한 스토어 고객센터로 직접 관련 문의 바랍니다.
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>상품을 교환하고 싶어요!</div>
                    <div class="li-div">
                        교환/반품 모두 하이버 APP 내의 [교환/환불요청] 버튼을 클릭 후 진행 가능합니다.<br><br><br>
                        - 교환을 원하실 경우 [교환/환불요청] ▶ [사유:교환] 접수로 진행 바라며, 교환 상품 수령 후 [환불요청 철회] 진행 하시면 됩니다.<br><br><br>
                        - 환불/교환 요청 접수 시 자동택배 회수 시스템이 제공되지 않습니다.<br><br>
                        각 스토어마다 환불 및 교환의 규정에 차이가 있을 수 있어 구매한 스토어 고객센터로 직접 관련 문의 바랍니다.
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>교환/반품시 택배비가 발송되나요?</div>
                    <div class="li-div">
                        무료배송은 구매한 상품이 최종적으로 [구매확정]되어야 제공되는 혜택입니다.<br><br>
                        반품 사유에 따라 배송비 지불 여부가 결정되며, 반품 시 스토어가 부담한 [초기 배송비+반품/교환] 왕복 배송비가 발생됩니다.<br><br><br>
                        1. 교환/반품 비용이 무료인 경우<br><br>
                        - 수령한 상품이 파손/불량이거나 상품이 잘못 배송된 경우에 해당 됩니다.<br><br><br>
                        2. 교환/반품 비용이 고객 부담인 경우<br><br>
                        - 고객 변심으로 인한 경우 비용이 발생됩니다.
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>환불은 언제 되나요?</div>
                    <div class="li-div">
                        [주문취소]<br><br>
                        주문 취소 완료일로부터 아래와 같이 소요됩니다.<br><br><br>
                        [환불완료]<br><br>
                        스토어측에서 반품 상품 입고/검수 후 하이버 측으로 [환불승인]이 접수되는 날로부터 아래와 같이 소요됩니다.
                    </div>
                </li>
            </ul>
        </div>
    </div>

    <div class="faq-content">
        <div class="faq-title">
            <h2>주문/결제/배송 관련</h2>
        </div>

        <div>
            <ul>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>현금영수증 발급은 어떻게 하나요?</div>
                    <div class="li-div">
                        현금 영수증은 결제하기 단계에서 신청 가능합니다.<br><br><br>
                        [현금 영수증 신청 방법]<br><br>
                        1) 결제하기 단계에서 현금 영수증 발행 가능한 결제수단 선택 ( 무통장입금 )<br><br>
                        2) [현금 영수증 발행 여부]에서 소득공제용, 지출증빙용 선택<br><br>
                        3) 번호 입력 후 주문
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>배송은 어떻게 진행되나요?</div>
                    <div class="li-div">
                        하이버는 다양한 스토어가 입점 되어 있는 플랫폼 서비스로<br><br>
                        예약 배송, 해외 배송, 주문제작 상품 및 입점 업체 배송 스케쥴에 따라 배송 기간은 다를 수 있습니다.<br><br>
                        스토어의 배송일정은 상품 상세페이지 혹은 주문정보에서 확인 가능합니다.<br><br><br>
                        - 상품 출고 후 국내배송 기준 2-4영업일 정도 배송기간이 소요되며, 택배사 내부사정에 따라 해당 기간은 변동될 수 있습니다.
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>주문한 상품과 다른 상품 또는 불량입니다!</div>
                    <div class="li-div">
                        먼저, 불편 드려 죄송합니다.<br><br>
                        교환·환불 중 원하시는 처리방향에 대하여 [교환/환불요청] 접수 통하여 신청 부탁드립니다<br><br>
                        이후 구매하신 하이버 내, 스토어 고객센터 또는 [상품 상세 페이지 ▶ Q&A]로 문의 바랍니다.<br><br>
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>주문 내역을 확인하고 싶어요!</div>
                    <div class="li-div">
                        [주문 내역 확인]은 아래와 같습니다.<br><br>
                        1) 로그인을 합니다.<br><br>
                        2) APP ▶ 하단 오른쪽 사람 모양 아이콘 클릭 / WEB ▶ 상단 오른쪽 사람 모양 아이콘 클릭<br><br>
                        3) 주문/배송조회에서 확인 가능합니다.
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>주문 후 결제 수단을 변경할 수 있나요?</div>
                    <div class="li-div">
                        주문 완료 후 결제 수단 변경은 불가합니다.<br><br>
                        결제 수단 변경을 원하실 경우 상품 주문 취소 후 재주문 진행 바랍니다.<br><br><br>
                        - 결제완료/상품준비 : 직접 주문 취소 ( MY 페이지 ▶ 주문/배송조회 )<br><br>
                        - 배송준비 : 구매하신 스토어로 취소 요청 문의<br><br>
                        - 배송중/배송완료 : 취소 불가하여 반품 후 재주문 진행 ( 단, 반품배송비 발생 )<br><br>
                        - 구매확정 : 불가
                    </div>
                </li>
            </ul>
        </div>
    </div>

    <div class="faq-content">
        <div class="faq-title">
            <h2>회원정보 관련</h2>
        </div>

        <div>
            <ul>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>회원탈퇴는 어떻게 하나요?</div>
                    <div class="li-div">
                        [탈퇴방법]<br><br>
                        APP : 로그인 ▶ 마이페이지 ▶ 설정 ▶ 탈퇴하기 ▶ 본인인증을 통하여 탈퇴<br><br>
                        WEB : 로그인 ▶ 마이페이지 ▶ 본인인증을 통한 회원탈퇴<br><br><br>
                        - 모든 주문건이 종결된 상태(취소완료/환불완료/구매확정)에서만 탈퇴 처리가 가능합니다.<br><br>
                        - 회원탈퇴 시 재가입은 31일 이후에 가능하며 기존 아이디로 가입은 불가합니다.<br><br>
                        - 탈퇴 후 보유하셨던 포인트 및 쿠폰 모두 소멸 되는 점 유의 바랍니다.
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>비밀번호를 잊어버렸어요!</div>
                    <div class="li-div">
                        1) 하이버 이메일 계정으로 가입한 경우<br><br>
                        - 로그인 버튼 클릭 ▶ 아이디/비밀번호찾기 를 통해 가능합니다.<br><br>
                        - 계정 확인이 어려울 경우 하이버 고객센터 또는 카카오채널 [@하이버]로 문의 바랍니다.<br><br><br>
                        2) SNS연동 계정으로 가입한 경우(페이스북/구글/애플/네이버/카카오톡 가입자)<br><br>
                        - SNS 계정은 연동을 통한 회원가입으로 비밀번호 찾기가 불가합니다.<br><br>
                        - 로그인이 어려운 경우 하이버 고객센터 또는 카카오채널 [@하이버]로 문의 바랍니다.
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>비밀번호를 변경하고 싶어요!</div>
                    <div class="li-div">
                        비밀번호 변경은 하이버 앱을 로그인 하신 뒤 설정에서 변경 가능합니다.<br><br>
                        웹사이트 환경에서는 비밀번호 찾기 기능만 제공되고 있어, 변경은 불가하오니 앱을 설치하신 후 변경해주시기 바랍니다.<br><br><br>
                        또한, SNS 계정으로 가입한 고객님의 경우 비밀번호 변경은 되지 않으며,<br><br>
                        확인 및 변경을 희망하실 경우 하이버 고객센터 또는 카카오채널 [@하이버]로 문의 바랍니다.
                    </div>
                </li>
                <li>
                    <div class="ul-div"><i class="fa-solid fa-play"></i>로그인이 안돼요!</div>
                    <div class="li-div">
                        1) 아이디/비밀번호 분실<br><br>
                        - 아이디/비밀번호 찾기 진행 후 임시 비밀번호 발급 받아 주시기 바랍니다.<br><br><br>
                        2) SNS 연동 로그인 불가 (페이스북/구글/네이버/카카오톡/애플 가입자)<br><br>
                        - SNS 가입 계정은 SNS 내 정보 수정, 비활성, 탈퇴 등으로 인해 일시적 연동 해제가 발생▶연동된 하이버 계정 이용 불가<br><br>
                        - SNS 연동 로그인이 불가한 경우 하이버 고객센터 또는 카카오채널 [@하이버]로 문의 주시면 계정 전환 후 사용이 가능합니다.<br><br>
                        - 계정 전환 후 SNS 계정과는 무관하게 아이디/비밀번호 기입 후 로그인이 가능합니다.
                    </div>
                </li>
            </ul>
        </div>
    </div>
</section>

<!-- Footer -->

<script type="text/javascript">
    $(function () {
        $('.ul-div').on("click", function () {
            $(this).next().toggle();
        });
    });

</script>
</body>
</html>
