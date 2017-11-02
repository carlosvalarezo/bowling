package bowling;

import bowling.interfaces.IBowlingThrow;

public abstract class Reward implements IBowlingThrow {
    IBowlingThrow bowlingThrow;

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