package br.com.guigui.kiwiland.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.exception.InvalidInputException;
import br.com.guigui.kiwiland.railroad.RailRoad;

public class StringRailRoadBuilder implements RailRoadBuilder
{
	private List<String> input;
	
	public StringRailRoadBuilder(String inputString) throws InvalidInputException
	{
		input = new ArrayList<String>();
		initializeInput(inputString);
	}

	private void initializeInput(String inputString) throws InvalidInputException
	{
		String[] split = inputString.split(",");
		for (String string : split)
		{
			string = string.trim();
			if (!string.matches("\\w\\w\\d+"))
				throw new InvalidInputException(string + " is not a valid input");
			input.add(string);
		}
	}

	public RailRoad buildRailRoad()
	{
		RailRoad railRoadReturn = new RailRoad();
		for (String string : input)
		{
			String fromTownInitials = String.valueOf(string.charAt(0));
			String toTownInitials = String.valueOf(string.charAt(1));
			int distance = Integer.parseInt(string.substring(2));
			railRoadReturn.addTrack(fromTownInitials, toTownInitials, distance);
		}
		return railRoadReturn;
	}
	
	
}
