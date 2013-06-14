
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
    private ArrayList<Desyrel> score = new ArrayList<>();
    
    private Desyrel[] scoreLabel;    
    private Desyrel[] timesTableLabel;    
    private Desyrel[] correctLabel;
    private Desyrel[] wrongLabel;
    private Desyrel[] gameOverLabel;
    
    private Dimension size;
    private FontManager fm;
    
    
    public LabelManager(FontManager fm, Dimension size){
        this.fm = fm;
        this.size = size;
        
        createLabels();
    }  
    
    private void createLabels() {
        correctLabel = new Desyrel[]{
            fm.getLetter("C"),
            fm.getLetter("O"),
            fm.getLetter("R"),
            fm.getLetter("R"),
            fm.getLetter("E"),
            fm.getLetter("C"),
            fm.getLetter("T")
        };

        wrongLabel = new Desyrel[]{
            fm.getLetter("T"),
            fm.getLetter("R"),
            fm.getLetter("Y"),
            fm.getLetter("A"),
            fm.getLetter("G"),
            fm.getLetter("A"),
            fm.getLetter("I"),
            fm.getLetter("N")
        };

        gameOverLabel = new Desyrel[]{
            fm.getLetter("W"),
            fm.getLetter("E"),
            fm.getLetter("L"),
            fm.getLetter("L"),
            fm.getLetter("D"),
            fm.getLetter("O"),
            fm.getLetter("N"),
            fm.getLetter("E")
        };

//        gameOverLabel = new Desyrel[]{
//            fm.getLetter("P"),
//            fm.getLetter("E"),
//            fm.getLetter("R"),
//            fm.getLetter("F"),
//            fm.getLetter("E"),
//            fm.getLetter("C"),
//            fm.getLetter("T")
//        };

        scoreLabel = new Desyrel[]{
            fm.getLetter("S"),
            fm.getLetter("c"),
            fm.getLetter("o"),
            fm.getLetter("r"),
            fm.getLetter("e"),
            fm.getLetter(":")                    
        };
    }
    
    public void updateGameOverLabel(Graphics2D g) {        
        for (int i = 0; i < gameOverLabel.length; i++) {
                gameOverLabel[i].update();
            
                gameOverLabel[i].setCentre(new Point(
                        ((size.width / 2) - 120) + (40 * i),
                          size.height / 2 - 50
                ));
                gameOverLabel[i].draw(g);
            }                  
    }
    
    public void drawGameOverLabel(Graphics2D g){
        for(Desyrel d: gameOverLabel){d.draw(g);}
    }
    
    public void updateCorrectLabel(Graphics2D g) {        
        for (int i = 0; i < correctLabel.length; i++) {
                correctLabel[i].update();
                correctLabel[i].setCentre(new Point(
                        ((size.width / 2) - 120) + (40 * i),
                        size.height - 50
                ));
            
                correctLabel[i].draw(g);
            }                  
    }
    
    public void drawCorrectLabel(Graphics2D g){
        for(Desyrel d: correctLabel){d.draw(g);}
    }
    
    public void updateWrongLabel(Graphics2D g) {
        for (int i = 0; i < wrongLabel.length; i++) {
                wrongLabel[i].update();
                wrongLabel[i].setCentre(new Point(
                        ((size.width / 2) - 130) + (40 * i),
                        size.height - 50
                ));

                wrongLabel[i].draw(g);
            }           
    }
    
    public void drawWrongLabel(Graphics2D g){
        for(Desyrel d: wrongLabel){d.draw(g);}
    }
    
    public void updateScoreLabel(Graphics2D g) {
        for (int i = 0; i < scoreLabel.length; i++) {
            scoreLabel[i].update();
            scoreLabel[i].setCentre(new Point(
                    50 + (30 * i),
                    50
            ));
            
            scoreLabel[i].draw(g);
        }
        
        for (int i = 0; i < score.size(); i++) {
            score.get(i).update();
            score.get(i).setCentre(new Point(300 + (40*i), 50));
            score.get(i).draw(g);
        }        
    }
    
    public void drawScoreLabel(Graphics2D g){
        for(Desyrel d: scoreLabel){d.draw(g);}
    }
    
    public void updateScore(int playerScore) {
        score.clear();
        String ps = Integer.toString(playerScore);

        for (int i = 0; i < ps.length(); i++) {                
            score.add(fm.getLetter(Character.toString(ps.charAt(i))));
            score.get(i).setCentre(new Point(300 + (40*i), 50));
        }
    }
    
    public void drawScore(Graphics2D g){
        for(Desyrel d: score){d.draw(g);}
    }

    /**
     * @return the score
     */
    public ArrayList<Desyrel> getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(ArrayList<Desyrel> score) {
        this.score = score;
    }
}
