package br.com.guigui.kiwiland.railroad;

public class Track
{
	private Town origin;
	private Town destination;
	private int distance;

	public Track(Town origin, Town destination, int distance)
	{
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}

	public Town getOrigin()
	{
		return origin;
	}

	public Town getDestination()
	{
		return destination;
	}

	public int getDistance()
	{
		return distance;
	}

}
