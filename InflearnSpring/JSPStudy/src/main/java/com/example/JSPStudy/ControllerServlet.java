package com.example.JSPStudy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // 요청 파악
        String type = request.getParameter("type");
        Object resultObject = null;
        // 요청한 기능을 수행한다.
        if(type == null || type.equals("greeting")){
            resultObject = "안녕하세요!";
        }else if(type.equals("date")){
            resultObject = new Date();
        }else{
            resultObject = "Invalid Type";
        }
        // request 나 Session 에 처리 결과를 저장
        request.setAttribute("result", resultObject);

        // RequestDispatcher 를 사용하여 알맞은 뷰로 포트포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("/simpleView.jsp");
        dispatcher.forward(request, response);
    }
}
