package br.com.guigui.kiwiland.algorithm;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import br.com.guigui.kiwiland.builder.InputRailRoadBuilder;
import br.com.guigui.kiwiland.railroad.RailRoad;
import junit.framework.TestCase;

public class TripsFinderShortestAlgorithmTest extends TestCase
{
	private RailRoad railRoad;
	

	public TripsFinderShortestAlgorithmTest()
	{
		InputRailRoadBuilder builder = new InputRailRoadBuilder(
										new InputStreamReader(
										new ByteArrayInputStream("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7".getBytes())));
		railRoad = builder.buildRailRoad();
	}
	
	public void testDoTheMathQuestion8()
	{
		TripsFinderShortestAlgorithm algorithm = new TripsFinderShortestAlgorithm("A", "C");
		RailRoadAlgorithmResult algorithmResult = algorithm.doTheMath(railRoad);
		
		assertEquals(1, algorithmResult.getPaths().size());
		assertTrue(algorithmResult.containsPath(Arrays.asList("A", "B", "C")));
		assertEquals(9, algorithmResult.getPaths().stream().findFirst().get().getTotalDistance());
	}

	public void testDoTheMathQuestion9()
	{
		TripsFinderShortestAlgorithm algorithm = new TripsFinderShortestAlgorithm("B", "B");
		RailRoadAlgorithmResult algorithmResult = algorithm.doTheMath(railRoad);
		
		assertEquals(1, algorithmResult.getPaths().size());
		assertTrue(algorithmResult.containsPath(Arrays.asList("B", "C", "E", "B")));
		assertEquals(9, algorithmResult.getPaths().stream().findFirst().get().getTotalDistance());

	}
}