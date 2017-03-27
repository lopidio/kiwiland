package br.com.guigui.kiwiland.algorithm;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import br.com.guigui.kiwiland.builder.InputRailRoadBuilder;
import br.com.guigui.kiwiland.railroad.RailRoad;
import junit.framework.TestCase;

public class TripsFinderWithMaximumDistanceTest extends TestCase
{
	private RailRoad railRoad;
	

	public TripsFinderWithMaximumDistanceTest()
	{
		InputRailRoadBuilder builder = new InputRailRoadBuilder(
										new InputStreamReader(
										new ByteArrayInputStream("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7".getBytes())));
		railRoad = builder.buildRailRoad();
	}
	
	public void testDoTheMath10()
	{
		TripsFinderWithMaximumDistance algorithm = new TripsFinderWithMaximumDistance("C", "C", 30);
		RailRoadAlgorithmResult algorithmResult = algorithm.doTheMath(railRoad);
		
		assertEquals(7, algorithmResult.getPaths().size());

		
		assertTrue(algorithmResult.containsPath(Arrays.asList("C", "D", "C")));
		assertTrue(algorithmResult.containsPath(Arrays.asList("C", "E", "B", "C")));
		assertTrue(algorithmResult.containsPath(Arrays.asList("C", "E", "B", "C", "D", "C")));
		assertTrue(algorithmResult.containsPath(Arrays.asList("C", "D", "C", "E", "B", "C")));
		assertTrue(algorithmResult.containsPath(Arrays.asList("C", "D", "E", "B", "C")));
		assertTrue(algorithmResult.containsPath(Arrays.asList("C", "E", "B", "C", "E", "B", "C")));
		assertTrue(algorithmResult.containsPath(Arrays.asList("C", "E", "B", "C", "E", "B", "C", "E", "B", "C")));
	}
}
