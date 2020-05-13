package ui;

import model.*;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TournamentGUI {
	
	private Tournament tournament;
	
    @FXML
    private TextField boxElementNo;

    @FXML
    private RadioButton radIterative;

    @FXML
    private ToggleGroup groupCategory;

    @FXML
    private RadioButton radRecursive;

    @FXML
    private RadioButton radAdd;

    @FXML
    private ToggleGroup groupType;

    @FXML
    private RadioButton radSearch;

    @FXML
    private RadioButton radRemove;

    @FXML
    private Label winTeamTree;

    @FXML
    private Label winTeamList;

    @FXML
    private Label winTeamArray;

    @FXML
    private ImageView buttonMusic;
    
    @FXML
    private BorderPane mainPane;
	
    @FXML
    private Pane menuPane;
    
	public TournamentGUI (Tournament t) {
		tournament = t;
	}
	
	public void initialize () {
		
	}
	
    @FXML
    void loadHelpPane(ActionEvent event) {

    }

    @FXML
    void loadRacePane(ActionEvent event) {

    }

    @FXML
    void musicManager(ActionEvent event) {

    }

    @FXML
    void loadMenuPane(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("race-menu.fxml"));
		
    	fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		
		mainPane.getChildren().clear();
    	mainPane.setCenter(root);
    }
}
