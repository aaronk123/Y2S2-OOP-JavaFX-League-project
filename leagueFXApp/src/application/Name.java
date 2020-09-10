package application;

// TODO: Auto-generated Javadoc
/**
 * The Class Name.
 */
public class Name {
	
	/** The first name. */
	private String firstName;
	
	/** The middle name. */
	private String middleName;
	
	/** The last name. */
	private String lastName;
		
	/**
	 * Instantiates a new name.
	 *
	 * @param firstName the first name
	 * @param middleName the middle name
	 * @param lastName the last name
	 */
	public Name(String firstName, String middleName, String lastName) {
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 *
	 * @param middleName the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.println(toString());
	}

}
