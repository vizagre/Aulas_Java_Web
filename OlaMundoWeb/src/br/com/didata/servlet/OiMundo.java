package br.com.didata.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OiMundo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Primeiro exemplo de servlet</h3>");
		out.println("<br/>");
		out.println("Usando tags html");
		out.println("</body>");
		out.println("</html>");
	}
}
