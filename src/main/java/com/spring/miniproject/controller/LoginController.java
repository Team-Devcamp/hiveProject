package com.spring.miniproject.controller;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.service.KakaoLoginService;
import com.spring.miniproject.service.NaverLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spring.miniproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	KakaoLoginService oAuthService;

	@Autowired
	NaverLoginBO naverLoginBO;

	@GetMapping("/login")
	public String login(HttpSession session, Model model) {
		//초기 페이지 로딩시, 네이버 로그인버튼에 인증 url을 담아서 login_form에 전송
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		model.addAttribute("naver_url", naverAuthUrl);
		return "login_form";
	}

	@PostMapping("/login")
	public String login(String user_email, String user_password, HttpServletRequest request) {
		UserDto userDto = userService.selectOneUser(user_email);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		HttpSession session = request.getSession();

		if(userDto.getUser_password().length()<50){
			String newPassword =  encoder.encode(userDto.getUser_password());
			UserDto updateUserDto = new UserDto(user_email,newPassword);
			userService.updateUserPassword(updateUserDto);
			userDto = userService.selectOneUser(user_email);
		}

		if (userDto == null) {
			return "redirect:/";
		} else {

				if (encoder.matches(user_password, userDto.getUser_password())) {
					session = request.getSession();
					session.setAttribute("user_email", user_email);
					return "login_form";

			} else {
				return "redirect:/";
			}
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login_form";
	}

	@GetMapping ("/login/kakao")
	public String kakaoLogin(@RequestParam String code, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String token = oAuthService.getKakaoAccessToken(code);
		String email = oAuthService.createKaKaoUser(token);

		if (email == null || email == "") {
			return "redirect:/";
		}
		HttpSession session = request.getSession();
		UserDto userDto = userService.selectOneUser(email);
		if(userDto!=null){
			session.setAttribute("user_email",userDto.getUser_email());
			return "redirect:/";
		}else{
			model.addAttribute("user_email",email);
			model.addAttribute("email_check","true");
			return "redirect:/register";
		}

	}

	@RequestMapping("login/naver")
	public String naverLogin(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
		OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
		String apiResult = naverLoginBO.getUserProfile(oauthToken);

		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(apiResult);

		JsonObject userInfo = element.getAsJsonObject().get("response").getAsJsonObject();
		String user_email = userInfo.get("email").getAsString();

		UserDto userDto = userService.selectOneUser(user_email);

		if(userDto!=null){
			return "redirect:/";
		}else{
			model.addAttribute("user_email",user_email);
			model.addAttribute("email_check","true");
			return "redirect:/register";
		}






	}
}
