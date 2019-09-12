/**
 * Classe permettant de représenter une Mouche suivant la définition d'une Chose
 * @author NYUNTING HACQUES
 * @version Beta
 * @since 2015
 */
public class Mouche extends Chose{
//Constructeur-----------------------------------------------
	/**
	 * Construit l'objet Mouche en position p avec une forme Cercle, d'une couleure prédefini dans Constante.
	 * @param p Position d'apparition de la mouche
	 */
	public Mouche(Position p){
		super(new Cercle(), Constante.mCouleur, p);
	}

//Méthodes principales---------------------------------------
	/**
	 *Vérifie si une mouche est mature
	 *@return true si age >= age de maturité, false sinon
	 */
	public boolean isMature(){
		return this.age >= Constante.mAgeMature;
	}
	
	/**
	 *Faire vieillir une mouche de 5 ans et vérifie si elle reste en vie (true = vivante, false meurt)
	 *@return true si age <= age maximale, false si age > age maximale
	 */
	public boolean vieillir(){
		this.age +=5;
		return this.age <= Constante.mAgeMort;
	}
	
	/**
	 *Vérifie si deux mouches peuvent se reproduire
	 *@return true si les deux choses sont des mouches matures, sinon false.
	 */
	public boolean reproduction(Chose c){
		if( !(this.isMature() && c.isMature()) ){
			return false;
		}
		if( !(c instanceof Mouche)){
			return false;
		}
		return true;
	}
}
