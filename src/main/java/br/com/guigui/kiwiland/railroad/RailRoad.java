package br.com.guigui.kiwiland.railroad;

import java.util.HashMap;
import java.util.Map;

public class RailRoad
{
	private Map<String, Town> towns;
	
	public RailRoad()
	{
		towns = new HashMap<>();
	}

	public void addTrack(String fromTownName, String toTownName, int distance)
	{
		Town from = getOrCreateTown(fromTownName);
		Town to = getOrCreateTown(toTownName);
		Track track = new Track(from, to, distance);
		from.addTrack(track);
	}
	
	public Town getTown(String townName)
	{
		return towns.get(townName);
	}

	private Town getOrCreateTown(String townName)
	{
		if (towns.containsKey(townName))
			return towns.get(townName);
		else
		{
			Town createdTown = new Town(townName);
			towns.put(townName, createdTown);
			return createdTown;
		}
	}

}
