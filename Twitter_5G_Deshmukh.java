//name:       date:
import twitter4j.*;  //set the classpath to:  lib\twitter4j-core-4.0.2.jar
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Twitter_5G_Deshmukh
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
         File file= new File("CommonWords.txt");
         Scanner sc=new Scanner(file);
         ArrayList<String> comword=new ArrayList<String>();
         ArrayList<String> newTerm=new ArrayList<String>();
         Boolean check=new Boolean(false);
         while(sc.hasNextLine())
         {
            String a=sc.next();
            comword.add(a);
            System.out.println(a);
         }
         for(String apple: terms)
         {
            for(String apple2: comword)
            {
               if(apple2.compareTo(apple)==0)
               {
                  check=true;
               }
            }
            if(check==false)
            {
               newTerm.add(apple);
            }
         }
               
            
         	// Sort words in alpha order
         	
         	
         	
         	
         	// Remove all empty strings ""
         	
         	
         	
         System.setOut(stnd_out);   //reset output to the screen
         System.out.println("The most common word from @" + handle + " is: " + findMostCommonWord(newTerm));  //Finds most common word
         System.out.println();
         System.out.print("Enter Twitter handle, (without the @ symbol, type done to quit) --> ");
         handle = scan.next();
      }	
   }	//end main
   	
   // static methods go here
   public static String removePunctuation( String s )
   { 
      String punct="[]{}()\":;!*?.-";
      for (int a=0;a<s.length();a++)
      {
         for (int b=0;b<punct.length();b++)
         {
            if(s.charAt(a)==punct.charAt(b))
            {
               s.replace(s.substring(a,a+1),"");
            }
         }
      }
      return s; 
   } 
              
   public static String findMostCommonWord(List<String> a)
   {
      String word="";
      int numtim=0;
      int tempnum=0;
      for(String b:a)
      {
         for(String c:a)
         {
            if(b.compareTo(c)==0)
            {
               tempnum++;
            }   
         }
         if(tempnum>numtim)
         {
            numtim=tempnum;
            word=b;
            tempnum=0;
         }       
      }
      return word;
   }
               
}
	
         		
