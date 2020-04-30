package com.changgou.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie getTargetCookie(String name,Cookie[] cookies){
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }

        }
        if (cookies==null) {
            return null;
        }
        return null;
    }
}
