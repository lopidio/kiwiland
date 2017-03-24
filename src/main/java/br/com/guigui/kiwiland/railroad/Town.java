package br.com.guigui.kiwiland.railroad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Town
{
	String name;
	/**
	 * Maps the City destiny name with its track
	 */
	private Map<String, Track> tracks;
	
	public Town(String name)
	{
		this.name = name;
		tracks = new HashMap<String, Track>();
	}

	public String getName()
	{
		return name;
	}

	public void addTrack(Track track)
	{
		tracks.put(track.getDestination().getName(), track);
	}

	public Collection<Track> getTracks()
	{
		return tracks.values();
	}

	public Track getTrackTo(String destinyName)
	{
		return tracks.get(destinyName);
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Town.class.isAssignableFrom(obj.getClass())) {
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
