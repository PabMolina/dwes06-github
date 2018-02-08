

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaludoServlet
 */
@WebServlet("/Saludo")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaludoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String error="";
		
		if (request.getParameter("reiniciarSesion") != null) {
			session.invalidate();
			session = request.getSession();
			response.sendRedirect("/U4P10-Java-Sesiones/Saludo");
			
		}
		// Si ha rellenado el formulario, se crea una variable de sesion con el nombre.
		
		if (request.getMethod().equals("POST")) {
			if (request.getParameter("nombre")!=null) {
				session.setAttribute("nombre", request.getParameter("nombre"));
			}else {
				error="No se escrito ningún nombre";
 
			}
		}
		// Comienza la salida...
				PrintWriter out = response.getWriter();
				out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>"
				    + "<title>Sesiones en JavaEE</title></head><body>");
				response.setContentType("text/html;UTF-8");
				
				if(session.getAttribute("nombre")!=null && session.getAttribute("nombre")!="")  {
					String nombre = session.getAttribute("nombre").toString();
					out.println("<h1>Bienvenido "+nombre+"</h1>");
					out.println("<a href='" + request.getRequestURI() + "?reiniciarSesion=true'>Borrar la sesión</a>");
				}else {
					error="No se escrito ningún nombre";
					out.println("<form action='"+request.getRequestURI()+"' method='post'>");
					out.println("<label>Introduce tu nombre:</label> <input type='text' name='nombre'/>");
					out.println("<input type='submit' name='enviar' value='Enviar'/></form>");
					out.println("<p>"+error+"</p>");
					
				}
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
