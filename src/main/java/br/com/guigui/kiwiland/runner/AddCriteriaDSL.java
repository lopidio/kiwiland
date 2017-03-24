package br.com.guigui.kiwiland.runner;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.algorithmresult.AlgorithmResultDisplay;

public class AddCriteriaDSL
{
	AlgorithmRunner runner;
	RailRoadAlgorithm algorithm;
	protected AddCriteriaDSL(AlgorithmRunner algorithmRunner, RailRoadAlgorithm algorithm)
	{
		super();
		this.runner = algorithmRunner;
		this.algorithm = algorithm;
	}

	public void andResultAs(AlgorithmResultDisplay algorithmResult)
	{
//		runner.add(new Executor(algorithm, algorithmResult));
	}
}
