package bowling.game;

import bowling.interfaces.IBowlingThrow;

/**
 * This class implements the interface IBowlingThrow and therefore the decorator pattern. This pattern includes
 * IBowlingThrow (interface), Reward (abstract), Spare (concrete), Strike (concrete)
 * */
public abstract class Reward implements IBowlingThrow {
    IBowlingThrow bowlingThrow;
    
    public Reward(){}

    private int numberOfPins;

    public Reward(IBowlingThrow bowlingThrow){
        this.bowlingThrow = bowlingThrow;
    }

    public int getNumberOfPins(){
        return bowlingThrow.getNumberOfPins();
    }

    public void setNumberOfPins(int numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

}