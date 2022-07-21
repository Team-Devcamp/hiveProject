<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Created by
IntelliJ IDEA. User: Renee Date: 2022-07-12 Time: 오후 12:59 To change this
template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %> <%--<!DOCTYPE html>
<html lang="en">
  <head>
    --%>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="/css/common/reset.css" />
    <link rel="stylesheet" href="/css/product/product_detail.css" />
    <link rel="stylesheet" href="/css/product/product_review.css" />
    <link rel="stylesheet" href="/css/product/product_qna.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
    />
    <%--
  </head>
  <body>
    --%>

    <div class="product-container-wrap">
      <!--Product Container-->
      <div class="container">
        <section class="product">
          <div class="product-image-viewer">
            <div class="main-image">
              <img
                src="/image/product/product_detail/thumb.png"
                srcset="
                  /image/product/product_detail/thumb.png 1x,
                  /image/product/product_detail/thumb.png 2x
                "
                alt=""
              />
              <%--${productDto.product_thumb_nail}--%>
            </div>
            <ul class="view-list">
              <li class="view-item selected">
                <button type="button">
                  <img
                    src="/image/product/product_detail/thumb.png"
                    srcset="
                      /image/product/product_detail/thumb.png 1x,
                      /image/product/product_detail/thumb.png 2x
                    "
                    alt=""
                  />
                </button>
              </li>
              <li class="view-item">
                <button type="button">
                  <img
                    src="/image/product/product_detail/thumb.png"
                    srcset="
                      /image/product/product_detail/thumb.png 1x,
                      /image/product/product_detail/thumb.png 2x
                    "
                    alt=""
                  />
                </button>
              </li>
              <li class="view-item">
                <button type="button">
                  <img
                    src="/image/product/product_detail/thumb.png"
                    srcset="
                      /image/product/product_detail/thumb.png 1x,
                      /image/product/product_detail/thumb.png 2x
                    "
                    alt=""
                  />
                </button>
              </li>
            </ul>
          </div>

          <div class="product-content">
            <header class="product-header">
              <h1 class="product-title">${productDto.product_title}</h1>
              <dl class="product-misc">
                <div class="rate">
                  <dt aria-label="Rated 4 out of 5">
                    <span aria-hidden class="icon-star-active"></span>
                    <span aria-hidden class="icon-star-active"></span>
                    <span aria-hidden class="icon-star-active"></span>
                    <span aria-hidden class="icon-star-active"></span>
                    <span aria-hidden class="icon-star-inactive"></span>
                  </dt>
                  <dd>132 reviews</dd>
                </div>
                <div class="orders">
                  <dt aria-hidden>
                    <span class="icon-cart"></span>
                  </dt>
                  <dd>154 orders</dd>
                </div>
              </dl>
            </header>

            <strong class="product-price">
              ${productDto.product_price} 원
            </strong>

            <p class="product-desc">
              판매수량 최다 상품! <br />미니 하이버는 모든 상품 무료배송!<br />
              ${productDto.product_name}
            </p>

              <div class="form-options">
                <div class="form-select-wrap">
                  <%--옵션번호도 받아올지 고민--%>
                  <c:forEach items="${optionMap}" var="firstOption">
                    <select
                      class="form-select"
                      aria-label="Default select example"
                    >
                      <option value="${firstOption.key}" selected>
                        ${firstOption.key} 선택
                      </option>
                      <c:forEach
                        items="${firstOption.value}"
                        var="secondOption"
                      >
                        <option
                          value="${secondOption.option_detail_name}"
                          id="${secondOption.option_detail_id}"
                        >
                          ${secondOption.option_detail_name}
                        </option>
                      </c:forEach>
                    </select>
                  </c:forEach>
                </div>
              </div>

              <div class="stats-likes" id="stats_likes">
                  <dt>
                      <%--<i class="fa fa-heart-o" aria-hidden="true"></i>--%>
                      <i class="fa fa-heart" aria-hidden="true"></i>
                  </dt>
                  <dd class="hidden">찜</dd>
              </div>

              <div class="product-detail-form">
                <dl class="product-detail">
                  <div>
                    <dt>주문수량</dt>
                    <dd>
                      <div class="form-group form-quantity">
                        <%--<label for="quantity"> 주문수량 </label>--%>
                        <div class="combo-box">
                          <button
                            type="button"
                            id="minus-button"
                            aria-label="Decrease"
                          ></button>
                          <input readonly
                            type="number"
                            name="quantity"
                            id="quantity"
                            min="0"
                            max="10"
                            value="1"
                          />
                          <button
                            type="button"
                            id="plus-button"
                            aria-label="Increase"
                          ></button>
                        </div>
                      </div>
                    </dd>
                      <button type="button" id="delProBtn" class="del-selected-btn">x</button>
                  </div>

                  <div>
                    <dt>색상</dt>
                    <dd id="detail_option1" name="detail_option1">네이비</dd>
                  </div>
                  <div>
                    <dt>사이즈</dt>
                    <dd id="detail_option2" name="detail_option2">L(100)</dd>
                  </div>
                  <div>
                    <dt>금액</dt>
                    <dd id="sum_price">
                      <span id="cost" name="cost">${productDto.product_price}</span>
                    </dd>
                  </div>
                </dl>
              </div>


              <%-- 선택한상품 리스트--%>
              <form action="/purchase/page" method="POST" class="product-form" id="product_form">
                  <div class="product-detail-list-container"></div>
                      <div>
                        <dl class="total-price-wrap">
                          <dt class="total-price-text">결제 총 금액</dt>
                          <dd class="total-price">
                            <strong id="total_price">0</strong>원
                          </dd>
                        </dl>
                      </div>
                      <div>
                        <button type="button" class="form-submit">장바구니</button>
                        <br />
                        <button type="button" id="orderBtn" class="form-submit">
                          주문하기
                        </button>
                      </div>
              </form>
          </div>
        </section>
      </div>


      <%--탭--%>
      <div class="tab_menu">
        <ul class="list">
          <li class="is_on">
            <a href="#tab1" id="detailBtn" class="btn">상품정보</a>
          </li>
          <li>
            <a href="#tab2" id="reviewBtn" class="btn">리뷰</a>
          </li>
          <li>
            <a href="#tab3" id="qnaBtn" class="btn">Q&A</a>
          </li>
          <li>
            <a href="#tab4" class="btn">환불&교환정책</a>
          </li>
        </ul>

        <%--탭 내용 영역--%>
        <div class="cont_area">
          <%--탭1 상품정보--%>
          <div id="tab1" class="cont">
            <img
              src="/image/product/product_detail/tab1_detail_sample.jpg"
              alt="tab1-image"
            />
          </div>

            <%--탭2 상품리뷰--%>
            <div id="tab2" class="cont">

                <div class="review-wrap">
                    <%--리뷰샘플css작업해놓은것--%>
                    <div class="profile clearfix">
                        <img src="/image/product/product_detail/profile_image.png" alt="profile-image" class="profile-user" />
                        <div class="profile-content">
                            <h1>User Email ***</h1>
                            <strong>
                                option / color / size
                            </strong>
                            <p>
                                오버핏인게 너무 이뻐요! 회색도 추가구매 해야될 것 같아요. 무난해서 평상시에 입기 좋을것같네요.
                            </p>
                        </div>
                    </div>

                    <!--동적 리뷰 리스트 -->
                    <div class="product-review" id="product-review">
                    </div>
                </div>
            </div>

            <%--탭3 qna 게시판--%>
            <div id="tab3" class="cont">

                <div class="qna-container">
                    <%-- qna안내 이미지 --%>
                    <div class="qna">
                        <div class="qna-info" id="qna-info">
                            <em class="qnaTit">Q&amp;A</em>
                            <div class="ea">
                                <em id="qnaCount"><span id="qna_count"></span> Questions</em>
                                <p>상품에 대해서 궁금한 점이 있으시면 문의하여 주세요.<br>신속하고 정확하게 답변드리도록 하겠습니다.</p>
                            </div>
                            <c:if test="${sessionScope.user_email == null}">
                                <br><br>
                                <a href="#none" id="goToLogin">상품 문의</a>
                                <br><br><br>
                            </c:if>
                            <c:if test="${sessionScope.user_email != null }">
                            <a href="#none" id="regQnaBtn">상품 문의</a>
                            </c:if>
                        </div>
                    </div>

                    <%--질문등록Form--%>
                    <div id="qna_container" class="hidden">
                        <div id="qna_write">
                            <form id="qna_form">
                                <div>
                                    <label for="qna_title">제목</label>
                                    <input type="text" name="qna_title" id="qna_title" required/>
                                </div>
                                <div>
                                    <label for="qna_content">내용</label>
                                    <textarea name="qna_content" id="qna_content" required></textarea>
                                </div>
                                <div class="qnaSubmitBtn">
                                    <button id="qnaSubmitBtn" type="button">등록하기</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <%--qna header--%>
                    <div class="qna-list">
                        <table class="qna-table">
                            <colgroup>
                                <col width="50px">
                                <col width="*">
                                <col width="130px">
                                <col width="100px">
                                <col width="122px">
                                <col width="102px">
                            </colgroup>
                            <tbody>
                            <tr class="tit">
                                <th>번호</th>
                                <th>제목</th>
                                <th>공개여부</th>
                                <th>작성자</th>
                                <th>등록일</th>
                                <th>답변상태</th>
                            </tr>

                            </tbody>
                        </table>

                        <%--qna List--%>
                        <table class="qna-table">
                            <div id="qnaShowList"></div>

                            <div class="qna-paging">
                                <div id="qnaPagingDiv"></div>
                            </div>
                        </table>
                    </div>
                </div>
            </div>




            <div id="tab4" class="cont">
            <p>
              <img
                src="/image/product/product_detail/tab4_refund_sample.jpg"
                alt="tab1-image"
              />
            </p>
          </div>
        </div>
      </div>
    </div>

    <script
      type="text/javascript"
      src="http://code.jquery.com/jquery-3.6.0.min.js"
    ></script>
    <script
      type="text/javascript"
      src="/script/product/product_detail.js"
    ></script>
    <script
      type="text/javascript"
      src="/script/product/product_qna.js"
    ></script>
    <%--
  </body>
  --%> <%--
</html>
--%>
<script type="text/javascript">
  //review
  // $(document).ready(function() {
  $("#reviewBtn").click(function () {
    $.ajax({
      type: "get",
      url: "/product/review",
      data: "product_id=" + 1,
      success: function (data) {
        alert(JSON.stringify(data));
      },
      error: function (err) {
        console.log(err);
      },
    });
  });
  // });
</script>
