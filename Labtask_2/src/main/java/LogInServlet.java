

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogInServlet extends HttpServlet {
    private  String userName="Fahim";
    private String pass="pass";

    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        PrintWriter out=resp.getWriter();
        out.println("login");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("username").equals(userName) && req.getParameter("password").equals(pass)){
            HttpSession session=req.getSession(false);
            session.setAttribute("userName",req.getParameter("username"));
            RequestDispatcher rd=req.getRequestDispatcher("/loginsucessServlet");
            rd.forward(req,resp);
        }else {
            resp.sendRedirect("/Labtask_2-1.0-SNAPSHOT/index.jsp");
        }

    }
}
