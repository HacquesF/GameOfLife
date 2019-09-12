import junit.framework.*;

public class MoucheTest extends TestCase{
	public void testMaturiteSup(){
		Mouche c = new Mouche(new Position());
		for(int i = 0; i<Constante.mAgeMature +5; i+=5){
			c.vieillir();
		}
		assertTrue(c.isMature());
	}
	public void testMaturiteEgale(){
		Mouche c = new Mouche(new Position());
		for(int i = 0; i<Constante.mAgeMature; i+=5){
			c.vieillir();
		}
		assertTrue(c.isMature());
	}
	public void testPasMature(){
		Mouche c = new Mouche(new Position());
		for(int i = 0; i<(Constante.mAgeMature)/2; i+=5){
			c.vieillir();
		}
		assertFalse(c.isMature());
	}
	public void testMort(){
		Mouche c = new Mouche(new Position());
		for(int i = 0; i<(Constante.mAgeMort); i+=5){
			c.vieillir();
		}
		assertFalse(c.vieillir());
	}
	public void testPasMort(){
		Mouche c = new Mouche(new Position());
		for(int i = 0; i<(Constante.mAgeMort)/2; i+=5){
			c.vieillir();
		}
		assertTrue(c.vieillir());
	}
	public void testEnfant(){
		Mouche c = new Mouche(new Position());
		Mouche v = new Mouche(new Position());
		for(int i = 0; i<(Constante.mAgeMature); i+=5){
			c.vieillir();
			v.vieillir();
		}
		assertTrue(c.reproduction(v));
	}
	public void testPasEnfant(){
		Mouche c = new Mouche(new Position());
		Mouche v = new Mouche(new Position());
		for(int i = 0; i<(Constante.mAgeMature)/2; i+=5){
			c.vieillir();
			v.vieillir();
		}
		assertFalse(c.reproduction(v));
	}
	public void testDeplacer(){
		Mouche c = new Mouche(new Position());
		Position p = new Position();
		c.Deplacer(p);
		assertTrue(c.getPos().equals(p));
	}
}
