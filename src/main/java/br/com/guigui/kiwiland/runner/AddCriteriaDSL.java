package br.com.guigui.kiwiland.runner;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.algorithm.result.AlgorithmResult;

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

	public void andResultAs(AlgorithmResult algorithmResult)
	{
		runner.add(new Executor(algorithm, algorithmResult));
	}
}
