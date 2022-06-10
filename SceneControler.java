package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneControler {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField nameOne;
	@FXML
	private TextField nameTwo;
	@FXML
	private Button submit;
	
	static String nom1 = "joueur1",
	              nom2 = "joueur2";
	
	static int sauve = 2; // si reprise de sauvegarde 2 si pas de reprise
	
	public void switchToGame(ActionEvent event) throws IOException {
		if(Etat == 2) {
			root = FXMLLoader.load(getClass().getResource("Game.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}else {
			root = FXMLLoader.load(getClass().getResource("Game2.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public void restartButton(ActionEvent event) throws IOException {
		if(Etat == 2) {
			vidergrid();
			root = FXMLLoader.load(getClass().getResource("Game.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}else {
			vidergrid();
			root = FXMLLoader.load(getClass().getResource("Game2.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public void HomeButton(ActionEvent event) throws IOException {
		vidergrid();
		root = FXMLLoader.load(getClass().getResource("1erpage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void submit2name(ActionEvent event) throws IOException {
		nom1 = nameOne.getText();
	    nom2 = nameTwo.getText();
		if(nom1 == null || nom1.isBlank()){
			nom1 = "Joueur1";
		}
		if(nom2 == null || nom2.isBlank()){
			nom2 = "Joueur2";
		}
		root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();	
	}

	public void switchToScene1(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("1erPage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
	      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		  stage.setScene(scene);
		  stage.show();
	}
	
	static int Etat; // 2 pour du 1v1 et 1 pour 1vIA
	
	public void switchToScene2VS2(ActionEvent event) throws IOException {
		  Etat = 2;
		  if(FichierExterne.estSauvegardeExistanteJcj()) {
			  root = FXMLLoader.load(getClass().getResource("2emePage.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			  stage.setScene(scene);
			  stage.show();
		  }else {
			  root = FXMLLoader.load(getClass().getResource("Nameplayers.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			  stage.setScene(scene);
			  stage.show();
		  }
	}
	
	public void switchToScene2VSia(ActionEvent event) throws IOException {
		  Etat = 1;
		  if(FichierExterne.estSauvegardeExistanteJco()) {
			  root = FXMLLoader.load(getClass().getResource("2emePage.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			  stage.setScene(scene);
			  stage.show();
		  }else {
			  root = FXMLLoader.load(getClass().getResource("Nameplayer.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			  stage.setScene(scene);
			  stage.show();
		  }
	}

	public void reprendreSauv(ActionEvent event) throws IOException {
		sauve = 1;
		if(Etat == 1) {
			FichierExterne.recupererDonneeSauvegardeJco();
			nom1 = FichierExterne.getJoueur1();
			nom2 = "ordinateur";
			jeton =FichierExterne.getCouleur();
			
			for(int y = 0; y < 5 ; y++) {
				if (FichierExterne.getTableau()[0][y].equals("rouge")) {
					grid[0][y]="rouge";
					
				}else if (FichierExterne.getTableau()[0][y].equals("jaune")){
					grid[0][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[1][y].equals("rouge")) {
					grid[1][y]="rouge";
				}else if (FichierExterne.getTableau()[1][y].equals("jaune")){
					grid[1][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[2][y].equals("rouge")) {
					grid[2][y]="rouge";
				}else if (FichierExterne.getTableau()[2][y].equals("jaune")){
					grid[2][y]="jaune";
				}

				if (FichierExterne.getTableau()[3][y].equals("rouge")) {
					grid[3][y]="rouge";
				}else if (FichierExterne.getTableau()[3][y].equals("jaune")){
					grid[3][y]="jaune";
				}
				if (FichierExterne.getTableau()[4][y].equals("rouge")) {
					grid[4][y]="rouge";
				}else if (FichierExterne.getTableau()[4][y].equals("jaune")){
					grid[4][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[5][y].equals("rouge")) {
					grid[5][y]="rouge";
				}else if (FichierExterne.getTableau()[5][y].equals("jaune")){
					grid[5][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[6][y].equals("rouge")) {
					grid[6][y]="rouge";
				}else if (FichierExterne.getTableau()[6][y].equals("jaune")){
					grid[6][y]="jaune";
				}
			}
		
			
			root = FXMLLoader.load(getClass().getResource("Game2.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		}else {
			
			root = FXMLLoader.load(getClass().getResource("Game.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
			FichierExterne.recupererDonneeSauvegardeJcj();
			nom1 = FichierExterne.getJoueur1();
			nom2 = FichierExterne.getJoueur2();
			jeton = FichierExterne.getCouleur();


			for(int y = 0; y < 5 ; y++) {
				
				if (FichierExterne.getTableau()[0][y].equals("rouge")) {
					grid[0][y]="rouge";
					
				}else if (FichierExterne.getTableau()[0][y].equals("jaune")){
					grid[0][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[1][y].equals("rouge")) {
					grid[1][y]="rouge";
				}else if (FichierExterne.getTableau()[1][y].equals("jaune")){
					grid[1][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[2][y].equals("rouge")) {
					grid[2][y]="rouge";
				}else if (FichierExterne.getTableau()[2][y].equals("jaune")){
					grid[2][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[3][y].equals("rouge")) {
					grid[3][y]="rouge";
				}else if (FichierExterne.getTableau()[3][y].equals("jaune")){
					grid[3][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[4][y].equals("rouge")) {
					grid[4][y]="rouge";
				}else if (FichierExterne.getTableau()[4][y].equals("jaune")){
					grid[4][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[5][y].equals("rouge")) {
					grid[5][y]="rouge";
				}else if (FichierExterne.getTableau()[5][y].equals("jaune")){
					grid[5][y]="jaune";
				}
				
				if (FichierExterne.getTableau()[6][y].equals("rouge")) {
					grid[6][y]="rouge";
				}else if (FichierExterne.getTableau()[6][y].equals("jaune")){
					grid[6][y]="jaune";
				}
			}
		}
	}
	
	

	public void switchToNamePlayers(ActionEvent event) throws IOException {
		  if(Etat == 1) {
			  root = FXMLLoader.load(getClass().getResource("Nameplayer.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			  stage.setScene(scene);
			  stage.show();
		  }else {
			  root = FXMLLoader.load(getClass().getResource("Nameplayers.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			  stage.setScene(scene);
			  stage.show();
		  }
	}
	
	
	public void sauvegarder(ActionEvent event) throws IOException {
		FichierExterne.sauvegarderJcj(jeton,nom1, nom2, grid);
		Image image = new Image(getClass().getResourceAsStream("sauvOk.png"));
		sauv.setGraphic(new ImageView(image));
		for( int y= 0 ; y < 5 ; y++ ){
			System.out.println(grid[1][y]);
		}
	}

	public void Help(MouseEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("Help.fxml"));
		stage = new Stage();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();	
	}
	
	public void vidergrid() {
		for(int i = 0; i <= 6 ; i++) {
			for(int y = 0 ; y <= 5 ; y++) {
				grid[i][y] = "";
			}
		}
	}
	
	@FXML
	private Circle cercle1 = new Circle();
	@FXML
	private Circle cercle2 = new Circle();
	@FXML
	private Circle cercle3 = new Circle();
	@FXML
	private Circle cercle4 = new Circle();
	@FXML
	private Circle cercle5 = new Circle();
	@FXML
	private Circle cercle6 = new Circle();
	@FXML
	private Circle cercle7 = new Circle();
	@FXML
	private Circle cercle8 = new Circle();
	@FXML
	private Circle cercle9 = new Circle();
	@FXML
	private Circle cercle10 = new Circle();
	@FXML
	private Circle cercle11 = new Circle();
	@FXML
	private Circle cercle12 = new Circle();
	@FXML
	private Circle cercle13 = new Circle();
	@FXML
	private Circle cercle14 = new Circle();
	@FXML
	private Circle cercle15 = new Circle();
	@FXML
	private Circle cercle16 = new Circle();
	@FXML
	private Circle cercle17 = new Circle();
	@FXML
	private Circle cercle18 = new Circle();
	@FXML
	private Circle cercle19 = new Circle();
	@FXML
	private Circle cercle20 = new Circle();
	@FXML
	private Circle cercle21 = new Circle();
	@FXML
	private Circle cercle22 = new Circle();
	@FXML
	private Circle cercle23 = new Circle();
	@FXML
	private Circle cercle24 = new Circle();
	@FXML
	private Circle cercle25 = new Circle();
	@FXML
	private Circle cercle26 = new Circle();
	@FXML
	private Circle cercle27 = new Circle();
	@FXML
	private Circle cercle28 = new Circle();
	@FXML
	private Circle cercle29 = new Circle();
	@FXML
	private Circle cercle30 = new Circle();
	@FXML
	private Circle cercle31 = new Circle();
	@FXML
	private Circle cercle32 = new Circle();
	@FXML
	private Circle cercle33 = new Circle();
	@FXML
	private Circle cercle34 = new Circle();
	@FXML
	private Circle cercle35 = new Circle();
	@FXML
	private Circle cercle36 = new Circle();
	@FXML
	private Circle cercle37 = new Circle();
	@FXML
	private Circle cercle38 = new Circle();
	@FXML
	private Circle cercle39 = new Circle();
	@FXML
	private Circle cercle40 = new Circle();
	@FXML
	private Circle cercle41 = new Circle();
	@FXML
	private Circle cercle42 = new Circle();


	
	static String[][] grid = {{"","","","","",""},
							  {"","","","","",""},
			                  {"","","","","",""},
			                  {"","","","","",""},
			                  {"","","","","",""},
		                      {"","","","","",""},
		 	                  {"","","","","",""}};
	
	static String jeton;

	static String nomGG;
	
	static String color = "red";
	
	@FXML
	private Text myLabel = new Text();
	
	@FXML
	private Text myLabelColor = new Text();
	
	@FXML
	private Text gagner1 = new Text();
	
	@FXML
	private Circle cercleTour = new Circle();
	
	@FXML
	private Circle cercleJouer = new Circle();

	
	public void ChangeJeton(MouseEvent event) {
		Image image = new Image(getClass().getResourceAsStream("sauv.png"));
		sauv.setGraphic(new ImageView(image));
		if(jeton.equals("jaune")) {
			jeton = "rouge";
			cercleJouer.setFill(Color.RED);
			cercleTour.setFill(Color.RED);
			myLabelColor.setText(nom2);
			myLabelColor.setFill(Color.RED);
			myLabel.setText("à toi de jouer!");
			nomGG = nom2;
			color ="red";
		}else {
			jeton = "jaune";
			cercleJouer.setFill(Color.YELLOW);
			cercleTour.setFill(Color.YELLOW);
			myLabelColor.setText(nom1);
			myLabelColor.setFill(Color.YELLOW);
			myLabel.setText("à toi de jouer!");
			nomGG = nom1;
			color ="yel";
			
		}
	}
	
	boolean poser;
	
	
    @FXML
    Button buttonRestart = new Button();
    
    @FXML
    Button buttonHome = new Button();
    
    @FXML
    Button sauv = new Button();

    public void initialize(){
    	
    	gagner1.setText(nomGG + "!");
    	if (color.equals("red")) {
    		gagner1.setFill(Color.RED);
    	}else {
    		gagner1.setFill(Color.YELLOW);
    	}

    	if(sauve == 1 && jeton != null && jeton.equals("jaune") ) {
    		//rien faire
    	}else if(sauve == 1 && jeton != null && jeton.equals("rouge")) {
    		//rien faire
    	}else {

    		Random r = new Random();
    		if ((r.nextInt((2 - 1) + 1) + 1) == 1) {
    			jeton = "jaune";
    			cercleJouer.setFill(Color.YELLOW);
    			cercleTour.setFill(Color.YELLOW);
    			myLabelColor.setText(nom1);
    			myLabelColor.setFill(Color.YELLOW);

    		}else {
    			jeton = "rouge";
    			cercleJouer.setFill(Color.RED);
    			cercleTour.setFill(Color.RED);
    			myLabelColor.setText(nom2);
    			myLabelColor.setFill(Color.RED);
    		}
    	}

    	
    	
        ImageView imageView = new ImageView(getClass().getResource("restart.PNG").toExternalForm());
        buttonRestart.setGraphic(imageView);
        ImageView imageView2 = new ImageView(getClass().getResource("home.PNG").toExternalForm());
        buttonHome.setGraphic(imageView2);
        ImageView imageView3 = new ImageView(getClass().getResource("sauv.PNG").toExternalForm());
        sauv.setGraphic(imageView3);
    }
    

	public void JetonLine1(MouseEvent event) throws IOException {
	
		ArrayList<Circle> listLigne1 = new ArrayList<Circle>();
		listLigne1.add(cercle1);
		listLigne1.add(cercle2);
		listLigne1.add(cercle3);
		listLigne1.add(cercle4);
		listLigne1.add(cercle5);
		listLigne1.add(cercle6);
		poser = false;
		int indice = 0;
		while(!poser && indice < 6){		
			if (grid[0][indice].equals("") || grid[0][indice].equals("vide")) {
				grid[0][indice] = jeton;
				int[] positionPion = {0,indice};
				if(jeton.equals("jaune")) { 
					listLigne1.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						
						
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();

						  
					}
				}else {
					listLigne1.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						
						
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
						gagner1.setText(nom2);
						gagner1.setFill(Color.RED);
					}
				}
			poser = true;
			}
			indice++;
		}
	}
	
	public void JetonLine2(MouseEvent event) throws IOException {
		
		ArrayList<Circle> listLigne2 = new ArrayList<Circle>();
		listLigne2.add(cercle7);
		listLigne2.add(cercle8);
		listLigne2.add(cercle9);
		listLigne2.add(cercle10);
		listLigne2.add(cercle11);
		listLigne2.add(cercle12);
		poser = false;
		int indice = 0;
		
		while(!poser && indice < 6){		
			if (grid[1][indice].equals("") || grid[1][indice].equals("vide")) {
				grid[1][indice] = jeton;
				int[] positionPion = {1,indice};
				if(jeton.equals("jaune")) { 
					listLigne2.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}else {
					listLigne2.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}
			poser = true;
			}
			indice++;
		}
	}
	
	public void JetonLine3(MouseEvent event) throws IOException {

		ArrayList<Circle> listLigne3 = new ArrayList<Circle>();
		listLigne3.add(cercle13);
		listLigne3.add(cercle14);
		listLigne3.add(cercle15);
		listLigne3.add(cercle16);
		listLigne3.add(cercle17);
		listLigne3.add(cercle18);
		poser = false;
		int indice = 0;
		
		while(!poser && indice < 6){		
			if (grid[2][indice].equals("")|| grid[2][indice].equals("vide")) {
				grid[2][indice] = jeton;
				int[] positionPion = {2,indice};
				if(jeton.equals("jaune")) { 
					listLigne3.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}else {
					listLigne3.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}
			poser = true;
			}
			indice++;
		}
	}
	
	public void JetonLine4(MouseEvent event) throws IOException {
		
		ArrayList<Circle> listLigne4 = new ArrayList<Circle>();
		listLigne4.add(cercle19);
		listLigne4.add(cercle20);
		listLigne4.add(cercle21);
		listLigne4.add(cercle22);
		listLigne4.add(cercle23);
		listLigne4.add(cercle24);
		
		poser = false;
		int indice = 0;
		while(!poser && indice < 6){		
			if (grid[3][indice].equals("")|| grid[3][indice].equals("vide")) {
				grid[3][indice] = jeton;
				int[] positionPion = {3,indice};
				if(jeton.equals("jaune")) { 
					listLigne4.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}else {
					listLigne4.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}
			poser = true;
			}
			indice++;
		}
	}
	public void JetonLine5(MouseEvent event) throws IOException {

		ArrayList<Circle> listLigne5 = new ArrayList<Circle>();
		listLigne5.add(cercle25);
		listLigne5.add(cercle26);
		listLigne5.add(cercle27);
		listLigne5.add(cercle28);
		listLigne5.add(cercle29);
		listLigne5.add(cercle30);
		
		poser = false;
		int indice = 0;
		while(!poser && indice < 6){		
			if (grid[4][indice].equals("")|| grid[4][indice].equals("vide")) {
				grid[4][indice] = jeton;
				int[] positionPion = {4,indice};
				if(jeton.equals("jaune")) { 
					listLigne5.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}else {
					listLigne5.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}
			poser = true;
			}
			indice++;
		}
	}
	
	public void JetonLine6(MouseEvent event) throws IOException {
		
		ArrayList<Circle> listLigne6 = new ArrayList<Circle>();
		listLigne6.add(cercle31);
		listLigne6.add(cercle32);
		listLigne6.add(cercle33);
		listLigne6.add(cercle34);
		listLigne6.add(cercle35);
		listLigne6.add(cercle36);
		
		poser = false;
		int indice = 0;
		while(!poser && indice < 6){		
			if (grid[5][indice].equals("")|| grid[5][indice].equals("vide")) {
				grid[5][indice] = jeton;
				int[] positionPion = {5,indice};
				if(jeton.equals("jaune")) { 
					listLigne6.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}else {
					listLigne6.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 ");
						root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
					    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}
			poser = true;
			}
			indice++;
		}
	}
	
	public void JetonLine7(MouseEvent event) throws IOException {

			ArrayList<Circle> listLigne7 = new ArrayList<Circle>();
			listLigne7.add(cercle37);
			listLigne7.add(cercle38);
			listLigne7.add(cercle39);
			listLigne7.add(cercle40);
			listLigne7.add(cercle41);
			listLigne7.add(cercle42);
			
			poser = false;
			int indice = 0;
			while(!poser && indice < 6){		
				if (grid[6][indice].equals("")|| grid[6][indice].equals("vide")) {
					grid[6][indice] = jeton;
					int[] positionPion = {6,indice};
					if(jeton.equals("jaune")) { 
						listLigne7.get(indice).setStyle("-fx-fill: yellow;");
						if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
							System.out.println("puissance 4 ");
							root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
							stage = (Stage)((Node)event.getSource()).getScene().getWindow();
							scene = new Scene(root);
						    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							stage.setScene(scene);
							stage.show();
						}
					}else {
						listLigne7.get(indice).setStyle("-fx-fill: red;");
						if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
							System.out.println("puissance 4 ");
							root = FXMLLoader.load(getClass().getResource("Gagner.fxml"));
							stage = (Stage)((Node)event.getSource()).getScene().getWindow();
							scene = new Scene(root);
						    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							stage.setScene(scene);
							stage.show();
						}
					}
				poser = true;
				}
				indice++;
			}
		}
	
	public static String[][] getGrid() {
		return grid;
	}
	
	public void remplir(MouseEvent event) throws IOException {
		
		ArrayList<Circle> listLigne1 = new ArrayList<Circle>();
		listLigne1.add(cercle1);
		listLigne1.add(cercle2);
		listLigne1.add(cercle3);
		listLigne1.add(cercle4);
		listLigne1.add(cercle5);
		listLigne1.add(cercle6);
		ArrayList<Circle> listLigne2 = new ArrayList<Circle>();
		listLigne2.add(cercle7);
		listLigne2.add(cercle8);
		listLigne2.add(cercle9);
		listLigne2.add(cercle10);
		listLigne2.add(cercle11);
		listLigne2.add(cercle12);
		ArrayList<Circle> listLigne3 = new ArrayList<Circle>();
		listLigne3.add(cercle13);
		listLigne3.add(cercle14);
		listLigne3.add(cercle15);
		listLigne3.add(cercle16);
		listLigne3.add(cercle17);
		listLigne3.add(cercle18);
		ArrayList<Circle> listLigne4 = new ArrayList<Circle>();
		listLigne4.add(cercle19);
		listLigne4.add(cercle20);
		listLigne4.add(cercle21);
		listLigne4.add(cercle22);
		listLigne4.add(cercle23);
		listLigne4.add(cercle24);
		ArrayList<Circle> listLigne5 = new ArrayList<Circle>();
		listLigne5.add(cercle25);
		listLigne5.add(cercle26);
		listLigne5.add(cercle27);
		listLigne5.add(cercle28);
		listLigne5.add(cercle29);
		listLigne5.add(cercle30);
		ArrayList<Circle> listLigne6 = new ArrayList<Circle>();
		listLigne6.add(cercle31);
		listLigne6.add(cercle32);
		listLigne6.add(cercle33);
		listLigne6.add(cercle34);
		listLigne6.add(cercle35);
		listLigne6.add(cercle36);
		ArrayList<Circle> listLigne7 = new ArrayList<Circle>();
		listLigne7.add(cercle37);
		listLigne7.add(cercle38);
		listLigne7.add(cercle39);
		listLigne7.add(cercle40);
		listLigne7.add(cercle41);
		listLigne7.add(cercle42);
		
		for(int y = 0; y < 5 ; y++) {
			
			if (grid[0][y].equals("rouge")) {
				listLigne1.get(y).setStyle("-fx-fill: red;");
				
			}else if (grid[0][y].equals("jaune")){
				listLigne1.get(y).setStyle("-fx-fill: yellow;");
			}
			
			if (grid[1][y].equals("rouge")) {
				listLigne2.get(y).setStyle("-fx-fill: red;");
			}else if (grid[1][y].equals("jaune")){
				listLigne2.get(y).setStyle("-fx-fill: yellow;");
			}
			
			if (grid[2][y].equals("rouge")) {
				listLigne3.get(y).setStyle("-fx-fill: red;");
			}else if (grid[2][y].equals("jaune")){
				listLigne3.get(y).setStyle("-fx-fill: yellow;");
			}
			
			if (grid[3][y].equals("rouge")) {
				listLigne4.get(y).setStyle("-fx-fill: red;");
			}else if (grid[3][y].equals("jaune")){
				listLigne4.get(y).setStyle("-fx-fill: yellow;");
			}
			
			if (grid[4][y].equals("rouge")) {
				listLigne5.get(y).setStyle("-fx-fill: red;");
			}else if (grid[4][y].equals("jaune")){
				listLigne5.get(y).setStyle("-fx-fill: yellow;");
			}
			
			if (grid[5][y].equals("rouge")) {
				listLigne6.get(y).setStyle("-fx-fill: red;");
			}else if (grid[5][y].equals("jaune")){
				listLigne6.get(y).setStyle("-fx-fill: yellow;");
			}
			
			if (grid[6][y].equals("rouge")) {
				listLigne7.get(y).setStyle("-fx-fill: red;");
			}else if (grid[6][y].equals("jaune")){
				listLigne7.get(y).setStyle("-fx-fill: yellow;");
			}
		}
	}
}
