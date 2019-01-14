import java.awt.Color;
import java.awt.Graphics;

public class Square implements DrawableObject{
	private Point center,topCorner;
	private Line l1,l2,l3,l4;
	private Color color;

	public Square(Point center, Point topCorner,Color color) {
		this.center = center;
		this.topCorner = topCorner;
		this.color = color;
		
		int radius = center.distance(topCorner);
		int sideLen = 2*(int)Math.sqrt(radius*radius/2);
		this.l1 = new Line(topCorner,topCorner.shifted(sideLen,0,0),5,color);
		this.l2 = new Line(topCorner.shifted(sideLen,0,0),topCorner.shifted(sideLen,sideLen,0),5,color);
		this.l3 = new Line(topCorner.shifted(sideLen,sideLen,0),topCorner.shifted(0,sideLen,0),5,color);
		this.l4 = new Line(topCorner.shifted(0,sideLen,0),topCorner,5,color);
	}
	
	public Square(Point center, Point topCorner) {
		this(center,topCorner,Color.BLACK);
	}
	
	public Square(Line l1, Line l2, Line l3, Line l4) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
	}

	@Override
	public Square rotated(double theta, double phi) {
		return new Square(l1.rotated(theta, phi),l2.rotated(theta, phi),l3.rotated(theta, phi),l4.rotated(theta, phi));
	}
	
	@Override
	public void draw(Graphics g){
		g.setColor(color);
		l1.draw(g);
		l2.draw(g);
		l3.draw(g);
		l4.draw(g);
	}
}