package info1.sae;

public class RecherchePuissance4 {
	/** recherche à chaque tour via un import de cette méthode si le jeu possède 
	 * quatre pions de la même couleur aligné
     * @param tableau 		tableau contenant les couleurs des pions placés à leurs positions
     * @param couleur       couleur du dernier pion placé
     * @param pion        	position du dernier pion placé
     * @return 				un boolean true si il existe quatre pions de la même couleur
     * 						alignés
     */
	public static boolean recherche(String[][] tableau, String couleur, int[] pionTest) {
		
		if (rechercheVerticale(tableau, couleur, pionTest)) {
			return true;
		} else if (rechercheDiagonaleBasGaucheHautDroite(tableau, couleur, pionTest)) {
			return true;
		} else if (rechercheHorizontale(tableau, couleur, pionTest)) {
			return true;
		}else if (rechercheDiagonaleBasDroiteHautGauche(tableau, couleur, pionTest)) {
			return true;
		} else {
			return false;
		}
    }
    
    public static boolean rechercheVerticale(String[][] tableau, String couleur,int[] pionTest) {
    	int[] pion = pionTest.clone();
    	boolean puissance4 = false;
    	if (pion[1] >= 3) {
	    	puissance4 = tableau[pion[0]][pion[1]-1].equals(couleur);
	    	puissance4 &= tableau[pion[0]][pion[1]-2].equals(couleur);
	    	puissance4 &= tableau[pion[0]][pion[1]-3].equals(couleur);
	    	return puissance4;
	    	
    	} else {
    		return puissance4;
    	}
    	
    }
    
    public static boolean rechercheDiagonaleBasGaucheHautDroite(String[][] tableau, String couleur,int[] pionTest) {
    	int[] pion = pionTest.clone();
    	boolean puissance4 = false;
    	while(pion[0] != 0 && pion[1] != 0 && tableau[pion[0]-1][pion[1]-1].equals(couleur)) {
    		pion[0] -= 1;
    		pion[1] -= 1;
    	}
    	if (pion[0] < 5 && pion[1] < 4) {
    		puissance4 = tableau[pion[0]+1][pion[1]+1].equals(couleur);
	    	puissance4 &= tableau[pion[0]+2][pion[1]+2].equals(couleur);
	    	puissance4 &= tableau[pion[0]+3][pion[1]+3].equals(couleur);
	    	return puissance4;
    	}
    	return puissance4;
    }
    
    public static boolean rechercheHorizontale(String[][] tableau, String couleur,int[] pionTest) {
    	int[] pion = pionTest.clone();
    	boolean puissance4 = false;
    	while(pion[0] != 0 && tableau[pion[0]-1][pion[1]].equals(couleur)) {
    		pion[0] -= 1;
    	}
    	if (pion[0] < 5) {
    		puissance4 = tableau[pion[0]+1][pion[1]].equals(couleur);
	    	puissance4 &= tableau[pion[0]+2][pion[1]].equals(couleur);
	    	puissance4 &= tableau[pion[0]+3][pion[1]].equals(couleur);
	    	return puissance4;
    	}
    	return puissance4;
    }
    
    public static boolean rechercheDiagonaleBasDroiteHautGauche(String[][] tableau, String couleur,int[] pionTest) {
    	int[] pion = pionTest.clone();
    	boolean puissance4 = false;
    	while(pion[0] != 6 && pion[1] != 0 && tableau[pion[0]+1][pion[1]-1].equals(couleur)) {
    		pion[0] += 1;
    		pion[1] -= 1;
    	}
    	if (pion[0] > 3 && pion[1] < 4) {
    		puissance4 = tableau[pion[0]-1][pion[1]+1].equals(couleur);
	    	puissance4 &= tableau[pion[0]-2][pion[1]+2].equals(couleur);
	    	puissance4 &= tableau[pion[0]-3][pion[1]+3].equals(couleur);
	    	return puissance4;
    	}
    	return puissance4;
    }
}