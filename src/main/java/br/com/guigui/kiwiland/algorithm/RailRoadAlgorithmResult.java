package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.railroad.Path;

public class RailRoadAlgorithmResult 
{
	private List<Path> paths;

	public RailRoadAlgorithmResult(List<Path> path)
	{
		super();
		this.paths = new ArrayList<>(path);
	}

	public RailRoadAlgorithmResult() 
	{
		super();
		this.paths = new ArrayList<>();
	}

	public List<Path> getPaths() 
	{
		return paths;
	}
	
}
