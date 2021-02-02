package com.example.JSPStudy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/now")
public class NowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<html>"); // println 은 자동으로 /r/n 을 추가하여, 데이터와 함께 개행을 출력합니다.
        out.println("<head><title> 현재시간 </title></head>");
        out.println("<body>");
        out.println("현재 시간은");
        out.println(new Date());
        out.println("입니다.");
        out.println("</body></html>");
    }
}
