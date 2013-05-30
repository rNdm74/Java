package pprogramming3assignmentone.Classes;

import pprogramming3assignmentone.JPanels.Home;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Activity extends JPanel {
   private int maxValue = 1023;
   private static int prefWidth = 800;
   private static int prefHeight = 600;
   
   private static final int BORDER_GAP = 20;
   private static final Color GRAPH_COLOR = Color.DARK_GRAY;
   private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
   private static final Stroke GRAPH_STROKE = new BasicStroke(1f);
   private static final int GRAPH_POINT_WIDTH = 0;
   private static final int Y_HATCH_CNT = 0;

   private List<Integer> data;
   
   public Activity(Home home) {
       data = new ArrayList<>();
       
       prefWidth = home.csvData.getData().size();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (getData().size() - 1);
      double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (maxValue - 1);

      List<Point> graphPoints = new ArrayList<>();
      for (int i = 0; i < getData().size(); i++) {
         int x1 = (int) (i * xScale + BORDER_GAP);
         int y1 = (int) ((maxValue - getData().get(i)) * yScale + BORDER_GAP);
         graphPoints.add(new Point(x1, y1));
      }

      // create x and y axes 
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

      // create hatch marks for y axis. 
      for (int i = 0; i < Y_HATCH_CNT; i++) {
         int x0 = BORDER_GAP;
         int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
         int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
         int y1 = y0;
         g2.drawLine(x0, y0, x1, y1);
      }

      // and for x axis
      for (int i = 0; i < getData().size() - 1; i++) {
         int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (getData().size() - 1) + BORDER_GAP;
         int x1 = x0;
         int y0 = getHeight() - BORDER_GAP;
         int y1 = y0 - GRAPH_POINT_WIDTH;
         g2.drawLine(x0, y0, x1, y1);
      }

      Stroke oldStroke = g2.getStroke();
      g2.setColor(GRAPH_COLOR);
      g2.setStroke(GRAPH_STROKE);
      for (int i = 0; i < graphPoints.size() - 1; i++) {
         int x1 = graphPoints.get(i).x;
         int y1 = graphPoints.get(i).y;
         int x2 = graphPoints.get(i + 1).x;
         int y2 = graphPoints.get(i + 1).y;
         g2.drawLine(x1, y1, x2, y2);         
      }

      g2.setStroke(oldStroke);      
      g2.setColor(GRAPH_POINT_COLOR);
      for (int i = 0; i < graphPoints.size(); i++) {
         int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
         int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
         int ovalW = GRAPH_POINT_WIDTH;
         int ovalH = GRAPH_POINT_WIDTH;
         g2.fillOval(x, y, ovalW, ovalH);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(prefWidth, prefHeight);
   }
        
   public void setMaxValue(int maxValue) {
       this.maxValue = maxValue;
   }

   public List<Integer> getData() {
       return data;
   }
}