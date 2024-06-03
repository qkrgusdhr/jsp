package utils;

public class BoardPage {
    public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
        String pagingStr = "";
        int totalPages = (int)(Math.ceil(((double)totalCount / pageSize)));
        
        int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
        if(pageTemp != 1) {
            pagingStr += "<a href='" + reqUrl + "?pageNum=1' class='btn btn-secondary'>첫 페이지</a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a href='" + reqUrl + "?pageNum=" + (pageTemp - 1) + "' class='btn btn-secondary'><</a>";
        }
        
        int blockCount = 1;
        while(blockCount <= blockPage && pageTemp <= totalPages) {
            if(pageTemp == pageNum) {
                pagingStr += "&nbsp;<span class='btn btn-primary'>" + pageTemp + "</span>&nbsp;";
            } else {
                pagingStr += "&nbsp;<a href='" + reqUrl + "?pageNum=" + pageTemp + "' class='btn btn-secondary'>" + pageTemp + "</a>&nbsp;";
            }
            pageTemp ++;
            blockCount ++;
        }
        
        if(pageTemp <= totalPages) {
            pagingStr += "<a href='" + reqUrl + "?pageNum=" + pageTemp + "' class='btn btn-secondary'>></a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a href='" + reqUrl + "?pageNum=" + totalPages + "' class='btn btn-secondary'>마지막 페이지</a>";
        }
        return pagingStr;
    }
}
