import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Interface permettant de représenter une Forme
 * @author NYUNTING HACQUES
 * @version Beta
 * @since 2015
 */
public interface Forme {
	//Méthode de dessin pour une forme donnée
	public void Dessiner(Graphics2D g2d, Position pos, Color col);
}
