package br.com.guigui.kiwiland.runner;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithm;
import br.com.guigui.kiwiland.railroad.RailRoad;

public class AlgorithmRunner
{
	private List<Executor> executors;
	private int outputNumber;
	
	public AlgorithmRunner()
	{
		executors = new ArrayList<>();
	}
	
	public AddAlgorithmDisplay addAlgorithm(RailRoadAlgorithm algorithm) 
	{
		return new AddAlgorithmDisplay(this, algorithm);
	}

	void execute(RailRoad railRoad) 
	{
		executors.stream().forEachOrdered( x ->
		{
			++outputNumber;
			System.out.println("Output #" + outputNumber + ": " + x.execute(railRoad));
		});
		
	}

	protected void addExecutor(Executor executor)
	{
		executors.add(executor);
	}
}
