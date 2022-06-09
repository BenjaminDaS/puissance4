package info1.sae.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import info1.sae.FichierExterne;

public class FichierExterneTest {
	public static void main(String[] args) throws IOException {
		sauvegarderTest();
	}
	
	public static void sauvegarderTest() throws FileNotFoundException {
		boolean testOk;
		String[][] listeCompare;
		final String[][] TESTLISTE1 =  {
				{"jaune","rouge","rouge","jaune","rouge","jaune"},
				{"rouge","jaune","jaune","jaune", "vide", "vide"},
				{"jaune","rouge","jaune","rouge", "vide", "vide"},
				{"rouge","jaune","jaune","rouge","rouge", "vide"},
				{"jaune","jaune", "vide", "vide", "vide", "vide"},
				{ "vide", "vide", "vide", "vide", "vide", "vide"},
				{ "vide", "vide", "vide", "vide", "vide", "vide"}};
		FichierExterne.sauvegarderJcj("jaune", "Benjamin", "Simon", TESTLISTE1);
		FichierExterne.recupererDonneeSauvegardeJcj();
		testOk = FichierExterne.getCouleur().equals("jaune");
		testOk &= FichierExterne.getJoueur1().equals("Benjamin");
		testOk &= FichierExterne.getJoueur2().equals("Simon");
		listeCompare = FichierExterne.getTableau();
		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 6; y++) {
				testOk &= listeCompare[i][y].equals(TESTLISTE1[i][y]);
			}
		}
		
		if(!testOk) {
			throw new IllegalArgumentException("Erreur lors du test de la sauvegarde/récupération du mode joueur contre joueur");
		}
		
		
		FichierExterne.sauvegarderJco("jaune", "Benjamin", TESTLISTE1);
		FichierExterne.recupererDonneeSauvegardeJco();
		String[][] Table = FichierExterne.getTableau();
		
		testOk = FichierExterne.getCouleur().equals("jaune");
		testOk &= FichierExterne.getJoueur1().equals("Benjamin");
		listeCompare = FichierExterne.getTableau();
		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 6; y++) {
				testOk &= listeCompare[i][y].equals(TESTLISTE1[i][y]);
			}
		}
		
		if(!testOk) {
			throw new IllegalArgumentException("Erreur lors du test de la sauvegarde/récupération du mode joueur contre ordinateur");
		}
	}
	
}
