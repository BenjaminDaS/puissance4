package application;


import java.io.IOException;
import java.util.ArrayList;

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

public class SceneControler2 {
	
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
	       nom2 = "ordinateur";
	
	
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

	public void submit1name(ActionEvent event) throws IOException {
		nom1 = nameOne.getText();
		nom2 = "ordinateur";
		if(nom1 == null || nom1.isBlank()){
			nom1 = "Joueur1";
		}
		root = FXMLLoader.load(getClass().getResource("Game2.fxml"));
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
		  root = FXMLLoader.load(getClass().getResource("2emePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
	      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchToScene2VSia(ActionEvent event) throws IOException {
		  Etat = 1;
		  root = FXMLLoader.load(getClass().getResource("2emePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
	      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		  stage.setScene(scene);
		  stage.show();
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
		FichierExterne.sauvegarderJco(jeton, nom1, grid);
		Image image = new Image(getClass().getResourceAsStream("sauvOk.png"));
		sauv.setGraphic(new ImageView(image));
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
	
	@FXML
	private Text gagner1 = new Text();

	static String[][] grid = {{"","","","","",""},
							  {"","","","","",""},
			                  {"","","","","",""},
			                  {"","","","","",""},
			                  {"","","","","",""},
		                      {"","","","","",""},
		 	                  {"","","","","",""}};
	
	static String jeton = "jaune";
	
	static String nomGG;
	
	static String color = "red";
	
	boolean poser;
	
	public void ChangeJetonIA(MouseEvent event) throws IOException {
		Image image = new Image(getClass().getResourceAsStream("sauv.png"));
		sauv.setGraphic(new ImageView(image));
		if(jeton.equals("jaune")) {
			jeton = "rouge";
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

			
			
			int[] positionPion = IA.pionIA(grid);
			grid[positionPion[0]][positionPion[1]] = jeton;
			if(positionPion[0] == 0) {
				listLigne1.get(positionPion[1]).setStyle("-fx-fill: red;");
			}
			if(positionPion[0] == 1) {
				listLigne2.get(positionPion[1]).setStyle("-fx-fill: red;");
			}
			if(positionPion[0] == 2) {
				listLigne3.get(positionPion[1]).setStyle("-fx-fill: red;");
			}
			if(positionPion[0] == 3) {
				listLigne4.get(positionPion[1]).setStyle("-fx-fill: red;");
			}
			if(positionPion[0] == 4) {
				listLigne5.get(positionPion[1]).setStyle("-fx-fill: red;");
			}
			if(positionPion[0] == 5) {
				listLigne6.get(positionPion[1]).setStyle("-fx-fill: red;");
			}
			if(positionPion[0] == 6) {
				listLigne7.get(positionPion[1]).setStyle("-fx-fill: red;");
			}
			nomGG = nom2;
			color ="red";
		
			if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
				root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			}
			jeton = "jaune";
			nomGG = nom1;
			color ="yel";
	}
}
	
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
		while(!poser && indice < 5){		
			if (grid[0][indice].equals("")|| grid[0][indice].equals("vide")) {
				grid[0][indice] = jeton;
				int[] positionPion = {0,indice};
				if(jeton.equals("jaune")) { 
					listLigne1.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 1");
						root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();				  
					}
				}else {
					listLigne1.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 1r");
						root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
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
		
		while(!poser && indice < 5){		
			if (grid[1][indice].equals("")|| grid[1][indice].equals("vide")) {
				grid[1][indice] = jeton;
				int[] positionPion = {1,indice};
				if(jeton.equals("jaune")) { 
					listLigne2.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("2");
						root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.show();
					}
				}else {
					listLigne2.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 2r");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
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
		
		while(!poser && indice < 5){		
			if (grid[2][indice].equals("")|| grid[2][indice].equals("vide")) {
				grid[2][indice] = jeton;
				int[] positionPion = {2,indice};
				if(jeton.equals("jaune")) { 
					listLigne3.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 3");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
						  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						  scene = new Scene(root);
					      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						  stage.setScene(scene);
						  stage.show();
					}
				}else {
					listLigne3.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 3r");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
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
		while(!poser && indice < 5){		
			if (grid[3][indice].equals("")|| grid[3][indice].equals("vide")) {
				grid[3][indice] = jeton;
				int[] positionPion = {3,indice};
				if(jeton.equals("jaune")) { 
					listLigne4.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 4");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
						  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						  scene = new Scene(root);
					      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						  stage.setScene(scene);
						  stage.show();
					}
				}else {
					listLigne4.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 4r");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
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
		while(!poser && indice < 5){		
			if (grid[4][indice].equals("")|| grid[4][indice].equals("vide")) {
				grid[4][indice] = jeton;
				int[] positionPion = {4,indice};
				if(jeton.equals("jaune")) { 
					listLigne5.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 5");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
						  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						  scene = new Scene(root);
					      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						  stage.setScene(scene);
						  stage.show();
					}
				}else {
					listLigne5.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 5r");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
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
		while(!poser && indice < 5){		
			if (grid[5][indice].equals("")|| grid[5][indice].equals("vide")) {
				grid[5][indice] = jeton;
				int[] positionPion = {5,indice};
				if(jeton.equals("jaune")) { 
					listLigne6.get(indice).setStyle("-fx-fill: yellow;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 6");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
						  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						  scene = new Scene(root);
					      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						  stage.setScene(scene);
						  stage.show();
					}
				}else {
					listLigne6.get(indice).setStyle("-fx-fill: red;");
					if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
						System.out.println("puissance 4 6r");
						  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
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
			while(!poser && indice < 5){		
				if (grid[6][indice].equals("")|| grid[6][indice].equals("vide")) {
					grid[6][indice] = jeton;
					int[] positionPion = {6,indice};
					if(jeton.equals("jaune")) { 
						listLigne7.get(indice).setStyle("-fx-fill: yellow;");
						if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
							System.out.println("puissance 4 7");
							  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
							  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
							  scene = new Scene(root);
						      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							  stage.setScene(scene);
							  stage.show();
						}
					}else {
						listLigne7.get(indice).setStyle("-fx-fill: red;");
						if (RecherchePuissance4.recherche(grid, jeton, positionPion)){
							System.out.println("puissance 4 7r");
							  root = FXMLLoader.load(getClass().getResource("GagnerIA.fxml"));
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
	public void remplir(MouseEvent event) throws IOException {
		
        grid = SceneControler.getGrid();

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
