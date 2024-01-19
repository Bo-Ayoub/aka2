package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import aka.RegisterTable;

/**
 * Servlet implementation class CreateAcc
 */
public class CreateAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAcc() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String univ = request.getParameter("univ");
        String name = request.getParameter("name");
    //    String roll = request.getParameter("roll");
        String degree = request.getParameter("degree");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("confirmpassword");
     //   String[] cb = request.getParameterValues("cb");

    /*    try {
            long rollno = Long.parseLong(roll);
        } catch (Exception e) {
            setErrorMessage(session, "Roll No. can only contain Numeric Data.");
            response.sendRedirect("Home.jsp");
            return;
        }*/

        // Checking Constraints
        if ( email == "" || name == "" || password == "" || cpassword == "" || degree == "") {
            setErrorMessage(session, "Please fill all the fields of the form.");
            response.sendRedirect("Home.jsp");
        } else if (password.length() < 5 || password.length() > 20) {
            setErrorMessage(session, "Password must be of 5 to 20 characters long.");
            response.sendRedirect("Home.jsp");
        } else if (!password.equals(cpassword)) {
            setErrorMessage(session, "Confirm Password didn't match. Please try again.");
            response.sendRedirect("Home.jsp");
        
        } else if (name.length() > 40) {
            setErrorMessage(session, "Your Name can be of maximum 40 characters long.");
            response.sendRedirect("Home.jsp");
        } else if (email.length() > 50) {
            setErrorMessage(session, "Your email can be of maximum 50 characters long.");
            response.sendRedirect("Home.jsp");
        } else if (!name.matches("^[\\p{L} .'-]+$")) {
            setErrorMessage(session, "Your Name must not contain any digits or special characters.");
            response.sendRedirect("Home.jsp");
        } else {
            String x = RegisterTable.authenticate(univ, degree,name,email, password);
            if (x.equals("true")) {
                session.setAttribute("user", email);
                setSuccessMessage(session, "Registration Successful.");
                response.sendRedirect("Home.jsp");
            } else if (x.equals("email")) {
                setErrorMessage(session, "This email has already been registered.");
                response.sendRedirect("Home.jsp");
            } else {
                setErrorMessage(session, "Some error occurred during registration! Please try again.");
                response.sendRedirect("Home.jsp");
            }
        }
    }

    private void setErrorMessage(HttpSession session, String message) {
        session.setAttribute("errorMessage", message);
    }

    private void setSuccessMessage(HttpSession session, String message) {
        session.setAttribute("successMessage", message);
    }

}
