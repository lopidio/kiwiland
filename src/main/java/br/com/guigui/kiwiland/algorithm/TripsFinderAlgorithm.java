package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Town;
import br.com.guigui.kiwiland.railroad.Track;

abstract class TripsFinderAlgorithm implements RailRoadAlgorithm
{
	private String fromCityName;
	protected String toCityName;
	protected List<Path> paths;

	TripsFinderAlgorithm(String fromCityName, String toCityName)
	{
		super();
		this.fromCityName = fromCityName;
		this.toCityName = toCityName;
		paths = new ArrayList<Path>();
	}

	@Override
	public final RailRoadAlgorithmResult doTheMath(RailRoad railRoad)
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
			startNewRecursion(path);
		}
	}
	
	protected final void addNextTracksFrom(Path path) 
	{
		//Run again
		for (Track nextTrack : path.getLastTown().getTracks()) 
		{
			checkNewInsertion(path, nextTrack);
		}
	}

	private void checkNewInsertion(Path path, Track nextTrack)
	{
		if (canRepeatCity() || !path.containsTownAsDestination(nextTrack.getDestination()))
		{
			List<Track> tracks = path.getTracks();
			tracks.add(nextTrack);
			Path newPath = new Path(tracks);
			startNewRecursion(newPath);
		}
	}

	protected abstract void startNewRecursion(Path path);

	/**
	 * Overridable hook method 
	 */
	protected boolean canRepeatCity()
	{
		return true;
	}

}
