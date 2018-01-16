package works.softwarethat.sports.club.tools;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Morten Andersen (mortena@gmail.com)
 */
@WebServlet(urlPatterns = "/loggedIn")
public class LoggedInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IsLoggedInResponse isLoggedInResponse = new IsLoggedInResponse();
        if (req.getUserPrincipal() != null) {
            // User is logged in
            isLoggedInResponse.isLoggedIn = true;
            isLoggedInResponse.email = req.getUserPrincipal().getName();
        } else {
            isLoggedInResponse = new IsLoggedInResponse();
            isLoggedInResponse.isLoggedIn = false;
        }
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json");
        resp.getWriter().write(new Gson().toJson(isLoggedInResponse));
    }

    private class IsLoggedInResponse {
        boolean isLoggedIn;
        String email;
    }
}
