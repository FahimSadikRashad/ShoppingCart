import newpack.CartValues_1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LogInSuccessful extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(session.getAttribute("userName")!=null){
            PrintWriter out=resp.getWriter();
            out.println("LoginSuccessIn post");
            resp.setContentType("text/html");
            RequestDispatcher rd3=req.getRequestDispatcher("/ShoppingItems.jsp");
            rd3.include(req,resp);
            
            RequestDispatcher rd=req.getRequestDispatcher("/Success.html");
            rd.include(req,resp);

        }
        else{
            resp.sendRedirect("/Labtask_2-1.0-SNAPSHOT/index.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        out.println("LoginSuccess");

    }
}
