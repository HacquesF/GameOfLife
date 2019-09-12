import java.awt.Color;
import java.util.Random;
/**
 * Classe permettant de représenter un Chameleon suivant la définition d'une Chose
 * @author NYUNTING HACQUES
 * @version Beta
 * @since 2015
 */
public class Chameleon extends Chose{
//Constructeur-----------------------------------------------
	/**
	 * Construit un Chaméléon à l'âge 0, avec la couleur définit par Constante.cCouleurInit, à une position donnée.
	 * @param p Position d'apparition du Chameleon
	 */
	public Chameleon(Position p){
		super(new Rectangle(), Constante.cCouleurInit, p);
	}
//Méthodes principales---------------------------------------
	/**
	 *Vérifie si un caméléon est mature
	 *@return true si age >= age de maturité, false sinon
	 */
	public boolean isMature(){
		return this.age >= Constante.cAgeMature;
	}
	
	/**
	 *Faire vieillir un caméléon de 2 ans et vérifie ce caméléon reste en vie (true = vivante, false meurt)
	 *@return true si age <= age maximale, false si age > age maximale
	 */
	public boolean vieillir(){
		this.age +=2;
		this.changerCol();
		return this.age <= Constante.cAgeMort;
	}
	
	/**
	 *Vérifie si deux caméléons peuvent se reproduire
	 *@return true si les deux choses sont des caméléons matures, sinon false.
	 */	
	public boolean reproduction(Chose c){
		if( !(this.isMature() && c.isMature()) ){
			return false;
		}
		if( !(c instanceof Chameleon)){
			return false;
		}
		return true;
	}
	
	/**
	 * Vérifie si le caméléon mange la Chose
	 * @return false si la Chose n'est pas une Mouche, sinon true
	 */
	public boolean manger(Chose c){
		if( !(c instanceof Mouche)){
			return false;
		}
		return true;
	}
	
	/**
	 * Fait changer la couleur des caméléons s'ils ont le droit.
	 * Ne fais rien si l'age du caméléon < age de changement de couleur mis en place dans Constante
	 * Sinon, un changement de couleur aléatoire sur la palette RGB.
	 */
	private void changerCol(){
		if(age < Constante.cAgeCoul){
			return;
		}
		Random r = new Random();
		this.col = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	}
}
