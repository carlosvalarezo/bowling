package bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingFrame{
    private int numberOfFrame;
    private int scoreOfFrame;
    private List<BowlingThrow> bowlingThrowList;

    public BowlingFrame(){
        setScoreOfFrame(0);
    }

    public BowlingFrame(int numberOfFrame){
        this.setNumberOfFrame(numberOfFrame);
        this.setScoreOfFrame(0);
        bowlingThrowList = new ArrayList<>();
    }

    public BowlingFrame(int numberOfFrame, List<BowlingThrow> bowlingThrowList) {
        this.setNumberOfFrame(numberOfFrame);
        this.setBowlingThrowList(bowlingThrowList);

    }

    public int getScoreOfFrame() {
        return scoreOfFrame;
    }

    public void setScoreOfFrame(int scoreOfFrame) {
        this.scoreOfFrame = scoreOfFrame;
    }

    public List<BowlingThrow> getBowlingThrowList() {
        return bowlingThrowList;
    }

    public void setBowlingThrowList(List<BowlingThrow> bowlingThrowList) {
        this.bowlingThrowList = bowlingThrowList;
    }

    public int getNumberOfFrame() {
        return numberOfFrame;
    }

    public void setNumberOfFrame(int numberOfFrame) {
        this.numberOfFrame = numberOfFrame;
    }
}