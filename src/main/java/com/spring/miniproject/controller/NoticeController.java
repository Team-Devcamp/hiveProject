package com.spring.miniproject.controller;

import com.spring.miniproject.domain.NoticeDto;
import com.spring.miniproject.domain.PageHandler;
import com.spring.miniproject.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "/list")
    public String noticeList (Integer page, Integer pageSize, Model m, HttpServletRequest request) {
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

        return "noticeList";
    }

    @RequestMapping(value = "/detail")
    public String noticeDetail (Model m, int notice_id, HttpServletRequest request) throws Exception {
        NoticeDto data = noticeService.selectDetail(notice_id);
        m.addAttribute("data", data);

        return "noticeDetail";
    }

    @RequestMapping(value = "/write")
    public String noticeWrite (HttpServletRequest request) throws Exception {
        return "noticeWrite";
    }
}
