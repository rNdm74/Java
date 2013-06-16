
package S6TimesTables;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Adam Charlton
 */
public class LabelManager {
    private ArrayList<GameText> score = new ArrayList<>();
    
    //private GameText[] scoreLabel; 
    private ArrayList<GameText> back; 
    private ArrayList<GameText> scoreLabel;    
    public ArrayList<GameText> timesTableLabel; 
    public ArrayList<GameText> stage6Label;  
    private ArrayList<GameText> correctLabel;
    private ArrayList<GameText> wrongLabel;
    private ArrayList<GameText> gameOverLabel;
    
    public ArrayList<ArrayList<GameText>> menuLabels = new ArrayList<>();
    public ArrayList<ArrayList<GameText>> questions = new ArrayList<>();
    public ArrayList<ArrayList<GameText>> answers = new ArrayList<>();
    
    private Dimension size;
    private FontManager fm;
    private TimesTable table;
    
    public LabelManager(FontManager fm, Dimension size, TimesTable table){
        this.fm = fm;
        this.size = size;
        this.table = table;
        //pos = new Point(size.width + 100, size.height / 2);
        createLabels();
    }  
    
    private ArrayList<GameText> label(String word){
        
        ArrayList<GameText> gameText = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++) {            
            char c = word.charAt(i);            
            if (c != '\u0020')gameText.add(fm.getLetter(c));
        }
        
        return gameText;        
    }
    
    private void createLabels() {       
        
        String[] levels = {
            //"One",
            //"Two",
            "Three",
            "Four",
            //"Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            //"Ten",
            //"Eleven",
            //"Twelve"                        
        };
        
        for (String s: levels) {
            menuLabels.add(label(s));
            for(Equation e: new ReadXML("tables.xml").getTableData(s)){               
                questions.add(label(e.getQuestion()));
                answers.add(label(e.getAnswer()));
            }            
        }
         
        back = label("BACK");
        correctLabel = label("CORRECT");
        wrongLabel = label("TRYAGAIN");
        gameOverLabel = label("WELLDONE");
        scoreLabel = label("SCORE:");
        timesTableLabel = label("TIMESTABLES");
        stage6Label = label("STAGE6");
    }
    
    //public Point pos;
    
    public void drawPickedTimesTableAnwser(Graphics2D g, int pickedTimesTable, Point pos){        
        for (int i = 0; i < answers.get(pickedTimesTable).size(); i++) {
            
                //sets bound rectangle for each letter in the string
                answers.get(pickedTimesTable).get(i).update();
            
                answers.get(pickedTimesTable).get(i).setCenter(
                        (pos.x) + (40 * i), pos.y
                );
                answers.get(pickedTimesTable).get(i).draw(g);
            }                  
    }
    
    public void drawWrongAnwser1(Graphics2D g, int pickedTimesTable, Point pos){        
        for (int i = 0; i < answers.get(pickedTimesTable).size(); i++) {
            
                //sets bound rectangle for each letter in the string
                answers.get(pickedTimesTable).get(i).update();
            
                answers.get(pickedTimesTable).get(i).setCenter(
                        (pos.x) + (40 * i), pos.y
                );
                answers.get(pickedTimesTable).get(i).draw(g);
            }                  
    }
    
    public void drawWrongAnwser2(Graphics2D g, int pickedTimesTable, Point pos){        
        for (int i = 0; i < answers.get(pickedTimesTable).size(); i++) {
            
                //sets bound rectangle for each letter in the string
                answers.get(pickedTimesTable).get(i).update();
            
                answers.get(pickedTimesTable).get(i).setCenter(
                        (pos.x) + (40 * i), pos.y
                );
                answers.get(pickedTimesTable).get(i).draw(g);
            }                  
    }
    
    public void drawPickedTimesTableQuestion(Graphics2D g, int pickedTimesTable){
        for (int i = 0; i < questions.get(pickedTimesTable).size(); i++) {
            
                //sets bound rectangle for each letter in the string
                questions.get(pickedTimesTable).get(i).update();
            
                questions.get(pickedTimesTable).get(i).setCenter(
                        ((size.width / 2) - 20) + (40 * i),
                          size.height - 50
                );
                questions.get(pickedTimesTable).get(i).draw(g);
            }
    }
    
    public void drawBack(Graphics2D g) {        
        for (int i = 0; i < back.size(); i++) {
                back.get(i).update();
                back.get(i).setCenter(new Point(
                        ((size.width / 2) - 120) + (40 * i),
                        size.height - 50
                ));
            
                back.get(i).draw(g);
            }                  
    }
    
    public void updateCorrectLabel(Graphics2D g) {        
        for (int i = 0; i < correctLabel.size(); i++) {
                correctLabel.get(i).update();
                correctLabel.get(i).setCenter(new Point(
                        ((size.width / 2) - 120) + (40 * i),
                        size.height - 50
                ));
            
                correctLabel.get(i).draw(g);
            }                  
    }
    
    public void drawCorrectLabel(Graphics2D g){
        //for(GameText d: correctLabel){d.draw(g);}
    }
    
    public void updateWrongLabel(Graphics2D g) {
        for (int i = 0; i < wrongLabel.size(); i++) {
                wrongLabel.get(i).update();
                wrongLabel.get(i).setCenter(new Point(
                        ((size.width / 2) - 130) + (40 * i),
                        size.height - 50
                ));

                wrongLabel.get(i).draw(g);
            }           
    }
    
    public void drawWrongLabel(Graphics2D g){
        //for(GameText d: wrongLabel){d.draw(g);}
    }
    
    public void updateScoreLabel(Graphics2D g) {
        for (int i = 0; i < scoreLabel.size(); i++) {
            scoreLabel.get(i).update();
            scoreLabel.get(i).setCenter(new Point(
                    50 + (30 * i),
                    50
            ));
            
            scoreLabel.get(i).draw(g);
        }
        
        for (int i = 0; i < score.size(); i++) {
            score.get(i).update();
            score.get(i).setCenter(new Point(300 + (40*i), 50));
            score.get(i).draw(g);
        }        
    }
    
    public void drawScoreLabel(Graphics2D g){
        for(GameText d: scoreLabel){d.draw(g);}
    }
    
    public void updateScore(int playerScore) {
        score.clear();
        String ps = Integer.toString(playerScore);

        for (int i = 0; i < ps.length(); i++) {                
            score.add(fm.getLetter(ps.charAt(i)));
            score.get(i).setCenter(new Point(300 + (40*i), 50));
        }
    }
    
    public void drawScore(Graphics2D g){
        for(GameText d: score){d.draw(g);}
    }

    
    public ArrayList<GameText> getScore() {
        return score;
    }

    public void setScore(ArrayList<GameText> score) {
        this.score = score;
    }
}
