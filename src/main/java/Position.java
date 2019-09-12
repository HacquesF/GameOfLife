import java.util.Random;
/**
 * Classe permettant de gérer des positions sur un plan
 * @author NYUNTING HACQUES
 * @version Beta
 * @since 2015
 */
public class Position implements Comparable<Position>{
//Attributs--------------------------------------------------
	private int x;
	private int y;
	
//Constructeurs----------------------------------------------
	/**
	 * Construit une Position à partir de ces coordonnées
	 * @param x abscisse de la Position
	 * @param y ordonnée de la Position
	 */
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * Construit une Position aléatoire avec une abscisse entre 0 et Constante.M et une ordonnée entre 0 et Constante.N
	 */
	public Position(){
		Random rng = new Random();
		this.x = rng.nextInt(Constante.M+1);
		this.y = rng.nextInt(Constante.N+1);
	}
	/**
	 * Construit une Position en copiant une autre Position
	 * @param p Position a copier
	 */
	public Position(Position p){
		this(p.x,p.y);
	}
	/**
	 * Getter permettant d'avoir accès à l'abscisse d'une Position
	 * @return l'abscisse de la Position
	 */
//Getters, toString------------------------------------------
	public int getX() {
		return x;
	}
	
	/**
	 * Getter permettant d'avoir accès à l'ordonnée d'une Position
	 * @return l'ordonnée de la Position
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Met en chaîne de caractères les coordonnées d'une position
	 * Setrouorne une chaîne (x, y)
	 */
	public String toString(){
		return "( " + this.x + " , " + this.y +" )";
	}
	
//Méthodes principales---------------------------------------
	/**
	 * Deplace une position à de nouvelles coordonnées donnée
	 * @param x Nouvelle abscisse
	 * @param y Nouvelle ordonnée
	 */
	public void Deplacer(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Deplace une Position à une nouvelle Position donnée
	 * @param p Nouvelle Position pour le déplacement
	 */
	public void deplacer(Position p){
		Deplacer(p.x, p.y);
	}
	
	
	/**
	 * Vérifie si la Position est à côté d'une autre sur le plan
	 * @param P Position à vérifier si est voisine
	 * @return true si les positions sont à côté, false sinon
	 */
	public boolean isVoisin(Position P){
		return (Math.abs(this.x-P.x) + Math.abs(this.y-P.y))==1;
	}
	
//Méthodes overridés-----------------------------------------
	/**
	 * Override de la méthode equals() afin de pouvoir vérifier si deux positions partagent les mêmes coordonnées.
	 *	@return true si les positions partagent les mêmes coordonnées, false sinon.
	 */
	public boolean equals(Object b){
		if(this == b){
			return true;
		}
		if(b instanceof Position){
			Position p = (Position) b;
			return (this.x == p.getX()) && (this.y == p.getY());
		}else{
			return false;
		}
	}
	
	/**
	 * Override la méthode compareTo() afin de pouvoir comparer deux positions
	 *	@return 0 si les deux positions partagent les mêmes coordonnées, 1 si l'abscisse ou l'ordonnée d'une position est inférieure à celle de la postion en paramètre. -1 sinon. 
	 */
	public int compareTo(Position pos){
		if(this.equals(pos)){
			return 0;
		}
		if(this.x == pos.x){
			return (this.y < pos.y) ? -1 : 1;
		}else{
			return (this.x < pos.x) ? -1 : 1;
		}
		
	}
}
