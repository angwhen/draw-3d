import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class Drawing extends Canvas implements MouseListener{
	private static final long serialVersionUID = 1L;
	private static int frameWidth = 1000;
	private int axisWidth= frameWidth/2;
	private ArrayList<DrawableObject> myDrawing = new ArrayList<DrawableObject>();
	private ArrayList<Line> guidelines = new ArrayList<Line>();
	private double theta = 0;
	private double phi = 0;
	
	public class MyKeyListener implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

		    if (key == KeyEvent.VK_LEFT) {
		    	theta += 0.1;
		    } else if (key == KeyEvent.VK_RIGHT){
		    	theta -= 0.1;
		    }else if (key == KeyEvent.VK_UP){
		    	phi += 0.1;
		    }else if (key == KeyEvent.VK_DOWN){
		    	phi -= 0.1;
		    }
		    validate();
		    repaint();
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}

	
	public Drawing(){
		super();
		addMouseListener(this);
		initGuidelines();
		
		this.requestFocus();
		KeyListener listener = new MyKeyListener();
		this.addKeyListener(listener);
	}
	
	private void initGuidelines() {
		int half = frameWidth/2;
		int end = half*2/3;

		guidelines.add(new Line(new Point(axisWidth, -end,0,0),new Point(axisWidth,end,0,0),5,Color.RED));//X
		guidelines.add(new Line(new Point(axisWidth,0,-end,0),new Point(axisWidth,0,end,0),5,Color.BLUE)); //Y
		guidelines.add(new Line(new Point(axisWidth,0,0,-end),new Point(axisWidth,0,0,end),5,Color.RED)); //Z
	}
	

	public void paintGuidelines(Graphics g) {
		
		for (Line line: guidelines) {
			Line toDraw = (Line) line.rotated(theta,phi);
			toDraw.draw(g);
		}	
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, frameWidth, frameWidth);
		
		paintGuidelines(g);
		
		g.setColor(Color.BLACK);
		for (DrawableObject o: myDrawing) {
			Line toDraw = (Line)o.rotated(theta,phi);
			toDraw.draw(g);
		}		
	}


	public static void main(String[] arg){
		 JFrame frame = new JFrame("My Drawing"); 
		 Canvas canvas = new Drawing(); 
		 canvas.setSize(frameWidth, frameWidth); 
		 frame.add(canvas); frame.pack(); 
		 frame.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
        int y = e.getY();
        
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