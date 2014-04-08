package oeztuerk.cipher;

/**
 * Die Klasse MonoAlphabeticCipher stellt die Basisfunktionalitäten auf Basis
 * des Interfaces Cipher zur Verfügung und setzt das Geheimalphabet immer auf
 * das Ausgangsalphabet
 * 
 * @author Sefa Öztürk
 * @date 06.04.2014
 */
public class MonoAlphabeticCipher implements Cipher {

	// Das Attribut alphabet ist das Standardalphabet
	private String alphabet;
	// Privates Attribut secretAlphabet ist zunächst das Ausgangsalphabet, das später
	//mit der Methode setSecretAlphabet mit einem ander Alphabet ersetzt werden kann
	private String secretAlphabet;

	/**
	 * Das ist der Default-Konstruktor
	 */
	public MonoAlphabeticCipher() {
		alphabet = "abcdefghijklmnopqrstuvwxyzäüöß";
		secretAlphabet = "abcdefghijklmnopqrstuvwxyzäüöß";
	}

	/**
	 * Die Methode getSecretAlphabet gibt das verschlüsselte Alphabet zurück.
	 * 
	 * @return secretAlphabet
	 */
	public String getSecretAlphabet() {
		return secretAlphabet;
	}

	/**
	 * Die Methode setSecretAlphabet ersetzt neu erhaltene Alphabet.
	 * 
	 * @param secretAlphabet
	 * @throws AnzahlZeichenException
	 */
	public void setSecretAlphabet(String secretAlphabet)throws AnzahlZeichenException {
		//Die if-Anweisung überprüft, ob die Länge des Geheima. 
		//genau 30 Buchstaben enthält
		if (secretAlphabet.length() == 30) {
			this.secretAlphabet = secretAlphabet;
		} else {
			throw new AnzahlZeichenException();
		}
	}
	/**
	 * encrypt ist eine Methode zum verschlüsseln von Wörtern
	 * 
	 * @param text 
	 * @throws FalscherParameterException
	 */
	@Override
	public String encrypt(String text) throws FalscherParameterException {
		//verschlüsselt=ausgabewort
		String verschlüsselt = "";
		//die matches methode vergleicht ein String mit einem Regulären Ausdruck
		//und gibt true oder false zurück.
		
		//RegAu: Wenn der Parameter text, Zeichen außerhalb des STANDARDALPHABETS enthält,
		//dann soll true zurückggegeben werden, also das soll heißen das dieses Wort ein
		//falsches Zeichen enthält und daher eine Exception geworfen wird, andersfalls 
		//kann das Wort entschlüsselt werden.
		boolean a = text.matches(".*[^" + alphabet + "].*");

		if (a == true) {
			throw new FalscherParameterException();
		} else {
			for (int i = 0; i < text.length(); i++) {
				for (int j = 0; j < alphabet.length(); j++) {
					if (alphabet.charAt(j) == (text.charAt(i))) {
						verschlüsselt += secretAlphabet.charAt(j);
					}
				}
			}
		}
		//Das verschlüsselte Wort zurückgeben
		return "Verschlüsseltes Wort: " + verschlüsselt;
	}
	/**
	 * decrypt ist eine Methode zum entschlüsseln von Wörtern
	 * 
	 * @param text 
	 * @throws FalscherParameterException
	 */
	@Override
	public String decrypt(String text) throws FalscherParameterException {
		String entschlüsselt = "";
		//hier gilt dasselbe nur  umgekehrt mit dem GEHEIMALPHABET
		boolean a = text.matches(".*[^" + secretAlphabet + "].*");
		if (a == true) {
			throw new FalscherParameterException();
		} else {
			for (int i = 0; i < text.length(); i++) {
				for (int j = 0; j < secretAlphabet.length(); j++) {
					if (secretAlphabet.charAt(j) == text.charAt(i)) {
						entschlüsselt += alphabet.charAt(j);
					}
				}
			}
		}
		//Das entschlüsselte Wort zurückgeben
		return "Entschlüsseltes Wort: " + entschlüsselt;
	}
}
