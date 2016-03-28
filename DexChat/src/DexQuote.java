

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Default.*;
import Default.*;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class DexQuote {
   
ArrayList<String> q = new ArrayList<String>(); 
public DexQuote() 
{
q.add("I will not waste chalk.");
q.add("I will not skateboard in the halls.");
q.add("This is a random quote");
q.add("I will not instigate a revolution.");
q.add("And this is another Random Quote");
q.add("I will not encourage others to fly.");
q.add("The program was made by Rohit");
q.add("I will not sell public property.");
q.add("I will not get very far with this attitude.");
q.add("I will not sell land in Florida.");
q.add("I will not grease the monkey bars.");
q.add("I will not hide behind the Fifth Amendment.");
q.add("I am not a dentist.");
q.add("I will finish what I sta");
q.add("Hamsters cannot fly.");
q.add("I will not aim for the head.");
q.add("I will not expose the ignorance "+ "of the faculty.");
q.add("I will not conduct my own fire drills.");
q.add("I will not fake seizures.");
q.add("This program is boring "+ "and meaningless.");
 
}
public String getQuote() 
{
int i = (int)(Math.random() * q.size());
return q.get(i);
}

}