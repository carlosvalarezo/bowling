package bowling.game;

import java.util.ArrayList;
import java.util.List;

import data.DataOutputConsole;
import data.interfaces.IDataOutput;


/**
 * Game class, holds the creation of the BowlingScoringBoard
 * */
public class Game{
    Player player;
    private List<Integer> listOfResults;
	private int totalScore;
    List<BowlingFrame> bowlingFrameList = new ArrayList<>();
    IDataOutput dataOutputConsole = new DataOutputConsole();

    private int numberOfFrames = 1;
    private int positionInFile = 0;
    
    public Game(String name, List<Integer> listOfResults){
        this.player = new Player(name);
        this.setListOfResults(listOfResults);
    }

    public Strike createStrike(BowlingThrow bowlingThrow ){
        Strike strike = new Strike(bowlingThrow);
        strike.setBowlingThrowOne(new BowlingThrow(this.getListOfResults().get(this.getPositionInFile() + 1)));
        strike.setBowlingThrowTwo(new BowlingThrow(this.getListOfResults().get(this.getPositionInFile() + 2)));
        return strike;
    }

    public void moveCursor(int positions){
        this.setPositionInFile(this.getPositionInFile() + positions);
    }

    public int getPinesFromScoreBoard(int position){ return this.getPositionInFile() + position; }

    public void addFrameToList(BowlingFrame bowlingFrame){
        this.getBowlingFrameList().add(bowlingFrame);
    }

    public BowlingThrow getThrow(BowlingFrame bowlingFrame, int number){ return bowlingFrame.getBowlingThrowList().get(number-1);   }

    public void createFrameWithStrike(BowlingFrame bowlingFrame){
        if (getThrow(bowlingFrame,1).getNumberOfPins()== 10) {
            Strike strike = createStrike(getThrow(bowlingFrame,1));
            getThrow(bowlingFrame,1).setReward(strike);
            bowlingFrame.setScoreOfFrame(getThrow(bowlingFrame,1).getNumberOfPins() + strike.getBowlingThrowOne().getNumberOfPins() + strike.getBowlingThrowTwo().getNumberOfPins());
            setTotalScore(bowlingFrame.getScoreOfFrame()+getTotalScore());
            bowlingFrame.setScoreTotalOfFrame(getTotalScore());
            moveCursor( 1);
        } else {
            bowlingFrame.getBowlingThrowList().add(new BowlingThrow(this.getListOfResults().get(getPinesFromScoreBoard(1))));
            moveCursor(2);
        }
    }

    public void createFrameWithSpare(BowlingFrame bowlingFrame){
        if (bowlingFrame.getBowlingThrowList().size() > 1) {
            if (getThrow(bowlingFrame,1).getNumberOfPins() +  getThrow(bowlingFrame,2).getNumberOfPins()== 10) {
                Spare spare = new Spare(getThrow(bowlingFrame,1));
                spare.setBowlingThrowOne(new BowlingThrow(this.getListOfResults().get(getPinesFromScoreBoard(0))));
                getThrow(bowlingFrame,2).setReward(spare);
                bowlingFrame.setScoreOfFrame(getThrow(bowlingFrame,1).getNumberOfPins() + getThrow(bowlingFrame,2).getNumberOfPins() + spare.getBowlingThrowOne().getNumberOfPins());
                setTotalScore(bowlingFrame.getScoreOfFrame()+getTotalScore());
                bowlingFrame.setScoreTotalOfFrame(getTotalScore());
            } else {
                bowlingFrame.setScoreOfFrame(getThrow(bowlingFrame,1).getNumberOfPins() + getThrow(bowlingFrame,2).getNumberOfPins());
                setTotalScore(bowlingFrame.getScoreOfFrame()+getTotalScore());
                bowlingFrame.setScoreTotalOfFrame(getTotalScore());
            }
        }
    }

    public void createFrames(BowlingFrame bowlingFrame){
        createFrameWithStrike(bowlingFrame);
        createFrameWithSpare(bowlingFrame);
    }

    /**
     * This method is called to organise the punctuation in frames, throws and spares.
     * */
    public void play(){
        while(this.getNumberOfFrames() <= 10) {
             BowlingFrame bowlingFrame = new BowlingFrame(this.getNumberOfFrames());
             bowlingFrame.getBowlingThrowList().add(new BowlingThrow(this.getListOfResults().get(getPinesFromScoreBoard(0))));
             createFrames(bowlingFrame);
             this.setNumberOfFrames(this.getNumberOfFrames() + 1);
             addFrameToList(bowlingFrame);
        }
        displayGameResults();
    }

    public void displayGameResults(){    	
    	dataOutputConsole.print(bowlingFrameList,player);
    }
	
	public List<BowlingFrame> getBowlingFrameList() {
		return bowlingFrameList;
	}

	public List<Integer> getListOfResults() {
		return listOfResults;
	}

	public void setListOfResults(List<Integer> listOfResults) {
		this.listOfResults = listOfResults;
	}

	public int getNumberOfFrames() {
		return numberOfFrames;
	}

	public void setNumberOfFrames(int numberOfFrames) {
		this.numberOfFrames = numberOfFrames;
	}

    public int getPositionInFile() {
        return positionInFile;
    }

    public void setPositionInFile(int positionInFile) {
        this.positionInFile = positionInFile;
    }

    public int getTotalScore() { return totalScore; }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
