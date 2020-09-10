package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static javafx.application.Application.launch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
//import jdk.jfr.internal.PrivateAccess;
//import project.Manager;
//import project.Name;
//import project.Player;
//import project.Team;
//import project.League;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
import javafx.application.Application;


import javafx.geometry.Insets;


import javafx.scene.Scene;


import javafx.scene.control.Button;


import javafx.scene.control.TextField;


import javafx.scene.layout.VBox;


import javafx.stage.Stage;
import java.sql.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Application implements Serializable { 	   
   	/**
   	 * The activities.
   	 *
   	 * @author aaron
   	 */
   // private ArrayList<Activity> activities = new ArrayList<Activity>();
    private ArrayList<League> leagues = new ArrayList<League>();
    /** The controller. */
    private Controller controller = new Controller();

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 230846983791489702L;
	
	/**
	 * Start.
	 *
	 * @param stage the stage
	 */
	@Test 
	   public void start(Stage stage) {      
	      
	     //misc objects
	      DatePicker managerDOB = new DatePicker();
	      DatePicker playerDOB = new DatePicker();	      
	      
	      //labels for the tabs
	      Label welcomeLabel = new Label("Welcome to my League application");
	      Label leagueBoxLabel = new Label("Pick the league to print");
	      Label leagueBoxLabelTeamTab = new Label("Pick the league to print");
	      Label addLeagueLabel = new Label("Enter new league name");
	      Label teamViewLabel = new Label("Pick the team");
	      Label addTeamNameLabel = new Label("Enter new team name");
	      Label addTeamColourLabel = new Label("Enter the teams jersey colour");
	      
	      //managers labels	      
	      Label managerHeaderLabel = new Label("Manager options");
	      Label managerNameLabel = new Label("Managers name: Enter first name in first box then middle in second and last name in third");
	      Label managerPhoneLabel = new Label("Enter manager's phone number");
	      Label managerEmailLabel = new Label("Enter manager's email");
	      Label managerDOBLabel = new Label("Select the manager's DOB");
	      Label managerStarRatingLabel = new Label("Enter their star rating 1-10");
	     
	      //players labels
	      Label playerNameLabel = new Label("Player's name: Enter first name in first box then middle in second and last name in third");
	      Label playerPhoneLabel = new Label("Enter player's phone number");
	      Label playerEmailLabel = new Label("Enter player's email ");
	      Label playerDOBLabel = new Label("Enter player's DOB");
	      
	      Label viewLeagueLabel = new Label("Select league to view and press button");

	      //Creating Buttons 
	      //add buttons
	      Button addLeagueButton = new Button("Add league");	      
	      Button addTeamButton = new Button("Add team");
	      Button addPersonButton = new Button("Add");
	      Button addManagerButton = new Button("Add manager to highlighted team");
	      
	      Button leagueSummaryButton = new Button("Summary for the league");
	      Button saveButton = new Button("Save to database");
	      //remove buttons
	      Button removeLeagueButton = new Button("Remove league");
	      Button removeTeamButton = new Button("Remove team"); 
	      Button removeManagerButton = new Button("Remove manager");
	      Button removePlayerButton = new Button("Remove player");
	      //misc buttons
	      Button printLeagueButton = new Button("Print the league");
	      Button viewLeagueButton = new Button("View teams of selected league");
	      Button viewTeamPlayersButton = new Button("View players of selected team");
	     
	      //redundant buttons
	      Button listButton = new Button("List");
	      Button loadButton = new Button("Load");      
	      Button dateOrderButton = new Button("Order by date");
	      
	      //creating radio buttons
	      RadioButton goalieRadioButton = new RadioButton("Player is a goalie");
	      RadioButton playerRadioButton = new RadioButton("Player is an outfield player");
	      final ToggleGroup goalieOptionGroup = new ToggleGroup();
	      goalieRadioButton.setToggleGroup(goalieOptionGroup);
	      playerRadioButton.setToggleGroup(goalieOptionGroup);
	      
	      //creating the textfields
	      TextField leagueTextField = new TextField();
	      TextField teamNameTextField = new TextField();
	      TextField teamColourTextField = new TextField();
	      TextField managerFNameTextField = new TextField();
	      TextField managerMNameTextField = new TextField();
	      TextField managerLNameTextField = new TextField();
	      TextField managerPhoneTextField = new TextField();
	      TextField managerEmailTextField = new TextField();
	      TextField managerStarRatingTextField = new TextField();
	      
	      //player textfields
	      TextField playerFNameTextField = new TextField();
	      TextField playerMNameField = new TextField();
	      TextField playerLnameTextField = new TextField();
	      TextField playerPhoneTextField = new TextField();
	      TextField playerEmailTextField = new TextField();
	      	      
	      //Creating a Pane 
	      GridPane gridPane = new GridPane(); 
	      TabPane tabPane = new TabPane();	      
	      
	      //Setting size for the pane 
	       tabPane.setPrefSize(600,825);
	      
	      //Setting the padding  
	      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      tabPane.setPadding(new Insets(0, 0, 10, 0));
	      
	      //Setting the vertical and horizontal gaps between the columns 
	      gridPane.setVgap(5); 
	      gridPane.setHgap(5);     
	
	      //creating the image object
	      Image image = new Image("file:introImage.png",100,100,true,true);
	      ImageView imageView = new ImageView(image);
	      
	      //testing for listview
	      ListView<League> 	leagueListView = new ListView();
	      ListView<League> 	leagueListViewTeamTab = new ListView();
	      ListView<League> 	leagueListViewPlayerTab = new ListView();
	      
	      ListView<Team> 	teamListView = new ListView();
	      ListView<Team> 	teamListViewTeamTab = new ListView();
	      ListView<Team> 	teamListViewPlayerTab = new ListView<Team>();
	      ListView<Player>	playerListView = new ListView();
	      
	      //Creating the tabs
	      Tab tab1 = new Tab("Intro", new Label("Welcome"));
	      Tab tab2 = new Tab("League"  , new Label("Select leagues,teams or players"));
	      Tab tab3 = new Tab("Team" , new Label("Show the results"));
	      Tab tab4 = new Tab("Persons" , new Label("Edit persons"));
	      Tab tab5 = new Tab("DB" , new Label("Save data"));
	      
	      //configuring the Intro tab	      
	      VBox tab1Box = new VBox();
	      	     
	      welcomeLabel.setFont(new Font("Calibri", 20));
	      tab1Box.getChildren().addAll(imageView, welcomeLabel);
	      tab1Box.setAlignment(Pos.CENTER);
	      
	      tab1.setContent(tab1Box);
	      
	      tabPane.getTabs().add(tab1);
	      tab1.setClosable(false);
	      
	      //configuring the Management tab	      
	      GridPane tab2GridPane = new GridPane();
	      tab2GridPane.setVgap(5); 
	      tab2GridPane.setHgap(5);
	      tab2GridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      tab2GridPane.setPrefSize(600, 400);

	      tab2GridPane.add(addLeagueLabel, 0, 1);
	      tab2GridPane.add(leagueTextField, 0, 2);	     
	      tab2GridPane.add(addLeagueButton, 0, 3);
	      tab2GridPane.add(leagueBoxLabel, 0, 4);
	      tab2GridPane.add(leagueListView, 0, 5);
	      tab2GridPane.add(printLeagueButton, 0, 6);
	      tab2GridPane.add(teamListView, 0, 7);	      
	      
	      tab2.setContent(tab2GridPane);
	      
	      tabPane.getTabs().add(tab2);
	      tab2.setClosable(false);
	      
	      //configuring the teams tab
	      GridPane tab3GridPane = new GridPane();
	      
	      tab3GridPane.setVgap(5); 
	      tab3GridPane.setHgap(5);
	      tab3GridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      tab3GridPane.setPrefSize(600, 700);
	      
	      tab3GridPane.add(leagueBoxLabelTeamTab, 0, 1);
	      tab3GridPane.add(leagueListViewTeamTab, 0, 2);
	      tab3GridPane.add(leagueSummaryButton, 0, 3);
	      tab3GridPane.add(teamListViewTeamTab, 0, 4);
	      tab3GridPane.add(addTeamNameLabel, 0, 5);
	      tab3GridPane.add(teamNameTextField, 0, 6);
	      tab3GridPane.add(addTeamColourLabel, 0, 7);
	      tab3GridPane.add(teamColourTextField, 0, 8);
	      tab3GridPane.add(addTeamButton, 0, 9);
	      tab3GridPane.add(removeTeamButton, 0, 10);
	      //manager options
	      tab3GridPane.add(managerHeaderLabel, 0, 11);
	      tab3GridPane.add(managerNameLabel, 0, 12);
	      tab3GridPane.add(managerFNameTextField, 0, 13);
	      tab3GridPane.add(managerMNameTextField, 0, 14);
	      tab3GridPane.add(managerLNameTextField, 0, 15);
	      tab3GridPane.add(managerPhoneLabel, 0, 16);
	      tab3GridPane.add(managerPhoneTextField, 0, 17);
	      tab3GridPane.add(managerEmailLabel, 0, 18);
	      tab3GridPane.add(managerEmailTextField, 0, 19);
	      tab3GridPane.add(managerDOBLabel, 0, 20);
	      tab3GridPane.add(managerDOB, 0, 21);
	      tab3GridPane.add(managerStarRatingLabel, 0, 22);
	      tab3GridPane.add(managerStarRatingTextField, 0, 23);
	      tab3GridPane.add(addManagerButton, 0, 24);
	      tab3GridPane.add(removeManagerButton, 0, 25);
	      	      
	      tab3.setContent(tab3GridPane);
	      
	      tabPane.getTabs().add(tab3);
	      tab3.setClosable(false);
	      
	      //configuring the players tab
	      GridPane tab4GridPane = new GridPane();
	      tab4GridPane.setVgap(5); 
	      tab4GridPane.setHgap(5);
	      tab4GridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      tab4GridPane.setPrefSize(600, 400);
	      
	      tab4GridPane.add(viewLeagueLabel, 0, 1);
	      tab4GridPane.add(leagueListViewPlayerTab, 0, 2);
	      tab4GridPane.add(viewLeagueButton, 0, 3);
	      //then view is updated
	      tab4GridPane.add(teamListViewPlayerTab, 0, 4);
	      tab4GridPane.add(viewTeamPlayersButton, 0, 5);
	      tab4GridPane.add(playerListView, 0, 6);
	      //add player options
	      tab4GridPane.add(playerNameLabel, 0, 7);
	      tab4GridPane.add(playerFNameTextField, 0, 8);
	      tab4GridPane.add(playerMNameField, 0, 9);
	      tab4GridPane.add(playerLnameTextField, 0, 10);
	      tab4GridPane.add(playerPhoneLabel, 0, 11);
	      tab4GridPane.add(playerPhoneTextField, 0, 12);
	      tab4GridPane.add(playerEmailLabel, 0, 13);
	      tab4GridPane.add(playerEmailTextField, 0, 14);
	      tab4GridPane.add(playerDOBLabel, 0, 15);
	      tab4GridPane.add(playerDOB, 0	, 16);
	      tab4GridPane.add(goalieRadioButton, 0, 17);
	      tab4GridPane.add(playerRadioButton, 0, 18);	      
	      tab4GridPane.add(addPersonButton, 0, 19);
	      tab4GridPane.add(removePlayerButton, 0, 20);
	      
	      tab4.setContent(tab4GridPane);
	      
	      tabPane.getTabs().add(tab4);
	      tab4.setClosable(false);
	      
	      //configuring the final tab
	      GridPane tab5GridPane = new GridPane();
	      tab5GridPane.setVgap(5); 
	      tab5GridPane.setHgap(5);
	      tab5GridPane.setPadding(new Insets(10, 10, 10, 10)); 
	      tab5GridPane.setPrefSize(600, 400);
	      
	      tab5GridPane.add(saveButton, 0, 1);
	      
	      tab5.setContent(tab5GridPane);
	      
	      tabPane.getTabs().add(tab5);
	      tab5.setClosable(false);
	      
	      //Styling nodes     
	      gridPane.setStyle("-fx-background-color: WHITE;"); 
	       
	      //Creating a scene object       
	      HBox hBox = new HBox(tabPane);
	      Scene scene = new Scene(hBox);	      
	
	    //add buttons
	      addLeagueButton.setOnAction(new EventHandler<ActionEvent>() {	      
	          public void handle(ActionEvent e) {
	             controller.addLeague(leagues, leagueTextField, leagueListView, leagueListViewPlayerTab, leagueListViewTeamTab); 
	           }
	       });
	     addTeamButton.setOnAction(new EventHandler<ActionEvent>() {	      
	          public void handle(ActionEvent e) {
	              controller.addTeam(leagues,leagueListViewTeamTab, teamListView, teamListViewPlayerTab, teamListViewTeamTab, teamNameTextField, teamColourTextField);
	           }
	       });
	     addPersonButton.setOnAction(new EventHandler<ActionEvent>() {	      
	          public void handle(ActionEvent e) {
	              controller.addPerson(leagues, leagueListViewPlayerTab, teamListViewPlayerTab, playerListView, playerFNameTextField, playerMNameField, playerLnameTextField, playerEmailTextField, playerPhoneTextField, playerDOB, goalieRadioButton, playerRadioButton);
	           }
	       });
	     addManagerButton.setOnAction(new EventHandler<ActionEvent>() {	      
	          public void handle(ActionEvent e) {
	              controller.addManager(managerFNameTextField, managerMNameTextField,managerLNameTextField, managerPhoneTextField, managerEmailTextField, managerDOB, managerStarRatingTextField,teamListViewTeamTab, leagueListViewTeamTab,leagues);
	           }
	       });
	     
	    //remove buttons
	     removeLeagueButton.setOnAction(new EventHandler<ActionEvent>() {
	    	  public void handle(ActionEvent e)	{
	    		
	    		 } 
	    	  }
	      );
	      removeTeamButton.setOnAction(new EventHandler<ActionEvent>() {
	    	  public void handle(ActionEvent e)	{
	    		controller.removeTeam(leagues,leagueListViewTeamTab, teamListView, teamListViewPlayerTab, teamListViewTeamTab, teamNameTextField, teamColourTextField);
	    		 } 
	    	  }
	      );
	      removeManagerButton.setOnAction(new EventHandler<ActionEvent>() {
	    	  public void handle(ActionEvent e)	{
	    		controller.removeManager(managerFNameTextField, managerMNameTextField,managerLNameTextField, managerPhoneTextField, managerEmailTextField, managerDOB, managerStarRatingTextField,teamListViewTeamTab, leagueListViewTeamTab,leagues);
	    		 } 
	    	  }
	      );
	      removePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
	    	  public void handle(ActionEvent e)	{
	    		controller.removePlayer(leagues, leagueListViewPlayerTab, teamListViewPlayerTab, playerListView, playerFNameTextField, playerMNameField, playerLnameTextField, playerEmailTextField, playerPhoneTextField, playerDOB, goalieRadioButton, playerRadioButton);
	    		 } 
	    	  }
	      );
	      //for team tab
	      leagueSummaryButton.setOnAction(new EventHandler<ActionEvent>() {	      
	          public void handle(ActionEvent e) {
	              controller.summariseLeague(leagues, leagueListViewTeamTab,teamListViewTeamTab);
	           }
	       });
	      //for person tab
	      viewLeagueButton.setOnAction(new EventHandler<ActionEvent>() {	      
	          public void handle(ActionEvent e) {
	              controller.summariseLeague(leagues, leagueListViewPlayerTab, teamListViewPlayerTab);
	           }
	       });
	      printLeagueButton.setOnAction(new EventHandler<ActionEvent>() {	      
	          public void handle(ActionEvent e) {
	              controller.summariseLeague(leagues, leagueListView, teamListView);
	           }
	       });
	      viewTeamPlayersButton.setOnAction(new EventHandler<ActionEvent>() {	      
	          public void handle(ActionEvent e) {
	              controller.summariseTeam(leagues, leagueListViewPlayerTab, teamListViewPlayerTab, playerListView);
	           }
	       });
	      saveButton.setOnAction(new EventHandler<ActionEvent>() {
	    	  public void handle(ActionEvent e)	{
	    		  controller.saveFunction(leagues);  	  
	    	  }
	      });   
	      
	      //creating test data
	      	League league1 = new League("BPL");
	      
	      	Team team1 = new Team("Stoke", "Red");
	      	Team team2 = new Team("Everton", "Blue");

	      	Name name1 = new Name("James", "Patrick", "Franloe");
	      	Name name2 = new Name("Mike", "John", "Lenord");
	      	Manager manager1 = new Manager(name1, "0872941956", "james@gmail.com", 9, "30/10/1950");
	      	Manager manager2 = new Manager(name2, "0858729271", "mike@gmail.com", 6, "12/07/1972");

			
			Name name3 = new Name("Frank", "Patrick", "Jones");
			Name name4 = new Name("Ben", "James", "O'Neill");
			Name name5 = new Name("Mark", "Matthew", "Smith");
			Name name6 = new Name("Aaron", "Anthony", "Barrett");
			Player player1 = new Player(name3, "0878529122", "Frank@gmail.com", true, 4);
			Player player2 = new Player(name4, "0862516293", "Ben@gmail.com", false, 10);
			Player player3 = new Player(name5, "0218452915", "Mark@gmail.com", false, 2);
			Player player4 = new Player(name6, "0892831512", "Aaron@gmail.com", true, 6);

			
			team1.addPlayer(player1);
			team1.addPlayer(player2);
			team2.addPlayer(player3);
			team2.addPlayer(player4);
			team1.addManager(manager1);
			team2.addManager(manager2);
			
			
		    leagues.add(league1);
		    
		    league1.addTeam(team1);
		    league1.addTeam(team2);
		    
		    for (int i=0;i<leagues.size();i++) {
		    	leagueListView.getItems().add(leagues.get(i));
		    	leagueListViewPlayerTab.getItems().add(leagues.get(i));
		    	leagueListViewTeamTab.getItems().add(leagues.get(i));
		    }
	      //Setting title to the Stage 
	      stage.setTitle("My League App"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene);
	      
	      
	      //Displaying the contents of the stage 
	      stage.show(); 
	   }      
	   
   	/**
   	 * The main method.
   	 *
   	 * @param args the arguments
   	 */
   	public static void main(String args[]){ 
	      launch(args); 
	   } 
	}
