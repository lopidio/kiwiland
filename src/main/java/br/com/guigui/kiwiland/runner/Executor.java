package br.com.guigui.kiwiland.runner;

import java.util.List;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.algorithmresult.AlgorithmResultDisplay;
import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.RailRoad;

class Executor
{

	RailRoadAlgorithm algorithm;
	AlgorithmResultDisplay algorithmResultDisplay;
	
	public Executor(RailRoadAlgorithm algorithm, AlgorithmResultDisplay algorithmResult)
	{
		super();
		this.algorithm = algorithm;
		this.algorithmResultDisplay = algorithmResult;
	}

	public List<Path> execute(RailRoad railRoad)
	{
		return null;
//		return algorithm.doTheMath(railRoad);
	}

}
