package Question4_Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Question4_Model.BookDAO;
import Question4_Model.BookDTO;

@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		BookDAO dao = new BookDAO();
		BookDTO member = dao.login(id, pw);
		
		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("nick", member.getNick());
			response.sendRedirect("Question4_Main.jsp");
		} else {
			
			
			
			
		}
		
	}

}
