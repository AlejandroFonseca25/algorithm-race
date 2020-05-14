package ui;

import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.AnimationManager;
import model.CircleModel;
import model.TimeUnit;
import model.Tournament;
import threads.ArrayThread;
import threads.CircleThread;
import threads.ListThread;
import threads.ThreadManager;
import threads.TimerThread;
import threads.TreeThread;

public class TournamentGUI {
	
	private Tournament tournament;
	
	private AnimationManager animationManager;
	
	private TimerThread timerThread;
	
	private CircleThread circleThread;
	
	private TreeThread treeThread;
	
	private ListThread listThread;
	
	private ArrayThread arrayThread;
	
	private ThreadManager threadManager;

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
    private Circle circle0;
    
    @FXML
    private Circle circle1;
    
    @FXML
    private Label timer;
    
    @FXML
    private Label treeTimer;

    @FXML
    private Label listTimer;

    @FXML
    private Label arrayTimer;
    
    @FXML
    private BorderPane mainPane;
	
    @FXML
    private Pane menuPane;
    
	public TournamentGUI (Tournament t) {
		tournament = t;
	}
    
    public void resetAnimations() {
    	timer.setText("--:--:--:--");
    	treeTimer.setText("--:--:--:--");
    	listTimer.setText("--:--:--:--");
    	arrayTimer.setText("--:--:--:--");
    	circle0.setRadius(20);
    	circle1.setRadius(40);
    	animationManager.getCircles()[0].setRadius(20);
    	animationManager.getCircles()[1].setRadius(40);
    }
    
    public void setTimerLoading () {
    	timer.setText("Loading");
    	treeTimer.setText("Loading");
    	listTimer.setText("Loading");
    	arrayTimer.setText("Loading");
    }
    
    public void initializeAnimationManager () {
    	CircleModel c0 = new CircleModel(circle0.getRadius(), true);
    	CircleModel c1 = new CircleModel(circle1.getRadius(), true);
    	TimeUnit t0 = new TimeUnit(0);
    	TimeUnit t1 = new TimeUnit(0);
    	TimeUnit t2 = new TimeUnit(0);
    	TimeUnit t3 = new TimeUnit(0);
    	
    	CircleModel[] circles = new CircleModel[] {c0,c1};
    	TimeUnit[] timerUnits = new TimeUnit[] {t0,t1,t2,t3};
    	
    	animationManager = new AnimationManager (circles, timerUnits);
    	circleThread = new CircleThread(animationManager, this, threadManager);
    	timerThread = new TimerThread (animationManager, this, threadManager);
    	circleThread.setDaemon(true);
    	timerThread.setDaemon(true);
    }
    
    public boolean setup() throws IOException {
    	boolean alright = true;
    	
    	int elements = 0; int category = 0; int mode = 0; long seed = 0;

    	try {
    		if (boxElementNo.getText() == "") {
    			throw new NumberFormatException();
    		}
    		elements = Integer.valueOf(boxElementNo.getText());



    		if (radRecursive.isSelected()) {
    			category = 1;
    		} 

    		if (radSearch.isSelected()) {
    			mode = 1;
    		} else if (radRemove.isSelected()) {
    			mode = 2;
    		}
    		Random r = new Random();
    		seed = r.nextLong();
    		
    		threadManager = new ThreadManager(tournament, this, animationManager, category, mode, elements, seed);
    		threadManager.setDaemon(true);
        	initializeAnimationManager();
        	
    	} catch (NumberFormatException nfe) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Woah!");
    		alert.setHeaderText("Trying to crash the app?");
    		alert.setContentText("Enter a number in the field!");
    		alright = false;
    		alert.showAndWait();
    	}
		return alright;
    }
    
    public void startRace () throws IOException, InterruptedException {
    	boolean alright  = setup();
    	if (alright) {
    		resetAnimations();
    		threadManager.start();
    	}
    }

    @FXML
    public void loadMenuPane(ActionEvent event) throws IOException {
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
    
    public void updateFinalTreeTime() {
    	treeTimer.setText(timer.getText());
    }
    
    public void updateFinalListTime() {
    	listTimer.setText(timer.getText());
    }
    
    public void updateFinalArrayTime() {
    	arrayTimer.setText(timer.getText());
    }

	public Label getTreeTimer() {
		return treeTimer;
	}

	public Label getListTimer() {
		return listTimer;
	}

	public Label getArrayTimer() {
		return arrayTimer;
	}

	public TreeThread getTreeThread() {
		return treeThread;
	}

	public ListThread getListThread() {
		return listThread;
	}

	public ArrayThread getArrayThread() {
		return arrayThread;
	}

	public TimerThread getTimerThread() {
		return timerThread;
	}

	public void setTimerThread(TimerThread timerThread) {
		this.timerThread = timerThread;
	}

	public CircleThread getCircleThread() {
		return circleThread;
	}

	public void setCircleThread(CircleThread circleThread) {
		this.circleThread = circleThread;
	}
}