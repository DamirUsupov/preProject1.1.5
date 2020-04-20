package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        Long id = Long.valueOf(request.getParameter("id"));
        UserService.getInstance().updateUser(id, new User(email, name, pass));
        response.sendRedirect("/reg");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        User user = UserService.getInstance().getUserById(id);
        request.setAttribute("id", id);
        request.setAttribute("user", user);

        request.getRequestDispatcher("updateUser.jsp").forward(request, response);

    }


}
