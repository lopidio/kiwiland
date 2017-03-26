package br.com.guigui.kiwiland.algorithmresultdisplay;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithmResult;
import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Track;
import junit.framework.TestCase;

public class PathsCounterDisplayTest extends TestCase
{
	private List<Path> paths;
	private RailRoad road;

	public PathsCounterDisplayTest()
	{
		paths = new ArrayList<Path>(); 
		
		road = new RailRoad();
		road.addTrack("A", "B", 10);
		
		
	}

	public void testDisplayResult()
	{
		RailRoadAlgorithmResult resultZero = new RailRoadAlgorithmResult(paths);
		PathsCounterDisplay zero = new PathsCounterDisplay();
		assertEquals("0", zero.displayResult(resultZero));
		
		Path path = new Path(road.getTown("A").getTracks());
		paths.add(path);
		RailRoadAlgorithmResult resultOne = new RailRoadAlgorithmResult(paths);
		PathsCounterDisplay one = new PathsCounterDisplay();
		assertEquals("1", one.displayResult(resultOne));
	}

}
