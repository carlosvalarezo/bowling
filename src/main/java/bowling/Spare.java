package bowling;

import bowling.interfaces.IBowlingThrow;

public class Spare extends Reward{

    private BowlingThrow bowlingThrowOne;

    public Spare(IBowlingThrow iBowlingThrow){
        super(iBowlingThrow);
        setBowlingThrowOne(new BowlingThrow());

    }

    @Override
    public int getNumberOfPins(){
        return super.getNumberOfPins() + getBowlingThrowOne().getNumberOfPins();
    }

    public BowlingThrow getBowlingThrowOne() {
        return bowlingThrowOne;
    }

    public void setBowlingThrowOne(BowlingThrow bowlingThrowOne) {
        this.bowlingThrowOne = bowlingThrowOne;
    }


}