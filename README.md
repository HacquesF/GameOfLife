# GameOfLife
Simple game of life showing chameleon and flies evolving on a grid

# Rules
  * A chameleon lives for 150 years before dying at his 151 birthday, a fly dies when 100 years old. Chameleon are matures, and therefore can reproduce, starting at 80 y.o. and the fly at 20.
  * Chameleon are born green, but they wll change color at each steps starting at 20 y.o.. Flies stays blue forever.
  * At each steps, a chameleon eat at most one fly adjacent to its position, but not from its corners.
  * If two things of the same type are matures and adjacent, then a new things of the same type will appear on an adjacent case. If no cases are free, then no creature will be born.
  * At each steps in the world (t+1):
    * Chameleons ages 2 years and flies 5.
    * for each `t mod 8 = 0`, things can reproduce following previous rule.
    * for each `t mod 15 = 0`, a percentage of randomly choosen creatures dies of diseases.
    * Each things walks to an adjacent position randomly choosen.
  * At a selected number of step, the world ends and everyone dies.
    
# Usage
Compile with `mvn clean package`
Execute `gameoflife-1.0.jar` located in target folder

# Credit
Work done in collaboration with [noel5550](https://github.com/noel5550) at a 3rd year university course at Université de Nantes

---

# Jeu de la Vie
Simple jeu de la vie montrant des chaméléons et des mouches évoluer sur une grille.

# Règles
  * Un caméléon vit à 150 avant de mourir à ses 151 ans et une mouche meurt à ses 100 ans. Un caméléon est mature (peut se reproduire) à 80 ans, et une mouche à 20 ans. 
  * Un caméléon est né vert, mais change de couleur à chaque évolution du monde à partir de ses 20 ans. Une mouche passe toute sa courte vie bleue.
  * À chaque tour, un caméléon mange au plus une mouche qui se trouve sur une position adjacente latéralement et longitudinalement de lui.
  * Si deux choses matures de même type se trouvent adjacentes à l'une et à l'autre, une chose de même type d'age 0 apparaîtra sur une position adjacentes libres des deux choses. Si aucune position est libre, aucune nouvelle chose apparaîtra.
  * Sur chaque évolution du monde (t+1) :
    * Les caméléons vieillissent de 2 ans et les mouches de 5 ans.
    * Pour chaque t mod 8 = 0, les choses peuvent se procréer en respectant les règles de procréation écrites an dessus. (saison de reproduction)
    * Pour chaque t mod 15 = 0, un pourcentage (à fixer) de la population totale est choisi de manière aléatoire et meurt (épidémie)
    * Chaque chose se déplace aléatoirement sur une position adjacente libre.
  * Lorsque un temps max est atteint, le monde sera détruit et la population de ce monde meurt.
  
# Utilisation
Compiler avec `mvn clean package`
Executer `gameoflife-1.0.jar` situé dans le dossier target

# Credit
Travail fait en collaboration avec [noel5550](https://github.com/noel5550) durant un cours de notre Licence 3 à L'Université de Nantes
