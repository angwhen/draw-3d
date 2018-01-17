import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class Drawing extends JFrame implements MouseListener{
	private ArrayList<Line> myDrawing = new ArrayList<Line>();
	private ArrayList<Line> guidelines = new ArrayList<Line>();
	private double theta = 0;
	private double phi = 0;
	
	public Drawing(){
		super();
		addMouseListener(this);
		guidelines.add(new Line(new Point(-800,0,0),new Point(800,0,0)));
		guidelines.add(new Line(new Point(0,-800,0),new Point(0,800,0)));
		guidelines.add(new Line(new Point(0,0,-800),new Point(0,0,800)));
		
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
		g.setColor(Color.RED);
		for (Line line: guidelines) {
			Point a = rotate(line.getA(),theta,phi);
			Point b = rotate(line.getB(),theta,phi);
			g.drawLine(a.x(),a.y(),b.x(),b.y());
		}	
	}
	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1600, 1600);
		paintGuidelines(g);
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