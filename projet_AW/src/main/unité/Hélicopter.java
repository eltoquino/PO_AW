package main.unité;

import main.armes.Missiles;

public class Hélicopter extends Unité{
	public Hélicopter() {
		pv=10;
		prix= 12000;
		pdd=6;
		armes=new Missiles();
		aérien=true;
		dispo=true;
	}
	public Hélicopter(float x) {
		pv=x;
		prix= 12000;
		pdd=6;
		armes=new Missiles();
		aérien=true;
		dispo=true;
	}

}
