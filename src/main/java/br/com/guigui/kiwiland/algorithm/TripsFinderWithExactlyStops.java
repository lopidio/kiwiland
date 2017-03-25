package br.com.guigui.kiwiland.algorithm;

import br.com.guigui.kiwiland.railroad.Path;

public class TripsFinderWithExactlyStops extends TripsFinderAlgorithm
{
	private int exactlyStopsNumber;

	public TripsFinderWithExactlyStops(String fromCityName, String toCityName, int exactlyStopsNumber)
	{
		super(fromCityName, toCityName);
		this.exactlyStopsNumber = exactlyStopsNumber;
		if (exactlyStopsNumber <= 0)
			throw new IllegalArgumentException("Stops number must be greater than 0");
	}

	@Override
	protected void startNewRecursion(Path current)
	{
		//Avoids useless iterations
		if (current.getTracks().size() > exactlyStopsNumber)
		{
			return;
		}

		//Found candidate 
		if (current.getLastTown().getName().equals(toCityName) && current.getTracks().size() == exactlyStopsNumber)
		{
			paths.add(current);
			return;
		}
		
		addNextTracksFrom(current);
	}
}
