import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

public class filterServlet implements Filter {
    public void init(FilterConfig config) {}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        // get login records
        ServletContext context = request.getServletContext();
        HashMap<String, User> loggedInUsers = (HashMap<String, User>) context.getAttribute("loggedInUsers");

        //  If there is no record, go to login
        if (session != null && loggedInUsers != null && loggedInUsers.containsKey(session.getId())) {
            chain.doFilter(req, res);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    public void destroy() {}
}
