import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Classe permettant de représenter un Rectangle suivant la définition d'une Forme
 * @author NYUNTING HACQUES
 * @version Beta
 * @since 2015
 */
public class Rectangle implements Forme {
//Attributs--------------------------------------------------
	private int width;
	private int height;
	
//Constructeur, getters et toString--------------------------
	/**
	 * width = Largeur du rectange
	 * height= Longeur du rectangle
	 */
	public Rectangle(){
		width = Constante.LargRect;
		height = Constante.LongRect;
	}
	
	/**
	 * @return width du rectangle en pixels
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return height du rectangle en pixels
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return "Largeur: width, Hauteur: height" en chaîne de caractères
	 */
	public String toString(){
		return "Largeur: " + width + ", Hauteur: " + height;
	}
	
//Méthode d'affichage----------------------------------------	
	/**
	 * Fait appel à la methode Dessiner de Forme pour faire un rectangle de couleur col, à pos et de longeur height et largeur width
	 */
	public void Dessiner(Graphics2D g2d, Position pos, Color col){
		g2d.setColor(col);
		g2d.fillRect((pos.getX()+1)*Constante.Pix, (pos.getY()+1)*Constante.Pix, width, height);
	}
	
}
