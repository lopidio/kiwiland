package br.com.guigui.kiwiland.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.railroad.RailRoad;

public class StringRailRoadBuilder implements RailRoadBuilder
{
	private List<String> input;
	
	public StringRailRoadBuilder(String inputString)
	{
		input = new ArrayList<String>();
		initializeInput(inputString);
	}

	private void initializeInput(String inputString)
	{
		String[] split = inputString.split(",");
		for (String string : split)
		{
			string = string.trim();
			if (!isValidInput(string))
				throw new RuntimeException(string + " is not a valid input");
			input.add(string);
		}
	}

	private boolean isValidInput(String string) 
	{
		return string.matches("\\w\\w\\d+");
	}

	public RailRoad buildRailRoad()
	{
		RailRoad railRoadReturn = new RailRoad();
		iterateThroughInput(railRoadReturn);
		return railRoadReturn;
	}

	private void iterateThroughInput(RailRoad railRoadReturn) 
	{
		input.stream().forEach(string ->
			{
				String fromTownInitials = String.valueOf(string.charAt(0));
				String toTownInitials = String.valueOf(string.charAt(1));
				int distance = Integer.parseInt(string.substring(2));
				railRoadReturn.addTrack(fromTownInitials, toTownInitials, distance);
			});
	}
}
