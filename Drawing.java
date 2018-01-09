import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class Drawing extends JFrame implements MouseListener{
	private ArrayList<Line> myDrawing = new ArrayList<Line>();
	private double theta = 0;
	private double phi = 0;
	private boolean showGuides = true;
	
	public Drawing(){
		super();
		addMouseListener(this);
	
		//pyramid
		/*myDrawing.add(new Line(new Point(-100,0,-100),new Point(100,0,-100)));
		myDrawing.add(new Line(new Point(-100,0,-100),new Point(-100,0,100)));
		myDrawing.add(new Line(new Point(-100,0,-100),new Point(0,100,0)));
		myDrawing.add(new Line(new Point(100,0,100),new Point(100,0,-100)));
		myDrawing.add(new Line(new Point(100,0,100),new Point(-100,0,100)));
		myDrawing.add(new Line(new Point(100,0,100),new Point(0,100,0)));
		myDrawing.add(new Line(new Point(-100,0,100),new Point(0,100,0)));
		myDrawing.add(new Line(new Point(100,0,-100),new Point(0,100,0)));*/
	}
	
	
	public double[][] rotationMatrix(double angle){
		double[][] r = {{Math.cos(angle),-Math.sin(angle)},{Math.sin(angle),Math.cos(angle)}};
		return r;
	}
	
	public Point rotate(Point a, double theta,double phi) {
		double[][] r = rotationMatrix(theta);
		
		Point t =  new Point(r[0][0]*a.getX()+r[0][1]*a.getZ(), a.getY(), r[1][0]*a.getX()+r[1][1]*a.getZ());
		
		r = rotationMatrix(phi);
		return new Point(t.getX(), r[0][0]*t.getY()+r[0][1]*t.getZ(), r[1][0]*t.getY()+r[1][1]*t.getZ());
		
	}

	// kind of confused about this .. dont think can draw like this
	public void paintGuidelines(Graphics g) {
		//draw Y lines, horizontal
		g.setColor(Color.RED);
		for (int i = 0; i < 1600; i+=40) {
			g.drawLine(0,i,1600,i);
		}
		g.drawLine(0,801,1600,801);
		g.drawLine(0,799,1600,799);
		
		//draw Z lines, vertical;
		g.setColor(Color.BLUE);
		for (int i = 0; i < 1600; i+=40) {
			g.drawLine(i,0,i,1600);
		}
		g.drawLine(801,0,801,1600);
		g.drawLine(799,0,799,1600);
		
		//draw X lines, diagonal
		g.setColor(Color.GREEN);
		for (int i = 0; i < 1600; i+=80) {
			g.drawLine(0,i,i,0);
		}
		for (int i = 0; i < 1600; i+=80) {
			g.drawLine(i,1600,1600,i);
		}
		g.drawLine(0,1601,1601,0);
		g.drawLine(0,1599,1599,0);
		
		
	}
	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1600, 1600);
		if (showGuides) {
			paintGuidelines(g);
		}
		g.setColor(Color.BLACK);
		for (Line line: myDrawing) {
			Point a = rotate(line.getA(),theta,phi);
			Point b = rotate(line.getB(),theta,phi);
			g.drawLine(a.x(),a.y(),b.x(),b.y());
		}		
	}

	public static void main(String[] arg){
		Drawing frame = new Drawing();

		frame.setSize(1600,1600);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		theta = theta + 0.1;
		phi = phi + 0.1;
		//System.out.println("theta is " + theta);
		revalidate();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}