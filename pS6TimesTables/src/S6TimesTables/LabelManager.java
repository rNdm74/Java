
package S6TimesTables;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Adam Charlton
 */
public class LabelManager {
    private ArrayList<GameText> score = new ArrayList<>();
    
    public ArrayList<GameText> choose; 
    private ArrayList<GameText> gameOver; 
    private ArrayList<GameText> scoreLabel;    
    public ArrayList<GameText> timesTableLabel; 
    public ArrayList<GameText> stage6Label;  
    private ArrayList<GameText> correctLabel;
    private ArrayList<GameText> wrongLabel;
    public ArrayList<GameText> menu;
    public ArrayList<GameText> play;
    public ArrayList<GameText> poop;
    
    
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
            menuLabels.add(label(s.toUpperCase()));
            for(Equation e: new ReadXML("tables.xml").getTableData(s)){               
                questions.add(label(e.getQuestion()));
                answers.add(label(e.getAnswer()));
            }            
        }
         
        poop = label(",");
        choose = label("CHOOSE:");
        play = label("PLAY");
        gameOver = label("GAMEOVER");
        correctLabel = label("CORRECT");
        wrongLabel = label("TRYAGAIN");
        menu = label("MENU");
        scoreLabel = label("SCORE:");
        timesTableLabel = label("TIMESTABLES");
        stage6Label = label("STAGE6:");
    }
    public int move = 0;
    public void drawPoop(Graphics2D g, Point p) { 
        
        //poopPos = center.getLocation();
        
        for (int i = 0; i < poop.size(); i++) {
                poop.get(i).update();
                poop.get(i).setCenter(p.x - 30, (p.y + 17) + move);            
                poop.get(i).draw(g);
            }                  
    }
    
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
    
    public void drawChoose(Graphics2D g) {        
        for (int i = 0; i < choose.size(); i++) {
                choose.get(i).update();
                choose.get(i).setCenter(new Point(
                        ((size.width / 2) - 50) + (35 * i),
                        size.height / 2 + 50
                ));
            
                choose.get(i).draw(g);
            }                  
    }
    
    public void drawPlay(Graphics2D g) {        
        for (int i = 0; i < play.size(); i++) {
                play.get(i).update();
                play.get(i).setCenter(new Point(
                        ((size.width / 2) - 50) + (35 * i),
                        size.height / 2 + 50
                ));
            
                play.get(i).draw(g);
            }                  
    }
    
    public void drawGameOver(Graphics2D g) {        
        for (int i = 0; i < gameOver.size(); i++) {
                gameOver.get(i).update();
                gameOver.get(i).setCenter(new Point(
                        ((size.width / 2) - 120) + (35 * i),
                        (size.height / 2)
                ));
            
                gameOver.get(i).draw(g);
            }                  
    }
    
    public void drawTimesTableLabel(Graphics2D g) {        
        for (int i = 0; i < timesTableLabel.size(); i++) {
                timesTableLabel.get(i).update();
                timesTableLabel.get(i).setCenter(new Point(
                        ((size.width / 2) - 10) + (36 * i),
                        50
                ));
            
                timesTableLabel.get(i).draw(g);
            }                  
    }
    
    public void drawStage6Label(Graphics2D g) {        
        for (int i = 0; i < stage6Label.size(); i++) {
                stage6Label.get(i).update();
                stage6Label.get(i).setCenter(new Point(
                        50 + (45 * i),
                        50
                ));
            
                stage6Label.get(i).draw(g);
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
        
    public void drawScoreLabel(Graphics2D g) {
        for (int i = 0; i < scoreLabel.size(); i++) {
            scoreLabel.get(i).update();
            scoreLabel.get(i).setCenter(new Point(
                    50 + (30 * i),
                    50
            ));
            
            scoreLabel.get(i).draw(g);
        }    
    }
    
    public void drawMenu(Graphics2D g) {
        for (int i = 0; i < menu.size(); i++) {
            menu.get(i).update();
            menu.get(i).setCenter(new Point(
                    size.width-150 + (35 * i),
                    50
            ));
            
            menu.get(i).draw(g);
        }    
    }
        
    public void updateScore(Graphics2D g, int playerScore) {
        for (int i = 0; i < score.size(); i++) {
            score.get(i).update();
            score.get(i).setCenter(new Point(300 + (40*i), 50));
            score.get(i).draw(g);
        }
        
        score.clear();
        String ps = Integer.toString(playerScore);

        for (int i = 0; i < ps.length(); i++) {                
            score.add(fm.getLetter(ps.charAt(i)));
            score.get(i).setCenter(new Point(300 + (40*i), 50));
        }
    }
    
    public ArrayList<GameText> getScore() {
        return score;
    }

    public void setScore(ArrayList<GameText> score) {
        this.score = score;
    }
}
