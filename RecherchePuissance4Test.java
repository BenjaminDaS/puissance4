package info1.sae.test;

import info1.sae.RecherchePuissance4;
public class RecherchePuissance4Test {
	public static void main(String[] args) {
		//rechercheVerticaleTest();
		//rechercheDiagonaleBasGaucheHautDroiteTest();
		//rechercheHorizontaleTest();
		//rechercheDiagonaleBasDroiteHautGaucheTest();
		PasDePuissanceTest();
	}
	
	public static void rechercheVerticaleTest() {
		final String[][] TESTLISTE1 =  {{"jaune","rouge","rouge","rouge","rouge","jaune"},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "}};
		final int[] TESTPION1 = {0,4};
		final String TESTCOULEUR1 = "rouge";
		if(!RecherchePuissance4.recherche(TESTLISTE1, TESTCOULEUR1, TESTPION1)) {
			throw new IllegalArgumentException("Erreur lors du test de la methode rechercheVerticale");
		}
	}
	
	public static void rechercheDiagonaleBasGaucheHautDroiteTest() {
		final String[][] TEST2LISTE =  {{"jaune","rouge","rouge","jaune","rouge","jaune"},
										{"rouge","jaune","rouge","jaune","vide ","vide "},
										{"jaune","rouge","jaune","rouge","vide ","vide "},
										{"rouge","jaune","jaune","rouge","rouge","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "}};
		final int[] TESTPION2 = {2,3};
		final String TESTCOULEUR2 = "rouge";
		if(!RecherchePuissance4.recherche(TEST2LISTE, TESTCOULEUR2, TESTPION2)) {
			throw new IllegalArgumentException("Erreur lors du test de la methode rechercheDiagonaleBasGaucheHautDroite");
		}
	}
	
	public static void rechercheHorizontaleTest() {
		final String[][] TESTLISTE3 =  {{"jaune","rouge","rouge","jaune","rouge","jaune"},
										{"rouge","jaune","jaune","jaune","vide ","vide "},
										{"jaune","jaune","jaune","rouge","vide ","vide "},
										{"rouge","jaune","jaune","rouge","rouge","vide "},
										{"rouge","jaune","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "}};
		final int[] TESTPION3 = {2,1};
		final String TESTCOULEUR3 = "jaune";
		if(!RecherchePuissance4.recherche(TESTLISTE3, TESTCOULEUR3, TESTPION3)) {
			throw new IllegalArgumentException("Erreur lors du test de la methode rechercheHorizontale");
		}
	}
	
	public static void rechercheDiagonaleBasDroiteHautGaucheTest() {
		final String[][] TEST4LISTE =  {{"jaune","rouge","rouge","jaune","rouge","jaune"},
										{"rouge","jaune","jaune","jaune","vide ","vide "},
										{"jaune","rouge","jaune","rouge","vide ","vide "},
										{"rouge","jaune","jaune","rouge","rouge","vide "},
										{"jaune","jaune","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "}};
		final int[] TESTPION4 = {3,1};
		final String TESTCOULEUR4 = "jaune";
		if(!RecherchePuissance4.recherche(TEST4LISTE, TESTCOULEUR4, TESTPION4)) {
			throw new IllegalArgumentException("Erreur lors du test de la methode rechercheDiagonaleBasDroiteHautGauche");
		}
	}
	
	public static void PasDePuissanceTest() {
		final String[][] TEST1LISTE =  {{"jaune","rouge","rouge","jaune","rouge","jaune"},
										{"rouge","jaune","jaune","jaune","vide ","vide "},
										{"jaune","rouge","rouge","rouge","vide ","vide "},
										{"rouge","jaune","jaune","rouge","rouge","vide "},
										{"jaune","jaune","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "},
										{"vide ","vide ","vide ","vide ","vide ","vide "}};
		final int[] TEST1PION = {3,1};
		final String TEST1COULEUR = "jaune";
		if(RecherchePuissance4.recherche(TEST1LISTE, TEST1COULEUR, TEST1PION)) {
			throw new IllegalArgumentException("Erreur lors du test avec un tableau ne contenant pas de puissance");
		}
	}
}
