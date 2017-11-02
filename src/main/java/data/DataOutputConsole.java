package data;

import java.util.List;

import bowling.game.BowlingFrame;
import bowling.game.Player;
import bowling.game.Strike;
import bowling.game.Spare;
import data.interfaces.IDataOutput;


/**
 *DataOutputConsole implements the pattern strategy.
 * It is possible to print to any source.
 * This class is to print in the console.
 * Addking a new class will allow to send data to a db or any other resource.
 * */
public class DataOutputConsole implements IDataOutput {

    private static void printFrameNumbers(BowlingFrame bowlingFrame) {
        if(bowlingFrame.getBowlingThrowList().size() != 1)
            System.out.print("\t");
        System.out.print(bowlingFrame.getNumberOfFrame() + "\t");
    }

    private static void printFrameScores(BowlingFrame bowlingFrame) {
        if(bowlingFrame.getBowlingThrowList().size() != 1) System.out.print("\t");
            System.out.print(bowlingFrame.getScoreTotalOfFrame() + "\t");
    }

    @Override
	public void print(Object o, Object s) {
		
		List<BowlingFrame> bowlingFrameList = (List<BowlingFrame>)o;
		Player player = (Player)s;

        System.out.print("Frame\t");
		bowlingFrameList.stream().forEach(DataOutputConsole::printFrameNumbers);
		System.out.println();
        System.out.print(player.getName());
        System.out.print("\nPinfalls ");
        bowlingFrameList.stream().forEach(bowlingFrame -> {
            bowlingFrame.getBowlingThrowList().stream().forEach(bowlingThrow -> {
                if (bowlingThrow.getReward() == null)
                    System.out.print(bowlingThrow.getNumberOfPins() + "\t");
                else {
                    if (bowlingThrow.getNumberOfPins() == 10)
                        System.out.print(new Strike().getRepresentation() + "\t");
                    else if (bowlingFrame.getScoreOfFrame() - 10 == bowlingThrow.getReward().getNumberOfPins())
                        System.out.print(new Spare().getRepresentation() + "\t");

                    if (bowlingFrame.getNumberOfFrame() == 10 && bowlingThrow.getNumberOfPins() == 10) {
                        Strike strike = (Strike) bowlingThrow.getReward();
                        System.out.print(strike.getBowlingThrowOne().getNumberOfPins() + "\t");
                        System.out.print(strike.getBowlingThrowTwo().getNumberOfPins() + "\t");
                    }
                }

            });
        });
        System.out.print("\nScore\t");
        bowlingFrameList.stream().forEach(DataOutputConsole::printFrameScores);
        System.out.println();
        System.out.println();
	}

}
