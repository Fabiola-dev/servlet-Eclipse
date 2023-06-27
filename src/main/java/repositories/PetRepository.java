package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Pet;

public class PetRepository {
	
	private static List<Pet> pets = new ArrayList<>();
	private static int petId = 0;

	private static int incrementaId() {
		return ++petId;
	}
	public void cadastra(Pet pet) {
		pet.setId(incrementaId());
		pets.add(pet);
	}
	public List<Pet> busca() {
		return pets;
	}
	public Pet buscaId(int id) {
		for (Pet pet : pets) {
			if (pet.getId() == id) {
				return pet;
			}
		}
		return null;
	}
	public boolean deleta(int id) {
		
		for (Pet pet : pets) {
			if (pet.getId() == id) {
				pets.remove(pet);
				return true;
			} 
		}
		return false;
	}
	
}
