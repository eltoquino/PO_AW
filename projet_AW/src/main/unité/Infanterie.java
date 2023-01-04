package main.unité;

import main.armes.Mitrailleuse_Légères;

public class Infanterie extends Unité {
	public Infanterie() {
		pv=10;
		prix= 1500;
		pdd=3;
		armes=new Mitrailleuse_Légères();
		aérien=false;
		dispo=true;
	}
	public Infanterie(float x) {
		pv=x;
		prix= 1500;
		pdd=3;
		armes=new Mitrailleuse_Légères();
		aérien=false;
		dispo=true;
	}
	

}
