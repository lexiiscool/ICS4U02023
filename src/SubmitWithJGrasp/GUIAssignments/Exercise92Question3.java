import java.awt.*;
import javax.swing.*;

public class Exercise92Question3 extends Frame {
   public Exercise92Question3() {
      JFrame f = new JFrame("Nested Squares");
      f.setSize(400, 250);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new Drawing());
      f.setVisible(true);
   }
   
   public static void main(String[] args){
      new Exercise92Question3();
   }
   
   class Drawing extends JComponent{
      public void paint(Graphics g){
         g.drawRect(190, 90, 20, 20);
         
         int[] x1 = {180, 200, 220, 200};
         int[] y1 = {100, 80, 100, 120};
         g.drawPolygon(x1, y1, 4);
         
         g.drawRect(180, 80, 40, 40);
         
         int[] x2 = {160, 200, 240, 200};
         int[] y2 = {100, 60, 100, 140};
         g.drawPolygon(x2, y2, 4);
         
         g.drawRect(160, 60, 80, 80);
         
         int[]x3 = {120, 200, 280, 200};
         int[] y3 = {100, 20, 100, 180};
         
         g.drawPolygon(x3, y3, 4);
      }
   }
}