package org.tp.progComp.bdd;

public interface AnnonceRepositoryCustom {

	public void changerPrix(int id, float prix);

	public void changerPrixEnchere(int id, float prix, String pseudo);

	public void changerNombreEnchere(int id, int nombre);
	
	public void augmenterUneEnchere(int id);

}
