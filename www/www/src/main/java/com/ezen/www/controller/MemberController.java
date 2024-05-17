package com.ezen.www.controller;

import com.ezen.www.domain.MemberVO;
import com.ezen.www.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;


@RequiredArgsConstructor
@RequestMapping("/member/*")
@Controller
public class MemberController {
    private final MemberService msv;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public void join(){}

    @PostMapping("/register")
    public String register(MemberVO mvo){
        mvo.setPwd(passwordEncoder.encode(mvo.getPwd()));
        int isOK = msv.insert(mvo);
        return "/index";
    }
    @GetMapping("/login")
    public void login(){}

    @GetMapping("/list")
    public void list(Model m){
        m.addAttribute("list",msv.getList());
    }

    @GetMapping("/modify")
    public void modify(){}

    @PostMapping("/modify")
    public String modify(MemberVO mvo, HttpServletRequest request, HttpServletResponse re, Principal prin){
        String email = prin.getName();
        mvo.setEmail(email);
        if(mvo.getPwd() == null || mvo.getPwd().length() < 0){
            msv.updateNick(mvo);
        }else {
            String setPwd = passwordEncoder.encode(mvo.getPwd());
            mvo.setPwd(setPwd);
            msv.updateWithPwd(mvo);
        }

    return "redirect:/member/logout";
    }



}
