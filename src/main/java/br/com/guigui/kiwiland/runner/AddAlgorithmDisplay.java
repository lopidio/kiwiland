package br.com.guigui.kiwiland.runner;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.algorithmresult.AlgorithmResultDisplay;

public class AddAlgorithmDisplay
{
	private AlgorithmRunner runner;
	private RailRoadAlgorithm algorithm;
	protected AddAlgorithmDisplay(AlgorithmRunner algorithmRunner, RailRoadAlgorithm algorithm)
	{
		super();
		this.runner = algorithmRunner;
		this.algorithm = algorithm;
	}

	public AlgorithmAdder andDisplayAs(AlgorithmResultDisplay resultDisplay) 
	{
		return null;
	}
}
