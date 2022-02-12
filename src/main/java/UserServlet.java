import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException | SystemException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, SystemException {
        List<User> listUser = userDao.getAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, SystemException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, SystemException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        int mobileNum = Integer.parseInt(request.getParameter("mobileNumber"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("PostalCode");
        String email = request.getParameter("email");
        User newUser = new User(firstName, lastName, userName, password, mobileNum, city,
                street, postalCode, email);
        userDao.saveUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, SystemException {
        int id = Integer.parseInt(request.getParameter("id"));

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        int mobileNum = Integer.parseInt(request.getParameter("mobileNumber"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("PostalCode");
        String email = request.getParameter("email");
        User newUser = new User(firstName, lastName, userName, password, mobileNum, city,
                street, postalCode, email);

        User user = new User(id, firstName, lastName, userName, password, mobileNum, city,
                street, postalCode, email);
        userDao.updateUser(user);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, SystemException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        response.sendRedirect("list");
    }
}
