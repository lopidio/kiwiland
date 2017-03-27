package br.com.guigui.kiwiland.railroad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Town
{
	private String name;
	/**
	 * Maps the destination city with its track
	 */
	private Map<Town, Track> tracks;
	
	Town(String name)
	{
		this.name = name;
		tracks = new HashMap<Town, Track>();
	}

	public String getName()
	{
		return name;
	}

	boolean addTrack(Track track)
	{
		//Already exists
		if (null != getTrackTo(track.getDestination()))
			return false;

		//Track origin is not me
		if (track.getOrigin() != this)
			return false;
		tracks.put(track.getDestination(), track);
		return true;
	}

	public List<Track> getTracks()
	{
		return new ArrayList<>(tracks.values());
	}

	public Track getTrackTo(Town town)
	{
		return tracks.get(town);
	}

	public Track getTrackTo(String townName)
	{
		for (Entry<Town, Track> track : tracks.entrySet())
		{
			if (track.getValue().getDestination().getName().equals(townName))
				return track.getValue();
		}
		return null;
	}

	@Override
	public boolean equals(Object obj)
	{
	    if (obj == null)
	    {
	        return false;
	    }
	    if (!Town.class.isAssignableFrom(obj.getClass())) 
	    {
	        return false;
	    }
	    final Town other = (Town) obj;
	    if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
	    {
	        return false;
	    }
	    return true;
	}
	

}
