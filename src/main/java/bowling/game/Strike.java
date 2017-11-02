package bowling.game;

public class Strike extends Reward{

    private BowlingThrow bowlingThrowOne;
    private BowlingThrow bowlingThrowTwo;
    static char strikeRepresentation;

    public Strike(){}
    
    public Strike(BowlingThrow t){
        super(t);
        setBowlingThrowOne(new BowlingThrow());
        setBowlingThrowTwo(new BowlingThrow());
        strikeRepresentation = 'X';
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

    public char getRepresentation() {
		return strikeRepresentation;
	}
}
