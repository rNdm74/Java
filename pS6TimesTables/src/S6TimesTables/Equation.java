
package S6TimesTables;

/**
 *
 * @author Adam Charlton
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
}
