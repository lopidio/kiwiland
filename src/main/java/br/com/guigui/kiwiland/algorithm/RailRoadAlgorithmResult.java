package br.com.guigui.kiwiland.algorithm;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.railroad.Path;
import br.com.guigui.kiwiland.railroad.Track;

public class RailRoadAlgorithmResult 
{
	private List<Path> paths;

	public RailRoadAlgorithmResult(List<Path> path)
	{
		super();
		this.paths = new ArrayList<>(path);
	}

	public RailRoadAlgorithmResult() 
	{
		super();
		this.paths = new ArrayList<>();
	}

	public List<Path> getPaths() 
	{
		return paths;
	}
	
	public boolean containsPath(List<String> townsNames)
	{
		for (Path path : paths)
		{
			List<Track> pathTracks = path.getTracks();
			if (townsNames.size() != pathTracks.size() + 1) //Avoids unnecessary checking
				continue;
			
			Track track = pathTracks.stream().findFirst().get();
			if (!townsNames.get(0).equals(track.getOrigin().getName()))
			{
				continue;
			}
			
			for (int i = 1; i < townsNames.size() - 1; ++i)
			{
				if (!track.getDestination().getName().equals(townsNames.get(i)))
					break;
						
				track = pathTracks.get(i);
			}
			return true;
		}
		return false;
	}

	
}
