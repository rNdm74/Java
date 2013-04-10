package pembeddedminor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

public class DrawString {
	public DrawString(Graphics2D g2d, Font font, Color color, String string, Point p){
		g2d.setFont(font);
		g2d.setColor(color);
		g2d.drawString(string, p.x, p.y);
	}
}
