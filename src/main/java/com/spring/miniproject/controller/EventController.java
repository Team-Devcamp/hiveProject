package com.spring.miniproject.controller;

import com.spring.miniproject.domain.EventDto;
import com.spring.miniproject.domain.EventPageHandler;
import com.spring.miniproject.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/event")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @PostMapping("/modify")
    public String modifyEvent(Integer page, Integer pageSize, EventDto eventDto, Model m, HttpSession session, RedirectAttributes rattr) {
//        String writer = (String) session.getAttribute("id");
        String writer = "admin";
        eventDto.setWriter(writer);

        try {
            int rowCnt = eventService.modifyEvent(eventDto);

            if (rowCnt != 1) {
                throw new Exception("Event Modify Error");
            }
            rattr.addAttribute("event_id", eventDto.getEvent_id());
            rattr.addAttribute("page", page);
            rattr.addAttribute("pageSize", pageSize);
            rattr.addFlashAttribute("msg", "Modify Success");
            return "redirect:/event/read";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("event_id", eventDto.getEvent_id());
            m.addAttribute("msg", "Modify Error");
            return "event/event_write.tiles";
        }
    }

    @PostMapping("/remove")
    public String removeEvent(Integer event_id, Integer page, Integer pageSize, RedirectAttributes rattr) {
        try {
            rattr.addAttribute("page", page);
            rattr.addAttribute("pageSize", pageSize);

            int rowCnt = eventService.removeEvent(event_id);
            if (rowCnt != 1) {
                throw new Exception("Event Remove Error");
            }
            rattr.addFlashAttribute("msg", "Delete Success");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "Delete Error");
        }
        return "redirect:/event/list";
    }

    @GetMapping("/read")
    public String readEvent(Integer event_id, Integer page, Integer pageSize, Model m) {
        try {
            EventDto eventDto = eventService.readEvent(event_id);
            m.addAttribute(eventDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "event/event_board.tiles";
    }

    @PostMapping("/write")
    public String writeEvent(EventDto eventDto, Model m, RedirectAttributes rattr) {
        try {
            int rowCnt = eventService.writeEvent(eventDto);

            if (rowCnt != 1) {
                throw new Exception("Event Write Error");
            }
            rattr.addFlashAttribute("msg", "write Success");
            return "redirect:/event/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(eventDto);
            m.addAttribute("msg", "Write Error");
            return "event/event_write.tiles";
        }
    }

    @GetMapping("/write")
    public String writeEvent(Integer page, Integer pageSize, Integer event_id, Model m, HttpServletRequest request, RedirectAttributes rattr) {
//        if(!adminLoginCheck(request)) {
//            return "redirect:/login/login?toURL="+request.getRequestURL();
//        }

        if (event_id == null) {
            return "event/event_write.tiles";
        }

        try {
            EventDto eventDto = eventService.readEvent(event_id);
            m.addAttribute(eventDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            return "event/event_write.tiles";
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "Load Error");
            return "redirect:/event/list";
        }
    }


    @GetMapping("/list")
    public String listEvent(Integer page, Integer pageSize, Model m) {
        if(page==null) page = 1;
        if(pageSize==null) pageSize = 10;

        try {
            int totalCnt = eventService.getCountEvent();
            EventPageHandler eventPageHandler = new EventPageHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);

            List<EventDto> list = eventService.getEventPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", eventPageHandler);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "event/event_list.tiles";
    }

//    private boolean adminLoginCheck(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        return session.getAttribute("id").equals("admin@hive.com");
//    }

}
