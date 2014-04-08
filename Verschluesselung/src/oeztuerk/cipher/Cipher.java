package oeztuerk.cipher;
/**
 * Die Schnittstelle Cipher beinhaltet die Funktionen encrypt und decrypt.Diese Methoden sollen die eigentliche
 * Verschlüsselungs- bzw. Entschlüsselungsarbeit vornehmen. Dazu übernehmen sie als Parameter einen Text, 
 * wandeln diesen in Kleinbuchstaben um und geben den ver- bzw. entschlüsselten Text zurück.
 *
 */

public interface Cipher {
	public String encrypt(String text) throws FalscherParameterException;
	public String decrypt(String text) throws FalscherParameterException;
}
