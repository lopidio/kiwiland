package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;

import br.com.guigui.kiwiland.railroad.Path;

public class TripsFinderShortestAlgorithm extends TripsFinderAlgorithm
{

	private Path bestPath;

	public TripsFinderShortestAlgorithm(String fromCityName, String toCityName)
	{
		super(fromCityName, toCityName);
	}

	@Override
	protected void startNewRecursion(Path current)
	{
		//Avoids useless iterations
		if (null != bestPath && current.getTotalDistance() > bestPath.getTotalDistance())
		{
			return;
		}

		//Found candidate 
		if (current.getLastTown().getName().equals(toCityName) && current.getTracks().size() > 0)
		{
			if (null == bestPath || bestPath.getTotalDistance() > current.getTotalDistance())
			{
				bestPath = current;
				paths = new ArrayList<>();
				paths.add(bestPath);
			}
			return;
		}
		
		addNextTracksFrom(current);
	}

	@Override
	protected boolean canRepeatCity()
	{
		return false;
	}
}
