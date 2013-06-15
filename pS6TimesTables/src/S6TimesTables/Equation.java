
package S6TimesTables;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author rNdm
 */
public class Equation {       
    private String question;
    private String answer;   
    
    public Equation(Object[] values) {
        this.question = (String) values[0];
        this.answer = (String) values[1];
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
    
//    public void updateAnswer(FontManager fm){  
//        getAnswerLetters().clear();
//        for (int i = 0; i < answer.length(); i++) {                
//            getAnswerLetters().add(fm.getLetter(Character.toString(answer.charAt(i))));
//        }
//    }
//    
//    public void drawAnswer(Graphics2D g){
//        for (int i = 0; i < getAnswerLetters().size(); i++) {
//            getAnswerLetters().get(i).update();
//            getAnswerLetters().get(i).setCenter(new Point(getAnswerLocation().x + (40 * i), getAnswerLocation().y));
//            getAnswerLetters().get(i).draw(g);            
//        }
//    }
//    
//    public Dimension getAnswerSize() {
//        for (int i = 0; i < getAnswerLetters().size(); i++) {
//            if(getAnswerLetters().get(i) != null){
//                answerSize.width+= getAnswerLetters().get(i).getBounds().width;
//            }
//        }
//        
//        answerSize.height = getAnswerLetters().get(0).getBounds().height;
//        
//        return answerSize;
//    }
//    
//    public void updateQuestion(FontManager fm){  
//        getQuestionLetters().clear();
//        
//        for (int i = 0; i < question.length(); i++) {    
//            
//            GameText d = fm.getLetter(Character.toString(question.charAt(i)));
//            
//            if (d != null) getQuestionLetters().add(d);
//        }
//    }
//    
//    public void drawQuestion(Graphics2D g){
//        for (int i = 0; i < getQuestionLetters().size(); i++) {
//            getQuestionLetters().get(i).update();
//            getQuestionLetters().get(i).setCenter(
//                    getQuestionLocation().x + (40 * i), 
//                    getQuestionLocation().y);
//            getQuestionLetters().get(i).draw(g);         
//        }
//    }
//    
//    public Dimension getQuestionSize() {
//        for (int i = 0; i < getQuestionLetters().size(); i++) {
//            if(getQuestionLetters().get(i) != null){
//                questionSize.width+= getQuestionLetters().get(i).getBounds().width;
//            }
//        }
//        questionSize.height = getQuestionLetters().get(0).getBounds().height;
//        return questionSize;
//    }
//    
//    public Point getAnswerLocation() {
//        return answerLocation;
//    }
//
//    public void setAnswerLocation(Point location) {
//        this.answerLocation = location;
//    }
//
//    public Point getQuestionLocation() {
//        return questionLocation;
//    }
//
//    public void setQuestionLocation(Point location) {
//        this.questionLocation = location;
//    }
//
//    /**
//     * @return the questionLetters
//     */
//    public ArrayList<GameText> getQuestionLetters() {
//        return questionLetters;
//    }
//
//    /**
//     * @param questionLetters the questionLetters to set
//     */
//    public void setQuestionLetters(ArrayList<GameText> questionLetters) {
//        this.questionLetters = questionLetters;
//    }
//
//    /**
//     * @return the answerLetters
//     */
//    public ArrayList<GameText> getAnswerLetters() {
//        return answerLetters;
//    }
//
//    /**
//     * @param answerLetters the answerLetters to set
//     */
//    public void setAnswerLetters(ArrayList<GameText> answerLetters) {
//        this.answerLetters = answerLetters;
//    }
}
