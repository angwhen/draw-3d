
public class Point {
	private double x, y, z;
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	
	/**
	 * @return x coordinate to draw
	 */
	public int x() {
		return (int) x+800;
	}
	public int y() {
		return (int) y + 800;
	}
	
}
