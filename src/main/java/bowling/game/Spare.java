package bowling.game;

import bowling.interfaces.IBowlingThrow;

public class Spare extends Reward{

    private BowlingThrow bowlingThrowOne;
    static char spareRepresentation;

    public Spare(){}
    
    public Spare(IBowlingThrow iBowlingThrow){
        super(iBowlingThrow);
        setBowlingThrowOne(new BowlingThrow());
        spareRepresentation = '/';
    }
	
    @Override
    public int getNumberOfPins(){
        /*System.out.println("Number of pins super = "+ super.getNumberOfPins());
        System.out.println("Number of pins = "+ getBowlingThrowOne().getNumberOfPins());*/
        return  getBowlingThrowOne().getNumberOfPins();
    }

    public BowlingThrow getBowlingThrowOne() {
        return bowlingThrowOne;
    }

    public void setBowlingThrowOne(BowlingThrow bowlingThrowOne) {
        this.bowlingThrowOne = bowlingThrowOne;
    }

    public char getRepresentation() {
		return spareRepresentation;
	}
}