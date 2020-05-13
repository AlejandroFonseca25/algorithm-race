package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

public class Main extends Application{
	
	private Tournament tournament;
	private TournamentGUI tGUI;
	
	public Main () {
		tournament = new Tournament();
		tGUI = new TournamentGUI(tournament);
	}
	
	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(tGUI);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Algoritmh Race : The Tournament");
		stage.show();
		tGUI.loadMenuPane(null);
	}
	
	
}
