package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.exception.DistanceCounterException;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.Town;
import br.com.guigui.kiwiland.railroad.Track;

public class DistanceCounterAlgorithm implements RailRoadAlgorithm
{
	private String[] stopTowns;
	
	public DistanceCounterAlgorithm(String[] stopTowns) throws DistanceCounterException
	{
		this.stopTowns = stopTowns;
		if (stopTowns.length < 2)
			throw new DistanceCounterException("Impossible to measure distance with only one town: " + stopTowns);
	}
	
	public RailRoadAlgorithmResult doTheMath(RailRoad railRoad)
	{
		List<Path> pahts = new ArrayList<Path>(); 
		List<Track> tracks = new ArrayList<Track>();
		Town origin = railRoad.getTown(stopTowns[0]);
		for (int i = 1; i < stopTowns.length; ++i)
		{
			Track track = origin.getTrackTo(stopTowns[i]);
			if (null == track)
				return new RailRoadAlgorithmResult();
			tracks.add(track);
			
			origin = track.getDestination();
			
		}
		pahts.add(new Path(tracks));
		return new RailRoadAlgorithmResult(pahts);
	}

}
