import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Classe abstraite permettant de représenter toutes choses "vivantes" sur un plan
 * @author NYUNTING HACQUES
 * @version Beta
 * @since 2015
 */
public abstract class Chose {
//Attributs--------------------------------------------------
	protected int age;
	protected Forme forme;
	protected Color col;
	protected Position pos;
	
//Constructeur-----------------------------------------------
	/**
	 * Construit une Chose à l'âge 0 avec une forme, couleur et Position donnés
	 * @param f Forme à donner à la Chose
	 * @param c Couleur à donner à la Chose
	 * @param p Position à donner à la Chose
	 */
	public Chose(Forme f, Color c, Position p){
		this.age = 0;
		this.forme = f;
		this.col = c;
		this.pos = p;
	}
	
//Méthodes principales---------------------------------------
	/**
	 * Fonction abstraite permettant de faire viellir une Chose si elle est vivante
	 * @return true si la Chose est vivante après viellissement, false sinon
	 */
	public abstract boolean vieillir();
	/**
	 * Fonction abstraite permettant de savoir si une Chose à atteint sa maturité sexuelle
	 * @return true si la Chose est mature, false sinon
	 */
	public abstract boolean isMature();
	/**
	 * Fonction abstraite permettant de savoir si la Chose peut se reproduire avec une autre donnée.
	 * Pour que deux Choses puissent se reproduire il faut qu'elles soient toutes les deux matures et d'une espèce compatible au minimum
	 * @param c Chose avec laquelle on veut vérfier si la reproduction est possible
	 * @return true si ils peuvent se reproduire, false sinon
	 */
	public abstract boolean reproduction(Chose c);
	/**
	 * Fonction permettant de dessiner une Chose suivant sa forme, couleur et Position dans le Graphics2D donné
	 * @param g2d Graphics2D sur lequel on veut dessiner la Chose
	 */
	public  void dessiner(Graphics2D g2d){
		forme.Dessiner(g2d,pos, col);
	}
	/**
	 * Fonction permettant de savoir si la Chose est à côté d'une autre donnée d'après leurs Position sur un plan
	 * @param c Chose à vérifier si est voisine
	 * @return true si les Chose sont à côté, false sinon
	 */
	public boolean isVoisin(Chose c){
		return this.pos.isVoisin(c.pos);
	}
	/**
	 * Deplace une Chose à de nouvelles coordonnées donnée
	 * @param x Nouvelle abscisse
	 * @param y Nouvelle ordonnée
	 */
	public void Deplacer(int x, int y){
		pos.Deplacer(x, y);
	}
	
	/**
	 * Deplace une Chose à une nouvelle Position donnée
	 * @param p Nouvelle Position pour le déplacement
	 */
	public void Deplacer(Position p){
		pos.deplacer(p);
	}
	
	/**
	 * Getter permettant de connaître l'âge actuel d'une Chose
	 * @return L'âge actuel d'une Chose
	 */
	 
//Getters et toString----------------------------------------------------
	public int getAge() {
		return age;
	}
	/**
	 * Getter permettant de connaître la Forme d'une Chose
	 * @return La forme actuel d'une Chose
	 */
	public Forme getForme() {
		return forme;
	}
	/**
	 * Getter permettant de connaître la Couleur d'une Chose
	 * @return La Couleur actuel d'une Chose
	 */
	public Color getCol() {
		return col;
	}
	/**
	 * Getter permettant de connaître la Position actuel d'une Chose
	 * @return La Position actuel d'une Chose
	 */
	public Position getPos() {
		return pos;
	}
	public String toString(){
		return "Age: " + age + ", Forme: " + forme + ", Couleur: " + col+ ", Position: " +pos;
	}
}
