package banana.controller;

import java.io.IOException;
import java.sql.SQLException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import banana.model.Produto;

/**
 * Servlet implementation class modificarProdutoController
 */

@WebServlet("/modificarProdutoController")
public class modificarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public modificarProdutoController() {
       super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String excluir = request.getParameter("alterar");
		String id = request.getParameter("id");
		
		if(excluir != null && id != null) {
			try {
				new Produto().excluir(Integer.valueOf(id));
				RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
				request.setAttribute("mensagem", "Produto apagado com sucesso!");
				dispatcher.forward(request, response);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			};
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String excluir = request.getParameter("excluir");
		String id = request.getParameter("id");
		
		if(excluir != null && id != null) {
			try {
				new Produto().excluir(Integer.valueOf(id));
				RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
				request.setAttribute("mensagem", "Produto apagado com sucesso!");
				dispatcher.forward(request, response);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			};
		}
		
	}

}
