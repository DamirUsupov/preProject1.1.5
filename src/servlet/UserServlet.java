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

@WebServlet("/users/*")
public class UserServlet extends javax.servlet.http.HttpServlet {
    String jsp = "users.jsp";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = UserService.getInstance().getAllUsers();
        request.setAttribute("users", users);
        request.setAttribute("delete", request.getParameter("delete"));
        request.setAttribute("update", request.getParameter("update"));
        request.setAttribute("reg", request.getParameter("reg"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            if (request.getParameter("reg") != null) {
                jsp = "users.jsp";

                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String pass = request.getParameter("pass");
                UserService.getInstance().addUser(new User(email, name, pass));

            } else if (request.getParameter("delete") != null) {
                jsp = "users.jsp";

                Long id = Long.parseLong(request.getParameter("delete"));
                User user = UserService.getInstance().getUserById(id);
                UserService.getInstance().deleteUser(user);
                String redirectURL = "users/del";
                getTable(request, response, redirectURL);

            } else if (request.getParameter("update") != null) {

                jsp = "userUpdate.jsp";

                RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);

                Long id = Long.parseLong(request.getParameter("update"));
                User user = UserService.getInstance().getUserById(id);
                request.setAttribute("user", user);
                request.setAttribute("id", id);
                requestDispatcher.forward(request, response);


            } else if (request.getParameter("updated") != null) {
                jsp = "users.jsp";

                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String pass = request.getParameter("pass");
                Long id = Long.valueOf(request.getParameter("id"));

                UserService.getInstance().updateUser(id, new User(email, name, pass));

                getTable(request, response, "users/");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        getTable(request, response, "users/");


    }

    private void getTable(HttpServletRequest request, HttpServletResponse response, String redirectUrl) throws ServletException, IOException {

        List<User> users = UserService.getInstance().getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(jsp);
        requestDispatcher.forward(request, response);
    }


}
