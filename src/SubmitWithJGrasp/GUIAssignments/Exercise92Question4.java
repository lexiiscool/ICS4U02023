import java.awt.*;
import javax.swing.*;

public class Exercise92Question4 extends Frame{
   public Exercise92Question4(){
      JFrame f = new JFrame("Mother's Day Card");
      f.setSize(500, 300);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new Drawing());
      f.setVisible(true);  
   }
   
   public static void main(String[] args){
      new Exercise92Question4();
   }
   
   class Drawing extends JComponent{
      public void paint (Graphics g){
         g.setColor(Color.pink);
         g.fillRect(0, 0, 500, 300);
         Font serif = new Font ("Serif", Font.BOLD, 40);
         g.setFont(serif);
         g.setColor(Color.black);
         g.drawString("HAPPY MOTHER's DAY!", 15, 50);
         
         drawHeart(g, 80, 80, 150, 150, Color.red);
         drawHeart(g, 40, 40, 40, 100, Color.red);
         
         Color purple = new Color (128, 0, 128);
         g.setColor(purple);
         
         drawHeart(g, 50, 50, 100, 200, purple);
         drawHeart(g, 60, 60, 170, 90, purple);
         drawHeart(g, 30, 30, 40, 155, Color.yellow);
         
         g.setColor(Color.black);
         Font heading = new Font("Serif", Font.ITALIC, 25);
         g.setFont(heading);
         g.drawString("I LOVE", 400, 100);
         g.drawString("YOU!", 410, 125);
         
         Font from = new Font("Serif", Font.PLAIN, 20);
         g.setFont(from);
         g.drawString("From", 300, 250);
         g.drawLine(350, 250, 480, 250);
      }
      
      public void drawHeart(Graphics g, int width, int height, int x, int y, Color color){
         int[] tX = {x-2*width/25, x + width + 2*width/25, (x-2*width/25 + x + width + 2*width/25)/2};
         int[] tY = {y+height-2*height/3, y+height-2*height/3, y+height};
         g.setColor(color);
         g.fillOval(x-width/12, y+1, width/2 + width/6, height/2);
         g.fillOval(x+width/2-width/12, y+1, width/2 + width/6, height/2);
         g.fillPolygon(tX, tY, tX.length);
      }
   }
}