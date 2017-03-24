package br.com.guigui.kiwiland.main;

import java.util.Arrays;

import br.com.guigui.kiwiland.algorithm.DistanceCounterAlgorithm;
import br.com.guigui.kiwiland.algorithm.ShortestPathAlgorithm;
import br.com.guigui.kiwiland.algorithm.TripsWithExactlyStops;
import br.com.guigui.kiwiland.algorithm.TripsWithMaximumDistance;
import br.com.guigui.kiwiland.algorithm.TripsWithMaximumStops;
import br.com.guigui.kiwiland.algorithmresult.DistanceSumDisplay;
import br.com.guigui.kiwiland.algorithmresult.PathsCounterDisplay;
import br.com.guigui.kiwiland.builder.RailRoadBuilder;
import br.com.guigui.kiwiland.builder.StringRailRoadBuilder;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.runner.AlgorithmRunner;

/**
 * Hello world!
 *
 */
public class Kiwiland 	
{
    public static void main( String[] args )
    {
    	RailRoadBuilder builder = new StringRailRoadBuilder("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
    	RailRoad railRoad = builder.buildRailRoad();

//    	AlgorithmRunner runner = new AlgorithmRunner();
//        	runner.addAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "B", "C"))).andDisplayAs(new DistanceSumDisplay()).
//				addOtherAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "B", "C"))).andDisplayAs(new DistanceSumDisplay()).
//				addOtherAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "B", "C"))).andDisplayAs(new DistanceSumDisplay()).
//				addOtherAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "B", "C"))).andDisplayAs(new DistanceSumDisplay()).
//				addOtherAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "B", "C"))).andDisplayAs(new DistanceSumDisplay()).runWith(railRoad);
    	
    	System.out.println(new DistanceSumDisplay().displayResult(new DistanceCounterAlgorithm(Arrays.asList("A", "B", "C")).doTheMath(railRoad)));
    	System.out.println(new DistanceSumDisplay().displayResult(new DistanceCounterAlgorithm(Arrays.asList("A", "D")).doTheMath(railRoad)));
    	System.out.println(new DistanceSumDisplay().displayResult(new DistanceCounterAlgorithm(Arrays.asList("A", "D", "C")).doTheMath(railRoad)));
    	System.out.println(new DistanceSumDisplay().displayResult(new DistanceCounterAlgorithm(Arrays.asList("A", "E", "B", "C", "D")).doTheMath(railRoad)));
    	System.out.println(new DistanceSumDisplay().displayResult(new DistanceCounterAlgorithm(Arrays.asList("A", "E", "D")).doTheMath(railRoad)));
    	System.out.println(new PathsCounterDisplay().displayResult(new TripsWithMaximumStops("C", "C", 3).doTheMath(railRoad)));
    	System.out.println(new PathsCounterDisplay().displayResult(new TripsWithExactlyStops("A", "C", 4).doTheMath(railRoad)));
    	System.out.println(new DistanceSumDisplay().displayResult(new ShortestPathAlgorithm("A", "C").doTheMath(railRoad)));
    	System.out.println(new DistanceSumDisplay().displayResult(new ShortestPathAlgorithm("B", "B").doTheMath(railRoad)));
    	System.out.println(new PathsCounterDisplay().displayResult(new TripsWithMaximumDistance("C", "C", 30).doTheMath(railRoad)));
    	
//    	Output #1: 9
//    	Output #2: 5
//    	Output #3: 13
//    	Output #4: 22
//    	Output #5: NO SUCH ROUTE
//    	Output #6: 2
//    	Output #7: 3
//    	Output #8: 9
//    	Output #9: 9
//    	Output #10: 7    	

    }
}
