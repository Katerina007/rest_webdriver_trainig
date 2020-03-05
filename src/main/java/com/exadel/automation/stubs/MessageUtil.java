package com.exadel.automation.stubs;

/*
* This class prints the given message on console.
*/
public class MessageUtil {
   private String message;

   // Constructor
   // @param message to be printed
   public MessageUtil(String message) {
      this.message = message;
   }

   // prints the message
   public String printMessage() {
      System.out.println(message);
      return message;
   }

   // add "Hello, my dear " to the message
   public String salutationMessage() {
      message = "Hello, my dear " + message;
      System.out.println(message);
      return message;
   }

   // add "See you " to the message
   public String exitMessage() {
      message = "See you " + message;
      System.out.println(message);
      return message;
   }
}
