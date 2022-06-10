package application;

import java.util.ArrayList;
import java.util.Random;

public class IA {
	
	public static int[] pionIA(String[][] tableau) {
		int[] pion = {0,0};
		int[] pionRandom = {0,0};
		ArrayList<int[]> listePionRandom = new ArrayList<int[]>();
		for (int i = 0; i < 7; i++) {
			boolean colonePleine = true;
			int compteur = 0;
			while (colonePleine && compteur < 6) {
				if (tableau[i][compteur] != "jaune" && tableau[i][compteur] != "rouge") {
					colonePleine = false;
					pion[0] = i;
					pion[1] = compteur;
					listePionRandom.add(pion.clone());
				}
				if(RecherchePuissance4.recherche(tableau, "rouge", pion)) {
					return pion;
				}
				compteur += 1;
			}
		}
		Random r = new Random();
		pionRandom = listePionRandom.get(r.nextInt(listePionRandom.size()));
		return pionRandom;
	}
}