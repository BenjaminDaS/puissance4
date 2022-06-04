package info1.sae.test;

import info1.sae.RecherchePuissance4;

import javax.swing.text.Position.Bias;

import info1.sae.IA;

public class IATest {
	
	public static void main(String[] args) {
		puissance4HorizontalTest();
	}
	
	
	public static void puissance4HorizontalTest() {
		int[] pion1;
		int[] pion2;
		final String[][] TESTLISTE1 =  {
				{"rouge","jaune","jaune","rouge","jaune","rouge"},
				{"jaune","rouge","rouge","rouge","vide ","vide "},
				{"rouge","rouge","rouge","jaune","vide ","vide "},
				{"jaune","rouge","rouge","jaune","jaune","vide "},
				{"jaune","vide ","vide ","vide ","vide ","vide "},
				{"vide ","vide ","vide ","vide ","vide ","vide "},
				{"vide ","vide ","vide ","vide ","vide ","vide "}
				};
		
		pion1 = IA.pionIA(TESTLISTE1);
		if(pion1[0] != 1 || pion1[1] != 4) {
			throw new IllegalArgumentException("Erreur lors du test de la methode rechercheHorizontale");
		}
		
		final String[][] TESTLISTE2 = {
				
				{"jaune","rouge","rouge","jaune","rouge","jaune"},
				{"rouge","jaune","jaune","jaune","vide ","vide "},
				{"jaune","rouge","rouge","jaune","vide ","vide "},
				{"rouge","jaune","jaune","rouge","rouge","vide "},
				{"jaune","jaune","vide ","vide ","vide ","vide "},
				{"vide ","vide ","vide ","vide ","vide ","vide "},
				{"vide ","vide ","vide ","vide ","vide ","vide "}
				};

		if(IA.pionIA(TESTLISTE2).equals(IA.pionIA(TESTLISTE2)) && IA.pionIA(TESTLISTE2).equals(IA.pionIA(TESTLISTE2))) {
			throw new IllegalArgumentException("Erreur lors du test de la methode rechercheHorizontale");
		}
	}
}
