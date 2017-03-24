package br.com.guigui.kiwiland.main;

import br.com.guigui.kiwiland.algorithm.DistanceCounterAlgorithm;
import br.com.guigui.kiwiland.algorithm.ShortestPathAlgorithm;
import br.com.guigui.kiwiland.algorithmresult.ShowDistanceResult;
import br.com.guigui.kiwiland.builder.RailRoadBuilder;
import br.com.guigui.kiwiland.builder.StringRailRoadBuilder;
import br.com.guigui.kiwiland.exception.DistanceCounterException;
import br.com.guigui.kiwiland.exception.InvalidInputException;
import br.com.guigui.kiwiland.railroad.RailRoad;

/**
 * Hello world!
 *
 */
public class Kiwiland 
{
    public static void main( String[] args ) throws DistanceCounterException
    {
        System.out.println( "Hello World!" );
        try
		{
        	RailRoadBuilder builder = new StringRailRoadBuilder("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        	RailRoad railRoad = builder.buildRailRoad();
//        	railRoad.showAllTracks();
        	System.out.println(new ShowDistanceResult().displayResult(new DistanceCounterAlgorithm(new String[]{"A", "B", "C"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().displayResult(new DistanceCounterAlgorithm(new String[]{"A", "D"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().displayResult(new DistanceCounterAlgorithm(new String[]{"A", "D", "C"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().displayResult(new DistanceCounterAlgorithm(new String[]{"A", "E", "B", "C", "D"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().displayResult(new DistanceCounterAlgorithm(new String[]{"A", "E", "D"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().displayResult(new ShortestPathAlgorithm("A", "C").doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().displayResult(new ShortestPathAlgorithm("D", "C").doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().displayResult(new ShortestPathAlgorithm("D", "B").doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().displayResult(new ShortestPathAlgorithm("B", "B").doTheMath(railRoad)));

		}
		catch (InvalidInputException e)
		{
			e.printStackTrace();
		}
    }
}
