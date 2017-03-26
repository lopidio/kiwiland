package br.com.guigui.kiwiland.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.guigui.kiwiland.railroad.RailRoad;

public class InputRailRoadBuilder implements RailRoadBuilder
{


	public InputRailRoadBuilder()
	{
	}

	@Override
	public RailRoad buildRailRoad()
	{
		while (true)
		{
			try
			{
				System.out.println("Enter tracks");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				String input = bufferedReader .readLine();
				if (!isValidInput(input))
				{
					System.out.println("Not a valid input. Try again");
				}
				return new StringRailRoadBuilder(input).buildRailRoad();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private boolean isValidInput(String string) 
	{
		return string.matches("(\\w\\w\\d+,\\s+)*(\\w\\w\\d+)");
	}

}
