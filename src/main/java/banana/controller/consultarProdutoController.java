package banana.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import banana.model.Produto;

/**
 * Servlet implementation class buscarProdutoController
 */
@WebServlet("/consultarProdutoController")
public class consultarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public consultarProdutoController() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String descricao = request.getParameter("descricao");
		
		try {
			ArrayList<Produto> produtos = new Produto().consultar(descricao);
			request.setAttribute("produtos", produtos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}