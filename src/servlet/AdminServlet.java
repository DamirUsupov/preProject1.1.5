package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/users")

public class AdminServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getTable(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        if (name != null && pass != null && email != null) {
            if (!email.equals("") && !name.equals("") && !pass.equals("")) {

                UserService.getInstance().addUser(new User(email, name, pass));

            }
        }
        getTable(request, response);

    }

    private void getTable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<User> users = UserService.getInstance().getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/users.jsp");
        requestDispatcher.forward(request, response);

    }


}
