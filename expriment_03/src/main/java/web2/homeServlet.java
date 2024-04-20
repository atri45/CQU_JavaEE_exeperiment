package web2;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class homeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // if not logged in
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/login.jsp");
            return;
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head>");
            out.println("<style>");
            out.println("body {");
            out.println("text-align: center;");
            out.println("}");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<br><h1>Welcome to Web2!</h1>");
            out.println("<a href='/home'>Back to Server</a>&nbsp&nbsp&nbsp");
            out.println("<a href='/web1/home'>Go to Web1</a><br><br>");
            out.println("<a href='/logout'>Logout</a>");
            out.println("</body></html>");
        }
    }
}
