package com.spring.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Random;


@Service
public class FindPasswordServiceImpl implements FindPasswordService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String mailCheck(String user_email) {
        int ranNum = (int) ((Math.random() * (99999 - 10000 + 1)) + 10000);
        String to = user_email;
        String title = "비밀번호 찾기 인증번호 입니다.";
        String content = "[인증번호] " + ranNum + " 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
        String num = "";
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

            mailHelper.setTo(to);
            mailHelper.setSubject(title);
            mailHelper.setText(content, true);

            mailSender.send(mail);
            num = Integer.toString(ranNum);

        } catch (Exception e) {
            num = "error";
        }
        return num;
    }

    @Override
    public String tempPassword() {
        int index = 0;
        char[] charSet = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };

        StringBuffer password = new StringBuffer();
        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            double rd = random.nextDouble();
            index = (int) (charSet.length * rd);

            password.append(charSet[index]);

        }
        System.out.println("새 비밀번호 : " + password.toString());
        return password.toString();
    }

    @Override
    public String sendNewPassword(String user_email, String password) {
        String to = user_email;
        String title = "임시 비밀번호 발급 안내입니다.";
        String content = "고객님의 임시 비밀번호는 " + password + " 입니다. <br/><br/> 로그인 하신 후 보안을 위해 비밀번호 변경을 하시기 바랍니다.";
        String num = "";
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");

            mailHelper.setTo(to);
            mailHelper.setSubject(title);
            mailHelper.setText(content, true);

            mailSender.send(mail);

        } catch (Exception e) {
            num = "error";
        }
        return num;
    }
}
