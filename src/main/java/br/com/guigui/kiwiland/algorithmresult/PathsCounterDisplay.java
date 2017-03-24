package br.com.guigui.kiwiland.algorithmresult;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithmResult;

public class PathsCounterDisplay implements AlgorithmResultDisplay 
{

	@Override
	public String displayResult(RailRoadAlgorithmResult result) 
	{
		return String.valueOf(result.getPaths().size());
	}

}
