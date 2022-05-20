package info1.sae;

public class RecherchePuissance4 {
	/** recherche � chaque tour via un import de cette m�thode si le jeu poss�de 
	 * quatre pions de la m�me couleur align�
     * @param tableau 		tableau contenant les couleurs des pions plac�s � leurs positions
     * @param couleur       couleur du dernier pion plac�
     * @param pion        	position du dernier pion plac�
     * @return 				un boolean true si il existe quatre pions de la m�me couleur
     * 						align�s
     */
	public static boolean recherche(String[][] tableau, String couleur, int[] pionTest) {
		
		//if (rechercheVerticale(tableau, couleur, pionTest)) {
		//	return true;
		//} else if (rechercheDiagonaleBasGaucheHautDroite(tableau, couleur, pionTest)) {
		//	return true;
		//} else if (rechercheHorizontale(tableau, couleur, pionTest)) {
		//	return true;
		//}else 
		if (rechercheDiagonaleBasDroiteHautGauche(tableau, couleur, pionTest)) {
			return true;
		} else {
			return false;
		}
    }
    
    public static boolean rechercheVerticale(String[][] tableau, String couleur,int[] pion) {
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
    
    public static boolean rechercheDiagonaleBasGaucheHautDroite(String[][] tableau, String couleur,int[] pion) {
    	boolean puissance4 = true;
    	while(pion[0] != 0 && pion[1] != 0 && tableau[pion[0]-1][pion[1]-1].equals(couleur)) {
    		pion[0] -= 1;
    		pion[1] -= 1;
    	}
    	for (int i = 0; i < 3 && pion[0] != 6 && pion[1] != 5;i ++) {
    		if (tableau[pion[0]+i+1][pion[1]+i+1].equals(couleur)) {
    			puissance4 &= true;
    		} else {
    			puissance4 &= false;
    		}
    	}
    	return puissance4;
    }
    
    public static boolean rechercheHorizontale(String[][] tableau, String couleur,int[] pion) {
    	boolean puissance4 = true;
    	while(pion[0] != 0 && tableau[pion[0]-1][pion[1]].equals(couleur)) {
    		pion[0] -= 1;
    	}
    	for (int i = 0; i < 3 && pion[0] != 6;i ++) {
    		if (tableau[pion[0]+1][pion[1]].equals(couleur)) {
    			pion[0] += 1;
    			puissance4 &= true;
    		} else {
    			puissance4 &= false;
    		}
    	}
    	return puissance4;
    }
    
    public static boolean rechercheDiagonaleBasDroiteHautGauche(String[][] tableau, String couleur,int[] pion) {
    	System.out.println(pion[0] + " " + pion[1]);
    	boolean puissance4 = true;
    	while(pion[0] != 6 && pion[1] != 0 && tableau[pion[0]+1][pion[1]-1].equals(couleur)) {
    		pion[0] += 1;
    		pion[1] -= 1;
    	}
    	for (int i = 0; i < 3 && pion[0] != 0 && pion[1] != 5;i ++) {
    		if (tableau[pion[0]-1][pion[1]+1].equals(couleur)) {
    			pion[0] -= 1;
    			pion[1] += 1;
    			puissance4 &= true;
    		} else {
    			puissance4 &= false;
    		}
    	}
    	return puissance4;
    }
}