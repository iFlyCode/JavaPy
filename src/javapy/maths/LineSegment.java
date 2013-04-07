package javapy.maths;
/*
 * This is a java class all on it's own, 
 * meant to be called.
 */
public class LineSegment {
	
	double x1;
	double y1;
	double x2;
	double y2;
	LineSegment(double x1_in, double y1_in, double x2_in, double y2_in) {
		this.x1 = x1_in;
		this.y1 = y1_in;
		this.x2 = x2_in;
		this.y2 = y2_in;
	}
	
	/**
	 * <strong><em>
	 * <Ul><li>slope</ul></li>
	 * </em></strong>
	 * <p style="font-family:Courier">public double slope()</p>
	 * <p>Gets the slope of the line segment</p>
	 * @return the slope of the line
	 */
	public double slope() {return (this.y1 - this.y2)/(this.x1 - this.x2);}
	
	/**
	 * <strong><em>
	 * <Ul><li>yIntercept</ul></li>
	 * </em></strong>
	 * <p style="font-family:Courier">public double yIntercept()</p>
	 * <p>Gets the y-intercept of the line segment</p>
	 * @return the y-intercept of the line
	 */
	public double yIntercept() {return this.y1 - this.slope()*this.x1;}
	
	public String toString() {return "(" + this.x1 + ", " + this.y1 + "), (" + this.x2 + ", " + this.y2 + ")";}
	
	/**
	 * <ul><li><b><i>
	 * 		intersects
	 * </i></b></li></ul>
	 * <p style="font-family:Courier">
	 * 	public boolean intersects(LineSegment seg)
	 * </p><p>
	 * 	Returns true if this line segment intersects with the
	 * 	one given as an argument.
	 * </p>
	 * @param seg - the line segment to test for intersection
	 * @return if the two line segments intersect
	 */
	public boolean intersects(LineSegment seg) {
		if (Math.max(this.x1, this.x2) >= Math.min(seg.x1, seg.x2)) {
			if (Math.max(seg.x1, seg.x2) >= Math.min(this.x1, this.x2)) {
				if (Math.max(this.y1, this.y2) >= Math.min(seg.y1, seg.y2)) {
					if (Math.max(seg.y1, seg.y2) >= Math.min(this.y1, this.y2)) {
						boolean PartA = ( (this.x2-this.x1)*(seg.y1-this.y1) - (this.y2-this.y1)*(seg.x1-this.x1) ) > 0;
						boolean PartB = ( (this.x2-this.x1)*(seg.y2-this.y1) - (this.y2-this.y1)*(seg.x2-this.x1) ) < 0;

						boolean PartC = ( (seg.x2-this.x1)*(this.y1-seg.y1) - (this.y2-seg.y1)*(this.x1-seg.x1) ) > 0;
						boolean PartD = ( (seg.x2-this.x1)*(this.y2-seg.y1) - (this.y2-seg.y1)*(this.x2-seg.x1) ) < 0;
						
						if ( (PartA && PartB) && (PartC && PartD) ) return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * <ul><li><b><i>
	 * 		intersectionOf
	 * </i></b></li></ul>
	 * <p style="font-family:Courier">public double intersectionOf(LineSegment seg)</p>
	 * <p>
	 * 	Returns the intersection point of two line segments,
	 * 	or returns null if they don't intersect.
	 * </p>
	 * @param seg - The line segment to test for intersection.
	 * @return The intersection point of the two lines, null if they don't intersect.
	 */
	public double[] intersectionOf(LineSegment seg) {
		if (!this.intersects(seg))
			return null;
		double x = (seg.yIntercept() - this.yIntercept())/(this.slope() - seg.slope());
		return new double[] {x, (x*this.slope()) - y1};
	}
}
