
package xml;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author rNdm
 */
public class Equation {
    private ArrayList<Desyrel> equationLetters = new ArrayList<>();
    private ArrayList<Desyrel> answerLetters = new ArrayList<>();
    
    private Point equationLocation = new Point();
    private Dimension equationSize = new Dimension();
    
    private Point answerLocation = new Point();
    private Dimension answerSize = new Dimension();
    
    private String equation;
    private String answer;    
    
    public Equation(Object[] values){
        this.equation = (String) values[0];
        this.answer = (String) values[1];
    }

    public String getEquation() {
        return equation;
    }

    public String getAnswer() {
        return answer;
    }
    
    public void updateAnswer(FontManager fm){  
        answerLetters.clear();
        for (int i = 0; i < answer.length(); i++) {                
            answerLetters.add(fm.getLetter(Character.toString(answer.charAt(i))));
            //item.get(i).setCentre(new Point(getLocation().x + (40*i), getLocation().y));
        }
    }
    
    public void drawAnswer(Graphics2D g){
        for (int i = 0; i < answerLetters.size(); i++) {
            if(answerLetters.get(i) != null){
                answerLetters.get(i).update();
                answerLetters.get(i).setCentre(new Point(getAnswerLocation().x + (40*i), getAnswerLocation().y));
                answerLetters.get(i).draw(g);
            }            
        }
    }
    
    public void updateEquation(FontManager fm){  
        equationLetters.clear();
        for (int i = 0; i < equation.length(); i++) {                
            equationLetters.add(fm.getLetter(Character.toString(equation.charAt(i))));
            //item.get(i).setCentre(new Point(getLocation().x + (40*i), getLocation().y));
        }
    }
    
    public void drawEquation(Graphics2D g){
        for (int i = 0; i < equationLetters.size(); i++) {
            if(equationLetters.get(i) != null){
                equationLetters.get(i).update();
                equationLetters.get(i).setCentre(new Point(getEquationLocation().x + (40*i), getEquationLocation().y));
                equationLetters.get(i).draw(g);
            }            
        }
    }
    
    public Dimension getEquationSize() {
        for (int i = 0; i < equationLetters.size(); i++) {
            if(equationLetters.get(i) != null){
                equationSize.width+= equationLetters.get(i).getBounds().width;
            }
        }
        equationSize.height = equationLetters.get(0).getBounds().height;
        System.out.println(equationSize.width);
        return equationSize;
    }
    
    public Point getAnswerLocation() {
        return answerLocation;
    }

    public void setAnswerLocation(Point location) {
        this.answerLocation = location;
    }

    public Point getEquationLocation() {
        return equationLocation;
    }

    public void setEquationLocation(Point location) {
        this.equationLocation = location;
    }
}
