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
	protected void startNewRecursion(Path current)
	{
		//Avoids useless iterations
		if (current.getTracks().size() > maxStops)
		{
			return;
		}

		//Found candidate 
		if (current.getLastTown().getName().equals(toCityName) && current.getTracks().size() > 0)
		{
			paths.add(current);
			return;
		}
		
		addNextTracksFrom(current);
	}

}