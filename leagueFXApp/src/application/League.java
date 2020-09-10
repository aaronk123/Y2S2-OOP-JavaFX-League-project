package application;

import java.util.ArrayList;

import javafx.scene.control.ListView;

// TODO: Auto-generated Javadoc
//import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

/**
 * The Class League.
 */
public class League {
	
	/** The name. */
	private String name;
	
	/** The teams. */
	private ArrayList<Team> teams;
	
	/**
	 * Instantiates a new league.
	 *
	 * @param leagName the leag name
	 */
	public League(String leagName) {
		teams = new ArrayList<Team>();
		this.name=leagName;
	}
	
	/**
	 * Adds the team.
	 *
	 * @param team the team
	 */
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	/**
	 * Removes the team.
	 *
	 * @param team the team
	 */
	public void removeTeam(Team team) {
		teams.remove(team);
	}
	
	/**
	 * Gets the team.
	 *
	 * @return the team
	 */
	public ArrayList<Team> getTeam() {
		return teams;		
	}
	
	/**
	 * Gets the team for print.
	 *
	 * @param index the index
	 * @return the team for print
	 */
	public Team getTeamForPrint(int index) {
		return teams.get(index);		
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param leagname the new name
	 */
	public void setName(String leagname) {
		this.name = leagname;
	}	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return getName();
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.println(toString());
		for(int i=0;i<teams.size(); i++){
			Team currentTeam=teams.get(i);
			currentTeam.print();
		}
		System.out.println("");
	}
	
	/**
	 * Prints the to view.
	 *
	 * @param view the view
	 * @return the list view
	 */
	public ListView<Team> printToView(ListView<Team> view) {
		view.getItems().addAll(teams);
		return view;
	}

}
