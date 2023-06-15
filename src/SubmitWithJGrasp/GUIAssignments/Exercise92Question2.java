import java.awt.*;
import javax.swing.*;

public class Exercise92Question2 extends Frame {
   public Exercise92Question2(){
      JFrame f = new JFrame("Rectangle");
      f.setSize(400, 200);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new Drawing());
      f.setVisible(true);
   }
   public static void main(String[] args){
      new Exercise92Question2();
   }
   
   class Drawing extends JComponent{
      public void paint(Graphics g){
         g.drawRect(150, 50, 100, 100);
         g.setColor(Color.green);
         g.drawLine(150, 50, 250, 50);
         g.drawLine(150, 150, 250, 150);
         g.setColor(Color.red);
         g.drawLine(150, 50, 150, 150);
         g.drawLine(250, 50, 250, 150);
      }
   }
}