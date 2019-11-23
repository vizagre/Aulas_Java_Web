package br.com.didata.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdicionaEditoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			String nomeEditora = request.getParameter("nome");
			String emailEditora = request.getParameter("email");

			Editora editora = new Editora();
			editora.setNomeEditora(nomeEditora);
			editora.setEmailEditora(emailEditora);

			EditoraDAO dao = new EditoraDAO();
			dao.adiciona(editora);			

			out.println("<html>");
			out.println("<body>");
			out.println("Editora " + editora.getNomeEditora() + " Adicionada com sucesso!");
			out.println("</body>");
			out.println("</html>");		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
