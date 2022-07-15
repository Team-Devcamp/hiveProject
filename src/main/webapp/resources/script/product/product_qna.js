/*
$(function (){
    $('#qna_container').hide();
});


$('.qna .qna-info>a').click(function(){

        $('#qna_container').show();
});
*/
$(".qna .qna-info>a").click(function(){
    $('#qna_container').toggleClass("hidden");
});


/* 옵션 활성화*/
$(document).on('change', '#option1 > select', function(){
    alert("창활성화시켜");
});



/* 상품 qna */




$('#qnaBtn').click(function(){

    /* qna count */
    $.ajax({
        type: 'get',
        url: '/qna/count',
        success: function (data){
            console.log('count='+data);
            $('#qna_count').html(data);
        },
        error:function(err){
            console.log(err);
        }
    });

    qnaList();

});

function qnaList(){
    /* qna목록*/
    $.ajax({
        type: 'get',
        url: '/qna/list/product',
        data: 'product_id='+1,
        success: function(data){
            /*  alert(JSON.stringify(data));*/
            let style = '';
            let s = '';
            s+="<table class=\"qna-table\">"
            $.each(data.list, function(index, items) {
                s+='<tr className="tit" style="border-bottom: #969696; font-family: "Helvetica Neue", "Noto Sans KR", sans-serif; font-weight: 400; padding: 18px 0;">';
                s+='<td style="width:50px;">'+items.qna_id+'</td>';
                s+='<td className="tal" style="width:*"><a href="#none">'+items.qna_title+'</a></td>';
                s+='<td style="width:130px;"><span>items.secret</span></td>';
                s+='<td style="width:100px;">'+items.writer+'</td>';
                s+='<td style="width:122px;">'+items.write_date+'</td>';
                s+='<td style="width:102px;">'+items.status+'</td>';
                s+="</tr>";
            });//each

            s+="</table>"

            console.log(s);
            $("#qnaShowList").html(s);

        },
        error:function(err){
            console.log(err);
        }

    });
}

/* qna 등록*/
$('#qnaSubmitBtn').click(function(){

    if(!$('#qna_form #qna_title').val()){
        alert("제목 입력하세요");
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
        alert("질문하자!"+$('#qna_title').val()+$('#qna_content').val());
        const qna_title = $('#qna_title').val();
        const qna_content = $('#qna_content').val();

        //     JSON.stringify({
        //
        //     qna_title: $('#qna_title').val(),
        //     qna_content: $('#qna_content').val()
        // });
        //
        // $.ajax({
        //     type:"post",
        //     url:"qna/write",
        //     data: "qna_title="+qna_title+"&qna_content="+qna_content,
        //     success: function(data){
        //         alert("빠른 답변 드리겠습니다!");
        //         alert(JSON.stringify(data));
        //         qnaList();
        //
        //     }
        // })

        $.ajax({
            type: 'post',
            url: '/qna/write',
            contentType:'application/json',
            headers:{'content-type':'application/json'},
            data: JSON.stringify({
                "qna_title":qna_title,
                "qna_content":qna_content
            }),
            success: function(data){
                alert("빠른 답변 드리겠습니다!");
                alert(JSON.stringify(data));
                qnaList();

            },
            error:function(err){
                console.log(err);
            }
        });

    }
});
