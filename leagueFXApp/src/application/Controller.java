package application;

import static org.junit.Assert.fail;

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
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;

//import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4592368230276631923L;

	
	/**
	 * Adds the league.
	 *
	 * @param leagues the leagues
	 * @param leagueTextField the league text field
	 * @param leagueListView the league list view
	 * @param leagueListViewPlayerTab the league list view player tab
	 * @param leagueListViewTeamTab the league list view team tab
	 * @return the array list
	 */
	public ArrayList<League> addLeague(ArrayList<League> leagues, TextField leagueTextField, ListView<League> leagueListView, ListView<League> leagueListViewPlayerTab, ListView<League> leagueListViewTeamTab) {
		String newLeagueName = leagueTextField.getText();
		League newLeague = new League(newLeagueName);
		leagues.add(newLeague);
		//clearing listviews of 
		leagueListView.getItems().clear();
		leagueListViewPlayerTab.getItems().clear();
		leagueListViewTeamTab.getItems().clear();
		
		for (int i=0; i<leagues.size();i++) {
			leagueListView.getItems().add(leagues.get(i));
			leagueListViewPlayerTab.getItems().add(leagues.get(i));
			leagueListViewTeamTab.getItems().add(leagues.get(i));
		}
		return leagues;		
	}


	/**
	 * Adds the team.
	 *
	 * @param leagues the leagues
	 * @param leagueListViewTeamTab the league list view team tab
	 * @param teamListView the team list view
	 * @param teamListViewPlayerTab the team list view player tab
	 * @param teamListViewTeamTab the team list view team tab
	 * @param teamNameTextField the team name text field
	 * @param teamColourTextField the team colour text field
	 * @return the array list
	 */
	public ArrayList<League> addTeam(ArrayList<League> leagues, ListView<League> leagueListViewTeamTab, ListView<Team> teamListView,
			ListView<Team> teamListViewPlayerTab, ListView<Team> teamListViewTeamTab, TextField teamNameTextField,
			TextField teamColourTextField) {
		
		//grabbing name and colour
		String newTeamName = teamNameTextField.getText();
		String newTeamColour = teamColourTextField.getText();
		
		//creating new team object
		Team newTeam = new Team(newTeamName, newTeamColour);
		
		//adding new team to selected league
		int leagueTobeAddedTo = leagueListViewTeamTab.getSelectionModel().getSelectedIndex();
		leagues.get(leagueTobeAddedTo).addTeam(newTeam);
		
		teamListViewTeamTab.getItems().clear();
		League leagueToBePrinted = leagues.get(leagueTobeAddedTo);
		
		leagueToBePrinted.printToView(teamListViewTeamTab);
	
		return leagues;
	}

	/**
	 * Summarise league.
	 *
	 * @param leagues the leagues
	 * @param leagueListViewTeamTab the league list view team tab
	 * @param teamListViewTeamTab the team list view team tab
	 */
	public void summariseLeague(ArrayList<League> leagues, ListView<League> leagueListViewTeamTab, ListView<Team> teamListViewTeamTab) {
		
		//leagueListViewTeamTab.getItems().clear();
		
		//getting index Of league to be printed
		teamListViewTeamTab.getItems().clear();
		int leagueTobeAddedTo = leagueListViewTeamTab.getSelectionModel().getSelectedIndex();
		
		League leagueToBePrinted = leagues.get(leagueTobeAddedTo);
		
		//ArrayList<Team> teamsToBePrinted = new ArrayList<Team>();
		//teamsToBePrinted.addAll(leagueTobeAddedTo, leagues);
		//teamListViewTeamTab.getItems().add(leagues.get(leagueTobeAddedTo).getName());
		
		leagueToBePrinted.getTeam();
		/*for (int i=0;i<((List<League>) leagueToBePrinted).size()-1;i++) {
			teamsToBePrinted.add(leagueToBePrinted.getName());
		}		
		*/
		leagueToBePrinted.printToView(teamListViewTeamTab);		
	}
	
	/**
	 * Summarise team.
	 *
	 * @param leagues the leagues
	 * @param leagueListView the league list view
	 * @param teamListView the team list view
	 * @param playerListView the player list view
	 */
	public void summariseTeam(ArrayList<League> leagues, ListView<League> leagueListView,
			ListView<Team> teamListView, ListView<Player> playerListView) {
		//clearing the view first
		playerListView.getItems().clear();
		int leagueTobeAddedTo = leagueListView.getSelectionModel().getSelectedIndex();		
		League leagueToBePrinted = leagues.get(leagueTobeAddedTo);
		leagueToBePrinted.printToView(teamListView);
		
		int teamToBePrinted = teamListView.getSelectionModel().getSelectedIndex();
		Team teamToBePrintedTeam = leagueToBePrinted.getTeamForPrint(teamToBePrinted);
		
		teamToBePrintedTeam.printToView(playerListView);		
		//ArrayList<Team> teamToBePrintedTeam = leagueToBePrinted.getTeam();
		
	}


	/**
	 * Adds the person.
	 *
	 * @param leagues the leagues
	 * @param leagueListView the league list view
	 * @param teamListView the team list view
	 * @param playerListView the player list view
	 * @param playerFNameTextField the player F name text field
	 * @param playerMNameField the player M name field
	 * @param playerLnameTextField the player lname text field
	 * @param playerEmailTextField the player email text field
	 * @param playerPhoneTextField the player phone text field
	 * @param playerDOB the player DOB
	 * @param goalieRadioButton the goalie radio button
	 * @param playerRadioButton the player radio button
	 */
	public void addPerson(ArrayList<League> leagues, ListView<League> leagueListView,
			ListView<Team> teamListView, ListView<Player> playerListView, TextField playerFNameTextField,
			TextField playerMNameField, TextField playerLnameTextField, TextField playerEmailTextField,
			TextField playerPhoneTextField, DatePicker playerDOB, RadioButton goalieRadioButton,
			RadioButton playerRadioButton) {
		
		int goals =2;
		Boolean isGoalie=false;

		//creating the new person object
		
		//creating the name first			
		Name newName = new Name(playerFNameTextField.getText(),playerMNameField.getText(), playerLnameTextField.getText());
		
		//checking if player is a goalie
		if (goalieRadioButton.isSelected()) {
			isGoalie=true;
		}
		else if (playerRadioButton.isSelected()) {
			isGoalie=false;
		}
		//new player object made
		Player newplayer = new Player(newName, playerPhoneTextField.getText(), playerEmailTextField.getText(), isGoalie, goals);
		//adding the new player to the selected team
		
		//clearing the view first
		playerListView.getItems().clear();
		int leagueTobeAddedTo = leagueListView.getSelectionModel().getSelectedIndex();		
		League leagueToBePrinted = leagues.get(leagueTobeAddedTo);
		leagueToBePrinted.printToView(teamListView);
			
		//something wrong with these 2 lines
		int teamToBePrinted = teamListView.getSelectionModel().getSelectedIndex();
		//teamToBePrinted=teamToBePrinted-1;
		
		
		Team teamToBePrintedTeam = leagueToBePrinted.getTeamForPrint(teamToBePrinted);
				
		//teamToBePrintedTeam.printToView(playerListView);
		
		teamToBePrintedTeam.addPlayer(newplayer);
		
		playerListView.getItems().clear();
		teamToBePrintedTeam.printToView(playerListView);
		
	}


	/**
	 * Adds the manager.
	 *
	 * @param managerFNameTextField the manager F name text field
	 * @param managerMNameTextField the manager M name text field
	 * @param managerLNameTextField the manager L name text field
	 * @param managerPhoneTextField the manager phone text field
	 * @param managerEmailTextField the manager email text field
	 * @param managerDOB the manager DOB
	 * @param managerStarRatingTextField the manager star rating text field
	 * @param teamListViewTeamTab the team list view team tab
	 * @param leagueListViewTeamTab the league list view team tab
	 * @param leagues the leagues
	 */
	public void addManager(TextField managerFNameTextField, TextField managerMNameTextField,
			TextField managerLNameTextField, TextField managerPhoneTextField, TextField managerEmailTextField,
			DatePicker managerDOB,TextField managerStarRatingTextField, ListView<Team> teamListViewTeamTab, ListView<League> leagueListViewTeamTab, ArrayList<League> leagues) {
		
		Name newManagerName = new Name(managerFNameTextField.getText(), managerMNameTextField.getText(), managerLNameTextField.getText());
		
		LocalDate dob = managerDOB.getValue();
		String dateString = dob.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
		int starRating = Integer.parseInt(managerStarRatingTextField.getText());
		
		Manager newManager = new Manager(newManagerName, managerPhoneTextField.getText(), managerEmailTextField.getText(), starRating, dateString);
		
		//adding manager to listview
		//playerListView.getItems().clear();
		int leagueTobeAddedTo = leagueListViewTeamTab.getSelectionModel().getSelectedIndex();		
		League leagueToBePrinted = leagues.get(leagueTobeAddedTo);
		leagueToBePrinted.printToView(teamListViewTeamTab);
			
		//something wrong with these 2 lines
		int teamToBePrinted = teamListViewTeamTab.getSelectionModel().getSelectedIndex();
		//teamToBePrinted=teamToBePrinted-1;
		
		
		Team teamToBePrintedTeam = leagueToBePrinted.getTeamForPrint(teamToBePrinted);
				
		//teamToBePrintedTeam.printToView(playerListView);
		
		teamToBePrintedTeam.addManager(newManager);
		
		teamListViewTeamTab.getItems().clear();
		leagueToBePrinted.printToView(teamListViewTeamTab);
		
	}


	/**
	 * Removes the team.
	 *
	 * @param leagues the leagues
	 * @param leagueListViewTeamTab the league list view team tab
	 * @param teamListView the team list view
	 * @param teamListViewPlayerTab the team list view player tab
	 * @param teamListViewTeamTab the team list view team tab
	 * @param teamNameTextField the team name text field
	 * @param teamColourTextField the team colour text field
	 */
	public void removeTeam(ArrayList<League> leagues, ListView<League> leagueListViewTeamTab,
			ListView<Team> teamListView, ListView<Team> teamListViewPlayerTab, ListView<Team> teamListViewTeamTab,
			TextField teamNameTextField, TextField teamColourTextField) {
		
		int leagueTobeAddedTo = leagueListViewTeamTab.getSelectionModel().getSelectedIndex();	
		League leagueToBePrinted = leagues.get(leagueTobeAddedTo);	
		int teamToBePrinted = teamListViewTeamTab.getSelectionModel().getSelectedIndex();	
		
		
		Team teamToBePrintedTeam = leagueToBePrinted.getTeamForPrint(teamToBePrinted);		
		
		
		leagues.get(leagueTobeAddedTo).removeTeam(teamToBePrintedTeam);		
		teamListViewTeamTab.getItems().clear();
		
		
		leagueToBePrinted.printToView(teamListViewTeamTab);	
		
	}


	/**
	 * Removes the manager.
	 *
	 * @param managerFNameTextField the manager F name text field
	 * @param managerMNameTextField the manager M name text field
	 * @param managerLNameTextField the manager L name text field
	 * @param managerPhoneTextField the manager phone text field
	 * @param managerEmailTextField the manager email text field
	 * @param managerDOB the manager DOB
	 * @param managerStarRatingTextField the manager star rating text field
	 * @param teamListViewTeamTab the team list view team tab
	 * @param leagueListViewTeamTab the league list view team tab
	 * @param leagues the leagues
	 */
	public void removeManager(TextField managerFNameTextField, TextField managerMNameTextField,
			TextField managerLNameTextField, TextField managerPhoneTextField, TextField managerEmailTextField,
			DatePicker managerDOB, TextField managerStarRatingTextField, ListView<Team> teamListViewTeamTab,
			ListView<League> leagueListViewTeamTab, ArrayList<League> leagues) {
		
		Name newManagerName = new Name(managerFNameTextField.getText(), managerMNameTextField.getText(), managerLNameTextField.getText());
		
		LocalDate dob = managerDOB.getValue();
		String dateString = dob.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
		int starRating = Integer.parseInt(managerStarRatingTextField.getText());
		
		Manager newManager = new Manager(newManagerName, managerPhoneTextField.getText(), managerEmailTextField.getText(), starRating, dateString);
		
		//adding manager to listview
		//playerListView.getItems().clear();
		int leagueTobeAddedTo = leagueListViewTeamTab.getSelectionModel().getSelectedIndex();		
		League leagueToBePrinted = leagues.get(leagueTobeAddedTo);
		leagueToBePrinted.printToView(teamListViewTeamTab);
			
		//something wrong with these 2 lines
		int teamToBePrinted = teamListViewTeamTab.getSelectionModel().getSelectedIndex();
		//teamToBePrinted=teamToBePrinted-1;
		
		
		Team teamToBePrintedTeam = leagueToBePrinted.getTeamForPrint(teamToBePrinted);
				
		//teamToBePrintedTeam.printToView(playerListView);
		
		teamToBePrintedTeam.removeManager();		
		
		teamListViewTeamTab.getItems().clear();
		leagueToBePrinted.printToView(teamListViewTeamTab);
		
	}


	/**
	 * Removes the player.
	 *
	 * @param leagues the leagues
	 * @param leagueListViewPlayerTab the league list view player tab
	 * @param teamListViewPlayerTab the team list view player tab
	 * @param playerListView the player list view
	 * @param playerFNameTextField the player F name text field
	 * @param playerMNameField the player M name field
	 * @param playerLnameTextField the player lname text field
	 * @param playerEmailTextField the player email text field
	 * @param playerPhoneTextField the player phone text field
	 * @param playerDOB the player DOB
	 * @param goalieRadioButton the goalie radio button
	 * @param playerRadioButton the player radio button
	 */
	public void removePlayer(ArrayList<League> leagues, ListView<League> leagueListViewPlayerTab,
			ListView<Team> teamListViewPlayerTab, ListView<Player> playerListView, TextField playerFNameTextField,
			TextField playerMNameField, TextField playerLnameTextField, TextField playerEmailTextField,
			TextField playerPhoneTextField, DatePicker playerDOB, RadioButton goalieRadioButton,
			RadioButton playerRadioButton) {
		
		int leagueTobeAddedTo = leagueListViewPlayerTab.getSelectionModel().getSelectedIndex();		
		League leagueToBePrinted = leagues.get(leagueTobeAddedTo);
		leagueToBePrinted.printToView(teamListViewPlayerTab);
			
		//something wrong with these 2 lines
		int teamToBePrinted = teamListViewPlayerTab.getSelectionModel().getSelectedIndex();
		//teamToBePrinted=teamToBePrinted-1;
		
		
		Team teamToBePrintedTeam = leagueToBePrinted.getTeamForPrint(teamToBePrinted);
				
		//teamToBePrintedTeam.printToView(playerListView);
		int playerToBeRemoved = playerListView.getSelectionModel().getSelectedIndex();
		//Player playerToBeRemovedPlayer = teamToBePrintedTeam.getPlayers();
		teamToBePrintedTeam.removePlayer(playerToBeRemoved);
		
		playerListView.getItems().clear();
		teamToBePrintedTeam.printToView(playerListView);
		
		
	}


	/**
	 * Save function.
	 *
	 * @param leagues the leagues
	 */
	public void saveFunction(ArrayList<League> leagues) {
		// TODO Auto-generated method stub
		try {
			//establish connection
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leagueschema?serverTimezone=UTC", "root", "Password");
					
			//create statement
			Statement myStatement = myConnection.createStatement();
			
			//execute query
			for(int i=0;i<leagues.size();i++) {
				
				League databaseLeague = leagues.get(i);			
				String dbName=databaseLeague.getName();
				
				String sql = "insert into leagues "
						+ "(LeagueName) "
						+"values( "+ "'"+dbName+"')";
				
				myStatement.executeUpdate(sql);
			}
			
			League league1 = leagues.get(0);
			
			for(int i=0;i<league1.getTeam().size();i++) {
				
				Team databaseTeam = league1.getTeamForPrint(i);
				
				String teamName = databaseTeam.getName();
				String teamColour = databaseTeam.getJerseyColour();
				
				String managerName = databaseTeam.getManagerName();
				String managerEmail = databaseTeam.getManagerEmail();
				String managerDOB = databaseTeam.getManagerDOB();
				String managerPhone = databaseTeam.getManagerPhone();
				int managerRating = databaseTeam.getManagerRating();
				
				String sql = "insert into teams "
						+ "(teamName, jerseyColour, managerName, managerEmail, managerPhoneNumber, managerRating, managerDOB) "
						+"values( "+ 
									"'"+teamName+"',"+
									"'"+teamColour+"',"+ 
									"'"+managerName+"'," +
									"'"+managerEmail+"',"+
									"'"+managerPhone+"',"+
									"'"+managerRating+"',"+
									"'"+managerDOB+"'"+									
									")";
				
				myStatement.executeUpdate(sql);				
			}
			
			ArrayList<Player> sqlPlayers = new ArrayList<Player>();
			
			for (int i = 0; i < league1.getTeam().size(); i++) {				
				Team databaseTeam = league1.getTeamForPrint(i);				
				sqlPlayers.addAll(databaseTeam.getPlayers());				
			}
			
			for (int i = 0; i < sqlPlayers.size(); i++) {
				
				Player sqlPlayer = sqlPlayers.get(i);
				String isGoalie="";
				
				String playerName = sqlPlayer.getName().toString();
				String playerNumber = sqlPlayer.getPhone();
				String playerEmail = sqlPlayer.getEmail();
				Boolean playerGoalie = sqlPlayer.isGoalie();
				
				if (playerGoalie=true) {
					 isGoalie="Yes";
				}
				else {
					 isGoalie="No";
				}
				
				int playerGoals = sqlPlayer.getGoals();
				System.out.print(playerName+ playerNumber+playerEmail+ playerGoalie);
				
				String sql = "insert into players "
						+ "(playerName, phoneNumber, email, goalie, goals) "
						+"values( "+ 
									"'"+playerName+"',"+
									"'"+playerNumber+"',"+ 
									"'"+playerEmail+"'," +
									"'"+isGoalie+"',"+
									"'"+playerGoals+"'"+									
									")";
				
				myStatement.executeUpdate(sql);	
			}
			
			
			System.out.println("Query successful");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				}
	
	


	

	
}

