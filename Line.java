import java.awt.Graphics;

public class Line implements DrawableObject{
	private Point a,b;
	private int thickness;
	
	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
		this.thickness = 0;
	}
	public Line(Point a, Point b, int thickness) {
		this.a = a;
		this.b = b;
		this.thickness = thickness;
	}
	
	public Point getA() {
		return a;
	}
	public Point getB() {
		return b;
	}
	
	
	public Line rotated(double theta, double phi) {
		return new Line(a.rotated(theta,phi),b.rotated(theta,phi),thickness);
	}
	
	public void draw(Graphics g){
		if (thickness <= 0) {
			g.drawLine(a.x(),a.y(),b.x(),b.y());
		}else {
			int[] xPts = {a.x(),a.x()+thickness,b.x()+thickness,b.x()};
			int[] yPts = {a.y(),a.y()+thickness,b.y()+thickness,b.y()};
			g.fillPolygon(xPts,yPts,4);
		}
	}
}
