package svts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "Servlet" ,urlPatterns = {"testme","jupiter.html","*"})
public class MyFirstServlet extends HttpServlet {

	private static final long serialVersionUID = -8873626480277569992L;

	/**
	 * Servlet initialisieren wenn nötig
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		//System.out.println("Start Servlet");
	}

	/**
	 * Diese Methode wird ausgeführt wenn die URL des Servlets aufgerufen wird
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"ISO-8859-1\">");
		out.write("<style>\r\n"
				+ "h1 {color:red;}"
				+ "h2 {color:orange;}"
				+ "h3 {color:steelblue;}"
				+ "</style>");
		out.write("<title>Unser Servlet</title>");
		out.write("</head>");
		out.write("<body>");
		
		out.println("<h1>Arbeiten mit Servlets</h1>");
		
		out.write("</body>");
		out.write("</html>");
		out.flush();
	}
	
	
	/**
	 * Aufräumen wenn die Applikation beendet wird
	 */
	@Override
	public void destroy() {
		super.destroy();
		//System.out.println("Ende Servlet");
	}
	
	
}
