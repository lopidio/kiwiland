package br.com.guigui.kiwiland.railroad;

import junit.framework.TestCase;

public class RailRoadTest extends TestCase
{

	private RailRoad railRoad;

	public RailRoadTest()
	{
		railRoad = new RailRoad();
	}

	public void testAddTrack()
	{
		assertNotNull(railRoad.addTrack("initial", "Destination", 10));
		assertNull(railRoad.addTrack("initial", "Destination", 10));
	}

	public void testGetTown()
	{
		assertNotNull(railRoad.addTrack("Origin", "Destination", 10));
		assertNotNull(railRoad.getTown("Origin"));
		assertNotNull(railRoad.getTown("Destination"));
		assertNull(railRoad.getTown("Inexistent"));
	}

}
