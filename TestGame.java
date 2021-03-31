import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class GameTest {

    public static void main(String[] args) {
        Frame frame = new JFrame("Yahtzee");
        String players = JOptionPane.showInputDialog("How many players? (2-4)"); //JOptionPane to get player count

        if(players == null)
        {
	        System.exit(0);
        }

        if (players.equals("2")){ //if 2 player mode is selected
            frame.setSize(500, 500); //the size here would be reflective to the amount of players
            frame.setVisible(true);
            JButton b=new JButton("Click Here"); //button that doesn't do anything just was testing it
            b.setBounds(50,50,50,50);
            frame.add(b);

            Player Player1 = new Player(), Player2 = new Player(); //create 2 player objects

            Dice[] dice = new Dice[5]; //dice array of dice object

            for (int i = 0; i < dice.length; ++i){ //rolls each dice
                dice[i] = new Dice();
                dice[i].roll();
            }



        }

    }

    private static boolean getYahtzee(Dice[] dice){ //checks if a 'yahtzee' move is possible
        if (dice[0].value == dice[1].value && dice[0].value == dice[2].value && dice[0].value == dice[3].value
                && dice[0].value == dice[4].value && dice[0].value == dice[5].value){
            return true;
        }
        return false;
    }

    private static boolean getOnes(Dice[] dice){ //checks if a 'ones' move is possible
        for (int i = 0; i < dice.length; ++i){
            if (dice[i].value == 1){
                return true;
            }
        }
        return false;
    }
}

class Player{ //Player class to hold the scores for each player
    int ones, twos, threes, fours, fives, sixes, fullHouse, smallStraight, largeStraight,
            yahtzee, chance, fourKind, bonus;
    int totalScore;

    void getScore(){
        totalScore = ones + twos + threes+ fours+ fives+ sixes+ fullHouse + smallStraight + largeStraight + 
                yahtzee + chance + fourKind + bonus;
    }

    void getBonus(){
        if (ones + twos + threes + fours + fives + sixes >= 63){
            bonus = 35;
        } else {
            bonus = 0;
        }
    }
}

class Dice{ //Dice class for dice values and functions
    int value; //value rolled
    boolean hold; //for determining if player wants to hold the specific die or reroll it
    Random rand = new Random();

    Dice(){ //default constructor
        value = 0;
        hold = false;
    }
    void roll() //roll dice
    {
        if (hold == false) {
            value = rand.nextInt(6) + 1;
        }
    }
}


