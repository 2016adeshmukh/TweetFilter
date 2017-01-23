//name:       date:
import twitter4j.*;  //set the classpath to:  lib\twitter4j-core-4.0.2.jar
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

   public class Twitter_shell
   {
      public static void main (String []args) throws TwitterException, IOException
      {
      	// Remembers the standard output location (the screen)
         PrintStream stnd_out = System.out;                	
      	
			// Make an instance of Twitter - this is re-useable and thread safe.
         Twitter twitter = TwitterFactory.getSingleton(); //connects to Twitter and performs authorizations          
      
      	//Ask for Twitter handle
         Scanner scan = new Scanner(System.in);
         System.out.print("Please enter a Twitter handle (without the @ symbol, type done to quit) --> ");
         String handle = scan.next();
         while (!handle.equals("done"))
         {
            System.setOut(new PrintStream(new FileOutputStream("garbageOutput.txt"))); // Creates file for useless console output
         
            Paging page = new Paging(1,200);  // Accesses last 200 tweets, I think this is the limit
            int p = 1;
            List<Status> statuses = new ArrayList<Status>();
            while (p < 10) // Can only access 20 per page I think
            {
               p++;
               page.setPage(p);
               statuses.addAll(twitter.getUserTimeline(handle,page));  //get the tweets
            }
               	
         	List<String> terms = new ArrayList<String>();//Make a list of all words in the tweets
            for (Status status : statuses)
            {			
               String[]array = status.getText().split(" ");
               for (String word : array)
                  terms.add(removePunctuation(word)); // Remove all punctuation from word before adding to list
            }	
               	
         	// Make a list of all words from user timeline
            // Remove all punctuation from word before adding to list
            	
            	
         		
         								
         			
            // Remove common English words, which are stored in commonWords.txt
            
            
         	
            
         	// Sort words in alpha order
         	
         	
         	
         	
         	// Remove all empty strings ""
         	
         	
         	
            System.setOut(stnd_out);   //reset output to the screen
            System.out.println("The most common word from @" + handle + " is: " + findMostCommonWord(terms));  //Finds most common word
            System.out.println();
            System.out.print("Enter Twitter handle, (without the @ symbol, type done to quit) --> ");
            handle = scan.next();
         }	
      }	//end main
   	
   // static methods go here
   
   }