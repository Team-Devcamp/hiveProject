<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Renee
  Date: 2022-07-12
  Time: 오후 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>
<html lang="en">
<head>--%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/common/reset.css">
    <link rel="stylesheet" href="/css/product/product_detail.css">
    <link rel="stylesheet" href="/css/product/product_review.css">
    <link rel="stylesheet" href="/css/product/product_qna.css">


<%--
</head>
<body>--%>


<div class="product-container-wrap">

    <!--Product Container-->
    <div class="container">
        <section class="product">
            <div class="product-image-viewer">
                <div class="main-image">
                    <img
                            src="/image/product/product_detail/thumb.png"
                            srcset="/image/product/product_detail/thumb.png 1x, /image/product/product_detail/thumb.png 2x"
                            alt=""
                    />
                    ${productDto.product_thumb_nail}
                </div>
                <ul class="view-list">
                    <li class="view-item selected">
                        <button type="button">
                            <img
                                    src="/image/product/product_detail/thumb.png"
                                    srcset="/image/product/product_detail/thumb.png 1x, /image/product/product_detail/thumb.png 2x"
                                    alt=""
                            />
                        </button>
                    </li>
                    <li class="view-item">
                        <button type="button">
                            <img
                                    src="/image/product/product_detail/thumb.png"
                                    srcset="/image/product/product_detail/thumb.png 1x, /image/product/product_detail/thumb.png 2x"
                                    alt=""
                            />
                        </button>
                    </li>
                    <li class="view-item">
                        <button type="button">
                            <img
                                    src="/image/product/product_detail/thumb.png"
                                    srcset="/image/product/product_detail/thumb.png 1x, /image/product/product_detail/thumb.png 2x"
                                    alt=""
                            />
                        </button>
                    </li>

                </ul>
            </div>

            <div class="product-content">
                <header class="product-header">
                    <h1 class="product-title">
                        ${productDto.product_title}
                        <br />
                        ${productDto.product_name}
                    </h1>
                    <dl class="product-misc">
                        <div class="rate">
                            <dt aria-label="Rated 4 out of 5">
                                <span aria-hidden class="icon-star-active"></span>
                                <span aria-hidden class="icon-star-active"></span>
                                <span aria-hidden class="icon-star-active"></span>
                                <span aria-hidden class="icon-star-active"></span>
                                <span aria-hidden class="icon-star-inactive"></span>
                            </dt>
                            <dd>
                                132 reviews
                            </dd>
                        </div>
                        <div class="orders">
                            <dt aria-hidden>
                                <span class="icon-cart"></span>
                            </dt>
                            <dd>
                                154 orders
                            </dd>
                        </div>
                    </dl>
                </header>

                <strong class="product-price">
                    ${productDto.product_price} 원
                </strong>

                <p class="product-desc">
                    [반바지 1+1/미친가격] 트레이닝 쿨링 반바지 남자 스포츠 헬스 츄리닝 밴딩 여름 팬츠 짐웨어<br>
                    ${productDto.product_name}
                </p>



                <form action="" method="POST" class="product-form">
                    <div class="form-options">
                        <div class="form-select-wrap">

                            <c:forEach items="${optionMap}" var="firstOption">

                                <select class="form-select" aria-label="Default select example">
                                    <option selected>${firstOption.key}을 선텍해 주세요</option>
                                        <c:forEach items="${firstOption.value}" var="secondOption">
                                            <option value="1">${secondOption.option_detail_name}</option>
                                        </c:forEach>
                                </select>

                            </c:forEach>
<%--
                            <option value="1">화이트</option>
                            <option value="2">베이지</option>
                            <option value="3">블랙</option>--%>

                            <%--<select class="form-select" aria-label="Default select example">
                                <option selected>사이즈를 선책해 주세요</option>
                                <option value="1">95</option>
                                <option value="2">100</option>
                                <option value="3">105</option>
                            </select>--%>

                        </div>


                        <div class="stats-likes">
                            <dt>
                                Likes
                            </dt>
                            <dd>
                                찜
                            </dd>
                        </div>

                        <div class="form-group form-quantity">
                            <label for="quantity">
                                주문수량
                            </label>
                            <div class="combo-box">
                                <button type="button" id="minus-button" aria-label="Add"></button>
                                <input type="number" name="quantity" id="quantity" min="0" max="10" value="1" />
                                <button type="button" id="plus-button" aria-label="Remove"></button>
                            </div>
                        </div>
                    </div>


                    <!--  선택한상품 + 수량선택콤보박스 + 금액 보여줘야할 곳
                  <dl class="product-detail">
                    <div>
                      <dt>
                        상품명
                      </dt>
                      <dd>
                        ABCDEF반바지
                      </dd>
                    </div>
                    <div>
                      <dt>
                        색상
                      </dt>
                      <dd>
                        네이비
                      </dd>
                    </div>
                    <div>
                      <dt>
                        사이즈
                      </dt>
                      <dd>
                        L(100)
                      </dd>
                    </div>
                  </dl>
                  -->


                    <button type="button" class="form-submit">
                        장바구니
                    </button>
                    <br>
                    <button type="submit" class="form-submit">
                        주문하기
                    </button>



                </form>

            </div>
        </section>
    </div>


    <!--탭-->
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
                <img src="/image/product/product_detail/tab1_detail_sample.jpg" alt="tab1-image" />
            </div>

            <%--탭2 상품리뷰--%>
            <div id="tab2" class="cont">

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


                <!--동적 리뷰목록 -->
                <div class="product-review" id="product-review">
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
                                <!-- //상품에 대해서 궁금한 점이 있으시면 문의하여 주세요.신속하고 정확하게 답변드리도록 하겠습니다. -->
                                <p>상품에 대해서 궁금한 점이 있으시면 문의하여 주세요.<br>신속하고 정확하게 답변드리도록 하겠습니다.</p>
                            </div>
                            <a href="#none" id="regQnaBtn">상품 문의</a><!-- //상품 문의 -->
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
                                <th>문의상태</th>
                            </tr>

                            </tbody>
                        </table>

                        <table class="qna-table">

                            <div id="qnaShowList"></div>

                            <div class="qna-paging">
                                <div id="qnaPagingDiv"></div>
                            </div>

                        </table>
                    </div>


                   <%--  <tr class="tit">
                         <td>1</td>
                         <td class="tal"><a href="#none">사이즈</a></td>
                         <td>
                             <span>비공개</span>
                         </td>
                         <td>zzang****@naver.com</td>
                         <td>2022.06.05</td>
                         <td>
                             <span>답변완료</span>
                         </td>
                     </tr>--%>
                    <%--<tr class="">
                        <td colspan="6">
                            <div class="qna-answer">
                                <div class="q">
                                    <em>${qnaDto.qna_content}</em>
                                </div>

                                <div class="a">
                                    <em>답변</em><!-- ##답변 -->
                                    <p><br><br><br></p>
                                </div>
                            </div>
                        </td>
                    </tr>--%>


                </div>






                <%-- 질문 토글목록 --%>
                <%-- <div class="layer1">
                     <p class="heading">제목 1 </p>
                     <div class="qna-content">첫 번째 컨텐츠<br>첫 번째 컨텐츠</div>
                     <p class="heading">제목 2</p>
                     <div class="qna-content">두 번째 컨텐츠<br>두 번째 컨텐츠</div>
                     <p class="heading">제목 3</p>
                     <div class="qna-content">세 번째 컨텐츠<br>세 번째 컨텐츠</div>
                 </div>--%>





            </div>




            <div id="tab4" class="cont">
                <p>
                    <img src="/image/product/product_detail/tab4_refund_sample.jpg" alt="tab1-image" />
                </p>
            </div>
        </div>

    </div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/script/product/product_detail.js"></script>
<script type="text/javascript" src="/script/product/product_qna.js"></script>
<%--</body>--%>
<%--</html>--%>
<script type="text/javascript">

    //review
    // $(document).ready(function() {
    $('#reviewBtn').click(function () {
        alert("리뷰뿌려줘dd!");

        $.ajax({
            type: 'get',
            url: '/product/review',
            data: 'product_id='+1,
            success: function (data) {
                alert(JSON.stringify(data));

            },
            error: function (err) {
                console.log(err);
            }
        });
    });
    // });

</script>