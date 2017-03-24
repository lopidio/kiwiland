package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.guigui.kiwiland.exception.DistanceCounterException;
import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Town;
import br.com.guigui.kiwiland.railroad.Track;

public class DistanceCounterAlgorithm implements RailRoadAlgorithm
{
	private List<String> stopTowns;
	
	public DistanceCounterAlgorithm(List<String> stopTowns) throws DistanceCounterException
	{
		this.stopTowns = stopTowns;
		if (stopTowns.size() < 2)
			throw new DistanceCounterException("Impossible to measure distance with only one town: " + stopTowns);
	}
	
	public RailRoadAlgorithmResult doTheMath(RailRoad railRoad)
	{
		
		List<Path> pahts = new ArrayList<Path>(); 
		List<Track> tracks = new ArrayList<Track>();
		Town origin = railRoad.getTown(stopTowns.stream().findFirst().orElseThrow(() -> new RuntimeException("There is no such string name")));
		
		Stream<String> notSkipedTowns = stopTowns.stream().skip(1);
		
		for (String name : notSkipedTowns.collect(Collectors.toList()))
		{
			Town destination = railRoad.getTown(name);
			if (null == destination)
				return new RailRoadAlgorithmResult();
			Track track = origin.getTrackTo(destination);
			if (null == track)
				return new RailRoadAlgorithmResult();
			tracks.add(track);
			
			origin = track.getDestination();
			
		}
		pahts.add(new Path(tracks));
		return new RailRoadAlgorithmResult(pahts);
	}

}
