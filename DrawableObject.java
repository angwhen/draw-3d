import java.awt.Graphics;

public interface DrawableObject {
	public void draw(Graphics g);
	public DrawableObject rotated(double theta,double phi);
}
