package servlet;

import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String role = "";
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("pass", pass);
        session.setAttribute("loggedUser", UserService.getInstance().getUserByEmailAndPass(email, pass));
        if (UserService.getInstance().userIsExist(email, pass)) {
            role = UserService.getInstance().getRole(email, pass);
            session.setAttribute("role", role);
        }


        if (role.equals("USER")) {
            response.sendRedirect("/user");
        } else if (role.equals("ADMIN")) {
            response.sendRedirect("/admin/users");
        } else
            response.sendRedirect("/login");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }
}
