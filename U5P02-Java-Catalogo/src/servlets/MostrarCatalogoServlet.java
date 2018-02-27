package servlets;

import clases.Obra;
import clases.Autor;

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

/**
 * Servlet implementation class MostrarCatalogo
 */
@WebServlet("/MostrarCatalogo")
public class MostrarCatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarCatalogoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		
		Connection conn = null;
		Statement sentencia = null;
		
		try {
		  // Paso 1: Cargar el driver JDBC.
		 Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		  String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost:3306/catalogo22";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear la sentencia SQL
		  sentencia = conn.createStatement();
		  

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  String order="";
		  
		  if(request.getParameter("order")!=null) {
		  if(request.getParameter("order").equals("1")){
			  order="ORDER BY titulo ASC;";
		  	}else if(request.getParameter("order").equals("2")){
			  order="ORDER BY titulo DESC;";
		  	}else if(request.getParameter("order").equals("3")){
				  order="ORDER BY nombre ASC;";
		  	}else if(request.getParameter("order").equals("4")){
				  order="ORDER BY nombre DESC;";
		  	}
		  }
		  
		  String consulta = "SELECT * from obra,autor WHERE obra.idAutor=autor.id "+ order;
		  
		  
		  ResultSet rset = sentencia.executeQuery(consulta);

		   // Paso 5: Mostrar resultados
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  
		  
		  if(request.getParameter("titulo")!=null) {
			  String tit = request.getParameter("titulo");
			  String consulta2 = "SELECT * from obra,autor WHERE obra.idAutor=autor.id AND obra.titulo LIKE '%"+tit+"%'";
			  ResultSet rset2 = sentencia.executeQuery(consulta2);
			  
			  if (!rset2.isBeforeFirst() ) {    
				    out.println("<h3>No hay resultados</p>");
				}
			  
			  out.println("<table style='border:'5px''>");
			  out.println("<tr style='background-color:yellow'>"
			  		+ "<td>Titulo</td>"
			  		+ "<td>Autor</td>"
			  		+ "<td>Imagen</td></tr>");
			  while (rset2.next()) {
				 Obra obra3=new Obra(rset2.getInt("idObra"), rset2.getString("titulo"), rset2.getInt("año"), rset2.getInt("idAutor"), rset2.getString("imagen"));
				
				out.println("<tr style='background-color:lightgreen'>");
			    out.println("<td>" + obra3.getTitulo() + "</td>"
			    		+ "<td> " + rset2.getString("nombre") + "</td>"
			    		+ "<td><img src='./img/"+obra3.getImagen()+"' width=100 heigh=100></td></tr>");
			  }
			  out.println("</table>");
			  
		  }else  if(request.getParameter("idAutor")==null) {
		
		  out.println("<table style='border:'5px''>");
		  out.println("<tr style='background-color:yellow'>"
		  		+ "<td>Titulo<a href=MostrarCatalogo?order=1>&#9650;</a><a href=MostrarCatalogo?order=2>&#9660;</a></td>"
		  		+ "<td>Autor<a href=MostrarCatalogo?order=3>&#9650;</a><a href=MostrarCatalogo?order=4>&#9660;</a></td>"
		  		+ "<td>Imagen</td></tr>");
		  while (rset.next()) {
			  Obra obra=new Obra(rset.getInt("idObra"), rset.getString("titulo"), rset.getInt("año"), rset.getInt("idAutor"), rset.getString("imagen"));
			
			out.println("<tr style='background-color:lightgreen'>");
		    out.println("<td>" +"<a href=MostrarObra?id_obra='"+obra.getIdObra()+"'>"+obra.getTitulo() + "</td>"
		    		+ "<td><a href=MostrarCatalogo?idAutor='"+obra.getIdAutor()+"'>"+rset.getString("nombre")+"</td>"
		    				+ "<td><img src='./img/"+obra.getImagen()+"' width=100 heigh=100></td></tr>");
		  }
		  out.println("</table>");
		  
		  }else if(request.getParameter("idAutor")!=null){
			  String idAutor=request.getParameter("idAutor");
			  String consulta1 = "SELECT * from obra,autor WHERE obra.idAutor=autor.id AND autor.id="+idAutor;
			  ResultSet rset1 = sentencia.executeQuery(consulta1);
			  
			  if (!rset1.isBeforeFirst() ) {    
				    out.println("<h3>No hay resultados</p>");
				}
			  
			  out.println("<table style='border:'5px''>");
			  out.println("<tr style='background-color:yellow'>"
			  		+ "<td>Titulo<a href=MostrarCatalogo?op=1>&#9650;</a><a href=MostrarCatalogo?op=2>&#9660;</a></td>"
			  		+ "<td>Autor<a href=MostrarCatalogo?op=3>&#9650;</a><a href=MostrarCatalogo?op=4>&#9660;</a></td>"
			  		+ "<td>Nacionalidad</td>"
			  		+ "<td>Imagen</td></tr>");
			  while (rset1.next()) {
				  
				 Obra obra1=new Obra(rset1.getInt("idObra"), rset1.getString("titulo"), rset1.getInt("año"), rset1.getInt("idAutor"), rset1.getString("imagen"));
				 Autor autor=new Autor(rset1.getInt("id"), rset1.getString("nombre"), rset1.getString("nacionalidad"), rset1.getString("genero"));
				
				 out.println("<tr style='background-color:lightgreen'>");
			    out.println("<td><a href=MostrarObra?id_obra='"+obra1.getIdObra()+"'>"+obra1.getTitulo() + 
			    		"</td><td> " + autor.getNombre() + 
			    		"</td><td>"+autor.getNacionalidad()+
			    		"</td><td><img src='./img/"+obra1.getImagen()+"' width=100 heigh=100></td></tr>");
			  }
			  out.println("</table>");
			  
		  } 
			 
		  
		  
		  out.println("<form action='MostrarCatalogo' method='post'><br/>");
		    out.println("<label>Buscar: </label>");
		    out.println("<input type='text' name='titulo'>");
		    out.println("<input type='submit' value='Enviar' name='enviar'>");
		  out.println("</form>");
		  
		  

		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	
		out.print("<a href=MostrarCatalogo>Eliminar filtros");
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}