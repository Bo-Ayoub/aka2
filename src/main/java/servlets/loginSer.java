package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import aka.LoginTable;

/**
 * Servlet implementation class loginSer
 */
public class loginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

        String person = request.getParameter("person");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == "" || password == "" || email == null || password == null) {
            session.setAttribute("alertMessage", "You haven't entered email or password.");
            response.sendRedirect("Home.jsp");
        } else if (password.length() < 5 || password.length() > 20) {
            session.setAttribute("alertMessage", "Password should be of 5 to 20 characters long.");
            response.sendRedirect("Home.jsp");
        } else {
            String x = LoginTable.authenticate(person, email, password);
            if (x.equals("true")) {
                session.setAttribute("user", email);
                response.sendRedirect("Home.jsp");
            } else if (x.equals("false")) {
                session.setAttribute("alertMessage", "Wrong email or password.");
                response.sendRedirect("Home.jsp");
            } else {
                session.setAttribute("alertMessage", "Some error occurred in the database! Please try again.");
                response.sendRedirect("Home.jsp");
            }
	}


}
	}
