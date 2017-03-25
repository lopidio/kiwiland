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
	protected void startNewRecursion(Path path)
	{
		//Avoids useless iterations
		if (path.getTracks().size() > exactlyStopsNumber)
		{
			return;
		}

		//Found candidate 
		if (path.getLastTown().getName().equals(toCityName) && path.getTracks().size() == exactlyStopsNumber)
		{
			paths.add(path);
			return;
		}
		
		addNextTracksFrom(path);
	}
}
