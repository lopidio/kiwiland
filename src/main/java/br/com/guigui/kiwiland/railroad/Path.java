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
		Track newTrack = lastTown.getTrackTo(town);
		if (null == newTrack)
			return false;
		tracks.add(newTrack);
		return true;
	}

	public int getTotalDistance()
	{
		return tracks.stream().mapToInt(r -> r.getDistance()).sum();
	}

	public Town getLastTown()
	{
		if (tracks.isEmpty())
			return null;
		return tracks.get(tracks.size() - 1).getDestination();
	}
	
	public boolean containsTownAsDestination(Town destination) 
	{
		return tracks.stream().filter(x -> x.getDestination().equals(destination)).findFirst().isPresent();
	}

}
