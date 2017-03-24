package br.com.guigui.kiwiland.runner;

import java.util.List;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.algorithm.result.AlgorithmResult;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Route;

class Executor
{

	RailRoadAlgorithm algorithm;
	AlgorithmResult algorithmResult;
	
	public Executor(RailRoadAlgorithm algorithm, AlgorithmResult algorithmResult)
	{
		super();
		this.algorithm = algorithm;
		this.algorithmResult = algorithmResult;
	}

	public List<Route> execute(RailRoad railRoad)
	{
		return algorithm.doTheMath(railRoad);
	}

}
