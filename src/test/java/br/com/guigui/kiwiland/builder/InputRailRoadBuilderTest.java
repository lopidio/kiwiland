package br.com.guigui.kiwiland.builder;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Optional;

import br.com.guigui.kiwiland.railroad.RailRoad;
import br.com.guigui.kiwiland.railroad.Town;
import br.com.guigui.kiwiland.railroad.Track;
import junit.framework.TestCase;

public class InputRailRoadBuilderTest extends TestCase
{
	private InputRailRoadBuilder builder;
	private RailRoad railRoad;

	public InputRailRoadBuilderTest() throws Exception
	{
		builder = new InputRailRoadBuilder(
				new InputStreamReader(
				new ByteArrayInputStream("AB10, CD5".getBytes())));
		railRoad = builder.buildRailRoad();
	}

	public void testBuildRailRoad()
	{
		Town a = railRoad.getTown("A");
		assertNotNull(a);
		Optional<Track> fromA = a.getTracks().stream().findFirst();
		assertEquals("B", fromA.get().getDestination().getName());
		assertEquals(10, fromA.get().getDistance());
		
		Town c = railRoad.getTown("C");
		assertNotNull(railRoad.getTown("C"));
		Optional<Track> fromC = c.getTracks().stream().findFirst();
		assertEquals("D", fromC.get().getDestination().getName());
		assertEquals(5, fromC.get().getDistance());

		assertNull(railRoad.getTown("Guigui"));
	}

}
