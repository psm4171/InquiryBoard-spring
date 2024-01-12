package com.nhnacademy.springmvc.domain;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCookie {
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAgeInSec) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAgeInSec);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static String getCookieValue(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void removeCookie(HttpServletResponse response, String name, String value, int maxAgeInSec){
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
