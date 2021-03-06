package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ContadorFilter
 */
//@WebFilter("/ContadorFilter")
public class ContadorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ContadorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Aplicando filtro de contador");
		ServletContext contexto= request.getServletContext();
		
		if(contexto.getAttribute("contador")!=null){
			int cont=(int)contexto.getAttribute("contador")+1;
			contexto.setAttribute("contador", cont);
			System.out.println("Incrementando contador.");

		}else {
			int cont=new Integer(0);
			contexto.setAttribute("contador", cont);
			System.out.println("Creando contador.");

		}

		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}