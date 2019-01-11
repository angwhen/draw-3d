import java.awt.Graphics;

public class Point implements DrawableObject{
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
	
	private double[][] rotationMatrix(double angle){
		double[][] r = {{Math.cos(angle),-Math.sin(angle)},{Math.sin(angle),Math.cos(angle)}};
		return r;
	}
	public Point rotated(double theta, double phi) {
		double[][] r;
		
		r = rotationMatrix(theta);
		Point t =  new Point(r[0][0]*x+r[0][1]*z, y, r[1][0]*x+r[1][1]*z);
		
		r = rotationMatrix(phi);
		return new Point(t.getX(), r[0][0]*t.getY()+r[0][1]*t.getZ(), r[1][0]*t.getY()+r[1][1]*t.getZ());	
	}
	
	public void draw(Graphics g){
		//TODO
	}
}
