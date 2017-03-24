package br.com.guigui.kiwiland.railroad;

public class Track
{
	Town origin;
	Town destiny;
	int distance;

	public Track(Town origin, Town destiny, int distance)
	{
		this.origin = origin;
		this.destiny = destiny;
		this.distance = distance;
	}

	public Town getOrigin()
	{
		return origin;
	}

	public Town getDestiny()
	{
		return destiny;
	}

	public int getDistance()
	{
		return distance;
	}

}
