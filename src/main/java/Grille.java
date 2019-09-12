import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Grille d'un monde gérant l'ensemble des positions libres
 * ou occupées par des choses.
 */
public class Grille extends JPanel {
//Attributs--------------------------------------------------
	// Dimensions de la grille : 0..N lignes et 0..M colonnes
	private int N;
	private int M;

	// Dimensions de la fenêtre d'affichage en pixels
	private int largeur;
	private int hauteur;
	//Monde représenté
	private Monde world;
	
//Constructeur et getters-----------------------------------
	/**
	 * Constructeur
	 * @param N N+1 lignes indicées de 0 à N
	 * @param M M+1 colonnes indicées de 0 à M
	 */
	public Grille(int N, int M, Monde world) {
		// dimensions pour les positions
		this.N = N;
		this.M = M;
		this.world = world;
		// dimensions de la fenêtre
		largeur = Constante.Pix*(this.M+2);
		hauteur = Constante.Pix*(this.N+2);
		setPreferredSize(new Dimension(largeur,hauteur));
	}

	/**
	 * @return Hauteur de la fenêtre graphique en pixels
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * @return Largeur de la fenêtre graphique en pixels
	 */
	public int getLargeur() {
		return largeur;
	}
	
	/**
	 * @return Monde représenté par la fenêtre graphique
	 */	
	public Monde getMonde() {
		return world;
	}

//Méthodes principales--------------------------------------
	/**
	 * Méthode publique de dessin de la grille dans la fenêtre graphique
	 */
	public boolean dessiner() {
		repaint();  // appel de paintComponent redéfinie ci-après
		return world.isApo();
	}

	/**
	 * Dessin effectif de la grille
	 * @param g Composant graphique de dessin
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		// fond de la grille
		Color couleur = new Color(80,80,80);
		g2d.setColor(couleur);
		g2d.fillRect(0,0,largeur,hauteur);

		// superposition des couleurs
		g2d.setXORMode(couleur);
		
		// Fait avancer le monde et le met à jour
		world.evolution();
		//Dessine les Choses et la grille
		world.dessiner(g2d);
	}

}
