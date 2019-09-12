import java.awt.Color;

import junit.framework.*;


public class ChameleonTest extends TestCase{
	public void testMaturiteSup(){
		Chameleon c = new Chameleon(new Position());
		for(int i = 0; i<Constante.cAgeMature +5; i+=2){
			c.vieillir();
		}
		assertTrue(c.isMature());
	}
	public void testMaturiteEgale(){
		Chameleon c = new Chameleon(new Position());
		for(int i = 0; i<Constante.cAgeMature; i+=2){
			c.vieillir();
		}
		assertTrue(c.isMature());
	}
	public void testPasMature(){
		Chameleon c = new Chameleon(new Position());
		for(int i = 0; i<(Constante.cAgeMature)/2; i+=2){
			c.vieillir();
		}
		assertFalse(c.isMature());
	}
	public void testMort(){
		Chameleon c = new Chameleon(new Position());
		for(int i = 0; i<(Constante.cAgeMort); i+=2){
			c.vieillir();
		}
		assertFalse(c.vieillir());
	}
	public void testPasMort(){
		Chameleon c = new Chameleon(new Position());
		for(int i = 0; i<(Constante.cAgeMort)/2; i+=2){
			c.vieillir();
		}
		assertTrue(c.vieillir());
	}
	public void testEnfant(){
		Chameleon c = new Chameleon(new Position());
		Chameleon v = new Chameleon(new Position());
		for(int i = 0; i<(Constante.cAgeMature); i+=2){
			c.vieillir();
			v.vieillir();
		}
		assertTrue(c.reproduction(v));
	}
	public void testPasEnfant(){
		Chameleon c = new Chameleon(new Position());
		Chameleon v = new Chameleon(new Position());
		for(int i = 0; i<(Constante.cAgeMature)/2; i+=2){
			c.vieillir();
			v.vieillir();
		}
		assertFalse(c.reproduction(v));
	}
	public void testDeplacer(){
		Chameleon c = new Chameleon(new Position());
		Position p = new Position();
		c.Deplacer(p);
		assertTrue(c.getPos().equals(p));
	}
	public void testCouleurChanger(){
		Chameleon c = new Chameleon(new Position());
		Color co = c.getCol();
		for(int i = 0; i<(Constante.cAgeCoul); i+=2){
			c.vieillir();
		}
		assertTrue(!co.equals(c.getCol())); //255³ de risque d'un faux négatif
	}
	public void testCouleurPasChanger(){
		Chameleon c = new Chameleon(new Position());
		Color co = c.getCol();
		for(int i = 0; i<(Constante.cAgeCoul)/2; i+=2){
			c.vieillir();
		}
		assertTrue(co.equals(c.getCol()));
	}
}
