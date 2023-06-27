package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pet;
import repositories.PetRepository;

@WebServlet("/atualizaPet")
public class AtualizaPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PetRepository repository = new PetRepository();
	
	public void doPut(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		Pet petAtualizado = repository.buscaId(id);
		
		if (petAtualizado != null) {
			String nome = req.getParameter("nome");
			if (nome != null) {
				petAtualizado.setNome(nome);
			}
			String especie = req.getParameter("especie");
			if (especie != null) {
				petAtualizado.setNome(especie);
			}
			String raca = req.getParameter("raca");
			if (raca != null) {
				petAtualizado.setNome(raca);
			}
			String peso = req.getParameter("peso");
			if (peso != null) {
				petAtualizado.setNome(peso);
			}

			resp.getWriter().println("Pet atualizado com sucesso!");

		} else {
			resp.getWriter().println("ID não encontrado.");
		}				
	}
	
}
