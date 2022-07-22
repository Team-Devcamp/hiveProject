package com.spring.miniproject.domain;

import org.springframework.stereotype.Component;

@Component
public class QnaPaging {
    private int currentPage;
    private int pageBlock;
    private int pageSize;
    private int countQna;
    private StringBuffer pagingHTML;

    public void makePagingHTML() {
        pagingHTML = new StringBuffer();

        //int totalP = (countQna-1) / pageSize + 1; //총 페이지 수
        int totalP = (countQna + pageSize-1) / pageSize;

        int startPage = (currentPage-1) / pageBlock * pageBlock + 1;//시작 페이지 번호

        int endPage = startPage + pageBlock - 1;
        if(endPage > totalP) endPage = totalP;

        if(startPage != 1)
            //if(startPage > pageBlock)
            pagingHTML.append(" <span id='paging' onclick='qnaPaging(" + (startPage-1) + ")'><<이전</span> ");

        for(int i=startPage; i<=endPage; i++) {
            if(i == currentPage)
                pagingHTML.append(" <span id='currentPaging' onclick='qnaPaging(" + i + ")'>" + i + "</span> ");
            else
                pagingHTML.append(" <span id='paging' onclick='qnaPaging(" + i + ")'>&nbsp" + i + "&nbsp</span> ");
        }

        if(endPage < totalP)
            pagingHTML.append(" <span id='paging' onclick='qnaPaging(" + (endPage+1) + ")'>다음>></span> ");
    }

    public QnaPaging() {}

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageBlock() {
        return pageBlock;
    }

    public void setPageBlock(int pageBlock) {
        this.pageBlock = pageBlock;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCountQna() {
        return countQna;
    }

    public void setCountQna(int totalA) {
        this.countQna = totalA;
    }

    public StringBuffer getPagingHTML() {
        return pagingHTML;
    }

    public void setPagingHTML(StringBuffer pagingHTML) {
        this.pagingHTML = pagingHTML;
    }
}
