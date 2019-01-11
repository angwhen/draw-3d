import java.awt.Graphics;

public class Circle implements DrawableObject{
	private Point center;
	private int radius;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Point getCenter() {
		return center;
	}
	public int getRadius() {
		return radius;
	}
	
	public void draw(Graphics g){
		 g.fillOval((int)center.getX(),(int)center.getY(),radius,radius);
	}

	@Override
	public Circle rotated(double theta, double phi) {
		// TODO Auto-generated method stub
		return null;
	}
}
