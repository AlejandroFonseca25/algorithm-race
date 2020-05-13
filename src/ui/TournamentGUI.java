package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.AnimationManager;
import model.CircleModel;
import model.TimeUnit;
import model.Tournament;
import threads.CircleThread;
import threads.TimerThread;

public class TournamentGUI {
	
	private Tournament tournament;
	
	private AnimationManager animationManager;
	
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
    private Circle circle0;
    
    @FXML
    private Circle circle1;
    
    @FXML
    private Label timer;
    
    @FXML
    private ProgressBar progBarTree;

    @FXML
    private ProgressBar progBarList;

    @FXML
    private ProgressBar progBarArray;

    
    @FXML
    private BorderPane mainPane;
	
    @FXML
    private Pane menuPane;
    
    @FXML
    private Pane racePane;
    
	public TournamentGUI (Tournament t) {
		tournament = t;
	}
	
	public void initialize () {

	}
	
    @FXML
    void loadHelpPane(ActionEvent event) {

    }

    @FXML
    void loadRacePane(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("race-pane.fxml"));

    	fxmlLoader.setController(this);
    	Parent root = fxmlLoader.load();

    	mainPane.getChildren().clear();
    	mainPane.setCenter(root);
    	
    	CircleModel c0 = new CircleModel(circle0.getRadius(), true);
    	CircleModel c1 = new CircleModel(circle1.getRadius(), true);
    	TimeUnit t0 = new TimeUnit(0);
    	TimeUnit t1 = new TimeUnit(0);
    	TimeUnit t2 = new TimeUnit(0);
    	TimeUnit t3 = new TimeUnit(0);
    	
    	
    	
    	CircleModel[] circles = new CircleModel[] {c0,c1};
    	TimeUnit[] timerUnits = new TimeUnit[] {t0,t1,t2,t3};
    	animationManager = new AnimationManager (circles, null, timerUnits);
    	CircleThread ct = new CircleThread(animationManager, this);
    	ct.setDaemon(true);
    	
    	TimerThread tt = new TimerThread (animationManager, this);
    	tt.setDaemon(true);
    	tt.start();
    	ct.start();
    }

    @FXML
    void musicManager(ActionEvent event) {
    }

    @FXML
    void loadMenuPane(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-pane.fxml"));
		
    	fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		
		mainPane.getChildren().clear();
    	mainPane.setCenter(root);
    }
    
    public void updateCircles () {
    	double r0 = animationManager.getCircles()[0].getRadius();
    	double r1 = animationManager.getCircles()[1].getRadius();
    	circle0.setRadius(r0);
    	circle1.setRadius(r1);
    }
    
    public void updateTimer () {
    	timer.setText(animationManager.toStringTime());
    }
}
