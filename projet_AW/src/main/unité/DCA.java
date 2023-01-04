package main.unité;

import main.armes.Mitrailleuse_Lourdes;

public class DCA extends Unité{
	public DCA() {
		pv=10;
		prix= 6000;
		pdd=6;
		armes=new Mitrailleuse_Lourdes();
		aérien=false;
		dispo=true;
	}
	public DCA(float x) {
		pv=x;
		prix= 6000;
		pdd=6;
		armes=new Mitrailleuse_Lourdes();
		aérien=false;
		dispo=true;
	}
}
