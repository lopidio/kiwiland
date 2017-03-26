package br.com.guigui.kiwiland.algorithmresultdisplay;

import java.util.List;

import br.com.guigui.kiwiland.algorithm.RailRoadAlgorithmResult;
import br.com.guigui.kiwiland.railroad.Path;

public class DistanceSumDisplay implements AlgorithmResultDisplay
{
	@Override
	public String displayResult(RailRoadAlgorithmResult result) 
	{
		List<Path> paths = result.getPaths();
		if (paths.isEmpty())
			return "NO SUCH ROUTE";
		
		return String.valueOf(paths.stream().mapToInt(path -> path.getTotalDistance()).sum());
	}

}
