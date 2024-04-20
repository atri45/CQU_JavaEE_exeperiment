package ssoServer;

import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class homeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();
        HashMap<String, User> loggedInUsers = (HashMap<String, User>) context.getAttribute("loggedInUsers");
        HttpSession session = request.getSession(false);

        // if not logged in
        if (loggedInUsers == null || session == null || !loggedInUsers.containsKey(session.getId())) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><head>");
                out.println("<style>");
                out.println("body {");
                out.println("text-align: center;");
                out.println("}");
                out.println("</style>");
                out.println("</head><body>");
                out.println("<br><h1>Welcome to SSO Server!</h1><br>");
                out.println("<a href='/login.jsp'>Log in</a><br><br>");
                out.println("<a href='/web1/home'>Go to Web1</a>&nbsp&nbsp&nbsp");
                out.println("<a href='/web2/home'>Go to Web2</a><br>");
                out.println("</body></html>");
            }
        }
        // has logged in
        else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><head>");
                out.println("<style>");
                out.println("body {text-align: center;}");
                out.println("</style>");
                out.println("</head><body>");
                out.println("<br><h1>Welcome to SSO Server!</h1>");
                out.println("<h2>Online Users:</h2>");
                if (loggedInUsers != null) {
                    loggedInUsers.forEach((id, user) ->
                            out.println("<p>" + user.getUserName() + " &nbsp&nbsp&nbsp logged in at "
                                    + new SimpleDateFormat("yyyy.MM.dd HH:MM").format(user.getLoginTime()) + "</p>"));
                }
                out.println("<a href='/web1/home'>Go to Web1</a>&nbsp&nbsp&nbsp");
                out.println("<a href='/web2/home'>Go to Web2</a><br><br>");
                out.println("<a href='/logout'>Logout</a><br>");
                out.println("</body></html>");

            }
        }
    }

}

