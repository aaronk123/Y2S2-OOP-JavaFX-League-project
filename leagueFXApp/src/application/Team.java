package application;

import java.util.ArrayList;

//import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import javafx.scene.control.ListView;

// TODO: Auto-generated Javadoc
/**
 * The Class Team.
 */
public class Team {
	
	/** The Name. */
	private String Name;
	
	/** The jersey colour. */
	private String jerseyColour;
	
	/** The players. */
	private ArrayList<Player> players;
	
	/** The managers. */
	private ArrayList<Manager> managers;	
	
	/** The manager. */
	private Manager manager;
	
	/** The player. */
	private Player player;
	
	/**
	 * Instantiates a new team.
	 *
	 * @param teamName the team name
	 * @param jerseyColour the jersey colour
	 */
	public Team(String teamName, String jerseyColour) {
		this.Name=teamName;
		this.manager=manager;
		this.jerseyColour=jerseyColour;
		players=new ArrayList<Player>();
		
	}
	
	/**
	 * Sets the name.
	 *
	 * @param newName the new name
	 */
	public void setName(String newName) {
		this.Name = newName;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.Name;
	}
	
	/**
	 * Gets the jersey colour.
	 *
	 * @return the jersey colour
	 */
	public String getJerseyColour() {
		return jerseyColour;
	}
	
	/**
	 * Sets the jersey colour.
	 *
	 * @param jerseyColour the new jersey colour
	 */
	public void setJerseyColour(String jerseyColour) {
		this.jerseyColour = jerseyColour;
	}
	
	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	public ArrayList<Manager> getManager() {
		return managers;
	}
	
	/**
	 * Sets the manager.
	 *
	 * @param manager the new manager
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	/**
	 * Adds the player.
	 *
	 * @param player the player
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	/**
	 * Removes the player.
	 *
	 * @param index the index
	 */
	public void removePlayer(int index) {
		players.remove(index);
	}
	
	/**
	 * Adds the manager.
	 *
	 * @param newManager the new manager
	 */
	public void addManager(Manager newManager) {
		if(manager==null) {
			manager=newManager;
		}
		else {
			System.out.println("This team already has a manger");
		}
	}
	
	/**
	 * Removes the manager.
	 */
	public void removeManager() {
		this.manager=null;
	}
	
	/**
	 * Gets the manager name.
	 *
	 * @return the manager name
	 */
	//manager getters
	public String getManagerName() {
		return manager.getName().toString();		
	}
	
	/**
	 * Gets the manager phone.
	 *
	 * @return the manager phone
	 */
	public String getManagerPhone() {
		return manager.getPhone().toString();
	}
	
	/**
	 * Gets the manager email.
	 *
	 * @return the manager email
	 */
	public String getManagerEmail() {
		return manager.getEmail().toString();
	}
	
	/**
	 * Gets the manager DOB.
	 *
	 * @return the manager DOB
	 */
	public String getManagerDOB() {
		return manager.getDOB().toString();
	}
	
	/**
	 * Gets the manager rating.
	 *
	 * @return the manager rating
	 */
	public int getManagerRating() {
		return manager.getStarRating();
	}
	
	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;		
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Name: " + Name + "\nManager: " + manager;
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.println(toString());
		for(int i=0; i<players.size();i++) {
			System.out.println(players.get(i));
		}
		System.out.println("");
	}
	
	/**
	 * Prints the to view.
	 *
	 * @param view the view
	 * @return the list view
	 */
	public ListView<Player> printToView(ListView<Player> view) {
		view.getItems().addAll(players);
		return view;
	}	
}

