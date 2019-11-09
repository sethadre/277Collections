import java.io.*;
import java.util.*;
import java.time.Duration;
import java.time.Instant;
        /*Instant start = Instant.now();
         Instant end = Instant.now();
         Duration timeElapsed = Duration.between(start, end);
         System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        */
public class AliceReader {
    public static void main(String[] args) throws FileNotFoundException {
                AliceHash();
                // AliceTree();
            }

            public static void AliceHash() throws FileNotFoundException {
                int count = 0;
                //try:
                Scanner alicein = new Scanner(new File("Alice.txt"));
                Set<String> hash = new HashSet<>();
                Instant start = Instant.now();
                while (alicein.hasNext()) {
                    String word = alicein.next();
                    hash.add(word);
                }
                System.out.println(count);
                Instant end = Instant.now();
                Duration timeElapsed = Duration.between(start, end);
                System.out.println("Time taken to insert to hashset: " + timeElapsed.toMillis() + " milliseconds");
                //catch throws FNF
                //Sys.out~~~~~ "Error File doesnt exist"

                //Hash word Searcher

                //Scanner in = new Scanner(System.in);
                //System.out.println("Enter a word to be hash searched");
                Iterator<String> iter = hash.iterator();
                String input = "alice";
                Instant start2 = Instant.now();
                while(iter.hasNext()) {
                    String word = iter.next();
                    while (count < 100) {
                        if (word.equals(input)) {
                            count++;
                        }
                    }
                    System.out.println(count);
                    Instant end2 = Instant.now();
                    Duration timeElapsed2 = Duration.between(start2, end2);
                    System.out.println("Time taken to search hashset: " + timeElapsed2.toMillis() + " milliseconds");
                }
                }

            }

