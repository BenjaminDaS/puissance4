package info1.sae.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import info1.sae.FichierExterne;

public class FichierExterneTest {
	public static void main(String[] args) throws IOException {
		sauvegarderTest();
	}
	
	public static void sauvegarderTest() throws FileNotFoundException {
		final String[][] TESTLISTE1 =  {
				{"jaune","rouge","rouge","jaune","rouge","jaune"},
				{"rouge","jaune","jaune","jaune", "vide", "vide"},
				{"jaune","rouge","jaune","rouge", "vide", "vide"},
				{"rouge","jaune","jaune","rouge","rouge", "vide"},
				{"jaune","jaune", "vide", "vide", "vide", "vide"},
				{ "vide", "vide", "vide", "vide", "vide", "vide"},
				{ "vide", "vide", "vide", "vide", "vide", "vide"}};
		FichierExterne.sauvegarder("jaune", "jvj", "Benjamin Simon",TESTLISTE1);
		
		
		if (!FichierExterne.recupererDonneeSauvegarde().equals("jaune jvj Benjamin"
				+ " Simon jaune rouge rouge jaune rouge jaune rouge jaune jaune"
				+ " jaune vide vide jaune rouge jaune rouge vide vide rouge jaune"
				+ " jaune rouge rouge vide jaune jaune vide vide vide vide vide"
				+ " vide vide vide vide vide vide vide vide vide vide vide ")) {
			throw new IllegalArgumentException("Erreur lors du test de la "
					+ "Sauvegarde et de la récupération d'un fichier");
		}
	}
	
	
}
