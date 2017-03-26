package br.com.guigui.kiwiland.main;

import java.util.Arrays;

import br.com.guigui.kiwiland.algorithm.DistanceCounterAlgorithm;
import br.com.guigui.kiwiland.algorithm.TripsFinderShortestAlgorithm;
import br.com.guigui.kiwiland.algorithm.TripsFinderWithExactlyStops;
import br.com.guigui.kiwiland.algorithm.TripsFinderWithMaximumDistance;
import br.com.guigui.kiwiland.algorithm.TripsFinderWithMaximumStops;
import br.com.guigui.kiwiland.algorithmresult.DistanceSumDisplay;
import br.com.guigui.kiwiland.algorithmresult.PathsCounterDisplay;
import br.com.guigui.kiwiland.builder.RailRoadBuilder;
import br.com.guigui.kiwiland.builder.StringRailRoadBuilder;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.runner.AlgorithmRunner;

public class Kiwiland 	
{
    private AlgorithmRunner runner;
	private RailRoad railRoad;
	private RailRoadBuilder builder;

	
    public Kiwiland()
    {
    	builder = new StringRailRoadBuilder("AB7, BC9, CD8, DC4, DE6, AD9, CE12, EB6, AE7, FA4, DF5, FC6");
    	railRoad = builder.buildRailRoad();
    	
    	runner = new AlgorithmRunner();
    }
    
	private void execute()
	{
		runner.
		addAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "B", "C"))).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "D"))).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new TripsFinderWithMaximumStops("A", "F", 3)).andDisplayAs(new PathsCounterDisplay()).
		addAnotherAlgorithm(new TripsFinderShortestAlgorithm("A", "F")).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("F", "D", "C"))).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "E", "B", "C", "D"))).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new DistanceCounterAlgorithm(Arrays.asList("A", "E", "D"))).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new TripsFinderWithMaximumStops("C", "C", 3)).andDisplayAs(new PathsCounterDisplay()).
		addAnotherAlgorithm(new TripsFinderWithExactlyStops("A", "C", 4)).andDisplayAs(new PathsCounterDisplay()).
		addAnotherAlgorithm(new TripsFinderShortestAlgorithm("A", "C")).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new TripsFinderShortestAlgorithm("C", "F")).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new TripsFinderShortestAlgorithm("F", "F")).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new TripsFinderShortestAlgorithm("B", "B")).andDisplayAs(new DistanceSumDisplay()).
		addAnotherAlgorithm(new TripsFinderWithMaximumDistance("C", "C", 30)).andDisplayAs(new PathsCounterDisplay()).				
		runWith(railRoad);
	}

	public static void main( String[] args )
    {
		Kiwiland kiwiland = new Kiwiland();
		kiwiland.execute();
    	
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
