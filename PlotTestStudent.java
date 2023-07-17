import org.junit.Test;
import static org.junit.Assert.*;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: PlotTestStudent class
 * Due: 7/17/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/
public class PlotTestStudent {
    
    @Test
    public void testDefaultPlotConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }
    
    @Test
    public void testParameterizedPlotConstructor() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(4, plot.getWidth());
        assertEquals(5, plot.getDepth());
    }
    
    @Test
    public void testCopyPlotConstructor() {
        Plot plot1 = new Plot(2, 3, 4, 5);
        Plot plot = new Plot(plot1);
        assertEquals(plot1.getX(), plot.getX());
        assertEquals(plot1.getY(), plot.getY());
        assertEquals(plot1.getWidth(), plot.getWidth());
        assertEquals(plot1.getDepth(), plot.getDepth());
    }
    
    @Test
    public void testGetX() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(2, plot.getX());
    }
    
    @Test
    public void testSetX() {
        Plot plot = new Plot();
        plot.setX(2);
        assertEquals(2, plot.getX());
    }
    
    @Test
    public void testGetY() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(3, plot.getY());
    }
    
    @Test
    public void testSetY() {
        Plot plot = new Plot();
        plot.setY(3);
        assertEquals(3, plot.getY());
    }
    
    @Test
    public void testGetWidth() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(4, plot.getWidth());
    }
    
    @Test
    public void testSetWidth() {
        Plot plot = new Plot();
        plot.setWidth(4);
        assertEquals(4, plot.getWidth());
    }
    
    @Test
    public void testGetDepth() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(5, plot.getDepth());
    }
    
    @Test
    public void testSetDepth() {
        Plot plot = new Plot();
        plot.setDepth(5);
        assertEquals(5, plot.getDepth());
    }
    
    @Test
    public void testOverlaps() {
        Plot plot1 = new Plot(2, 2, 4, 4);
        Plot plot2 = new Plot(4, 4, 4, 4);
        assertTrue(plot1.overlaps(plot2));
    }
    
    @Test
    public void testEncompasses() {
        Plot plot1 = new Plot(2, 2, 8, 8);
        Plot plot2 = new Plot(4, 4, 4, 4);
        assertTrue(plot1.encompasses(plot2));
    }
    
    @Test
    public void testToString() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals("2,3,4,5", plot.toString());
    }
}