package bowling;

import bowling.design.LastFrame;
import bowling.design.NoFrames;
import bowling.design.NormalFrame;
import bowling.interfaces.IGameState;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGameState{
    Player player;
    private List<Integer> listOfResults;
	int totalScore;
    List<BowlingFrame> bowlingFrameList = new ArrayList<>();
    private IGameState noFrames;
    private IGameState normalFrame;
    private IGameState lastFrame;
    
    private IGameState state;
    private int numberOfFrames = 1;
    private int positionInFile = 0;
    
    
    public Game(String name, List<Integer> listOfResults){
        this.player = new Player(name);
        this.setListOfResults(listOfResults);
        setNoFrames(new NoFrames(this));
        setNormalFrame(new NormalFrame(this));
        setLastFrame(new LastFrame(this));
        setState(getNoFrames());
    }

    public void play(){
        /*System.out.println(this.player.getName());
        this.getListOfResults().stream().map(i -> {
        });
        System.out.println();*/
        createFrame();
        createFrame();
        createFrame();
    }

    public void displayGameResults(){

    }

	@Override
	public void createFrame() {
        this.getState().createFrame();

	}

	@Override
	public int calculateScore(BowlingFrame bowlingFrame) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<BowlingFrame> getBowlingFrameList() {
		return bowlingFrameList;
	}

	public void setBowlingFrameList(List<BowlingFrame> bowlingFrameList) {
		this.bowlingFrameList = bowlingFrameList;
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

    public IGameState getState() {
        return state;
    }

    public void setState(IGameState state) {
        this.state = state;
    }

    public IGameState getNoFrames() {
        return noFrames;
    }

    public void setNoFrames(IGameState noFrames) {
        this.noFrames = noFrames;
    }

    public IGameState getNormalFrame() {
        return normalFrame;
    }

    public void setNormalFrame(IGameState normalFrame) {
        this.normalFrame = normalFrame;
    }

    public IGameState getLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(IGameState lastFrame) {
        this.lastFrame = lastFrame;
    }

    public int getPositionInFile() {
        return positionInFile;
    }

    public void setPositionInFile(int positionInFile) {
        this.positionInFile = positionInFile;
    }
}
