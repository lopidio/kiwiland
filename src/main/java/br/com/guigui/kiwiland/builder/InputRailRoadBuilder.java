package br.com.guigui.kiwiland.builder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.guigui.kiwiland.railroad.RailRoad;

public class InputRailRoadBuilder implements RailRoadBuilder
{


	private InputStreamReader inputStreamReader;
	private List<String> input;
	private RailRoad railRoadReturn;

	public InputRailRoadBuilder(InputStreamReader inputStreamReader)
	{
		this.inputStreamReader = inputStreamReader;
		input = new ArrayList<>();
		railRoadReturn = new RailRoad();
	}

	@Override
	public RailRoad buildRailRoad()
	{
		while (true)
		{
			try
			{
				System.out.println("Enter tracks");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String line = bufferedReader.readLine();
				if (!isValidInput(line))
				{
					System.out.println("Not a valid input. Try again");
					continue;
				}
				return create(line);
			}
			catch (Exception e)
			{
				System.out.println("An I/O error has occured");
			}
		}
	}
	
	private RailRoad create(String line) throws Exception
	{
		String[] split = line.split(",");
		for (String string : split)
		{
			string = string.trim();
			if (!isValidInput(string))
				throw new Exception(string + " is not a valid input");
			input.add(string);
		}
		return iterateThroughInput();
	}

	private boolean isValidInput(String string) 
	{
		return string.matches("(\\w\\w\\d+,\\s+)*(\\w\\w\\d+)");
	}

	private RailRoad iterateThroughInput() 
	{
		input.stream().forEach(string ->
			{
				String fromTownInitials = String.valueOf(string.charAt(0));
				String toTownInitials = String.valueOf(string.charAt(1));
				int distance = Integer.parseInt(string.substring(2));
				railRoadReturn.addTrack(fromTownInitials, toTownInitials, distance);
			});
		return railRoadReturn;
	}
}
