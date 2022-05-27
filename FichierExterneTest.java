package info1.sae.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import info1.sae.FichierExterne;

public class FichierExterneTest {
	public static void main(String[] args) throws IOException {
		System.out.println(FichierExterne.estSauvegardeExistante());
		FichierExterne.creerFichierSauvegarde();
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
		FichierExterne.recupererDonneeSauvegarde();
	}
	
	
}
