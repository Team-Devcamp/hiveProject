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
                        밴딩 원턱 버뮤다 와이드 하프 팬츠 반바지 코튼
                        <br />
                        데일리바지
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
                    112,000 원
                </strong>

                <p class="product-desc">
                    [반바지 1+1/미친가격] 트레이닝 쿨링 반바지 남자 스포츠 헬스 츄리닝 밴딩 여름 팬츠 짐웨어
                </p>



                <form action="" method="POST" class="product-form">
                    <div class="form-options">



                        <div class="form-select-wrap">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>색상을 선텍해 주세요</option>
                                <option value="1">화이트</option>
                                <option value="2">베이지</option>
                                <option value="3">블랙</option>
                            </select>

                            <select class="form-select" aria-label="Default select example">
                                <option selected>사이즈를 선책해 주세요</option>
                                <option value="1">95</option>
                                <option value="2">100</option>
                                <option value="3">105</option>
                            </select>
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
                <a href="#tab1" class="btn">상품정보</a>
            </li>
            <li>
                <a href="#tab2" class="btn">리뷰</a>
            </li>
            <li>
                <a href="#tab3" class="btn">Q&A</a>
            </li>
            <li>
                <a href="#tab4" class="btn">환불&교환정책</a>
            </li>
        </ul>

        <div class="cont_area">
            <div id="tab1" class="cont">
                <img src="/image/product/product_detail/tab1_sample.jpg" alt="tab1-image" />
            </div>
            <div id="tab2" class="cont">
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

        </div>
            <div id="tab3" class="cont">
                <div>질문게시판</div>
            </div>
            <div id="tab4" class="cont">
                <p>
                    sample.................
                </p>
            </div>
        </div>

    </div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/script/product/product_detail.js"></script>

<%--</body>--%>
<%--</html>--%>