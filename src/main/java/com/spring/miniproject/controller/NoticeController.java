package com.spring.miniproject.controller;

import com.spring.miniproject.domain.NoticeDto;
import com.spring.miniproject.domain.PageHandler;
import com.spring.miniproject.service.NoticeService;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    // 공지사항 게시판 목록 불러오기
    @RequestMapping(value = "/list")
    public String noticeList (Integer page, Integer pageSize, Model m) {
        if(page==null) page=1;
        if(pageSize==null) pageSize=10;

        try {
            int totalCnt = noticeService.getCount();
            PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<NoticeDto> list = noticeService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "noticeList.tiles";
    }

    // 공지사항 상세보기
    @RequestMapping(value = "/detail")
    public String noticeDetail (Model m, int notice_id) throws Exception {
        NoticeDto data = noticeService.selectDetail(notice_id);
        noticeService.viewCount(notice_id); // 조회수 증가
        m.addAttribute("data", data);

        return "noticeDetail.tiles";
    }

    // 공지사항 등록 화면
    @RequestMapping(value = "/write")
    public String noticeWrite () throws Exception {
        return "noticeWrite.tiles";
    }

    // 공지사항 등록 POST
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertNotice(NoticeDto noticeDto) throws Exception {
        noticeService.insertNotice(noticeDto);
        return "redirect:/notice/list";
    }

    // 공지사항 게시글 수정
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String noticeUpdate(int notice_id, Model m) throws Exception {
        NoticeDto data = noticeService.selectDetail(notice_id);
        m.addAttribute("data", data);
        return "noticeUpdate.tiles";
    }

    // 공지사항 게시글 POST
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateNotice(NoticeDto noticeDto) throws Exception {
        noticeService.updateNotice(noticeDto);
        return "redirect:/notice/detail?notice_id="+noticeDto.getNotice_id();
    }

    // 공지사항 삭제
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String deleteNotice(int notice_id) throws Exception {
        noticeService.deleteNotice(notice_id);
        return "redirect:/notice/list";
    }

}
