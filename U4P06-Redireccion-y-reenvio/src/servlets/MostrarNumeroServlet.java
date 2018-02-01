package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarNumeroServlet
 */
@WebServlet("/MostrarNumero")
public class MostrarNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarNumeroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int num, num1, num2, num3;
		ServletContext contexto = getServletContext();

		if (request.getAttribute("numero") != null) {

			if (request.getAttribute("numero1") != null || request.getAttribute("numero2") != null
					|| request.getAttribute("numero3") != null) {

				num = (int) request.getAttribute("numero");
				num1 = (int) request.getAttribute("numero1");
				num2 = (int) request.getAttribute("numero2");
				num3 = (int) request.getAttribute("numero3");
				
				out.println("<title>"+num+"</title>");
				out.println("<h1 style='color:rgb("+num1+","+num2+","+num3+")'>" + num + "</h1>");
				out.println("<p><a href='./index.html'>Index</a></p>");
				out.close();
			} else {
				response.sendRedirect(contexto.getContextPath() + "/GenerarColores");
			}
		} else {
			response.sendRedirect(contexto.getContextPath() + "/Sorpresa");
		}

	}


	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
