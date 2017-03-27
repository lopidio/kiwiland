package br.com.guigui.kiwiland.algorithm;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import br.com.guigui.kiwiland.builder.InputRailRoadBuilder;
import br.com.guigui.kiwiland.railroad.RailRoad;
import junit.framework.TestCase;

public class DistanceCounterAlgorithmTest extends TestCase
{
	private RailRoad railRoad;
	

	public DistanceCounterAlgorithmTest()
	{
		InputRailRoadBuilder builder = new InputRailRoadBuilder(
										new InputStreamReader(
										new ByteArrayInputStream("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7".getBytes())));
		railRoad = builder.buildRailRoad();
	}
	
	public void testDoTheMathQuestion1()
	{
		DistanceCounterAlgorithm algorithm = new DistanceCounterAlgorithm(Arrays.asList("A", "B", "C"));
		RailRoadAlgorithmResult algorithmResult = algorithm.doTheMath(railRoad);
		
		assertEquals(9, algorithmResult.getPaths().stream().findFirst().get().getTotalDistance());
	}

	public void testDoTheMathQuestion2()
	{
		DistanceCounterAlgorithm algorithm = new DistanceCounterAlgorithm(Arrays.asList("A", "D"));
		RailRoadAlgorithmResult algorithmResult = algorithm.doTheMath(railRoad);
		
		assertEquals(5, algorithmResult.getPaths().stream().findFirst().get().getTotalDistance());
	}

	public void testDoTheMathQuestion3()
	{
		DistanceCounterAlgorithm algorithm = new DistanceCounterAlgorithm(Arrays.asList("A", "D", "C"));
		RailRoadAlgorithmResult algorithmResult = algorithm.doTheMath(railRoad);
		
		assertEquals(13, algorithmResult.getPaths().stream().findFirst().get().getTotalDistance());
	}

	public void testDoTheMathQuestion4()
	{
		DistanceCounterAlgorithm algorithm = new DistanceCounterAlgorithm(Arrays.asList("A", "E", "B", "C", "D"));
		RailRoadAlgorithmResult algorithmResult = algorithm.doTheMath(railRoad);
		
		assertEquals(22, algorithmResult.getPaths().stream().findFirst().get().getTotalDistance());
	}

	public void testDoTheMathQuestion5()
	{
		DistanceCounterAlgorithm algorithm = new DistanceCounterAlgorithm(Arrays.asList("A", "E", "D"));
		RailRoadAlgorithmResult algorithmResult = algorithm.doTheMath(railRoad);
		
		assertTrue(algorithmResult.getPaths().isEmpty());
	}
}