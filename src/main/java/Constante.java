import java.awt.Color;

/**
 * Classe de définition de toutes les constantes apparaissant
 * dans le projet.
 */
public class Constante {
	
	/**
	 *  Dimensions de la grille
	 *     - N+1 lignes numérotées de 0 à N
	 *     - M+1 colonnes numérotées de 0 à M
	 */
	public static final int N = 10; //y
	public static final int M = 20; //x

	/**
	 * Un point (x,y) est affiché sur le pixel ((x+1)*Pix, (y+1)*Pix)
	 */
	public static final int Pix = 30;

	/**
	 * Délai en millisecondes entre deux affichages du monde
	 */
	public static final int pauseTempsMs = 1000;
	
	// Constantes pour les mouches
	public static final int mAgeMature = 20; //age de maturité
	public static final int mAgeMort = 99; //age maximale
	public static final Color mCouleur = Color.BLUE; //couleur
	// Constantes pour les caméléons 
	public static final int cAgeMort = 150; //age maximale
	public static final int  cAgeMature = 80; //age de maturité
	public static final int cAgeCoul = 20; //age de début de changement de couleur
	public static final Color cCouleurInit = Color.GREEN; //couleur initiale
	// Constantes pour les cercles
	public static final int TailleCercle = 5; //diamétre du cercle
	// Constant pour les rectangles
	public static final int LargRect = 5; //largeur du rectangle
	public static final int LongRect = 7; //longueur du rectangle

}
