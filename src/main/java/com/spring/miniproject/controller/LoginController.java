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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "user/login_form.tiles";
	}

	/*
	* 로그인 메서드(로그인 기능)
	* */
	@PostMapping("/login")
	public String login(String user_email, String user_password, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		UserDto userDto = userService.selectOneUser(user_email);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		HttpSession session = request.getSession();

		if (userDto == null) {
				redirectAttributes.addFlashAttribute("error_msg","아이디 또는 비밀번호가 일치하지 않습니다. 확인 후 다시 로그인 해주세요.");
			return "redirect:/login";
		} else {


				if (encoder.matches(user_password, userDto.getUser_password())) {
					session = request.getSession();
					session.setAttribute("user_email", user_email);
					return "redirect:/";
			} else {
					redirectAttributes.addFlashAttribute("error_msg","아이디 또는 비밀번호가 일치하지 않습니다. 확인 후 다시 로그인 해주세요.");
				return "redirect:/login";
			}
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}

	// 카카오 소셜 로그인 메서드(이메일 수집 동의를 하지 않을 경우, 로그인 화면으로 다시 redirect 한다.
	@GetMapping ("/login/kakao")
	public String kakaoLogin(@RequestParam String code, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception{
		String token = oAuthService.getKakaoAccessToken(code);
		String email = oAuthService.createKaKaoUser(token);

		if (email == null || email == "") {
			redirectAttributes.addFlashAttribute("error_msg_social","이메일 수집 동의를 하지 않아, 서비스 이용이 어렵습니다. 이메일 수집 동의 후 다시 회원가입 신청바랍니다.");
			return "redirect:/login";
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

	// 네이버 소셜 로그인 메서드
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
			session.setAttribute("user_email",user_email);
			return "redirect:/";
		}else{
			model.addAttribute("user_email",user_email);
			model.addAttribute("email_check","true");
			return "redirect:/register";
		}






	}
}
