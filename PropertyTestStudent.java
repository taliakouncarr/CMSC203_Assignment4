import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: PropertyTestStudent class
 * Due: 7/17/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/

public class PropertyTestStudent {
	Property home1 = new Property("Talia's House", "Rockville", 1000.0, "Me", 1, 2, 3, 4);

	@Test
	public void testDefaultConstructor() {
		Property home1 = new Property ();
	    assertEquals("", home1.getPropertyName());
	    assertEquals("", home1.getCity());
	    assertEquals(0.0, home1.getRentAmount(), 0.001);
	    assertEquals("", home1.getOwner());
	    assertEquals(new Plot(), home1.getPlot());
	}


	@Test
	public void testParameterizedConstructor() {
	    assertEquals("Talia's House", home1.getPropertyName());
	    assertEquals("Rockville", home1.getCity());
	    assertEquals(1000.0, home1.getRentAmount(), 0.001);
	    assertEquals("Me", home1.getOwner());
	    assertEquals(new Plot(1, 2, 3, 4), home1.getPlot());
	}


	@Test
	public void testParameterizedConstructorWithPlot() {
		 assertEquals("Talia's House", home1.getPropertyName());
	        assertEquals("Rockville", home1.getCity());
	        assertEquals(1000.0, home1.getRentAmount(), 0.001);
	        assertEquals("Me", home1.getOwner());
	        assertEquals(new Plot(1, 2, 3, 4), home1.getPlot());
	    }	

	@Test
	public void testCopyConstructor() {
		Property anotherProperty = new Property("Jack's House", "Gaithersburg", 2000.0, "You");
		Property home1 = new Property(anotherProperty);
		assertEquals(anotherProperty.getPropertyName(), home1.getPropertyName());
        assertEquals(anotherProperty.getCity(), home1.getCity());
        assertEquals(anotherProperty.getRentAmount(), home1.getRentAmount(), 0.001);
        assertEquals(anotherProperty.getOwner(), home1.getOwner());
        assertEquals(anotherProperty.getPlot(), home1.getPlot());	}

	@Test
	public void testGettersAndSetters() {

		// Set property details using setter methods
		home1.setPropertyName("Talia's House");
		home1.setCity("Rockville");
		home1.setRentAmount(1000.0);
		home1.setOwner("Me");
		home1.setPlot(new Plot(1, 2, 3, 4));

		// Use getter methods and assert the expected values
		assertEquals("Talia's House", home1.getPropertyName());
		assertEquals("Rockville", home1.getCity());
		assertEquals(1000.0, home1.getRentAmount(), 0.001);
		assertEquals("Me", home1.getOwner());
		assertEquals(new Plot(1, 2, 3, 4), home1.getPlot());
	}

	@Test
	public void testToString() {
		 assertEquals("Talia's House,Rockville,Me,1000.0", home1.toString());	
		 }
}
