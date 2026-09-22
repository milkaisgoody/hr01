package com.example.hr.config;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.hr.dto.EmpDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    // @Override
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    //     HttpSession session = request.getSession(false);   // 없으면 새로 만들지 않음
    //     if (session == null || session.getAttribute("user") == null) {
    //         try {
	// 			response.sendRedirect("/login");
	// 		} catch (IOException e) {
	// 			log.error("로그인 체크 - 리다이렉트 실패");
	// 			e.printStackTrace();
	// 		}
    //         return false;   // false = 컨트롤러 호출 안 하고 여기서 끝
    //     }
    //     return true;
    // }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
                throws Exception{
        System.out.println("LoginCheckInterceptor 진입=========");
        
        //세션 객체를 통해 로그인 정보를 확인
        HttpSession session = request.getSession();   // 없으면 새로 만들지 않음
        if (session != null && session.getAttribute("user") != null) {
            EmpDto user = (EmpDto)session.getAttribute("user");
            System.out.println(user.getEmpName());
            System.out.println("컨트롤러 진입");
            //로그인한 사용자
            // true : 컨트롤러 진입
            return true;
        }

        //false : 컨트롤러 호출 안하고 여기서 끝
        System.out.println("로그인후 이용 가능");

        //로그인 후 사용자가 원래 보던 페이지로 이동

        //파라미터 정보로 함께 전달
        String queryString = request.getQueryString();

        String uri = queryString != null ? 
                        request.getRequestURI() + "?" + queryString
                        : request.getRequestURI();

        System.out.println("이전 요청 정보 : " + request.getRequestURI());
        //사용자의 요청 정보를 저장
        session.setAttribute("prevRequestUrl", uri);

        response.sendRedirect("/login");
        return false;
    }
}
