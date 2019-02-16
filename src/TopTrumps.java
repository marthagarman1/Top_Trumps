import commandline.TopTrumpsCLIApplication;
import java.util.Scanner;  
import java.io.*;

//import online.TopTrumpsOnlineApplication;



public class TopTrumps {

	/** This is the main class for the TopTrumps Application */
   public static void main(String[] args) throws IOException {
      
      boolean printTestLog = false;
      String[] commandArgs = {String.valueOf(printTestLog)};
      //TopTrumpsCLIApplication.main(commandArgs);
     
     //****************** UNCOMMENT BELOW AFTER TESTING ************************
     
    //   Scanner scan = new Scanner(System.in);
      // boolean exit = false; 
   //    
      // System.out.println("╔╦╗╔═╗╔═╗  ╔╦╗╦═╗╦ ╦╔╦╗╔═╗╔═╗);
      // System.out.println("║ ║ ║╠═╝   ║ ╠╦╝║ ║║║║╠═╝╚═╗");
      // System.out.println(" ╩ ╚═╝╩     ╩ ╩╚═╚═╝╩ ╩╩  ╚═╝");
   // 	
      // do {
         // System.out.println("Do you want to see past results or play a game?" 
            // + "\n\t1: Print Game Statistics"
            // + "\n\t2: Play game"
            // + "\nEnter the number for your selection: "); 
      //       
      //    
         // int userInput = scan.nextInt();
      //    
      //    
         // if(userInput == 1) {
         // //enter method for sql retrive game stats
         // } else if (userInput == 2) {
            // exit = true;
         // } else {
            // continue; 
         // } 
      // } while (!exit);
   //     
   //   
   // 	// command line switches
      // boolean onlineMode = false;
      // boolean commandLineMode = false;
      // boolean printTestLog = false;
   // 	
   // 	// check the command line for what switches are active
      // for (String arg : args) {
      // 	
         // if (arg.equalsIgnoreCase("-t")) printTestLog=true;
         // if (arg.equalsIgnoreCase("-c")) commandLineMode=true;
         // if (arg.equalsIgnoreCase("-o")) onlineMode=true;
      // 	
      // }
   // 	
   // 	// We cannot run online and command line mode simultaniously
      // if (onlineMode && commandLineMode) {
         // System.out.println("ERROR: Both online and command line mode selected, select one or the other!");
         // System.exit(0);
      // }
   // 	
   // 	// Start the appropriate application
      // if (onlineMode) {
      // 	// Start the online application
         // String[] commandArgs = {"server", "TopTrumps.json"};
      //    //once import is used for online - uncomment
      //    //TopTrumpsOnlineApplication.main(commandArgs);
      // } else if (commandLineMode) {
      // 	// Start the command line application
         // String[] commandArgs = {String.valueOf(printTestLog)};
         // 
      //    TopTrumpsCLIApplication.main(commandArgs);
      // }
   // 	
   }
	
}
