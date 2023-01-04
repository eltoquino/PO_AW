package main.unité;

import main.armes.Bombes;

public class Bombardier extends Unité{
	public Bombardier() {
		pv=10;
		prix= 20000;
		pdd=7;
		armes=new Bombes();
		aérien=true;
		dispo=true;
	}
	public Bombardier(float x) {
		pv=x;
		prix= 20000;
		pdd=7;
		armes=new Bombes();
		aérien=true;
		dispo=true;
	}
}
