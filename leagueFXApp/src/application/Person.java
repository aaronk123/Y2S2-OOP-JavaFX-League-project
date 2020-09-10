package application;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
public class Person {
	
	/** The name. */
	private Name name;
	
	/** The phone. */
	private String phone;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new person.
	 *
	 * @param name the name
	 * @param phone the phone
	 * @param email the email
	 */
	public Person(Name name, String phone, String email) {
		this.name=name;
		this.phone=phone;
		this.email=email;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
