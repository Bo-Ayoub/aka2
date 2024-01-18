package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import aka.SubmitQuiz;

/**
 * Servlet implementation class submitQuestion
 */
public class submitQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Submit_Quiz.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question = request.getParameter("question");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String d = request.getParameter("d");
        String ans = request.getParameter("ans");
        int answer = 0;

        if (question == null || a == null || b == null || c == null || d == null || ans == null || question.equals("")
                || a.equals("") || b.equals("") || c.equals("") || d.equals("") || ans.equals("")) {
            // If any field is empty, you can redirect to an error page or the same page
            response.sendRedirect("Submit_Quiz.jsp?error=empty_fields");
            return;
        }

        try {
            answer = Integer.parseInt(ans);
        } catch (Exception e) {
            // Handle the exception if parsing fails
            response.sendRedirect("Submit_Quiz.jsp?error=invalid_input");
            return;
        }

        int srno = SubmitQuiz.getMaxSrNo();

        if (!SubmitQuiz.saveData(srno + 1, question, a, b, c, d, answer)) {
            // Handle the case where data saving fails
            response.sendRedirect("Submit_Quiz.jsp?error=database_error");
            return;
        }

        // Redirect to the quiz page after successful submission
        response.sendRedirect("Quiz.jsp");
	}

}
