package br.com.guigui.kiwiland.railroad;

import junit.framework.TestCase;

public class TownTest extends TestCase
{

	public void testNotTheOriginTrack()
	{
		Town townsVille = new Town("TownsVille");
		Town alameda = new Town("Alameda dos Anjos");

		Track notTheOriginTrack = new Track(alameda, townsVille, 10);
		assertFalse(townsVille.addTrack(notTheOriginTrack));
	}

	public void testSingleAdd()
	{
		Town townsVille = new Town("TownsVille");
		Town alameda = new Town("Alameda dos Anjos");
		Track trackToAlameda = new Track(townsVille, alameda, 10);

		assertEquals(0, townsVille.getTracks().size());
		assertFalse(townsVille.getTracks().stream().findFirst().isPresent());
		assertTrue(townsVille.addTrack(trackToAlameda));
		assertTrue(townsVille.getTracks().stream().findFirst().isPresent());
	}


	public void testDoubleAdd()
	{
		Town townsVille = new Town("TownsVille");
		Town alameda = new Town("Alameda dos Anjos");
		Track trackToAlameda = new Track(townsVille, alameda, 10);

		assertTrue(townsVille.addTrack(trackToAlameda));
		assertFalse(townsVille.addTrack(trackToAlameda));
	}

	public void testGetTrackTo()
	{
		Town patopolis = new Town("Patópolis");
		Town cidadeCity = new Town("Cidade City");
		Town itapipoca = new Town("Itapipoca");
		Track track = new Track(patopolis, cidadeCity, 10);
		patopolis.addTrack(track);
		
		assertSame(track, patopolis.getTrackTo(cidadeCity));
		assertNull(patopolis.getTrackTo(itapipoca));
	}

	public void testEqualsObject()
	{
		Town original = new Town("Original");
		Town notSoOriginal = new Town("Original");
		assertNotSame(original, notSoOriginal);
		assertSame(original, original);
	}

}
