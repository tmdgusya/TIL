package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/hello")
public class NowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html; charset=utf-8");

        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head><title>현재시간</title></head>");
        out.println("<body>");
        out.println("현재 시간은");
        out.println(new Date());
        out.println("입니다.");
        out.println("</body></html>");
    }
}
