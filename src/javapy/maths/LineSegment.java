package javapy.maths;

/**
 *
 * @author ncolaprete
 * @author ifly6
 */
public class LineSegment {

	double x1;
	double y1;
	double x2;
	double y2;

	LineSegment(double inX1, double inY1, double inX2, double inY2) {
		this.x1 = inX1;
		this.y1 = inY1;
		this.x2 = inX2;
		this.y2 = inY2;
	}

	/**
	 * Calculates the slope of the line segment
	 *
	 * @return the slope of the line
	 */
	public double slope() {
		return (this.y1 - this.y2) / (this.x1 - this.x2);
	}

	/**
	 * Calculates the y-intercept of the line segment
	 *
	 * @return the y-intercept of the line
	 */
	public double yIntercept() {
		return this.y1 - this.slope() * this.x1;
	}

	@Override public String toString() {
		return "(" + this.x1 + ", " + this.y1 + "), (" + this.x2 + ", " + this.y2 + ")";
	}

	/**
	 * Returns true if this line segment intersects with the one given as an argument.
	 *
	 * @param seg is the line segment to test for intersection
	 * @return <code>true</code> the two line segments intersect, <code>false</code> if they do nots
	 */
	public boolean intersects(LineSegment seg) {
		if (Math.max(this.x1, this.x2) >= Math.min(seg.x1, seg.x2)) {
			if (Math.max(seg.x1, seg.x2) >= Math.min(this.x1, this.x2)) {
				if (Math.max(this.y1, this.y2) >= Math.min(seg.y1, seg.y2)) {
					if (Math.max(seg.y1, seg.y2) >= Math.min(this.y1, this.y2)) {
						boolean PartA = ((this.x2 - this.x1) * (seg.y1 - this.y1) - (this.y2 - this.y1) * (seg.x1 - this.x1)) > 0;
						boolean PartB = ((this.x2 - this.x1) * (seg.y2 - this.y1) - (this.y2 - this.y1) * (seg.x2 - this.x1)) < 0;

						boolean PartC = ((seg.x2 - this.x1) * (this.y1 - seg.y1) - (this.y2 - seg.y1) * (this.x1 - seg.x1)) > 0;
						boolean PartD = ((seg.x2 - this.x1) * (this.y2 - seg.y1) - (this.y2 - seg.y1) * (this.x2 - seg.x1)) < 0;

						if ((PartA && PartB) && (PartC && PartD)) { return true; }
					}
				}
			}
		}
		return false;
	}

	/**
	 * Calculates the intersection point of two line segments, or returns null if they don't intersect.
	 *
	 * @param seg line segment to test for intersection.
	 * @return intersection point of the two lines or null if they do not intersect
	 */
	public double[] intersectionOf(LineSegment seg) {
		if (!this.intersects(seg)) { return null; }
		double x = (seg.yIntercept() - this.yIntercept()) / (this.slope() - seg.slope());
		return new double[] { x, (x * this.slope()) - y1 };
	}
}
