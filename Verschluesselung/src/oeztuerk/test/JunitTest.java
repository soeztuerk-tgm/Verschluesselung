package oeztuerk.test;

import static org.junit.Assert.*;
import oeztuerk.cipher.AnzahlZeichenException;
import oeztuerk.cipher.FalscherParameterException;
import oeztuerk.cipher.MonoAlphabeticCipher;
import oeztuerk.cipher.SubstitutionCipher;

import org.junit.Test;

public class JunitTest {
	//Attribut hallo ist das Parameter zum ent- bzw. verschlüsseln
	String text="hallo";
	//Hier zum Test ein Geheimalphabet
	String secretAlphabet="xyzabcdefghijklmnopqrstuvwäüöß";
	//Neues Objekt aus der Klasse MAC
	MonoAlphabeticCipher mac=new MonoAlphabeticCipher();

	@Test
	public void testSetSecretAlphabet() {
		try {
			//Versuch, ob die Anzahl an Buchstaben im Geheimalphabet richtig ist
			mac.setSecretAlphabet(secretAlphabet);
			//Wenn was schief geht, dann halt Exception werfen
		} catch (AnzahlZeichenException e) {
			System.out.println("Anzahl Buchstaben im Geheimalphabet falsch");
		}
	}

	@Test
	public void testEncrypt() throws AnzahlZeichenException{
		try {
			//Zuerst Geheimalphabet setzten 
			mac.setSecretAlphabet(secretAlphabet);
			//Dann verschlüsseln
			System.out.println(mac.encrypt(text));
			//Wenn was schief geht, dann halt Exception werfen
		} catch (FalscherParameterException e) {
			System.out.println("Ungültiges Wort ins Parameter eingegeben");
		} 
	}

	@Test
	public void testDecrypt() throws AnzahlZeichenException{
		try {
			//Wieder zuerst Geheimalphabet eingeben
			mac.setSecretAlphabet(secretAlphabet);
			//Dann entschlüsseln
			System.out.println(mac.decrypt(text));
			//Wenn was schief geht, dann Exception werfen
		} catch (FalscherParameterException e) {
			System.out.println("Ungültiges Wort ins Parameter eingegeben");
		} 
	}

	@Test
	public void testgetSecretAlphabet() throws AnzahlZeichenException{
		mac.setSecretAlphabet(secretAlphabet);
		System.out.println(mac.getSecretAlphabet());
	}
}
