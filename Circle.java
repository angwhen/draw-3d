import java.awt.Graphics;

public class Circle implements DrawableObject{
	private Point center;
	private Point topEdge, rightEdge;

	
	public Circle(Point center, Point edgePoint) {
		this.center = center;
		int radius = center.distance(edgePoint);
		
	}

	public void draw(Graphics g){
		//too advanced for me to do rn, can't just use oval
	}

	@Override
	public Circle rotated(double theta, double phi) {
		// TODO Auto-generated method stub
		return null;
	}
}
