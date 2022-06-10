package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FichierExterne {
	
	private static String couleur;
	
	private static String joueur1;
	
	private static String joueur2;
	
	private static String[][] tableau  =  {
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""},
			{"","","","","",""}};
	
	
	public static boolean estSauvegardeExistanteJcj() throws IOException {
		File file = new File("sauvegardeJcj.txt");
		if (file.length() != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean estSauvegardeExistanteJco() throws IOException {
		File file = new File("sauvegardeJco.txt");
		if (file.length() != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void sauvegarderJcj(String couleur, String nomJoueur1, String nomJoueur2, String[][] TableauCouleur) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("sauvegardeJcj.txt");
		writer.println(couleur);
		writer.println(nomJoueur1);
		writer.println(nomJoueur2);
		for (int colonne = 0; colonne <= 6; colonne ++) {
			for (int ligne = 0; ligne <= 4; ligne ++) {
				if(TableauCouleur[colonne][ligne].equals("")) {
					TableauCouleur[colonne][ligne] = "vide";
				}
				writer.print(TableauCouleur[colonne][ligne] + " ");
			}
			writer.println(TableauCouleur[colonne][5] + "");
		}
		writer.close();
	}
	
	public static void sauvegarderJco(String couleur, String nomJoueur1, String[][] TableauCouleur) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("sauvegardeJco.txt");
		writer.println(couleur);
		writer.println(nomJoueur1);
		for (int colonne = 0; colonne <= 6; colonne ++) {
			for (int ligne = 0; ligne <= 4; ligne ++) {
				if(TableauCouleur[colonne][ligne].equals("")) {
					TableauCouleur[colonne][ligne] = "vide";
				}
				writer.print(TableauCouleur[colonne][ligne] + " ");
			}
			writer.println(TableauCouleur[colonne][5] + "");
		}
		writer.close();
	}
	
	public static void recupererDonneeSauvegardeJcj() throws FileNotFoundException {
		String sauvegarde = "";
		File doc =new File("sauvegardeJcj.txt");
		Scanner obj = new Scanner(doc);
		couleur = obj.nextLine();
		joueur1 = obj.nextLine();
		joueur2 = obj.nextLine();
		for (int i = 0; i < 7; i++) {
			String colonne = obj.nextLine();
	        tableau[i] = colonne.split(" ");
		}
	}
	
	public static void recupererDonneeSauvegardeJco() throws FileNotFoundException {
		String sauvegarde = "";
		File doc =new File("sauvegardeJco.txt");
		Scanner obj = new Scanner(doc);
		couleur = obj.nextLine();
		joueur1 = obj.nextLine();
		for (int i = 0; i < 7; i++) {
			String colonne = obj.nextLine();
	        tableau[i] = colonne.split(" ");
		}
	}
	
	public static String getCouleur() {
		return couleur;
	}
	
	public static String getJoueur1() {
		return joueur1;
	}
	
	public static String getJoueur2() {
		return joueur2;
	}
	
	public static String[][] getTableau() {
		return tableau;
	}
	
	
	
	
}