package br.com.guigui.kiwiland.runner;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.railroad.RailRoad;

public class AlgorithmAdder 
{
	private AlgorithmRunner runner;

	protected AlgorithmAdder(AlgorithmRunner runner)
	{
		this.runner = runner;
	}

	public AddAlgorithmDisplay addAnotherAlgorithm(RailRoadAlgorithm algorithm) 
	{
		return runner.addAlgorithm(algorithm);
	}

	public void runWith(RailRoad railRoad) 
	{
		runner.execute(railRoad);
	}
}
