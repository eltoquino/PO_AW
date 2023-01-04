/** package principal */
package main;
import librairies.AssociationTouches;
import librairies.StdDraw;
import main.terrain.Plaine;
import main.terrain.Terrain;
import ressources.Config;
import ressources.ParseurCartes;
import ressources.Affichage;
import ressources.Chemins;

public class Jeu {
	private int indexJoueurActif; //l'indice du joueur actif:  1 = rouge, 2 = bleu
	// l'indice 0 est reserve au neutre, qui ne joue pas mais peut posseder des proprietes
	public Jeu(String fileName) throws Exception {
		//appel au parseur, qui renvoie un tableau de String 
		String map = "";
		String[][] carteString = ParseurCartes.parseCarte(fileName);
		Config.setDimension(carteString[0].length, carteString.length);// initialise la configuration avec la longueur de la carte
		for (int i = 0; i<carteString.length; i++) {
			for (int j=0; j < carteString[0].length; j++){
				map=map+carteString[i][j];
				if (j != carteString[0].length) {
						System.out.print(" ");
						map=map+" ";
					}
				else {
					System.out.println();
				}
			}
			map.split(" ");
			
			//System.out.println();
		}	
		System.out.println(map);
		// a vous de manipuler ce tableau de String pour le transformer en une carte avec vos propres classes, a l'aide de la methode split de la classe String


		afficheCarte(carteString);
		
		
		indexJoueurActif = 1; // rouge commence
	}
	public void afficheCarte(String[][]map) {
		for (int i = 0; i<map.length; i++) {
			for (int j=0; j < map[0].length; j++){
				if (map[i][j].compareTo("Plaine")==0){
					Affichage.dessineImageDansCase(j, i, Chemins.getCheminTerrain(Chemins.FICHIER_PLAINE));
				}
				if (map[i][j].compareTo("Foret")==0){
					Affichage.dessineImageDansCase(j, i, Chemins.getCheminTerrain(Chemins.FICHIER_FORET));
				}
				if (map[i][j].compareTo("Montagne")==0){
					Affichage.dessineImageDansCase(j, i, Chemins.getCheminTerrain(Chemins.FICHIER_MONTAGNE));
				}
				if (map[i][j].compareTo("Eau")==0){
					Affichage.dessineImageDansCase(j, i, Chemins.getCheminTerrain(Chemins.FICHIER_EAU));
				}
				if (map[i][j].compareTo("Ville:0")==0){
					Affichage.dessineImageDansCase(j, i,Chemins.getCheminPropriete(Chemins.FICHIER_VILLE, 0));
				}
				if (map[i][j].compareTo("Ville:1")==0){
					Affichage.dessineImageDansCase(j, i,Chemins.getCheminPropriete(Chemins.FICHIER_VILLE, 1));
				}
				if (map[i][j].compareTo("Ville:2")==0){
					Affichage.dessineImageDansCase(j, i,Chemins.getCheminPropriete(Chemins.FICHIER_VILLE, 2));
				}
				if (map[i][j].compareTo("Usine:0")==0){
					Affichage.dessineImageDansCase(j, i,Chemins.getCheminPropriete(Chemins.FICHIER_USINE, 0));
				}
				if (map[i][j].compareTo("Usine:1")==0){
					Affichage.dessineImageDansCase(j, i,Chemins.getCheminPropriete(Chemins.FICHIER_USINE, 1));
				}
				if (map[i][j].compareTo("Usine:2")==0){
					Affichage.dessineImageDansCase(j, i,Chemins.getCheminPropriete(Chemins.FICHIER_USINE, 2));
				}
				if (map[i][j].compareTo("QG:1")==0){
					Affichage.dessineImageDansCase(j, i,Chemins.getCheminPropriete(Chemins.FICHIER_QG, 1));
				}
				if (map[i][j].compareTo("QG:2")==0){
					Affichage.dessineImageDansCase(j, i,Chemins.getCheminPropriete(Chemins.FICHIER_QG, 2));
				}
			}
		}
	}

	public boolean isOver() {
		return false;
	}

	public void afficheStatutJeu() {
		Affichage.videZoneTexte();
		Affichage.afficheTexteDescriptif("Status du jeu");
		}


	public void display() {
		//StdDraw.clear();
		afficheStatutJeu();

		
		/*Affichage.dessineImageDansCase(1, 1, Chemins.getCheminTerrain(Chemins.FICHIER_FORET)); //exemple d'affichage d'une image de forêt dans la case (1,1)

		Affichage.dessineImageDansCase(1, 1, Chemins.getCheminFleche(Chemins.DIRECTION_DROITE,Chemins.DIRECTION_DEBUT));
		Affichage.dessineImageDansCase(2, 1, Chemins.getCheminFleche(Chemins.DIRECTION_GAUCHE,Chemins.DIRECTION_HAUT));
		Affichage.dessineImageDansCase(2, 2, Chemins.getCheminFleche(Chemins.DIRECTION_BAS,Chemins.DIRECTION_HAUT));
		Affichage.dessineImageDansCase(2, 3, Chemins.getCheminFleche(Chemins.DIRECTION_BAS,Chemins.DIRECTION_FIN));
		
		Affichage.dessineImageDansCase(4, 4, Chemins.getCheminFleche(Chemins.DIRECTION_DEBUT,Chemins.DIRECTION_FIN));*/		
		Affichage.dessineGrille(); //affiche une grille, mais n'affiche rien dans les cases		
		drawGameCursor();
		StdDraw.show(); //montre a l'ecran les changement demandes
	}

	public void initialDisplay() {
		StdDraw.enableDoubleBuffering(); // rend l'affichage plus fluide: tout draw est mis en buffer et ne s'affiche qu'au prochain StdDraw.show();
		display();
	}

	public void drawGameCursor() {
		Affichage.dessineCurseur(0, 0); //affiche le curseau en (0,0), a modifier
	}

	public void update() {
		AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree(); //cette fonction boucle jusqu'a la prochaine entree de l'utilisateur
		if (toucheSuivante.isHaut()) { 
			//TODO: deplacer le curseur vers le haut
			System.out.println("Touche HAUT");
			display();
			}
		if (toucheSuivante.isBas()){ 
			//TODO: deplacer le curseur vers le bas	
			System.out.println("Touche BAS");
			display();
		}
		if (toucheSuivante.isGauche()) { 
			//TODO: deplacer le curseur vers la gauche
			System.out.println("Touche GAUCHE");
			display();
		}
		if 	(toucheSuivante.isDroite()) { 
				//TODO: deplacer le curseur vers la droite
			System.out.println("Touche DROITE");
			 	display();
		}
		
		//  ATTENTION ! si vous voulez detecter d'autres touches que 't',
		//  vous devez les ajouter au tableau Config.TOUCHES_PERTINENTES_CARACTERES
		if (toucheSuivante.isCaractere('t')) {
			String[] options = {"Oui", "Non"};
			if (Affichage.popup("Finir le tour de XXX?", options, true, 1) == 0) {
				//le choix 0, "Oui", a été selectionné
				//TODO: passer au joueur suivant 
				System.out.println("FIN DE TOUR");
			}
			
			display();
		}
	}
}

