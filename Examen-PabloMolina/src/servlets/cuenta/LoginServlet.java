package servlets.cuenta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;
import modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext contexto = request.getServletContext();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;UTF-8");
		HttpSession session = request.getSession(false); 
		String mensajeError = "";
		
		
		out.println("<html><head><meta charset='UTF-8'/></head><body>");

		Connection conn = null;
		Statement sentencia = null;
		try {
			
			Class.forName("org.mariadb.jdbc.Driver").newInstance();

			
			String userName = contexto.getInitParameter("usuario");
			String password = contexto.getInitParameter("password");
			String url = contexto.getInitParameter("url");
			conn = DriverManager.getConnection(url, userName, password);
			
						sentencia = conn.createStatement();

						if (session != null) {
							if ((session.getAttribute("login") != null)) { 
								response.sendRedirect(contexto.getContextPath() + "/"); 
							}
						} else { 
							if (request.getMethod().equals("POST")) { 

								if (request.getParameter("nick") == "") {
									mensajeError += "Campo login vacio, rellénelo.";
								} else {
									
									if (request.getParameter("contraseña") == "") {
										mensajeError += "Campo password vacio, rellénelo.";
									} else {
										if (request.getParameter("nick") != "") {

											String consulta = "SELECT * FROM cliente where cliente.login LIKE '"
													+ request.getParameter("nick") + "'";
											ResultSet rset = sentencia.executeQuery(consulta);
											
											if (!rset.isBeforeFirst()) {
												mensajeError = "No existe el usuario.";
												
											} else {
												rset.next();

												if (!rset.getString("password").equals(request.getParameter("contraseña"))) {

													mensajeError += "La contraseña no es correcta. Vuelva a introducirla";
												} else {
													
														session = request.getSession(); 

														Usuario user = new Usuario(rset.getString("login"), rset.getString("password"), rset.getString("nombre"), rset.getString("direccion"), rset.getDouble("gasto"));
														session.setAttribute("usuario", user);
														contexto.log(" * Creando sesión en " + request.getRequestURI());
														ArrayList<Producto> ListaCompra = new ArrayList<>();
														HttpSession session2 = request.getSession();
													    session2.setAttribute("MiCompra", ListaCompra);
														response.sendRedirect(contexto.getContextPath() + "/");

													} 
												}

											}
										}
									}
								
								}
								

							}
							out.println("<h3>Inicio de sesión</h3>");
							out.println("<form action='" + request.getRequestURI() + "' method='post'>"
									+ "<label> Usuario:</label><br><input type='text' name='nick'><br>"
									+ "<label> Contraseña:</label><br><input type='password' name='contraseña'><br>"
									+ "<input type='submit' value='Iniciar sesión' name='enviar'>"
									+ "</form>" + "<h3>" + mensajeError
									+ "</h3>");

						}catch(Exception e){
							e.printStackTrace();
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
