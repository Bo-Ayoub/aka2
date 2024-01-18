package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class QuizCorr
 */
public class QuizCorr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizCorr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Assuming id is the parameter you want to retrieve
        String idParam = request.getParameter("id");
        
        System.out.println("ayoub");

        if (idParam != null) {
            int id = Integer.parseInt(idParam);

            // Do your logic based on the id parameter
            if (id == 0) {
         

                // Set usans attribute to 0
                session.setAttribute("usans", 0);

                // Check if usans is equal to myans
                int usans = (int) session.getAttribute("usans");
                int myans = (int) session.getAttribute("myans");

                if ( usans == myans) {
                    // Increment the score attribute
                    int score = (int) session.getAttribute("score");
                    session.setAttribute("score", score + 1);

                    // Redirect to Question.jsp
                    response.sendRedirect("Question.jsp");
                };
            }
        }
    	//response.sendRedirect("Home.jsp");

    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	}
