<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Renee
  Date: 2022-07-17
  Time: 오후 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/common/reset.css">
    <link rel="stylesheet" href="/css/purchase/purchase.css">
</head>
<body>

<div class="purchase-page">
    <div class="purchase-page-title">
        <h1>주문하기</h1>
    </div>


    <%--구매전체정보--%>
    <div class="purchase-container-wrap">

        <h2>주문 상품 정보</h2>
        <div class="product-info">
            <c:forEach items="${list}" var="items">
            <div class="product-item">
                <ul>
                    <li>
                        <div class="p-img">
                            <img src="/image/product/product_detail/profile_image.png">
                        </div>
                    </li>
                    <li>
                        <span>${product_title}</span><br>
                        <span>${items.option_color}/${items.option_size}</span><br>
                        <span>수량 : ${items.qty}개</span>
                    </li>
                    <li><span>${items.sub_total_price}</span>원</li>
                </ul>
            </div>
            </c:forEach>

            <div class="tot">총 결제 금액 : <strong>${total_price}</strong> 원</div>

        </div>


        <%--주문자정보관련div--%>
        <div class="product-buyer-wrap">
            <form>
                <input type="hidden" name="user_email" value="${user_email}" required>
                <h2>주문자 정보</h2>
                <div class="user-info">
                    <dl>
                        <dt>이름</dt>
                        <dd>
                            <input type="text" name="user_name" id="user_name" >
                        </dd>
                    </dl>
                    <dl>
                        <dt>휴대폰</dt>
                        <dd>
                            <input type="tel" name="user_phone" id="b_tel">
                        </dd>
                    </dl>
                    <dt>이메일</dt>
                    <dd>
                        <input type="text" id="user_email" required>
                    </dd>
                </div>

                <h2>배송지 정보</h2>
                <div class="delivery-info">
                    <dl>
                        <dt>수령인</dt>
                        <dd>
                            <input type="text" name="receiver_name" id="receiver_name" required>
                        </dd>
                        <dt>휴대폰</dt>
                        <dd>
                            <input type="text" name="user_phone" id="d_tel1" placeholder="010">-
                            <input type="text" name="user_phone" id="d_tel2" >-
                            <input type="text" name="user_phone" id="d_tel3">
                        </dd>
                        <dt>배송주소</dt>
                        <dd>
                            <input type="text" name="zipcode" id="zipcode" readonly>
                            <input type="button" value="우편번호검색" onclick="checkPost()"><br>
                            <input type="text" name="address" id="address" placeholder="주소" size="50" readonly><br>
                            <input type="text" name="address_detail" id="address_detail" placeholder="상세주소" size="50">
                        </dd>
                        <dt>배송메모</dt>
                        <dd>
<%--                            <input type="text" id="request_message" placeholder="배송시 요청메세지를 남겨주세요.">--%>
                            <select id="request_message" placeholder="배송시 요청메세지를 선택해주세요">
                                <option>배송시 요청메세지를 선택해주세요</option>
                                <option>문 앞에 놓아 주세요.</option>
                                <option>경비(관리)실에 맡겨 주세요.</option>
                                <option>택배함에 넣어 주세요.</option>
                                <option>직접 받겠습니다.</option>
                                <option>직접 입력</option>
                            </select>
                            <div><input type="text" name="my_request_message" id="my_request_message" ></div>
                        </dd>
                    </dl>

                </div>

            </form>
        </div>

        <%--결제관련div--%>
        <div class="product-price-wrap">
            <div>
                <h2>최종 결제 금액</h2>
                <div class="total-price">
                    <dl>
                        <dt>총 상품금액</dt>
                        <dd><span>${total_price}</span>원</dd>
                        <dt>배송비</dt>
                        <dd><span>0</span>원</dd>
                        <dt>총 결제예상 금액</dt>
                        <dd><span>${total_price}</span>원</dd>
                    </dl>
                </div>

                <h2>결제수단</h2>
                <div class="payment-method">
                    <input type="radio" checked id="pay-method">
                        <button type="button" id="kakaoPayBtn">KakaoPay</button>
                    </input>
                </div>
            </div>

            <div>
                <h2>구매조건/약관 및 개인정보 이용 동의</h2>
                <div class="agreement">
                    <div class="agreement-text">
                        <dl>
                            <div>
                            <dt>하이버 약관 동의</dt>
                            <dd>
                                <button type="button">내용보기</button>
                            </dd>
                            </div>
                            <div>
                            <dt>개인정보수집 및 이용에 대한 안내</dt>
                            <dd>
                                <button type="button">내용보기</button>
                            </dd>
                            </div>
                            <div>
                            <dt>구매조건 및 개인정보 제3자 제공</dt>
                            <dd>
                                <button type="button">내용보기</button>
                            </dd>
                            </div>
                        </dl>
                    </div>
                    <strong>
                        - 위 상품의 구매조건을 확인하였으며, 결제 및 개인 정보 제 3자 제공에 모두 동의합니다.
                    </strong>
                </div>
            </div>

        </div>

        <div class="purchase-btn">
            <button type="submit" id="purchaseBtn">주문하기</button>
        </div>

</div>

</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/script/purchase/purchase.js"></script>
<script type="text/javascript" src="/script/purchase/kakaoPay.js"></script>
</body>
</html>