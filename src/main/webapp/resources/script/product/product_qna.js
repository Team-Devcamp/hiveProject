/*url에서 product_id parameter 넘겨받기*/
product_id = new URLSearchParams(location.search).get('product_id');

/* 상품 qna count 보여주기 */
$('#qnaBtn').click(function(){
    $.ajax({
        type: 'get',
        url: '/qna/count?product_id='+product_id,
        success: function (data){
            // alert("count?"+data);
            console.log('count='+data);
            $('#qna_count').html(data);
        },
        error:function(err){
            console.log(err);
        }
    });
    qnaList();
});


// qna 목록
function qnaList(){

    $.ajax({
        type: 'get',
        url: '/qna/list/product',
        data: 'product_id='+product_id,
        success: function(data){

            let empty='';
            if(data.list==''){
                empty+='<table class=\"qna-table\"><tr class="tit " >';
                empty+='<td colSpan="6">';
                empty+='<div class="qna-answer">';
                empty+='<div class="q qna-empty" style="padding-top:30px; font-size: 16px">';
                empty+='<em>등록된 문의사항이 없습니다.</em></div>';
                empty+='</div></div></td></tr></table>';

                $("#qnaShowList").html(empty);

            }//if
            else{

                // alert(JSON.stringify(data));
                let s = '';

                s+="<table class=\"qna-table\">"
                $.each(data.list, function(index, items) {
                    let secret='';
                    let status='';
                    if(items.secret===0){
                        secret='공개';
                    }else{
                        secret='비공개';
                    }
                    if(items.status===0){
                        status='미완료';
                    }else{
                        status='완료';
                    }
                    s+='<tr class="tit tit_tr " style="border-bottom: #969696; font-family: "Helvetica Neue", "Noto Sans KR", sans-serif; font-weight: 400; padding: 18px 0;">';
                    s+='<td style="width:50px;">'+items.qna_id+'</td>';
                    s+='<td class="tal qna_title" style="width:*"><a href="#none"' +
                        'style="text-decoration: none; color:inherit;">'+items.qna_title+'</a></td>';
                    s+='<td style="width:130px;"><span>'+secret+'</span></td>';
                    s+='<td style="width:100px;">'+items.writer+'</td>';
                    s+='<td style="width:122px;">'+items.write_date+'</td>';
                    s+='<td style="width:102px;">'+status+'</td>';
                    s+="</tr>";

                    s+='<tr class="tit hidden" >';
                    s+='<td colSpan="6">';
                    s+='<div class="qna-answer">';
                    s+='<div class="q" style="padding-top:12px;">';
                    s+='<em>'+items.qna_content+'</em></div>';
                    s+='<div class="a">';
                    s+='<em>답변</em>';
                    s+='<p><br><br><br></p></div></div></td></tr>';

                });//each

                s+="</table>"

                console.log(s);
                $("#qnaShowList").html(s);
                $('#qnaPagingDiv').html(data.qnaPaging.pagingHTML);
            }


        },
        error:function(err){
            console.log(err);
        }
    });
}


/* 목록 내용 보여주는 이벤트 */
$('#qnaShowList').on('click', ".qna_title", function(){
    // alert($(this).text());
    console.log("click");
    $(this).parent().next().toggleClass("hidden");
});


//페이징처리한 qna 목록
function qnaPaging(pg) {
    $.ajax({
        type: 'get',
        url: '/qna/list/product',
        data: 'product_id='+product_id+'&pg='+pg,
        success: function(data){
            // alert(JSON.stringify(data));
            let s = '';
            s+="<table class=\"qna-table\">"
            $.each(data.list, function(index, items) {
                let secret1='';
                let status1='';
                if(items.secret===0){
                    secret1='공개';
                }else{
                    secret1='비공개';
                }
                if(items.status===0){
                    status1='미완료';
                }else{
                    status1='완료';
                }
                s+='<tr class="tit tit-tr" style="border-bottom: #969696; font-family: "Helvetica Neue", "Noto Sans KR", sans-serif; font-weight: 400; padding: 18px 0;">';
                s+='<td style="width:50px;" >'+items.qna_id+'</td>';
                s+='<td class="tal qna_title" style="width:*"><a href="#none"' +
                    'style="text-decoration: none; color:inherit;">'+items.qna_title+'</a></td>';
                s+='<td style="width:130px;"><span>'+secret1+'</span></td>';
                s+='<td style="width:100px;">'+items.writer+'</td>';
                s+='<td style="width:122px;">'+items.write_date+'</td>';
                s+='<td style="width:102px;">'+status1+'</td>';
                s+="</tr>";

                s+='<tr class="tit hidden">';
                s+='<td colSpan="6">';
                s+='<div class="qna-answer">';
                s+='<div class="q">';
                s+='<em>'+items.qna_content+'</em></div>';
                s+='<div class="a">';
                s+='<em>답변</em>';
                s+='<p><br><br><br></p></div></div></td></tr>';
            });//each

            s+="</table>"

            console.log(s);
            $("#qnaShowList").html(s);
            $('#qnaPagingDiv').html(data.qnaPaging.pagingHTML);

        },
        error:function(err){
            console.log(err);
        }

    });
}


/* qna 등록 토글*/
$(".qna .qna-info #regQnaBtn").click(function(){
    $('#qna_container').toggleClass("hidden");
});

$(".qna .qna-info #goToLogin").click(function(){
    let on = confirm("로그인이 필요한 서비스입니다.로그인 하시겠습니까?");
    if(on){
        location.replace("/login");
    }
    else{
        return;
    }
})

/* qna 등록창 초기화 */
$('#regQnaBtn').on('click',function(){
    $('#qna_title').val('');
    $('#qna_content').val('');
});

/* qna 등록 */
$('#qnaSubmitBtn').click(function(){

    $('#qna_container').toggleClass("hidden");

    if(!$('#qna_form #qna_title').val()){
        alert("제목을 입력하세요");
        $(this).focus();
        $('#titleDiv').html('제목을 입력하세요');
        return false;
    }
    else if(!$('#qna_form #qna_content').val()){
        alert("내용을 입력하세요");
        $(this).focus();
        return false;
    }
    else{
        const qna_title = $('#qna_title').val();
        const qna_content = $('#qna_content').val();

        $.ajax({
            type: 'post',
            url: '/qna/write?product_id='+product_id,
            headers:{'content-type':'application/json'},
            data: JSON.stringify({
                "qna_title":qna_title,
                "qna_content":qna_content
            }),
            success: function(data){
                qnaList();
            },
            error:function(err){
                console.log(err);
            }
        });

    }
});


