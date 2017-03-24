package br.com.guigui.kiwiland.railroad;

import java.util.ArrayList;
import java.util.List;

public class Path
{
	private List<Track> tracks;

	public Path(List<Track> tracks)
	{
		super();
		this.tracks = tracks;
	}

	public List<Track> getTracks()
	{
		return new ArrayList<>(tracks);
	}
	
	public boolean addTrackTo(Town town)
	{
		if (tracks.isEmpty())
			return false;
		Town lastTown = tracks.get(tracks.size() - 1).getDestination();
		Track newTrack = lastTown.getTrackTo(town.getName());
		if (null == newTrack)
			return false;
		tracks.add(newTrack);
		return true;
	}

	public int getTotalDistance()
	{
		int distanceSum = 0;
		for (Track track : tracks)
		{
			distanceSum += track.getDistance();
		}
		return distanceSum;
	}

	public boolean containsTown(String townName)
	{
		if (tracks.isEmpty())
			return false;
		for (Track track : tracks)
		{
			if (track.getOrigin().getName().equals(townName))
				return true;
		}
		if (tracks.get(tracks.size() - 1).getDestination().getName().equals(townName))
			return true;
		return false;
	}

	public Town getLastTown()
	{
		if (tracks.isEmpty())
			return null;
		return tracks.get(tracks.size() - 1).getDestination();
	}
	
	public void displayPath()
	{
		if (tracks.isEmpty())
			System.out.println("There is no path");
		System.out.print("Path: " + tracks.get(0).getOrigin().getName());
		for (Track track : tracks) 
		{
			System.out.print("--(" + track.getDistance() + ")-->" + track.getDestination().getName());
		}
		System.out.println();
	}

	public boolean containsTownAsDestination(Town destination) 
	{
		return tracks.stream().filter(x -> x.getDestination().equals(destination)).findFirst().isPresent();
	}

}
