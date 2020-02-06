package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MadYeti on 06.02.2020.
 */
public class Main {

    public static void main(String[] args) {

        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(view, model);
        //to change range write rand(int min, int max)
        controller.rand(5, 15);

        while(!controller.getNumberIsFind()) {
            int number = 0;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                number = Integer.parseInt(bufferedReader.readLine());
                if(!controller.isNumberInsideRange(number, controller.getLowerLimit(), controller.getHigherLimit())){
                    controller.printOutOfRangeMessage();
                }else if(controller.isNumberWasPicked(number)){
                    controller.printNumberAlreadyBeenPickedMessage();
                }else {
                    if(number > controller.getNumberToFind()){
                        controller.printPickedNumberIsUpwardMessage();
                    }else if(number < controller.getNumberToFind()){
                        controller.printPickedNumberIsUnderMessage();
                    }else {
                        controller.printCongratulationMessage();
                        controller.setNumberIsFind(true);
                    }
                    controller.setGuessNumber(number);
                    controller.addMentionedNumberToList(number);
                    controller.increaseTriesAmount();
                    controller.updateView();
                }
            } catch (Exception e) {
                controller.printIncorrectInputTypeMessage();
            }
        }
    }

}
