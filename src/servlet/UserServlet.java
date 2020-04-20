package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/reg/*")

public class UserServlet extends javax.servlet.http.HttpServlet {
    String jsp = "users.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            getTable(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (!email.equals("") && !name.equals("") && !pass.equals("")) {

            try {
                UserService.getInstance().addUser(new User(email, name, pass));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        try {
            getTable(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    private void getTable(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {

        List<User> users = UserService.getInstance().getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
        requestDispatcher.forward(request, response);

    }


}
