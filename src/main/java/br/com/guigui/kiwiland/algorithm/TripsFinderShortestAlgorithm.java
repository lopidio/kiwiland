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
	protected void startNewRecursion(Path path)
	{
		//Avoids useless iterations
		if (null != bestPath && path.getTotalDistance() > bestPath.getTotalDistance())
		{
			return;
		}

		//Found candidate 
		if (path.getLastTown().getName().equals(toCityName) && path.getTracks().size() > 0)
		{
			if (null == bestPath || bestPath.getTotalDistance() > path.getTotalDistance())
			{
				bestPath = path;
				paths = new ArrayList<>();
				paths.add(bestPath);
			}
			return;
		}
		
		addNextTracksFrom(path);
	}

	@Override
	protected boolean canRepeatCity()
	{
		return false;
	}
}
