package com.spring.miniproject.domain;

public class PageHandlerDto {
    int totalCnt;   // 전체 데이터의 개수(게시글의 개수)
    int page;       // 현재 페이지
    int beginPage; // 시작 페이지
    int totalPage; // 전체 페이지수
    int endPage;   // 마지막 페이지
    int naviSize = 5;  // 네비게이터의 크기
    int pageSize = 5;  // 페이지의 크기
    int startList; // 시작하는 offset
    boolean preView; // 뒤로가기
    boolean nextView; // 다음으로 가기
    private int user_id;

    public PageHandlerDto(int totalCnt, int page,int user_id){
        this.totalCnt = totalCnt;
        this.page = page;
        this.startList = (page - 1) * pageSize;
        totalPage = (int)Math.ceil((double)totalCnt/pageSize);
        beginPage = (page-1)/naviSize * naviSize + 1;
        endPage = Math.min((((page-1)/naviSize + 1) * naviSize),totalPage);

        preView = beginPage != 1;
        nextView = endPage != totalPage;
        this.user_id = user_id;
    }

    public PageHandlerDto(int totalCnt, int page,int user_id,int pageSize,int naviSize){
        this.pageSize = pageSize;
        this.totalCnt = totalCnt;
        this.page = page;
        this.startList = (page - 1) * pageSize;
        totalPage = (int)Math.ceil((double)totalCnt/pageSize);
        beginPage = (page-1)/naviSize * naviSize + 1;
        endPage = Math.min((((page-1)/naviSize + 1) * naviSize),totalPage);

        preView = beginPage != 1;
        nextView = endPage != totalPage;
        this.user_id = user_id;
        this.naviSize = naviSize;
    }

    public boolean isPreView() {
        return preView;
    }

    public void setPreView(boolean preView) {
        this.preView = preView;
    }

    public boolean isNextView() {
        return nextView;
    }

    public void setNextView(boolean nextView) {
        this.nextView = nextView;
    }

    public int getStartList() {
        return startList;
    }

    public void setStartList(int startList) {
        this.startList = startList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "PageHandler2{" +
                "totalCnt=" + totalCnt +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", totalPage=" + totalPage +
                ", endPage=" + endPage +
                ", naviSize=" + naviSize +
                ", pageSize=" + pageSize +
                ", preView=" + preView +
                ", nextView=" + nextView +
                '}';
    }
}

