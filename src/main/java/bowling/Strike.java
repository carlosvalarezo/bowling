package bowling;

public class Strike extends Reward{

    private BowlingThrow bowlingThrowOne;
    private BowlingThrow bowlingThrowTwo;

    public Strike(BowlingThrow t){
        super(t);
        setBowlingThrowOne(new BowlingThrow());
        setBowlingThrowTwo(new BowlingThrow());
    }

    @Override
    public int getNumberOfPins(){
        return super.getNumberOfPins() + getBowlingThrowOne().getNumberOfPins() + getBowlingThrowTwo().getNumberOfPins();
    }

    public BowlingThrow getBowlingThrowOne() {
        return bowlingThrowOne;
    }

    public void setBowlingThrowOne(BowlingThrow bowlingThrowOne) {
        this.bowlingThrowOne = bowlingThrowOne;
    }

    public BowlingThrow getBowlingThrowTwo() {
        return bowlingThrowTwo;
    }

    public void setBowlingThrowTwo(BowlingThrow bowlingThrowTwo) {
        this.bowlingThrowTwo = bowlingThrowTwo;
    }
}
