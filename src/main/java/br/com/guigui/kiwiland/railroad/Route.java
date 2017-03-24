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

	public int getTotalDistance()
	{
		int distanceSum = 0;
		for (Track track : tracks)
		{
			distanceSum += track.getDistance();
		}
		return distanceSum;
	}
	
}
