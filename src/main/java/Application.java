/**
 * Classe applicative montrant un EXEMPLE de création d'une grille
 * et de son affichage dans une fenêtre graphique.
 */
public class Application {

	/**
	 * Point d'entrée du programme exécutable
	 * @param args Paramètre non utilisé
	 */
	public static void main(String[] args) {
		// Création de la grille
		
		Grille grille = new Grille(Constante.N,Constante.M, new Monde(5000,60, 80));
		// Création et affichage de la fenêtre graphique
		Fenetre fenetre = new Fenetre("Un monde de choses",grille);

		// Entre deux évolutions d'un monde, il est nécessaire de faire une pause
		// pour l'affichage au moyen du code suivant.
		boolean flag = false;
		try {
			while(!flag){
				Thread.sleep(Constante.pauseTempsMs);
				flag =grille.dessiner();
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
