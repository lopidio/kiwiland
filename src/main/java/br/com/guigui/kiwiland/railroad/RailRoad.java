package br.com.guigui.kiwiland.railroad;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RailRoad
{
	Map<String, Town> towns;
	
	public RailRoad()
	{
		towns = new HashMap<String, Town>();
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

	public void showAllTracks()
	{
		for (Entry<String, Town> entry : towns.entrySet())
		{
			System.out.println("City " + entry.getKey());
			Town town = entry.getValue();
			for (Track track : town.getTracks())
			{
				System.out.println("\thas track to " + track.getDestiny().getName() + "(" + track.getDistance() + ")");
			}
			
		}
	}
}
