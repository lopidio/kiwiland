package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Route;
import br.com.guigui.kiwiland.railroad.Town;
import br.com.guigui.kiwiland.railroad.Track;

public class ShortestRouteAlgorithm implements RailRoadAlgorithm
{
	String fromCityName;
	String toCityName;
	Map<String, Route> routesMap;

	public ShortestRouteAlgorithm(String fromCityName, String toCityName)
	{
		super();
		this.fromCityName = fromCityName;
		this.toCityName = toCityName;
		routesMap = new HashMap<String, Route>();
	}

	public List<Route> doTheMath(RailRoad railRoad)
	{
		// Algo:
		// 1. Take the unvisited node with minimum weight.
		// 2. Visit all its neighbours.
		// 3. Update the distances for all the neighbours (In the Priority Queue).
		// Repeat the process till all the connected nodes are visited.
		
		Town origin = railRoad.getTown(fromCityName);
		
		for (Track track : origin.getTracks())
		{
			List<Track> firstTrack = new ArrayList<Track>();
			Route route = new Route(firstTrack);
			routesMap.put(track.getDestiny().getName(), route);
		}
		while(processMap());
		return null;
	}
	
	private boolean processMap()
	{
		for (Entry<String, Route> entry : routesMap.entrySet())
		{
			Town lastTown = entry.getValue().getLastTown();
			for (Track track : lastTown.getTracks())
			{
				
//				if (routesMap.get(track.getDestiny().getName()))
			}
		}
		return false;
	}

	private Route traceDown(Route routeFromOrigin)
	{
		List<Route> routesReturn = new ArrayList<Route>();
		Town lastTown = routeFromOrigin.getLastTown();
		for (Track track : lastTown.getTracks())
		{
			if (!routeFromOrigin.containsTown("townName"))
			{
				Route newPossibility = new Route(routeFromOrigin.getTracks());
//				if (newPossibility.addTrack(track))
//					routesReturn.add(traceDown(routeFromOrigin));
			}
		}
		return null;
	}

}
