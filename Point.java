import java.awt.Graphics;

public class Point implements DrawableObject{
	private double x, y, z;
	private int axisWidth;
	
	public Point(int axisWidth, double x, double y, double z) {
		this.axisWidth = axisWidth;
		this.x = x ;
		this.y = y ;
		this.z = z ;
	}
	
	public int axisWidth() {
		return axisWidth;
	}
	
	/**
	 * @return x coordinate to draw
	 */
	public int drawableX() {
		return (int) x + axisWidth;
	}
	public int drawableY() {
		return (int) y + axisWidth;
	}
	
	
	public int distance(Point p2) {
		return (int) Math.sqrt((x-p2.x)*(x-p2.x) + (y-p2.y)*(y-p2.y) + (z-p2.z)*(z-p2.z));
	}
	
	private double[][] rotationMatrix(double angle){
		double[][] r = {{Math.cos(angle),-Math.sin(angle)},{Math.sin(angle),Math.cos(angle)}};
		return r;
	}
	
	public Point rotated(double theta, double phi) {
		double[][] r;
		
		r = rotationMatrix(theta);
		Point t =  new Point(axisWidth, r[0][0]*x+r[0][1]*z, y, r[1][0]*x+r[1][1]*z);
		
		r = rotationMatrix(phi);
		return new Point(axisWidth, t.x, r[0][0]*t.y+r[0][1]*t.z, r[1][0]*t.y+r[1][1]*t.z);	
	}
	
	
	public Point shifted(int x, int y, int z) {
		return new Point(axisWidth, this.x+x,this.y+y,this.z+z);
	}
	
	public void draw(Graphics g){
		//TODO
	}
}
