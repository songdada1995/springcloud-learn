package com.example.provider.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {

    private ResponseUtils() {

    }

    // 发送内容 "application/json;charset=UTF-8"
    public static void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 发送的是JSON
    public static void renderJSON(HttpServletResponse response, String text) {
        render(response, "application/json;charset=UTF-8", text);
    }

    // 发送xml
    public static void renderXml(HttpServletResponse response, String text) {
        render(response, "application/xml;charset=UTF-8", text);
    }

    // 发送text
    public static void renderText(HttpServletResponse response, String text) {
        render(response, "application/plain;charset=UTF-8", text);
    }

}
