package oeztuerk.cipher;

public class AnzahlZeichenException extends Exception{
      //Parameterfreier Konstruktor
      public AnzahlZeichenException() {}

      //Konstruktor, das eine eine Nachricht annimt
      public AnzahlZeichenException(String message)
      {
         super(message);
      }
 }
