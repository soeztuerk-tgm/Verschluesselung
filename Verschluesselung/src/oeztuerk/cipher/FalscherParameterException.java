package oeztuerk.cipher;

public class FalscherParameterException extends Exception{
      //Parameterfreier Konstruktor
      public FalscherParameterException() {}

      //Konstruktor, das eine eine Nachricht annimmt
      public FalscherParameterException(String message)
      {
         super(message);
      }
 }
