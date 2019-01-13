import java.awt.Graphics;

public class Square implements DrawableObject{
	private Point center;
	private Point topCorner;

	
	public Square(Point center, Point edgePoint) {
		this.center = center;
		int radius = center.distance(edgePoint);
		Point topCorner;
	}

	public void draw(Graphics g){
		
	}

	@Override
	public Square rotated(double theta, double phi) {
		// TODO Auto-generated method stub
		return null;
	}
}