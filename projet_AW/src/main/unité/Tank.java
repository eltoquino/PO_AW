package main.unité;

import main.armes.Canon;

public class Tank extends Unité{
	public Tank() {
		pv=10;
		prix= 7000;
		pdd=6;
		armes=new Canon();
		aérien=false;
		dispo=true;
	}
	public Tank(float x) {
		pv=x;
		prix= 7000;
		pdd=6;
		armes=new Canon();
		aérien=false;
		dispo=true;
	}

}
