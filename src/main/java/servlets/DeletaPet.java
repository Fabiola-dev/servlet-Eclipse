package servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pet;
import repositories.PetRepository;

@WebServlet("/DeletaPet")
public class DeletaPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PetRepository repository = new PetRepository();
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
//		String[] pathParts = req.getPathInfo().split("/");
//        int id = Integer.parseInt(pathParts[1]);
//		boolean deletado = repository.deleta(id);
//		
//		PrintWriter writer = resp.getWriter();
//		writer.print(deletado);
//		resp.setStatus(204);
		
		int id = Integer.parseInt(req.getParameter("id"));
		List<Pet> pets = repository.busca();
		Pet petParaDeletar = null;
		
		for(Pet pet : pets) {
			if (pet.getId() ==  id) {
				petParaDeletar = pet;
				break;
			}
		}
		
		if (petParaDeletar != null) {
			pets.remove(petParaDeletar);
		}
		
		resp.setStatus(204);
	}

}
