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

@WebServlet("/buscaPet")
public class BuscaPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PetRepository repository = new PetRepository();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		//resp.getWriter().print("Endpoint Get");
		
		List<Pet> pets = repository.busca();
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		if (pets.isEmpty()) {
            writer.println("<h2>Nenhum animal cadastrado.</h2>");
        } else {
            writer.println("<h2>Animais cadastrados:</h2>");
            for (Pet pet : pets) {
            	writer.println("<p>ID: " + pet.getId() + "</p>");
                writer.println("<p>Nome: " + pet.getNome() + "</p>");
                writer.println("<p>Espécie: " + pet.getEspecie() + "</p>");
                writer.println("<p>Raça: " + pet.getRaca() + "</p>");
                writer.println("<p>Peso: " + pet.getPeso() + "</p>");
                writer.println("<hr>");
            }
        }

        writer.println("</body></html>");
    }
}
		
