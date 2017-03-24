package br.com.guigui.kiwiland.algorithm.result;

import java.util.List;

import br.com.guigui.kiwiland.railroad.Route;

public class ShowDistanceResult implements AlgorithmResult
{
	public String getResult(List<Route> routes)
	{
		if (routes.isEmpty())
			return "NO SUCH ROUTE";
		
		int distanceSum = 0;
		for (Route route : routes)
		{
			distanceSum += route.getTotalDistance();
		}
		return String.valueOf(distanceSum);
	}


}
