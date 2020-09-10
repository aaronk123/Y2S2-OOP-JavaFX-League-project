package application;

// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 */
public class Manager extends Person {
	
	/** The star rating. */
	private int starRating;
	
	/** The dob. */
	private String DOB;
	
	/**
	 * Instantiates a new manager.
	 *
	 * @param name the name
	 * @param phone the phone
	 * @param email the email
	 * @param starRating the star rating
	 * @param DOB the dob
	 */
	public Manager(Name name, String phone, String email, int starRating, String DOB) {
		super(name, phone, email);
		this.starRating=starRating;
		this.DOB=DOB;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the star rating.
	 *
	 * @return the star rating
	 */
	public int getStarRating() {
		return starRating;
	}

	/**
	 * Sets the star rating.
	 *
	 * @param starRating the new star rating
	 */
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dOB the new dob
	 */
	public void setDOB(String dOB) {
		DOB = dOB;
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
		return getName()+"\tPhone: " + getPhone() + "\tEmail: " + getEmail() + "\tDOB " + DOB + "\tRating " + starRating;
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.println(toString());
	}



}
