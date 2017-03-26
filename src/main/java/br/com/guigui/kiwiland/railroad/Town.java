package br.com.guigui.kiwiland.railroad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

	void addTrack(Track track)
	{
		tracks.put(track.getDestination(), track);
	}

	public Collection<Track> getTracks()
	{
		return new ArrayList<>(tracks.values());
	}

	public Track getTrackTo(Town town)
	{
		return tracks.get(town);
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
