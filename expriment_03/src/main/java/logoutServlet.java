import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

public class logoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // get login records
            ServletContext context = getServletContext();
            HashMap<String, User> loggedInUsers = (HashMap<String, User>) context.getAttribute("loggedInUsers");

            // remove user
            if (loggedInUsers != null) {
                if (loggedInUsers.containsKey(session.getId())) {
                    loggedInUsers.remove(session.getId());
                    response.sendRedirect("/logout.jsp");
                }
                // logout fail
                else {
                    response.sendRedirect("/error.jsp");
                }
            }

            session.invalidate();
        }

    }
}
