package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesarDatosServlets
 */
@WebServlet("/ProcesarDatos")
public class ProcesarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarDatosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<ul>");
		Enumeration<String> parametros= request.getParameterNames();
		while(parametros.hasMoreElements()) {
			out.println("<li>"+parametros.nextElement()+"</li>");
		}
		out.println("</ul>");
		
		Map<String, String[]> parejas=request.getParameterMap();
		parejas.forEach((campo,valor)->{
			out.println("<p>"+campo+": ");
			for(String val: valor) {
				out.println("- "+val);
			}
		});
		
		SimpleDateFormat formatoFecha =new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fecha=formatoFecha.parse(request.getParameter("fecha"));
			SimpleDateFormat formatoFechaFinal= new SimpleDateFormat("dd/MM/yyyy");
			out.println("<p>Fecha: "+formatoFechaFinal.format(fecha)+"</p>");
		}catch(java.text.ParseException e) {
			e.printStackTrace();
		}
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