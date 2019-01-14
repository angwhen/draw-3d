import java.awt.Color;
import java.awt.Graphics;

public class Line implements DrawableObject{
	private Point a,b;
	private int thickness;
	private Color color;
	
	public Line( Point a, Point b) {
		this.a = a;
		this.b = b;
		this.thickness = 0;
		this.color = Color.BLACK;
	}
	
	public Line(Point a, Point b, int thickness) {
		this.a = a;
		this.b = b;
		this.thickness = thickness;
		this.color = Color.BLACK;
	}
	
	public Line(Point a, Point b, Color color) {
		this.a = a;
		this.b = b;
		this.thickness = 0;
		this.color = color;
	}
	
	public Line(Point a, Point b, int thickness, Color color) {
		this.a = a;
		this.b = b;
		this.thickness = thickness;
		this.color = color;
	}
	
	
	public Line rotated(double theta, double phi) {
		return new Line(a.rotated(theta,phi),b.rotated(theta,phi),thickness,color);
	}
	
	public void draw(Graphics g){
		g.setColor(color);
	
		if (thickness <= 0) {
			g.drawLine(a.drawableX(),a.drawableY(),b.drawableX(),b.drawableY());
		}else {
			int[] xPts = {a.drawableX(),a.drawableX()+thickness,b.drawableX()+thickness,b.drawableX()};
			int[] yPts = {a.drawableY(),a.drawableY()+thickness,b.drawableY()+thickness,b.drawableY()};
			g.fillPolygon(xPts,yPts,4);
		}
	}
}
