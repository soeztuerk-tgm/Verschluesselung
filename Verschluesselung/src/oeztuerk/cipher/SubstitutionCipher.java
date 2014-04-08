package oeztuerk.cipher;
/**
 * Die Klasse SubstitutionCipher soll eine allgemeine Substitionsverschlüsselung darstellen. 
 * Dazu muss das gesamte Geheimalphabet an ein Objekt dieser Klasse im Konstruktor oder in der 
 * Methode setSecretAlphabet übergeben werden.
 *
 */
public class SubstitutionCipher extends MonoAlphabeticCipher {
	
	/**
	 * Default Konstruktor mit dem Parameter secretAlphabet
	 * 
	 * @param secretAlphabet
	 * @throws AnzahlZeichenException
	 */
	public SubstitutionCipher(String secretAlphabet) throws AnzahlZeichenException{
	}
	/**
	 *  Und die Methode setSecretAlphabet hat die selben Funktionen 
	 * wie bei der selben Methode in der Oberklasse
	 * 
	 * @param secretAlphabet
	 * @throws AnzahlZeichenException
	 */
	public void setSecretAlphabet(String secretAlphabet) throws AnzahlZeichenException{
		if(secretAlphabet.length()==30){
		super.setSecretAlphabet(secretAlphabet);
		}
		else{
			throw new AnzahlZeichenException();
		}
	}
}
