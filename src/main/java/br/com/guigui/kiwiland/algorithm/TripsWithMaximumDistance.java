package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Town;
import br.com.guigui.kiwiland.railroad.Track;

public class TripsWithMaximumDistance implements RailRoadAlgorithm 
{
	private String fromCityName;
	private String toCityName;
	private List<Path> paths;
	private int maximumDistance;

	public TripsWithMaximumDistance(String fromCityName, String toCityName, int maximumDistance)
	{
		super();
		this.fromCityName = fromCityName;
		this.toCityName = toCityName;
		this.maximumDistance = maximumDistance;
		paths = new ArrayList<>();
		if (maximumDistance <= 0)
			throw new IllegalArgumentException("Maximum distance must be greater than 0");
	}

	public RailRoadAlgorithmResult doTheMath(RailRoad railRoad)
	{
		// Algo:
		// 1. Take the unvisited node with minimum weight.
		// 2. Visit all its neighbours.
		// 3. Update the distances for all the neighbours (In the Priority Queue).
		// Repeat the process till all the connected nodes are visited.
		
		Town origin = railRoad.getTown(fromCityName);
		if (null != origin)
		{
			run(origin);
		}
		return new RailRoadAlgorithmResult(paths);
	}

	private void run(Town origin)
	{
		for (Track track : origin.getTracks())
		{
			List<Track> tracks = new ArrayList<Track>();
			tracks.add(track);
			Path path = new Path(tracks);
			depthFirstSearch(path);
		}
	}
	
	private void depthFirstSearch(Path current)
	{
		//Avoids useless iterations
		if (current.getTotalDistance() > maximumDistance)
		{
			return;
		}

		//Found candidate 
		if (current.getLastTown().getName().equals(toCityName) && current.getTotalDistance() < maximumDistance)
		{
			paths.add(current);
		}
		
		runAgain(current);
	}

	private void runAgain(Path current) 
	{
		//Run again
		for (Track nextTrack : current.getLastTown().getTracks()) 
		{
//			if (!current.containsTownAsDestination(nextTrack.getDestination()))
			{
				List<Track> tracks = current.getTracks();
				tracks.add(nextTrack);
				Path path = new Path(tracks);
				depthFirstSearch(path);
			}
				
		}
	}
}
