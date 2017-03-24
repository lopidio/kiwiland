package br.com.guigui.kiwiland.main;

import java.util.List;

import br.com.guigui.kiwiland.algorithm.DistanceCounterAlgorithm;
import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.algorithm.result.AlgorithmResult;
import br.com.guigui.kiwiland.algorithm.result.ShowDistanceResult;
import br.com.guigui.kiwiland.builder.RailRoadBuilder;
import br.com.guigui.kiwiland.builder.StringRailRoadBuilder;
import br.com.guigui.kiwiland.exception.DistanceCounterException;
import br.com.guigui.kiwiland.exception.InvalidInputException;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Route;
import br.com.guigui.kiwiland.runner.AlgorithmRunner;

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
        	railRoad.showAllTracks();
        	System.out.println(new ShowDistanceResult().getResult(new DistanceCounterAlgorithm(new String[]{"A", "B", "C"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().getResult(new DistanceCounterAlgorithm(new String[]{"A", "D"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().getResult(new DistanceCounterAlgorithm(new String[]{"A", "D", "C"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().getResult(new DistanceCounterAlgorithm(new String[]{"A", "E", "B", "C", "D"}).doTheMath(railRoad)));
        	System.out.println(new ShowDistanceResult().getResult(new DistanceCounterAlgorithm(new String[]{"A", "E", "D"}).doTheMath(railRoad)));
		}
		catch (InvalidInputException e)
		{
			e.printStackTrace();
		}
    }
}
