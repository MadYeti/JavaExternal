package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MadYeti on 06.02.2020.
 */
public class GameView {

    public GameView(){

    }

    public void printNumberOutOfRange(){
        System.out.println("Введенный номер выходит за пределы диапазона. Повторите попытку");
    }

    public void printNumberAlreadyBeenPicked(){
        System.out.println("Введенный номер уже ранее был выбран. Повторите попытку");
    }

    public void printIncorrectInputType(){
        System.out.println("Неправильно введенный номер. Повторите попытку");
    }

    public void printCongratulation(){
        System.out.println("Поздравляем вы угадали номер!");
    }

    public void printPickedNumberIsUpward(){
        System.out.println("Введенный номер больше загаданного. Повторите попытку");
    }

    public void printPickedNumberIsUnder(){
        System.out.println("Введенный номер меньше загаданного. Повторите попытку");
    }

    public void printGameDetails(int choosenNumber, List<Integer> mentionedNumbers, int lowerLimit, int higherLimit, int triesAmount){
        System.out.println("Вы выбрали число: " + choosenNumber);
        System.out.println("Номера, которые вы уже выбирали: " + Arrays.toString(mentionedNumbers.toArray()));
        System.out.println("Загаданное число находиться в диапазоне: [" + lowerLimit + ", " + higherLimit + "]");
        System.out.println("Количество попыток: " + triesAmount);
    }

}
