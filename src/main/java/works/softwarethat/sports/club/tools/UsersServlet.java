package works.softwarethat.sports.club.tools;

import com.google.appengine.api.datastore.AsyncDatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Morten Andersen (mortena@gmail.com)
 */
@WebServlet(
        name = "UserAPI",
        description = "UserAPI: Login / Logout with UserService",
        urlPatterns = "/userapi"
)
public class UsersServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(UsersServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService userService = UserServiceFactory.getUserService();

        String thisUrl = req.getRequestURI();

        resp.setContentType("text/html");
        if (req.getUserPrincipal() != null) {
            LOGGER.info("User <" + req.getUserPrincipal().getName() + "> is already logged in.");
            
            resp.getWriter()
                    .println(
                            "<p>Hello, "
                                    + req.getUserPrincipal().getName()
                                    + "!  You can <a href=\""
                                    + userService.createLogoutURL(thisUrl)
                                    + "\">sign out</a>.</p>");
        } else {
            resp.getWriter()
                    .println(
                            "<p>Please <a href=\"" + userService.createLoginURL(thisUrl) + "\">sign in</a>.</p>");
        }
    }
}