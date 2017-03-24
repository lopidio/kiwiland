package br.com.guigui.kiwiland.runner;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.algorithm.result.AlgorithmResult;
import br.com.guigui.kiwiland.railroad.RailRoad;

public class AlgorithmRunner
{
	Map<Executor, AlgorithmResult> executors;
	
	public AlgorithmRunner()
	{
		executors = new HashMap<Executor, AlgorithmResult>();
	}
	
	public void runAll(RailRoad railRoad)
	{
		for (Entry<Executor, AlgorithmResult> executor : executors.entrySet())
		{
//			executor.setValue(executor.getKey().execute(railRoad));
		}
	}
	
	public AddCriteriaDSL addAlgorithmExecutor(RailRoadAlgorithm algorithm)
	{
		return new AddCriteriaDSL(this, algorithm);
	}
	
	public void showResults()
	{
		int i = 0;
		for (AlgorithmResult algorithmResult : executors.values())
		{
			++i;
//			System.out.println("Output #" + i + ": " + algorithmResult.getResult());
		}
	}

	protected void add(Executor executor)
	{
		executors.put(executor, null);
	}
}
