package TechExercise;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfo user = new UserInfo();
		user.setUser(request.getParameter("user"));
		user.setPass(request.getParameter("pass"));
		user = UserDAO.login(user);
		
		if(user.isValid())
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", user);
			response.sendRedirect("userLogged.jsp");
		}
		else
		{
			response.sendRedirect("invalidLogin.jsp");
		}
	}
}