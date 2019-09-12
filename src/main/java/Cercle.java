import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Classe permettant de représenter un Cercle suivant la définition d'une Forme
 * @author NYUNTING HACQUES
 * @version Beta
 * @since 2015
 */
public class Cercle implements Forme {
//Attributs--------------------------------------------------
	private int width;
	
//Constructeur, getter et toString---------------------------
	//Diamètre du cercle = taille constante dans la classe Constante
	public Cercle(){
		width = Constante.TailleCercle;
	}
	/**
	 * @return width du cercle en pixels
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return "Diametre: width" en chaîne de caractères
	 */
public String toString(){
		return "Diametre: " + width;
	}
	
//Methode de dessin------------------------------------------
	/**
	 * Fait appel à la methode Dessiner de Forme pour faire un cercle de couleur col, à pos et de diamètre width
	 */
	public void Dessiner(Graphics2D g2d, Position pos, Color col){
		g2d.setColor(col);
		g2d.fillOval((pos.getX()+1)*Constante.Pix, (pos.getY()+1)*Constante.Pix, width, width);
	}
	
}
