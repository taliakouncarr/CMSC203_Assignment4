/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: ManagementCompany class
 * Due: 7/17/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/
public class ManagementCompany {

	// Create our instance variables
	private String name, taxID;
	private double mgmFee;
	final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;

	
/**
 * // Creates a ManagementCompany object using empty strings,
	// creates a default Plot with maximum width and depth
	// initializes the properties array
 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot();
		this.properties = new Property[MAX_PROPERTY];
	}

	
/**
 * // Creates a ManagementCompant object using the given values
	// Creates a default plot w max width and depth
	// Initializes the properties array
 * @param name
 * @param taxID
 * @param mgmFee
 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}

	
/**
 * // Creates a ManagementCompany object using the given values
	// creates a Plot using the given values and
	// it initializes the properties array.
 * @param name
 * @param taxID
 * @param mgmFee
 * @param x
 * @param y
 * @param width
 * @param depth
 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
	}

	
/**
 * // Creates a new ManagementCompany copy of the given ManagementCompany
 * @param otherCompany
 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee, otherCompany.plot.getX(),
				otherCompany.plot.getY(), otherCompany.plot.getWidth(), otherCompany.plot.getDepth());

		// Copy properties from otherCompany to this company
		for (int i = 0; i < otherCompany.numberOfProperties; i++) {
			Property property = otherCompany.properties[i];
			this.properties[i] = new Property(property);
		}
		this.numberOfProperties = otherCompany.numberOfProperties;
	}

	// Getters and setters
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getTaxID() {
		return taxID;
	}

	/**
	 * 
	 * @param taxID
	 */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	/**
	 * 
	 * @return
	 */
	public double getMgmFee() {
		return mgmFee;
	}

	/**
	 * 
	 * @param mgmFee
	 */
	public void setMgmFee(double mgmFee) {
		this.mgmFee = mgmFee;
	}

	/**
	 * 
	 * @return
	 */
	public Plot getPlot() {
		return plot;
	}

	/**
	 * 
	 * @param plot
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	/**
	 * 
	 * // Overloaded method which has multiple versions // Will return a certain
	 * value depending on success or failure of adding // property // • If there is
	 * a problem adding the property, this method will return // If the array is
	 * full, it will return -1 // o If the property is null, it will return -2 // o
	 * If the plot for the property is not encompassed by the management company //
	 * plot, it will return -3 // o If the plot for the property overlaps any other
	 * property’s plot, it will // return -4 // Otherwise if the property is
	 * successfully added, it will return the index of // the array where the
	 * property was added
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		Property property1 = new Property(name, city, rent, owner);
		if (numberOfProperties == MAX_PROPERTY) {
			return -1; // Array is full
		}
		if (property1 == null) {
			return -2; // Property is null
		}
		if (!plot.encompasses(property1.getPlot())) {
			return -3; // Property plot is not encompassed by the management company plot
		}
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null && properties[i].getPlot().overlaps(property1.getPlot())) {
				return -4; // Property plot overlaps with an existing property
			}
		}
		properties[numberOfProperties] = property1;
		numberOfProperties++;
		return numberOfProperties - 1; // Index where the property was added
	}

	/**
	 * // Adds a new property to the properties array, this method should call an //
	 * appropriate existing overloaded method.
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property1 = new Property(name, city, rent, owner, x, y, width, depth);
		if (numberOfProperties == MAX_PROPERTY) {
			return -1; // Array is full
		}
		if (property1 == null) {
			return -2; // Property is null
		}
		if (!plot.encompasses(property1.getPlot())) {
			return -3; // Property plot is not encompassed by the management company plot
		}
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null && properties[i].getPlot().overlaps(property1.getPlot())) {
				return -4; // Property plot overlaps with an existing property
			}
		}
		properties[numberOfProperties] = property1;
		numberOfProperties++;
		return numberOfProperties - 1; // Index where the property was added
	}

	/**
	 * // Creates a property object by copying from another property and adds it to
	 * the // properties array
	 * 
	 * @param property
	 * @return
	 */

	public int addProperty(Property property) {
		if (numberOfProperties == MAX_PROPERTY) {
			return -1; // Array is full
		}
		if (property == null) {
			return -2; // Property is null
		}
		if (!plot.encompasses(property.getPlot())) {
			return -3; // Property plot is not encompassed
		}
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
				return -4; // Property plot overlaps with another property
			}
		}
		properties[numberOfProperties] = property;
		numberOfProperties++;
		return numberOfProperties - 1; // Index where the property was added
	}

	/**
	 * // get the total rent amount
	 * 
	 * @return
	 */
	public double getTotalRent() {
		double totalRent = 0.0;
		for (int i = 0; i < numberOfProperties; i++) {
			totalRent += properties[i].getRentAmount();
		}
		return totalRent;
	}

	/**
	 * gets highest rent property
	 * 
	 * @return
	 */
	public Property getHighestRentPropperty() {
		if (numberOfProperties == 0) {
			return null;
		}

		Property highestRentPropperty = properties[0];
		for (int i = 1; i < numberOfProperties; i++) {
			if (properties[i].getRentAmount() > highestRentPropperty.getRentAmount()) {
				highestRentPropperty = properties[i];
			}
		}

		return highestRentPropperty;
	}

	/**
	 * // nullifies the LAST property in the properties array
	 * 
	 */
	public void removeLastProperty() {
		if (numberOfProperties > 0) {
			properties[numberOfProperties - 1] = null;
			numberOfProperties--;
		}
	}

	/**
	 * // Checks if the properties array has reached the maximum capacity
	 * 
	 * @return
	 */
	public boolean isPropertiesFull() {
		if (numberOfProperties == MAX_PROPERTY) {
			return true;
		} else
			return false;

	}

	/**
	 * // Returns the number of existing properties in the array
	 * 
	 * @return
	 */
	public int getPropertiesCount() {
		return numberOfProperties;

	}

	/**
	 * // Checks if the management company has a valid (between 0-100) fee
	 * 
	 * @return
	 */
	public boolean isManagementFeeValid() {
		if (mgmFee >= 0 && mgmFee <= 100) {
			return true;
		} else
			return false;
	}

	/**
	 * extra method to calculate the total management fee
	 * 
	 * @return
	 */
	private double totalManagementFee() {
		return (getTotalRent() * mgmFee) / 100;

	}
	// gets the property in the array with the max amount of rent

	// toString method
	/**
	 * 
	 */
	public String toString() {
		String myString = "";
		myString += ("List of the properties for ") + (name) + (", taxID: ") + (taxID) + ("\n");

		myString += ("______________________________________________________\n");

		for (int i = 0; i < numberOfProperties; i++) {
			myString += (properties[i]) + ("\n");
		}

		myString += ("______________________________________________________\n");
		myString += ("\ntotal management Fee: " + totalManagementFee());

		return myString.toString();
	}

	/**
	 * 
	 * @return
	 */

	public Property[] getProperties() {
		return properties;
	}

}