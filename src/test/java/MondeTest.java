import junit.framework.*;

public class MondeTest extends TestCase{
	public void testViellissement(){
		Monde m = new Monde(20);
		m.evolution();
		assertTrue(m.getTempcour() >0);
	}
	public void testDateApocalypse(){
		Monde m = new Monde(20);
		for(int i = 0; i<25; i++){
			m.evolution();
		}
		assertTrue(m.isApo());
	}
	public void testPosAleaLibre(){
		Monde m = new Monde(20);
		Position p = m.posAleaLibre();
		assertTrue(m.estLibre(p));
	}
	public void testPosAleaPlusLibre(){
		Monde m = new Monde(20);
		Position p = m.posAleaLibre();
		m.ajoutPop(new Mouche(p));
		assertFalse(m.estLibre(p));
	}
	public void testEpidemie(){
		Monde m = new Monde(20,100);
		m.epidemie();
		assertTrue(m.getNbPop() == 85);//15% de 100
	}
	public void testMortApocalypse(){
		Monde m = new Monde(20,100);
		m.apocalypse();
		assertTrue(m.getNbPop() == 0);
	}
}
