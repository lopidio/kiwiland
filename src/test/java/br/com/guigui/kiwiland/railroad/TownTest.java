package br.com.guigui.kiwiland.railroad;

import junit.framework.TestCase;

public class TownTest extends TestCase
{

	public void testAddGetTrack()
	{
		Town townsVille = new Town("TownsVille");
		Town alameda = new Town("Alameda dos Anjos");
		Track trackToAlameda = new Track(townsVille, alameda, 10);

		assertEquals(0, townsVille.getTracks().size());
		assertFalse(townsVille.getTracks().stream().findFirst().isPresent());
		townsVille.addTrack(trackToAlameda);
		assertTrue(townsVille.getTracks().stream().findFirst().isPresent());
		assertEquals(1, townsVille.getTracks().size());

		Town fortaleza = new Town("Fortaleza");
		Track trackToFortaleza = new Track(townsVille, fortaleza, 10);
		townsVille.addTrack(trackToFortaleza);
		assertEquals(2, townsVille.getTracks().size());
		
		Track inverseTrack = new Track(fortaleza, townsVille, 10);
		assertFalse(townsVille.addTrack(inverseTrack));
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
