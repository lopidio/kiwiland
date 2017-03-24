package br.com.guigui.kiwiland.railroad;

import java.util.List;

public class Route
{
	private List<Track> tracks;

	public Route(List<Track> tracks)
	{
		super();
		this.tracks = tracks;
	}

	public List<Track> getTracks()
	{
		return tracks;
	}
	
	public boolean addTrackTo(Town town)
	{
		if (tracks.isEmpty())
			return false;
		Town lastTown = tracks.get(tracks.size() - 1).getDestiny();
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

	public boolean containsTown(String name)
	{
		if (tracks.isEmpty())
			return false;
		for (Track track : tracks)
		{
			if (track.getOrigin().getName() == name)
				return true;
		}
		if (tracks.get(tracks.size() - 1).getDestiny().getName() == name)
			return true;
		return false;
	}

	public Town getLastTown()
	{
		if (tracks.isEmpty())
			return null;
		return tracks.get(tracks.size() - 1).getDestiny();
	}

}
