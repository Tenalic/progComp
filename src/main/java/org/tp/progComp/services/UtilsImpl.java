package org.tp.progComp.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tp.progComp.entities.Annonce;
import org.tp.progComp.entities.Vente;

@Service
public class UtilsImpl implements Utils {

	private final String algorithm = "SHA-256";

	private final char[] hexArray = "0123456789ABCDEF".toCharArray();

	@Autowired
	private AnnonceService annonceService;

	/**
	 * genère une string crypté a partir d'une string
	 * 
	 * @param data string a crypté
	 * @return la string crypté
	 */
	public String generateHash(String data) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.reset();
			byte[] hash = digest.digest(data.getBytes());
			return bytesToStringHex(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String bytesToStringHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	@Override
	public Iterable<Annonce> changerPrixAnnonce(Iterable<Annonce> listeAnnonce, String devise) {
		if (devise != null && !"€".equals(devise)) {
			ArrayList<Annonce> reponse = new ArrayList<Annonce>();

			for (Annonce annonce : listeAnnonce) {
				switch (devise) {
				case "$":
					annonce.setPrix(annonceService.euroToDollar(annonce.getPrix()));
					reponse.add(annonce);
					break;
				default:
					reponse.add(annonce);
					break;
				}
			}
			return reponse;
		}
		return listeAnnonce;
	}

	@Override
	public Iterable<Vente> changerPrixVente(Iterable<Vente> listeVente, String devise) {
		if (devise != null && !"€".equals(devise)) {
			ArrayList<Vente> reponse = new ArrayList<Vente>();
			for (Vente vente : listeVente) {
				switch (devise) {
				case "$":
					vente.setPrix((float) annonceService.euroToDollar(vente.getPrix()));
					reponse.add(vente);
					break;
				default:
					reponse.add(vente);
					break;
				}
			}
			return reponse;
		}
		return listeVente;
	}

}
