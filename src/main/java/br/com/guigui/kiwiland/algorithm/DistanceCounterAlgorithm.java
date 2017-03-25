package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.exception.DistanceCounterException;
import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Town;
import br.com.guigui.kiwiland.railroad.Track;

public class DistanceCounterAlgorithm implements RailRoadAlgorithm
{
	private List<String> stopTowns;
	private Town origin;
	private boolean thereIsARoute;
	
	public DistanceCounterAlgorithm(List<String> stopTowns) throws DistanceCounterException
	{
		this.stopTowns = stopTowns;
		if (stopTowns.size() < 2)
			throw new DistanceCounterException("Impossible to measure distance with only one town: " + stopTowns);
		thereIsARoute = true;
	}
	
	public RailRoadAlgorithmResult doTheMath(RailRoad railRoad)
	{
		origin = railRoad.getTown(stopTowns.stream().findFirst().orElseThrow(() -> new RuntimeException("There is no such string name")));
		
		List<Path> paths = new ArrayList<Path>(); 
		List<Track> tracks = new ArrayList<Track>();
		
		stopTowns.stream().skip(1).forEachOrdered(townName ->
		{
			Town destination = railRoad.getTown(townName);
			Track track = checkAddition(destination);

			if (null != track)
				tracks.add(track);
			else
				thereIsARoute = false;
			
		});
		
		if (thereIsARoute)
			paths.add(new Path(tracks));
		
		return new RailRoadAlgorithmResult(paths);
	}

	private Track checkAddition(Town destination)
	{
		Track track = null;
		if (null != destination)
		{
			track = origin.getTrackTo(destination);
			if (null != track)
			{
				origin = track.getDestination();
			}
		}
		return track;
	}

}
