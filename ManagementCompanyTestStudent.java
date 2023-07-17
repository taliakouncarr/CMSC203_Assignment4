import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import junit.framework.TestCase;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: ManagementCompanyTestStudent class
 * Due: 7/17/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/
public class ManagementCompanyTestStudent extends TestCase {

	public void testManagementCompany() {
		ManagementCompany company = new ManagementCompany();
		assertEquals("", company.getName());
		assertEquals("", company.getTaxID());
		assertEquals(0.0, company.getMgmFee(), 0.001);
		assertEquals(new Plot(), company.getPlot());
		assertEquals(0, company.getPropertiesCount());
		assertFalse(company.isPropertiesFull());
		assertTrue(company.isManagementFeeValid());
	}

	public void testManagementCompanyStringStringDouble() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals("Company", company.getName());
		assertEquals("12345", company.getTaxID());
		assertEquals(10.0, company.getMgmFee(), 0.001);
		assertEquals(new Plot(0, 0, 10, 10), company.getPlot());
		assertEquals(0, company.getPropertiesCount());
		assertFalse(company.isPropertiesFull());
		assertTrue(company.isManagementFeeValid());
	}

	public void testManagementCompanyStringStringDoubleIntIntIntInt() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0, 1, 2, 3, 4);
		assertEquals("Company", company.getName());
		assertEquals("12345", company.getTaxID());
		assertEquals(10.0, company.getMgmFee(), 0.001);
		assertEquals(new Plot(1, 2, 3, 4), company.getPlot());
		assertEquals(0, company.getPropertiesCount());
		assertFalse(company.isPropertiesFull());
		assertTrue(company.isManagementFeeValid());
	}

	public void testManagementCompanyManagementCompany() {
		ManagementCompany otherCompany = new ManagementCompany("Other Company", "54321", 15.0, 5, 6, 7, 8);
		ManagementCompany company = new ManagementCompany(otherCompany);
		assertEquals(otherCompany.getName(), company.getName());
		assertEquals(otherCompany.getTaxID(), company.getTaxID());
		assertEquals(otherCompany.getMgmFee(), company.getMgmFee(), 0.001);
		assertEquals(otherCompany.getPlot(), company.getPlot());
		assertEquals(0, company.getPropertiesCount());
		assertFalse(company.isPropertiesFull());
		assertTrue(company.isManagementFeeValid());
	}

	public void testGetName() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals("Company", company.getName());
	}

	public void testSetName() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals("Company", company.getName());

		// Set a new name for the company
		company.setName("New Company");

		// Verify that the name has been successfully updated
		assertEquals("New Company", company.getName());
	}

	public void testGetTaxID() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals("12345", company.getTaxID());
	}

	public void testSetTaxID() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals("12345", company.getTaxID());

		// Set a new tax ID for the company
		company.setTaxID("54321");

		// Verify that the tax ID has been successfully updated
		assertEquals("54321", company.getTaxID());
	}

	public void testGetMgmFee() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals(10.0, company.getMgmFee(), 0.001);
	}

	public void testSetMgmFee() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals(10.0, company.getMgmFee(), 0.001);

		// Set a new management fee for the company
		company.setMgmFee(15.0);

		// Verify that the management fee has been successfully updated
		assertEquals(15.0, company.getMgmFee(), 0.001);
	}

	public void testGetPlot() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		Plot plot = company.getPlot();
		assertEquals(new Plot(0, 0, 10, 10), plot);
	}

	public void testSetPlot() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals(new Plot(0, 0, 10, 10), company.getPlot());

		// Create a new plot and set it for the company
		Plot newPlot = new Plot(1, 2, 5, 5);
		company.setPlot(newPlot);

		// Verify that the plot has been successfully updated
		assertEquals(newPlot, company.getPlot());
	}

	public void testAddPropertyStringStringDoubleString() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0, 0, 0, 10, 10);
		int result = company.addProperty("Property 1", "City 1", 1000.0, "Owner 1");
		assertEquals(0, result);
		assertEquals(1, company.getPropertiesCount());
		assertFalse(company.isPropertiesFull());
	}

	public void testAddPropertyStringStringDoubleStringIntIntIntInt() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0, 0, 0, 10, 10);
		int result = company.addProperty("Property 1", "City 1", 1000.0, "Owner 1", 1, 1, 3, 3);
		assertEquals(0, result);
		assertEquals(1, company.getPropertiesCount());
		assertFalse(company.isPropertiesFull());

		Property addedProperty = company.getProperties()[0];
		assertEquals("Property 1", addedProperty.getPropertyName());
		assertEquals("City 1", addedProperty.getCity());
		assertEquals(1000.0, addedProperty.getRentAmount(), 0.001);
		assertEquals("Owner 1", addedProperty.getOwner());
		assertEquals(1, addedProperty.getPlot().getX());
		assertEquals(1, addedProperty.getPlot().getY());
		assertEquals(3, addedProperty.getPlot().getWidth());
		assertEquals(3, addedProperty.getPlot().getDepth());
	}

	public void testAddPropertyProperty() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0, 0, 0, 10, 10);
		Property property = new Property("Property 3", "City 3", 3000.0, "Owner 3");
		int result = company.addProperty(property);
		assertEquals(0, result);
		assertEquals(1, company.getPropertiesCount());
		assertFalse(company.isPropertiesFull());
	}

	public void testGetTotalRent() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		Property p1 = new Property("Talia's Crib", "Potomac", 1000.0, "LeBron James", 2, 1, 2, 2);
		Property p2 = new Property("JK's Jaunt", "Lakewood", 2000.0, "Timmy Turner", 4, 1, 2, 2);
		Property p3 = new Property("Wolf Pack", "Grandy", 3000.0, "Grandma", 6, 1, 2, 2);

		company.addProperty(p1);
		company.addProperty(p2);
		company.addProperty(p3);

		double totalRent = company.getTotalRent();
		assertEquals(6000.0, totalRent, 0.001);
	}

	public void testRemoveLastProperty() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		assertEquals(0, company.getPropertiesCount());
		Property p1 = new Property("Talia's Crib", "Potomac", 4844.00, "LeBron James", 2, 1, 2, 2);
		Property p2 = new Property("JK's Jaunt", "Lakewood", 4114, "Timmy Turner", 4, 1, 2, 2);
		Property p3 = new Property("Wolf Pack", "Grandy", 4905, "Grandma", 6, 1, 2, 2);
		company.addProperty(p1);
		company.addProperty(p2);
		company.addProperty(p3);
		assertEquals(3, company.getPropertiesCount());
		company.removeLastProperty();
		assertEquals(2, company.getPropertiesCount());

	}

	public void testIsPropertiesFull() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		Property p1 = new Property("Talia's Crib", "Potomac", 4844.00, "LeBron James");
		Property p2 = new Property("JK's Jaunt", "Lakewood", 4114, "Timmy Turner");
		Property p3 = new Property("Wolf Pack", "Grandy", 4905, "Grandma");
		Property p4 = new Property("Prop4", "Nowhere", 500.0, "Talia");
		

		company.addProperty(p1);
		company.addProperty(p2);
		company.addProperty(p3);
		company.addProperty(p4);
		

		assertFalse(company.isPropertiesFull());	
		}

	public void testGetPropertiesCount() {
		ManagementCompany company = new ManagementCompany("Company", "12345", 10.0);
		Property p1 = new Property("Talia's Crib", "Potomac", 4844.00, "LeBron James", 2, 1, 2, 2);
		Property p2 = new Property("JK's Jaunt", "Lakewood", 4114, "Timmy Turner", 4, 1, 2, 2);
		Property p3 = new Property("Wolf Pack", "Grandy", 4905, "Grandma", 6, 1, 2, 2);

		company.addProperty(p1);
		company.addProperty(p2);
		company.addProperty(p3);
		int count = company.getPropertiesCount();
		assertEquals(3, count);

	}

	public void testIsManagementFeeValid() {
		// Create a ManagementCompany with a valid management fee (between 0 and 100)
		ManagementCompany company1 = new ManagementCompany("Company1", "12345", 10.0);
		assertTrue(company1.isManagementFeeValid());

		// Create a ManagementCompany with an invalid management fee (less than 0)
		ManagementCompany company2 = new ManagementCompany("Company2", "54321", -5.0);
		assertFalse(company2.isManagementFeeValid());

		// Create a ManagementCompany with an invalid management fee (greater than 100)
		ManagementCompany company3 = new ManagementCompany("Company3", "98765", 150.0);
		assertFalse(company3.isManagementFeeValid());
	}

	public void testToString() {
		ManagementCompany company1 = new ManagementCompany("Company", "12345", 10.0);
	    Property p1 = new Property("Property 1", "City 1", 1000.00, "Owner 1");
	    
	    company1.addProperty(p1);
		 assertEquals("List of the properties for Company, taxID: 12345\n"
		 		+ "______________________________________________________\n"
				 +"Property 1,City 1,Owner 1,1000.0\n"
		 		+"______________________________________________________\n"+
				 "\ntotal management Fee: 100.0",company1.toString());	

	}

	public void testGetHighestRentProperty() {
	    ManagementCompany company1 = new ManagementCompany("Company", "12345", 10.0);
	    Property p1 = new Property("Property 3", "City 3", 3000.00, "Owner 3");
	    Property p2 = new Property("Property 2", "City 2", 2000.00, "Owner 2");
	    Property p3 = new Property("Property 1", "City 1", 1000.00, "Owner 1");

	    company1.addProperty(p1);
	    company1.addProperty(p2);
	    company1.addProperty(p3);

	    Property highestRentProperty = company1.getHighestRentPropperty();
	    assertEquals("Property 3", highestRentProperty.getPropertyName());
	    assertEquals("City 3", highestRentProperty.getCity());
	    assertEquals(3000.0, highestRentProperty.getRentAmount(), 0.001);
	    assertEquals("Owner 3", highestRentProperty.getOwner());
	}


}
