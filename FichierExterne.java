package info1.sae;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FichierExterne {
	
	
	public static boolean estSauvegardeExistante() throws IOException {
		File file = new File("puissance4/info1/sae/sauvegarde.txt");
		if (file.length() != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void sauvegarder(String couleur, String type, String nomJoueur, String[][] TableauCouleur) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("puissance4/info1/sae/sauvegarde.txt");
		writer.println(couleur + " " + type + " " + nomJoueur + " ");
		for (int colonne = 0; colonne <= 6; colonne ++) {
			for (int ligne = 0; ligne <= 4; ligne ++) {
				writer.print(TableauCouleur[colonne][ligne] + " ");
			}
			writer.println(TableauCouleur[colonne][5] + " ");
		}
		writer.close();
	}
	
	public static String recupererDonneeSauvegarde() throws FileNotFoundException {
		String sauvegarde = "";
		File doc =new File("puissance4/info1/sae/sauvegarde.txt");
		Scanner obj = new Scanner(doc);
		while (obj.hasNextLine()) {
			sauvegarde += obj.nextLine();
		}
		return sauvegarde;
	}
	
	public static void creerFichierSauvegarde() throws IOException {
		File file = new File("puissance4/info1/sae/sauvegarde.txt");
		if (file.exists()) {
			System.err.println("un fichier existe deja");
		} else {
			file.createNewFile();
		}
	}
}