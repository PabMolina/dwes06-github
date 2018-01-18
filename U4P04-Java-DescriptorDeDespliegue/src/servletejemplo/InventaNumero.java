package servletejemplo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Servlet implementation class InventaNumero
 
@WebServlet("/InventaNumero")
*/
public class InventaNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventaNumero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;UTF-8");
		int numeroAleatorio = (int) (Math.random()*1000+1);
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Número random</title></head>");
		out.println("<body><h1>Número Aleatorio</h1>");
 		out.println("<body><h1>"+numeroAleatorio+"</h1>");
 		out.println("<p><a href='./index.html'>Volver</a></p>");
 		out.println("</body></html>");
 		out.close();
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
