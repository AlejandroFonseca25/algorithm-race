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

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FALTA LA VENTANA"));
		fxmlLoader.setController(tGUI);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("ALGORITHM RACE TOURNAMENT");
		stage.show();
	}
	
	
}