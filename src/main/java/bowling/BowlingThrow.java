package bowling;

import bowling.interfaces.IBowlingThrow;

public class BowlingThrow implements IBowlingThrow{

    private int numberOfPins;
    private Reward reward;

    public BowlingThrow(){
        this.numberOfPins = 0;
    }

    public BowlingThrow(int numberOfPins){
        this.numberOfPins = numberOfPins;
    }

    @Override
    public int getNumberOfPins() {
        return numberOfPins;
    }

    @Override
    public void setNumberOfPins(int numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }
}