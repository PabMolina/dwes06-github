package servlets;

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
import javax.servlet.http.HttpSession;

import modelo.Usuario;


/**
 * Servlet implementation class MostrarProductos
 */
@WebServlet(urlPatterns = { "/MostrarProductos", "" })
public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><h1>Supermercado Pablo Molina</h1><h2><img src='img/supermercado1.jpg'></h2></head><body>");
		
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

		  // Paso 3: Crear la sentencia SQL
		  sentencia = conn.createStatement();
		  
		  String consulta = "SELECT DISTINCT familia FROM producto";
		  
		  
		  ResultSet rset = sentencia.executeQuery(consulta);
		  String order="";
		  String where="";
		  String and="";
		  String nFam="";
		  
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  while (rset.next()) {
				
			    out.println("<li><a href='MostrarProductos?familia=" + rset.getString("familia") + "'>" + rset.getString("familia") + "</a></li><br>");
			  }
		  
		  if(request.getParameter("order")!=null) {
			  if(request.getParameter("order").equals("1")){
				  order=" ORDER BY nombre ASC;";
			  	}else if(request.getParameter("order").equals("2")){
				  order=" ORDER BY nombre DESC;";
			  	}else if(request.getParameter("order").equals("3")){
					  order=" ORDER BY marca ASC;";
			  	}else if(request.getParameter("order").equals("4")){
					  order=" ORDER BY marca DESC;";
			  	}
			  }
		  
		  if(request.getParameter("familia")==null) {
			  
			  where = " WHERE familia = 'Bio'";
		  }
		  
		  
		  
		  if(request.getParameter("familia")!=null) {
			  
			  nFam=request.getParameter("familia");
			  where = " WHERE familia = '" +nFam+ "'";
		  }
		  
		  if(request.getParameter("buscarnombre")!=null) {
			  String buscar = request.getParameter("buscarnombre");
			  and = " AND nombre LIKE '%"+buscar+"%'";
			  
		  }
		  
		  
		  String consulta2 = "SELECT * FROM producto" + where + and + order + "";
		  
		  
		  ResultSet rset2 = sentencia.executeQuery(consulta2);
		  
		  if (!rset2.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  
		  out.println("<form action='MostrarProductos' method='post'><br/>");
		    out.println("<label>Buscar un producto: </label>");
		    out.println("<input type='text' name='buscarnombre'>");
		    out.println("<input type='submit' value='Enviar' name='enviar'>");
		  out.println("</form>");
	  
		  
		  out.println("<table style='border:'5px''>");
		  out.println("<tr style='background-color:yellow'>"
		  		+ "<td>Nombre<a href=MostrarProductos?order=1>&#9650;</a><a href=MostrarProductos?&order=2>&#9660;</a></td>\"</td>"
		  		+ "<td>Marca<a href=MostrarProductos?order=3>&#9650;</a><a href=MostrarProductos?order=4>&#9660;</a></td>\"</td>"
		  		+ "<td>Imagen</td></tr>");
		  while (rset2.next()) {
		  
			  out.println("<tr style='background-color:lightgreen'>");
			    out.println("<td><a href=DetallesProducto?idproducto='"+rset2.getInt("idproducto")+"'>" + rset2.getString("nombre") + "<a href=AñadirCesta?idproducto='"+rset2.getInt("idproducto")+"'><img src='img/carrito1.png' width=20 heigh=20></td>"
			    		+ "<td> " + rset2.getString("marca") + "</td>"
			    		+ "<td><img src='./img/productos/"+rset2.getString("imagen")+"' width=100 heigh=100></td>"
			    		+ "</tr>");
			  }
			  out.println("</table>");
		    
		  
	 if (sentencia != null) {
		sentencia.close();
		}
	
	 if (conn != null) {
		conn.close();
	 }
	 
	 HttpSession session = request.getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		out.println("<h4>Sesión iniciada por <a href='" + contexto.getContextPath() + "/Cuenta'>" + usuario.getLogin() + "</a></h4>");
		  
	}catch (Exception e) {
		  e.printStackTrace();
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
