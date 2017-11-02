package bowling.game;

import java.util.ArrayList;
import java.util.List;
/***
 * BowlingFrame class handles the score of each frame and the number of points reached in every BowlingThrow
 */


public class BowlingFrame{
    private int numberOfFrame;
    private int scoreOfFrame;
    private int scoreTotalOfFrame;
    /**bowlingThrowList is a list because in a frame there might be 1, 2 or 3 throws*/
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

    public int getScoreTotalOfFrame() {
        return scoreTotalOfFrame;
    }

    public void setScoreTotalOfFrame(int scoreTotalOfFrame) {
        this.scoreTotalOfFrame = scoreTotalOfFrame;
    }
}