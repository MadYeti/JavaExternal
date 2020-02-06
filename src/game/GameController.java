package game;

/**
 * Created by MadYeti on 06.02.2020.
 */
public class GameController {

    private GameView view;
    private GameModel model;

    public GameController(GameView view, GameModel model){
        this.view = view;
        this.model = model;
    }

    public int rand(){
        model.setLowerLimit(0);
        model.setHigherLimit(100);
        model.setNumberToFind((int)(Math.random() * model.getHigherLimit()));
        return model.getNumberToFind();
    }

    public int rand(int min, int max){
        model.setLowerLimit(min);
        model.setHigherLimit(max);
        model.setNumberToFind(min + (int)(Math.random() * ((max - min) + 1)));
        return model.getNumberToFind();
    }

    public boolean getNumberIsFind(){
        return model.getNumberIsFind();
    }

    public void setNumberIsFind(boolean numberIsFind){
        model.setNumberIsFind(numberIsFind);
    }

    public void updateView(){
        view.printGameDetails(model.getGuessNumber(), model.getMentionedNumbers(), model.getLowerLimit(), model.getHigherLimit(), model.getTriesAmount());
    }

    public void printOutOfRangeMessage(){
        view.printNumberOutOfRange();
    }

    public void printNumberAlreadyBeenPickedMessage(){
        view.printNumberAlreadyBeenPicked();
    }

    public void printCongratulationMessage(){
        view.printCongratulation();
    }

    public void printIncorrectInputTypeMessage(){
        view.printIncorrectInputType();
    }

    public void printPickedNumberIsUpwardMessage(){
        view.printPickedNumberIsUpward();
    }

    public void printPickedNumberIsUnderMessage(){
        view.printPickedNumberIsUnder();
    }

    public int getNumberToFind() {
        return model.getNumberToFind();
    }

    public void addMentionedNumberToList(int mentionedNumber){
        model.addMentionedNumberToList(mentionedNumber);
    }

    public void increaseTriesAmount(){
        model.increaseTriesAmount();
    }

    public void setGuessNumber(int guessNumber){
        model.setGuessNumber(guessNumber);
    }

    public boolean isNumberInsideRange(int number, int lowerRange, int higherRange){
        if(number <= higherRange && number >= lowerRange){
            return true;
        }else{
            return false;
        }
    }

    public int getLowerLimit(){
        return model.getLowerLimit();
    }

    public int getHigherLimit(){
        return model.getHigherLimit();
    }

    public boolean isNumberWasPicked(int number){
        if(model.getMentionedNumbers().contains(number)){
            return true;
        }else{
            return false;
        }
    }
}
