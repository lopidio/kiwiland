package br.com.guigui.kiwiland.algorithm;

import br.com.guigui.kiwiland.railroad.Path;

public class TripsFinderWithMaximumStops extends TripsFinderAlgorithm 
{
	private int maxStops;

	public TripsFinderWithMaximumStops(String fromCityName, String toCityName, int maxStops)
	{
		super(fromCityName, toCityName);
		this.maxStops = maxStops;
		if (maxStops <= 0)
			throw new IllegalArgumentException("Stops number must be greater than 0");
	}

	@Override
	protected void startNewRecursion(Path path)
	{
		//Avoids useless iterations
		if (path.getTracks().size() > maxStops)
		{
			return;
		}

		//Found candidate 
		if (path.getLastTown().getName().equals(toCityName) && path.getTracks().size() > 0)
		{
			paths.add(path);
			return;
		}
		
		addNextTracksFrom(path);
	}

}