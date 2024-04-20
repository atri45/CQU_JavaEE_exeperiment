import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (validateUser(username, password)) {
            // record username and login time
            User user = new User(username, System.currentTimeMillis());

            // record login
            ServletContext context = getServletContext();
            HashMap<String, User> loggedInUsers = (HashMap<String, User>) context.getAttribute("loggedInUsers");
            if (loggedInUsers == null) {
                loggedInUsers = new HashMap<>();
                context.setAttribute("loggedInUsers", loggedInUsers);
            }
            HttpSession session = request.getSession();
            loggedInUsers.put(session.getId(), user);

            // go to home after login
            response.sendRedirect(request.getContextPath() + "/home");

        } else {
            // login fail
            response.sendRedirect("/error.jsp");
        }
    }

    // validation
    private boolean validateUser(String username, String password) {
        return ("user1".equals(username) && "123".equals(password)) ||
                ("user2".equals(username) && "123".equals(password)) ||
                ("user3".equals(username) && "123".equals(password));
    }

}
