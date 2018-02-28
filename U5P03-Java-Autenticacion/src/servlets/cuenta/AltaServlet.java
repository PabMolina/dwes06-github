package servlets.cuenta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AltaServlet
 */
@WebServlet("/Alta")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext contexto = request.getServletContext();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		String mensajeError = "";

		out.println("<html><head><meta charset='UTF-8'/><html><head><meta charset='UTF-8'/></head><body>");

		if (request.getMethod().equals("POST")) { // si venimos de enviar el formulario...

			if (request.getParameter("username") != "" && request.getParameter("password") != "") {

				Connection conn = null;
				Statement sentencia = null;
				try {
					// Paso 1: Cargar el driver JDBC.
					Class.forName("org.mariadb.jdbc.Driver").newInstance();

					// Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
					String userName = contexto.getInitParameter("usuario");
					String password = contexto.getInitParameter("password");
					String url = contexto.getInitParameter("url");
					conn = DriverManager.getConnection(url, userName, password);

					// Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
					sentencia = conn.createStatement();

					String username = request.getParameter("username");
					String pass = request.getParameter("password");
					String nombre = request.getParameter("nombre");
					int admin = Integer.parseInt(request.getParameter("admin"));
					String descripcion = request.getParameter("descripcion");

					String consultaComprobacion = "SELECT * from usuario WHERE login='" + username + "'";
					String consultaAlta = "INSERT INTO `usuario` (`login`, `password`, `nombre`, `admin`, `descripcion`) VALUES ('"
							+ username + "', '" + pass + "', '" + nombre + "' , '" + admin + "', '" + descripcion
							+ "');";
					ResultSet rset = sentencia.executeQuery(consultaComprobacion);
					
					
					if (!rset.isBeforeFirst()) {
						rset = sentencia.executeQuery(consultaAlta);
						response.sendRedirect(contexto.getContextPath() + "/Login");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else {

			out.println("<div><h3>Alta de usuario</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<div><label>Usuario:</label>"
					+ "<input type='text' name='username'></div><br/>\n"
					+ "<div><label>Contraseña:</label>"
					+ "<input type='password' name='password'></div><br/>\n"
					+ "<div><label>Nombre:</label>"
					+ "<input type='text' name='nombre'></div><br/>\n"
					+ "<div><label>Admin:</label>"
					+ " No <input type='radio' name='admin' value='0' checked/>\n"
					+ " Sí <input type='radio' name='admin' value='1'/></div><br/>\n"
					+ "<div><label>Descripción:</label>"
					+ "<input type='textarea' name='descripcion'></div><br/>\n"
					+ "<input type='submit'  value='Crear usuario' name='enviar'>\n"
					+ "</form>\n" + "<p><a href='" + contexto.getContextPath()
					+ "/Login'>¿Ya estás registrado? Haz clic aquí</a></p>\n" + "<h3>" + mensajeError
					+ "</h3></div>\n");

		}
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}