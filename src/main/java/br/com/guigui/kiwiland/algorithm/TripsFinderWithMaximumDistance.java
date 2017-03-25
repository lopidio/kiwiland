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
	protected void startNewRecursion(Path path)
	{
		//Avoids useless iterations
		if (path.getTotalDistance() > maximumDistance)
		{
			return;
		}

		//Found candidate 
		if (path.getLastTown().getName().equals(toCityName) && path.getTotalDistance() < maximumDistance)
		{
			paths.add(path);
		}
		
		addNextTracksFrom(path);
	}

}
