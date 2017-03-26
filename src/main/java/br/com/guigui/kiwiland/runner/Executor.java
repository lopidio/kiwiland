package br.com.guigui.kiwiland.runner;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.algorithmresultdisplay.AlgorithmResultDisplay;
import br.com.guigui.kiwiland.railroad.RailRoad;

class Executor
{

	private RailRoadAlgorithm algorithm;
	private AlgorithmResultDisplay algorithmResultDisplay;
	
	public Executor(RailRoadAlgorithm algorithm, AlgorithmResultDisplay algorithmResult)
	{
		super();
		this.algorithm = algorithm;
		this.algorithmResultDisplay = algorithmResult;
	}

	public String execute(RailRoad railRoad)
	{
    	return algorithmResultDisplay.displayResult(algorithm.doTheMath(railRoad));
	}

}
