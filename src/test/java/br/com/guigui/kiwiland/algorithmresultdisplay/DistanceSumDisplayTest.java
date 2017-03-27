package br.com.guigui.kiwiland.algorithmresultdisplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithmResult;
import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.RailRoad;
import junit.framework.TestCase;

public class DistanceSumDisplayTest extends TestCase
{

	private List<Path> paths;
	private RailRoad road;
	private RailRoadAlgorithmResult result;

	public DistanceSumDisplayTest()
	{
		paths = new ArrayList<Path>(); 
		road = new RailRoad();
		road.addTrack("A", "B", 10);
		road.addTrack("B", "C", 15);
		Path path = new Path(Arrays.asList(
						road.getTown("A").getTrackTo("B"),
						road.getTown("B").getTrackTo("C")));
		paths.add(path);
		result = new RailRoadAlgorithmResult(paths);
	}
	
	public void testDisplayResult()
	{
		DistanceSumDisplay sum = new DistanceSumDisplay();
		assertEquals("25", sum.displayResult(result));
	}
}
