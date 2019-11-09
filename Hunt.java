import java.util.*;
import java.io.*;
public class Hunt{
    public static void main(String [] args) throws FileNotFoundException{
        List myList = null;
        Scanner in = new Scanner(new File("Hunt.txt"));
        Scanner console = new Scanner(System.in);

        if (args.length == 0) System.out.println("Usage: datatype");
        else {
            if (args[0].equals("LinkedList")) {
                myList=new LinkedList();
                System.out.println("Using LinkedList");
            } else {
                myList=new ArrayList();
                System.out.println("Using ArrayList"); }
            while(in.hasNextLine()) {
                String input = in.nextLine();
                myList.add(input);
            }
            Iterator<String> iter = myList.iterator();
            while(iter.hasNext()) {
                iter.next();
            }
            while(iter.hasPrevious()) {
                iter.previous();
            }
            System.out.println("How many teams are playing?");
            int teams = console.nextInt();
            

            }

        }
    }
}