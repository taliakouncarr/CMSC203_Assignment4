
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Plot class
 * Due: 7/17/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/
public class Plot {
	/**
	 * @author Talia
	 * @version 7/17/2023
	 */

	// declare instance variables
	private int x, y;
	private int width, depth;

	/**
	 * Creates a default plot with a width and depth of 1
	 * 
	 */

	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	/**
	 * Creates a plot using the given values
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * 
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * Creates a new plot given another plot
	 * 
	 * @param otherPlot
	 */

	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}

	
	/**
	 * determines if the given plot instance is overlapped by the current plot
	 * @param plot
	 * @return
	 */
	public boolean overlaps(Plot plot) {
		int x2 = plot.x;
		int y2 = plot.y;
		int width2 = plot.width;
		int depth2 = plot.depth;

		// Check for overlap
		if (x < x2 + width2 && x + width > x2 && y < y2 + depth2 && y + depth > y2) {
			return true;
		}

		return false;
	}

	
	/**
	 * determines if the given plot is encompassed by this plot
	 * @param plot
	 * @return
	 */
	public boolean encompasses(Plot plot) {
		int x2 = plot.x;
		int y2 = plot.y;
		int width2 = plot.width;
		int depth2 = plot.depth;

		// Check if plot is encompassed
		if (x <= x2 && y <= y2 && x + width >= x2 + width2 && y + depth >= y2 + depth2) {
			return true;
		}

		return false;
	}

	
	// Getter and Setter methods
	/**
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}
/**
 * 
 * @param y
 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}
/**
 * 
 * @param width
 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * 
	 * @return
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * 
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}


	
	/**
	 *  toString method
	 */
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}

	@Override
	/**
	 * @param obj
	 * @return
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Plot otherPlot = (Plot) obj;

		return this.x == otherPlot.x && this.y == otherPlot.y && this.width == otherPlot.width
				&& this.depth == otherPlot.depth;
	}
}
