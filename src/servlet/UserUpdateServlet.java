package servlet;

import model.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/update/*")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        Long id = Long.parseLong(request.getParameter("update"));
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        UserService.getInstance().updateUser(id, new User(email,name,pass));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)   {

    }
}
