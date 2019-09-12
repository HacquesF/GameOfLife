import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;


/**
 * Classe permettant de représenter et faire évoluer un monde composé de Chose
 * @author NYUNTING HACQUES
 * @version Beta
 * @since 2015
 */
public class Monde {
//Attributs--------------------------------------------------
	private ArrayList<Chose> pop;
	private int tempscour;
	private int tempstot;
	private ArrayList<Position> place;
	/**
	 * Constructeur faisant un monde vide au temps 0
	 * @param tempstot Entier représentant la date à laquelle la fin du monde arrive
	 */
	 
//Constructeurs-----------------------------------------------
	/**
	 * Construit un monde vode à temps 0, et à temps total donnée en paramètre
	 * @param tempstot Entier représentant la date à laquelle la fin du monde arrive
	 */
	public Monde(int tempstot){
		this.tempstot = tempstot;
		this.pop = new ArrayList<Chose>();
		this.tempscour = 0;
		this.place = new ArrayList<Position>();
		initPos();
	}
	
	/**
	 * Construit un monde à temps total donnée en paramètre avec une population 
	 * de caméléons et mouches predéfinie.
	 * @param tempstot Entier représentant la date à laquelle la fin du monde arrive
	 * @param cham Entier représentant le nombre de caméléons initial
	 * @param mou Entier représentant le nombre de mouches initial
	 */
	 
	public Monde(int tempstot, int cham, int mou){
		this(tempstot);
		initPos();
		for (int i = 0; i < cham; ++i){
			Position x = posAleaLibre();
			if(x != null){
				ajoutPop(new Chameleon(x));
			}else{
				return;
			}
		}
		for (int i = 0; i < mou; ++i){
			Position x = posAleaLibre();
			if(x != null){
				ajoutPop(new Mouche(x));
			}else{
				return;
			}
		}
	}
	
	
	/**
	 * Construit le Monde à partir d'un nombre de Chose totale, les choses sont choisie aléatoirement entre des Chaméléons et des Mouches
	 * @param tempstot Entier représentant la date à laquelle la fin du monde arrive
	 * @param nbpop Entier donnant la population initiale à installer dans le monde
	 */
	public Monde(int tempstot, int nbpop){
		this(tempstot);
		Random Choix = new Random();
		for(int i = 0; i< nbpop; i++){
			Position p = posAleaLibre();
			if(p == null){
				return;//Ajouter une exception
			}
			if(Choix.nextBoolean()){
				ajoutPop(new Chameleon(p));
			}else{
				ajoutPop(new Mouche(p));
			}
		}		
	}
	
//Getter----------------------------------------------------
	/**
	 * Getter donnant le nombre de Chose présentes dans le monde
	 * @return Le nombre de Chose dans le Monde
	 */
	public int getNbPop(){
		return pop.size();
	}
	/**
	 * Getter donnant le temps courant du  monde
	 * @return le temps courant du  monde
	 */
	public int getTempcour(){
		return tempscour;
	}
	/**
	 * Getter donnant la date de fin du monde
	 * @return la date de fin du monde
	 */
	public int getTemptot(){
		return tempstot;
	}
	
//Méthodes principales---------------------------------------
//Gestion de population et de position-----------------------

	/**
	 * Fonction ajoutant une Chose donné à la population du monde si il reste de la place
	 * @param e Chose à rajouter au monde
	 */
	public void ajoutPop(Chose e){
		if(place.size()>0){
			this.pop.add(e);
			place.remove(e.getPos());
		}
	}
	
	/**
	 * Fonction permettant de considérer le monde entier comme étant libre
	 */
	private void initPos(){
		place.clear();
		pop.clear();
		for(int i = 0; i<=Constante.M; i++){
			for(int j = 0; j<=Constante.N; j++){
				this.place.add(new Position(i,j));
			}
		}
	}
	
	/**
	 * Fonction permettant de savoir si une position du Monde est vide
	 * @param p Position que l'on souhaite savoir si est vide
	 * @return true si la position est vide, false sinon
	 */
	public boolean estLibre(Position p){
		return place.contains(p);	
	}
	
	/**
	 * Fonction permettant d'avoir une position libre aléatoire du Monde
	 * @return Une position aléatoire libre présente dans le monde
	 */
	public Position posAleaLibre(){//placement inital des choses
		Random r= new Random();
		
		return (place.size() > 0) ? place.get(r.nextInt(place.size())): null;
	}
	
	/**
	 * Fonction permettant de considérer une position libre
	 * @param p Position à libérer
	 */
	private void LibererPosition(Position p){
		if(!place.contains(p)){
			place.add(p);
		}
	}
	
	/**
	 * Fonction permettant de récupérer toutes les position libres adjacente à une chose du Monde
	 * @param itPop Entier représentant la position dans le tableau de la population d'une Chose
	 * @return Un tableau de Position libre et adjacente à la Chose donné
	 */
	public Position[] posAdjLibre(int itPop){
		ArrayList<Position> posLibre = new ArrayList<Position>();
		if(pop.get(itPop).getPos().getX() +1 <= Constante.M){
			posLibre.add(new Position(pop.get(itPop).getPos().getX() +1 , pop.get(itPop).getPos().getY()));
		}
		if((pop.get(itPop).getPos().getX() -1 >= 0)){
			posLibre.add(new Position(pop.get(itPop).getPos().getX() -1, pop.get(itPop).getPos().getY()));
		}
		if((pop.get(itPop).getPos().getY() +1 <= Constante.N)){
			posLibre.add(new Position(pop.get(itPop).getPos().getX() , pop.get(itPop).getPos().getY() +1 ));
		}
		if((pop.get(itPop).getPos().getY() -1 >= 0)){
			posLibre.add(new Position(pop.get(itPop).getPos().getX() , pop.get(itPop).getPos().getY() -1 ));
		}
		
		for(Chose c: pop){
			if(c.isVoisin(pop.get(itPop))){
				posLibre.remove(c.getPos());
			}
		}
		
		Position [] res = new Position[posLibre.size()];
		for(int i = 0; i< posLibre.size(); i++){
			res[i] = posLibre.get(i);
		}
		
		return res;
	}
	
	/**
	 * Fonction permettant de dessiner toute la population du Monde et mettre un point blanc sur les position libres
	 * @param g2d Composant graphique pour le dessin
	 */
	public void dessiner(Graphics2D g2d){
		for(Chose c : pop){ //parcours list Chose et dessinne les éléments
			c.dessiner(g2d);
		}
		for(Position p : place){ // parcours place libres et dessinne les points blancs pour chaque poition libre
			g2d.setColor(Color.WHITE);
			g2d.fillOval((p.getX()+1)*Constante.Pix,(p.getY()+1)*Constante.Pix,3,3);
		}
	}
			
	
//Gestion des événements-------------------------------------

	/**
	 * Fonction permettant de simuler une épidémie dans le monde supprimant aléatoirement 15% de la population totale du Monde
	 */
	public void epidemie(){
		int cpt;
		Random rnd = new Random();
		cpt = (15 * pop.size()) / 100;
	
		for ( int i = 0; i< cpt && pop.size()>0 ; ++ i){
			int choix = rnd.nextInt(pop.size());
			LibererPosition(pop.get(choix).getPos());
			pop.remove(choix);
		}
	}
	
	/**
	 * Fonction permettant de faire essayer de reproduire la population entière du monde avec leurs voisins. Les enfants seront créés sur des positions adjacentes libre des parents
	 */
	public void chaleur(){
		ArrayList<Chose> aEnfant = new ArrayList<Chose>();
		for (int i = 0 ; i < pop.size() ; ++i){
			Chose Maman = pop.get(i);
			for (int j= 0; j < pop.size() && !aEnfant.contains(Maman); ++j){
				Chose Papa = pop.get(j);
				if((Maman.getPos().isVoisin(Papa.getPos()))&&(Maman.reproduction(Papa))){
					Position[] posLibrePapa = posAdjLibre(i);
					Position[] posLibreMaman = posAdjLibre(j);
					Position choix = null;
					boolean enfant= false;
					Random r = new Random();
					if(posLibreMaman.length > 0){ //mere en priorite pour position libre
						choix = posLibreMaman[r.nextInt(posLibreMaman.length)];
						enfant = true;
					}else if(posLibrePapa.length > 0){
						choix = posLibrePapa[r.nextInt(posLibrePapa.length)];
						enfant = true;
					}
					if(enfant){
						if(Maman instanceof Mouche){
							ajoutPop(new Mouche(choix));
						}else{
							if(Maman instanceof Chameleon){
								ajoutPop(new Chameleon(choix));
							}
						}
						aEnfant.add(Maman);
						aEnfant.add(Papa);
					}
				}
			}
		}
	}
	
	/**
	 * Fonction permettant aux caméléons de manger maximum 1 mouche adjacente
	 */
	public void manger(){
		for( Chose C : pop){
			if(C instanceof Chameleon){
				int j = 0;
				boolean aMange = false;
				while(j<pop.size() && aMange){
					if(C.isVoisin(pop.get(j))){
						if(pop.get(j) instanceof Mouche){
							LibererPosition(pop.get(j).getPos());
							pop.remove(j);
							aMange = true;
						}
					}
					j++;
				}		
			}
		}
	}
	
	/**
	 * Permmet de déplacer toutes les choses sur une position adjacente libre si au moins une est disponible
	 * Afin de pouvoir récuperer les position liberé, une copie de la position est nécessaire.
	 */
	public void deplacer(){
		Random rng = new Random();
		int k;
		for (int i = 0; i < pop.size() ; ++i){
			Position pos[] = posAdjLibre(i);
			if(pos.length > 0){
				k = rng.nextInt( pos.length );
				LibererPosition(new Position(pop.get(i).getPos()));//Besoin de copie de la position
				
				pop.get(i).Deplacer(pos[k]);
				place.remove(pos[k]);
			}
		}
	}
	
	/**
	 * Fonction faisant avancer le monde d'un an, fait vieillir toute la population, lance les chaleurs tous les 8 ans, une épidémie tous les 15 ans.
	 * De plus chaques année fait les chaméléons mange une mouche adjacentes si possible et permet à la population de se déplacer
	 * Fait appel à la méthode apocalypse() si isApo() true ==> La simulation est 
	 * finie à tempstot.
	 */
	public void evolution(){
		this.tempscour ++;
		if(!isApo()){
			for (int i = 0; i < pop.size(); ++i){
				if(!pop.get(i).vieillir()){
					LibererPosition(pop.get(i).getPos());
					pop.remove(i);
					i--;
				}
			}
			if(tempscour % 8 == 0){
				this.chaleur();
			}		
			if(tempscour % 15 == 0){
				this.epidemie();
			}		
			this.manger();		
			this.deplacer();
		}else{
			apocalypse();
		}
	}
	
	/**
	 * Fonction permettant de savoir si l'apocalypse à eu lieu
	 * @return true si l'apocalypse est passée, false sinon
	 */
	public boolean isApo(){
		return tempscour > tempstot;
	}
	
	/**
	 * Créer une apocalypse supprimant toute la population et considérant le monde entièrement libre de Choses
	 */
	public void apocalypse(){
		initPos(); //toute position est libérée
	}
}
