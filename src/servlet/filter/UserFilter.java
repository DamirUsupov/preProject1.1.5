package servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*", "/user/*"})
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession();

        if (session.getAttribute("email") == null && session.getAttribute("pass") == null) {

            resp.sendRedirect("/login");

        } else if (session.getAttribute("role").equals("ADMIN") && uri.contains("/admin/")||
                session.getAttribute("role").equals("ADMIN") && uri.contains("/user")||
                session.getAttribute("role").equals("USER") && uri.contains("/user")) {

            chain.doFilter(req, resp);

        }
    }


    @Override
    public void destroy() {
    }
}