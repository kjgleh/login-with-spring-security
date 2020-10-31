package me.kjgleh.loginwithspringsecurity.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/user/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public String signup(MemberDto memberDto) {
        memberService.joinUser(memberDto);
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
