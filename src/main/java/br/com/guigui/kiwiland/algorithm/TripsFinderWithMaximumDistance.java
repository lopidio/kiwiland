package br.com.guigui.kiwiland.algorithm;

import br.com.guigui.kiwiland.railroad.Path;

public class TripsFinderWithMaximumDistance extends TripsFinderAlgorithm 
{
	private int maximumDistance;

	public TripsFinderWithMaximumDistance(String fromCityName, String toCityName, int maximumDistance)
	{
		super(fromCityName, toCityName);
		this.maximumDistance = maximumDistance;
		if (maximumDistance <= 0)
			throw new IllegalArgumentException("Maximum distance must be greater than 0");
	}

	@Override
	protected void startNewRecursion(Path current)
	{
		//Avoids useless iterations
		if (current.getTotalDistance() > maximumDistance)
		{
			return;
		}

		//Found candidate 
		if (current.getLastTown().getName().equals(toCityName) && current.getTotalDistance() < maximumDistance)
		{
			paths.add(current);
		}
		
		addNextTracksFrom(current);
	}

}
