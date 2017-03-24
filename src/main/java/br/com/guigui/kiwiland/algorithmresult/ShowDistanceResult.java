package br.com.guigui.kiwiland.algorithmresult;

import java.util.List;

import br.com.guigui.kiwiland.railroad.Path;

public class ShowDistanceResult implements AlgorithmResultDisplay
{
	public String getResult(List<Path> routes)
	{
		if (routes.isEmpty())
			return "NO SUCH ROUTE";
		
		return String.valueOf(routes.stream().mapToInt(r -> r.getTotalDistance()).sum());
	}


}
