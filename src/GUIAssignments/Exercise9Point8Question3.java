package GUIAssignments;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise9Point8Question3 implements MouseListener{
	int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
	private int counter = 0;
	Drawing draw = new Drawing();
	
	public Exercise9Point8Question3() {
		JFrame frame = new JFrame("Drawing A Rectangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		draw.addMouseListener(this);
		frame.add(draw);
		frame.setSize(800, 500);
		frame.setVisible(true);
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if (counter == 0) {
			x1 = e.getX();
			y1 = e.getY();
			counter++;
			//System.out.println("x1: " + x1 + ", y1: " + y1);
			draw.repaint();
		} else if (counter == 1) {
			x2 = e.getX();
			y2 = e.getY();
			//System.out.println("x2: " + x2 + ", y2: " + y2);
			counter++;
			draw.repaint();
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	class Drawing extends JComponent{
		public void paint (Graphics g) {
			Font f = new Font("Serif", Font.BOLD, 25);
			g.setFont(f);
			g.drawString("Click two points! Make a rectangle!", 25, 50);
			
			
			int width = -1, len = -1;
			g.drawLine(x1, y1, x1, y1);
			g.drawLine(x2, y2, x2, y2);
			if (x1 != -1 && x2 != -1 && y1 != -1 && y2 != -1) {
				len = Math.abs(x1-x2);
				width = Math.abs(y1-y2);
				//g.drawLine(x1,  y1,  x2,  y2);
				g.drawRect(Math.min(x1,  x2),  Math.min(y1, y2), len, width);
			}
		}
	}
	
	public static void main(String[] args) {
		new Exercise9Point8Question3();
	}
}
