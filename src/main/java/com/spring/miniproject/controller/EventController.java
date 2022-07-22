package com.spring.miniproject.controller;

import com.google.gson.JsonObject;
import com.spring.miniproject.domain.EventDto;
import com.spring.miniproject.domain.EventPageHandler;
import com.spring.miniproject.service.EventService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.spec.ECField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/event")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @PostMapping("/modify")
    public String modifyEvent(Integer page, Integer pageSize, EventDto eventDto, Model m, HttpSession session, RedirectAttributes rattr) {

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
    public String removeEvent(Integer event_id, Integer page, Integer pageSize, HttpSession session, RedirectAttributes rattr) {

        if (session.getAttribute("user_email")==null || !adminCheck(session)) {
            return "error/error";
        }

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
    public String writeEvent(Integer page, Integer pageSize, Integer event_id, Model m, HttpSession session, RedirectAttributes rattr) {

        if (session.getAttribute("user_email")==null || !adminCheck(session)) {
            return "error/error";
        }

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

    private boolean adminCheck(HttpSession session) {
        String admin = (String)session.getAttribute("user_email");
        System.out.println("admin = " + admin);
        return admin.equals("admin@hive.co.kr");
    }

    // 파일업로드
    @ResponseBody
    @RequestMapping(value = "/uploadImage")
    public void communityImageUpload(HttpServletRequest req, HttpServletResponse resp, MultipartHttpServletRequest multiFile) throws Exception{
        JsonObject jsonObject = new JsonObject();
        PrintWriter printWriter = null;
        OutputStream out = null;
        MultipartFile file = multiFile.getFile("upload");

        if(file != null) {
            if(file.getSize() >0 && StringUtils.isNotBlank(file.getName())) {
                if(file.getContentType().toLowerCase().startsWith("image/")) {
                    try{
                        String fileName = file.getOriginalFilename();
                        byte[] bytes = file.getBytes();
                        String uploadPath = req.getSession().getServletContext().getRealPath("/resources/image/event/upload_files");

                        File uploadFile = new File(uploadPath);
                        if(!uploadFile.exists()) {
                            uploadFile.mkdir();
                        }
                        fileName = UUID.randomUUID().toString();
                        uploadPath = uploadPath + "/" + fileName;

                        out = new FileOutputStream(new File(uploadPath));
                        out.write(bytes);

                        printWriter = resp.getWriter();
                        String fileUrl = req.getContextPath() + "/image/event/upload_files/" + fileName;

                        JsonObject json = new JsonObject();
                        json.addProperty("uploaded", 1);
                        json.addProperty("fileName", fileName);
                        json.addProperty("url", fileUrl);
                        printWriter.print(json);

                    }catch(IOException e){
                        e.printStackTrace();
                    } finally {
                        if (out != null) {
                            out.close();
                        }
                        if (printWriter != null) {
                            printWriter.close();
                        }
                    }
                }

            }

        }
    }

    // 썸네일 파일 업로드


}