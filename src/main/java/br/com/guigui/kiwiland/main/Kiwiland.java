package br.com.guigui.kiwiland.main;

import br.com.guigui.kiwiland.builder.RailRoadBuilder;
import br.com.guigui.kiwiland.builder.StringRailRoadBuilder;
import br.com.guigui.kiwiland.exception.InvalidInputException;
import br.com.guigui.kiwiland.railroad.RailRoad;

/**
 * Hello world!
 *
 */
public class Kiwiland 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try
		{
			RailRoadBuilder builder = new StringRailRoadBuilder("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
			RailRoad railRoad = builder.buildRailRoad();
		}
		catch (InvalidInputException e)
		{
			e.printStackTrace();
		}
    }
}
