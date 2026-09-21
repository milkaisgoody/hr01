package com.example.hr.config;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession(false);   // 없으면 새로 만들지 않음
        if (session == null || session.getAttribute("user") == null) {
            try {
				response.sendRedirect("/login");
			} catch (IOException e) {
				log.error("로그인 체크 - 리다이렉트 실패");
				e.printStackTrace();
			}
            return false;   // false = 컨트롤러 호출 안 하고 여기서 끝
        }
        return true;
    }
}
