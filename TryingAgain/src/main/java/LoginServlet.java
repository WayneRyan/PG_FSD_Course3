import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World</h3>");
        String username = request.getParameter("txtuname");
        String password = request.getParameter("txtpwrd");
        RequestDispatcher rd;
        if (username.equalsIgnoreCase("hello") && password.equals("world")){
            rd = request.getRequestDispatcher("Welcome.html");
            rd.forward(request,response); // replace the page
        } else {
            rd = request.getRequestDispatcher("Index.html");
            rd.include(request,response); // prepend to page
            rd.
        }
        // if I use out.println() it will put it on a new page
        rd.forward(request,response);

    }
}
