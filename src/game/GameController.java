package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public void rand(){
        model.setLowerLimit(0);
        model.setHigherLimit(100);
        model.setNumberToFind((int)(Math.random() * model.getHigherLimit()));
    }

    public void rand(int min, int max){
        model.setLowerLimit(min);
        model.setHigherLimit(max);
        model.setNumberToFind(min + (int)(Math.random() * ((max - min) + 1)));
    }

    public void updateView(){
        view.printGameDetails(model.getGuessNumber(), model.getMentionedNumbers(), model.getLowerLimit(), model.getHigherLimit(), model.getTriesAmount());
    }

    public boolean isNumberInsideRange(int number, int lowerRange, int higherRange){
        if(number <= higherRange && number >= lowerRange){
            return true;
        }else{
            return false;
        }
    }

    public boolean isNumberWasPicked(int number){
        if(model.getMentionedNumbers().contains(number)){
            return true;
        }else{
            return false;
        }
    }

    public void playGame(){
        //to change range write rand(int min, int max)
        //written rand() automatically set up range from 0 to 100
        rand(5, 15);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(!model.isNumberFinded()) {
            int number = 0;
            try {
                number = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                view.printIncorrectInputType();
            }
            if(!isNumberInsideRange(number, model.getLowerLimit(), model.getHigherLimit())){
                view.printNumberOutOfRange();
            }else if(isNumberWasPicked(number)){
                view.printNumberAlreadyBeenPicked();
            }else {
                if(number > model.getNumberToFind()){
                    view.printPickedNumberIsUpward();
                }else if(number < model.getNumberToFind()){
                    view.printPickedNumberIsUnder();
                }else {
                    view.printCongratulation();
                    model.checkNumberIsFinded(number);
                }
                model.setGuessNumber(number);
                model.addMentionedNumberToList(number);
                model.increaseTriesAmount();
                updateView();
            }
        }
    }
}
