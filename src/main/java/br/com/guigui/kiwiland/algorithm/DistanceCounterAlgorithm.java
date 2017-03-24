package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.exception.DistanceCounterException;
import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Route;
import br.com.guigui.kiwiland.railroad.Town;
import br.com.guigui.kiwiland.railroad.Track;

public class DistanceCounterAlgorithm implements RailRoadAlgorithm
{
	private String[] stopTowns;
	
	public DistanceCounterAlgorithm(String[] stopTowns) throws DistanceCounterException
	{
		this.stopTowns = stopTowns;
		if (stopTowns.length < 2)
			throw new DistanceCounterException("Impossible measure distance with only one town: " + stopTowns);
	}
	
	public List<Route> doTheMath(RailRoad railRoad)
	{
		List<Route> routes = new ArrayList<Route>(); 
		List<Track> tracks = new ArrayList<Track>();
		Town origin = railRoad.getTown(stopTowns[0]);
		for (int i = 1; i < stopTowns.length; ++i)
		{
			Track track = origin.getTrackTo(stopTowns[i]);
			if (null == track)
				return new ArrayList<Route>();
			tracks.add(track);
			
			origin = track.getDestiny();
			
		}
		routes.add(new Route(tracks));
		return routes;
	}

}
