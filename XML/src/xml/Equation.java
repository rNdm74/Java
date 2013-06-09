
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
    private ArrayList<Desyrel> questionLetters = new ArrayList<>();
    private ArrayList<Desyrel> answerLetters = new ArrayList<>();
    
    private Point questionLocation = new Point();
    private Dimension questionSize = new Dimension();
    
    private Point answerLocation = new Point();
    private Dimension answerSize = new Dimension();
    
    private String question;
    private String answer;    
    
    public Equation(Object[] values){
        this.question = (String) values[0];
        this.answer = (String) values[1];
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    
    public void updateAnswer(FontManager fm){  
        answerLetters.clear();
        for (int i = 0; i < answer.length(); i++) {                
            answerLetters.add(fm.getLetter(Character.toString(answer.charAt(i))));
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
    
    public Dimension getAnswerSize() {
        for (int i = 0; i < answerLetters.size(); i++) {
            if(answerLetters.get(i) != null){
                answerSize.width+= answerLetters.get(i).getBounds().width;
            }
        }
        answerSize.height = answerLetters.get(0).getBounds().height;
        return answerSize;
    }
    
    public void updateQuestion(FontManager fm){  
        questionLetters.clear();
        
        for (int i = 0; i < question.length(); i++) {                
            questionLetters.add(fm.getLetter(Character.toString(question.charAt(i))));
        }
    }
    
    public void drawQuestion(Graphics2D g){
        for (int i = 0; i < questionLetters.size(); i++) {
            if(questionLetters.get(i) != null){
                questionLetters.get(i).update();
                questionLetters.get(i).setCentre(new Point(getQuestionLocation().x + (40*i), getQuestionLocation().y));
                questionLetters.get(i).draw(g);
            }            
        }
    }
    
    public Dimension getQuestionSize() {
        for (int i = 0; i < questionLetters.size(); i++) {
            if(questionLetters.get(i) != null){
                questionSize.width+= questionLetters.get(i).getBounds().width;
            }
        }
        questionSize.height = questionLetters.get(0).getBounds().height;
        return questionSize;
    }
    
    public Point getAnswerLocation() {
        return answerLocation;
    }

    public void setAnswerLocation(Point location) {
        this.answerLocation = location;
    }

    public Point getQuestionLocation() {
        return questionLocation;
    }

    public void setQuestionLocation(Point location) {
        this.questionLocation = location;
    }
}
