package poupeesrusses;

import java.io.IOException;
import java.net.URL;

import prompter.Prompter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//Création d'un prompt console
		Prompter console = new Prompter();

		//Init de l'exercice
		URL file = ClassLoader.getSystemClassLoader().getResource("names.txt");
		RussianDoll RDC = new RussianDoll(file);
		
		//Exercice Russian Doll
		getDollsNames(RDC, console);
		
		//Fermeture du prompt console
		console.close();
	}
	
	/**
	 * Parcourrir l'ensemble des objets RussianDoll et afficher le prénom de chacune d'entre elles. 
	 * 
	 * @param russianDoll
	 * @param console
	 */
	static void getDollsNames(RussianDoll russianDoll, Prompter console){
		//A implémenter
	}
	
}
