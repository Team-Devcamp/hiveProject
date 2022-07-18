package com.spring.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
public class MailCheckServiceImpl implements MailCheckService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String mailCheck(String user_email){
        int ranNum = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
        String from = "hive@hive.com";//보내는 이 메일주소
        String to = user_email;
        String title = "회원가입시 필요한 인증번호 입니다.";
        String content = "[인증번호] "+ ranNum +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
        String num = "";
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
            System.out.println("111");
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(title);
            mailHelper.setText(content, true);

            mailSender.send(mail);
            num = Integer.toString(ranNum);
        } catch(Exception e) {
            num = "error";
        }
        return num;
    }
}
