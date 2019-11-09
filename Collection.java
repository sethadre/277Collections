import java.util.*;
import java.io.*;
import java.time.Duration;
import java.time.Instant;
public class Collection {
    public static void main(String[] args) {


    Instant start = Instant.now();
    //your code
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        Scanner in = new Scanner(new File("PointValue.txt"));
    Map <String,Integer> pointValue = new HashMap<String,Integer>();
        /*
    }
        put("A", 9);put("B",2);put("C",2);put("D",4);put("E",12);put("F",2);
        put("G",3);put("H",2);put("I",9);put("J",1);put("K",1);put("L",4);
        put("M",2);put("N",6);put("O",8);put("P",2);put("Q",1);put("R",6);
        put("S",4);put("T",6);put("U",4);put("V",2);put("W",2);put("X",1);
        put("Y",2);put("Z",1);put(" ",2);*/

    while(in.hasNextLine()) {
        pointValue.put(in.next(),in.nextInt());
        in.nextLine();
    }


    Map<String,Interger> scrabbleHash = new has....
//Map<String,Interger> scrabbleTree = new HashTree<String,Integer>();


            while(fileStream.hasNext()) {

        String whatwegot = fileStream.nextLine();
        String[] ar = whatwegot.split();
        int total = 0;
        for (String letter: ar) {
            total += pointCalc.get(letter);
        }
        scrabbleHash.put(whatwegot,total);
//scrabbleTree.put(whatwegot,total);
    }
}
}




