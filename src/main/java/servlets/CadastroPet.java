package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Pet;
import repositories.PetRepository;

@WebServlet("/CadastroPet")
public class CadastroPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PetRepository repository = new PetRepository();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		//resp.getWriter().print("Endpoint Post");
			
			Pet novoPet = new Pet();
			
			novoPet.setNome(req.getParameter("nome"));
			novoPet.setEspecie(req.getParameter("especie"));
			novoPet.setRaca(req.getParameter("raca"));
			novoPet.setPeso(Double.parseDouble(req.getParameter("peso")));
			
			repository.cadastra(novoPet);
			
			PrintWriter writer = resp.getWriter();
			writer.printf("<li>Pet cadastrado: %s, Especie: %s, "
					+ "Raca: %s, Peso: %.2f</li>",
					novoPet.getNome(),
					novoPet.getEspecie(),
					novoPet.getRaca(),
					novoPet.getPeso());
		
	}

}
