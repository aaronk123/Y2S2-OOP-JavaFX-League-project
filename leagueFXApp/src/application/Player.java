package application;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player extends Person {
	
	/** The is goalie. */
	private boolean isGoalie;
	
	/** The goals. */
	private int goals;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 * @param phone the phone
	 * @param email the email
	 * @param isGoalie the is goalie
	 * @param goals the goals
	 */
	public Player(Name name, String phone, String email, Boolean isGoalie, int goals) {
		super(name, phone, email);
		this.isGoalie=isGoalie;
		this.goals=goals;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Checks if is goalie.
	 *
	 * @return true, if is goalie
	 */
	public boolean isGoalie() {
		return isGoalie;
	}

	/**
	 * Sets the goalie.
	 *
	 * @param isGoalie the new goalie
	 */
	public void setGoalie(boolean isGoalie) {
		this.isGoalie = isGoalie;
	}
	
	/**
	 * Gets the goals.
	 *
	 * @return the goals
	 */
	public int getGoals() {
		return goals;
	}

	/**
	 * Sets the goals.
	 *
	 * @param goals the new goals
	 */
	public void setGoals(int goals) {
		this.goals = goals;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Override
	public Name getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	@Override
	public void setName(Name name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return super.getPhone();
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	@Override
	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		super.setPhone(phone);
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return getName()+"\tPhone: " + getPhone() + "\tEmail: " + getEmail() + "\tIs a goalie?:" + isGoalie + "\tNumber of goals conceded/scored " + goals;
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.println(toString());
	}


}
