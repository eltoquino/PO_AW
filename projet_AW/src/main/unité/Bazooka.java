package main.unité;

import main.armes.Canon;

public class Bazooka extends Unité{
	public Bazooka() {
		pv=10;
		prix= 3500;
		pdd=2;
		armes=new Canon();
		aérien=false;
		dispo=true;
	}
	public Bazooka(float x) {
		pv=x;
		prix= 3500;
		pdd=2;
		armes=new Canon();
		aérien=false;
		dispo=true;
	}
}
