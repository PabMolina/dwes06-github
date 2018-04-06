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
 * Servlet implementation class DetallesProductoServlet
 */
@WebServlet("/DetallesProducto")
public class DetallesProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallesProductoServlet() {
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

		 Class.forName("org.mariadb.jdbc.Driver").newInstance();

		 String userName = contexto.getInitParameter("usuario");
			String password = contexto.getInitParameter("password");
			String url = contexto.getInitParameter("url");
			conn = DriverManager.getConnection(url, userName, password);

		  sentencia = conn.createStatement();
		  
		  String where="";
		  
			if(request.getParameter("idproducto")!=null) {
				where=" WHERE idproducto="+request.getParameter("idproducto");
			}
			
			String consulta = "SELECT * FROM producto, ubicacion" + where + " AND producto.ubicacion=ubicacion.idubicacion"; 
			ResultSet rset = sentencia.executeQuery(consulta);
			
			 if (!rset.isBeforeFirst() ) {    
				    out.println("<h3>No hay resultados</p>");
				}
			  
			  out.println("<table style='border:'5px''>");
			  out.println("<tr style='background-color:yellow'>"
			  		+ "<td>Nombre</td>"
			  		+ "<td>Marca</td>"
			  		+ "<td>Precio</td>"
			  		+ "<td>Stock</td>"
			  		+ "<td>Descripción</td>"
			  		+ "<td>Imagen</td>"
			  		+ "<td>Familia</td>"
			  		+ "<td>Pasillo</td>"
			  		+ "<td>Módulo</td>"
			  		+ "<td>Altura</td>"
			  		+ "<td>Hueco</td>"
			  		+ "</tr>");
			  while (rset.next()) {
				  
				
				  out.println("<tr style='background-color:lightgreen'>");
				    out.println("<td>" + rset.getString("nombre") + "</td>"
				    		+"<td>" + rset.getString("marca") + "</td>"
				    		+ "<td> " + rset.getDouble("precio") + "</td>"
				    		+ "<td> " + rset.getInt("stock") + "</td>"
				    		+ "<td> " + rset.getString("descripcion") + "</td>"
				    		+ "<td><img src='./img/productos/"+rset.getString("imagen")+"' width=100 heigh=100></td>"
				    		+ "<td> " + rset.getString("familia") + "</td>"
				    		+ "<td> " + rset.getInt("pasillo") + "</td>"
				    		+ "<td> " + rset.getInt("modulo") + "</td>"
				    		+ "<td> " + rset.getInt("altura") + "</td>"
				    		+ "<td> " + rset.getInt("hueco") + "</td>");
				  }
				  out.println("</table>");
				  out.println("<a href = MostrarProductos>Volver al catálogo");
			
				  if (sentencia != null) {
						sentencia.close();
				  }
					 if (conn != null) {
						conn.close();
					 }
					 
					 HttpSession session = request.getSession(false);
						Usuario usuario = (Usuario) session.getAttribute("usuario");
						out.println("<h4>Sesión iniciada por <a href='" + contexto.getContextPath() + "/Cuenta'>"
								+ usuario.getNombre() + "</a></h4>");
						  
		  
		} catch (Exception e) {
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
