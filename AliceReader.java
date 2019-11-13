import java.io.*;
import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class AliceReader {
    public static void main(String[] args) {
        if (args.length != 0) {
            Set<String> set = new HashSet<String>();
            switch (Character.toUpperCase(args[0].charAt(0))) {
            case 'H':
                System.out.println("Working with the Hash Set");
                set = new HashSet<String>();
                break;
            case 'T':
                System.out.println("Working with the Tree Set");
                set = new TreeSet<String>();
                break;
            default:
                System.out.println("Inproper argument specified, please use \"Hash\" or \"Tree\" as an argument\nUsing Hash as default");
                break;
            }

            try {
                Scanner alicein = new Scanner(new File("Alice.txt"));
                Instant start = Instant.now();
                while (alicein.hasNext()) {
                    String word = alicein.next();
                    set.add(word);
                }
                Instant end = Instant.now();
                Duration timeElapsed = Duration.between(start, end);
                System.out.println("Time taken to insert to set: " + timeCalculator(timeElapsed.toNanos()));
                alicein.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error finding file\n");
                e.printStackTrace();
            }

            //System.out.println(set);
            String input = "Alice";
            System.out.println("Seaching for 100 instances of: " + input);
            int count = 0;
            boolean found = false;
            Iterator<String> iter = set.iterator();
            Instant start2 = Instant.now();
            while(iter.hasNext() && !found) {
                if(iter.next().contains(input)) {
                    count++;
                }
                if (count > 100) {
                    found = true;
                }
            }
            Instant end2 = Instant.now();
            System.out.println("100 instances of: \""+input+"\" were "+(found?"found ":"not found"));
            Duration timeElapsed2 = Duration.between(start2, end2);
            System.out.println("Time taken to search set: " + timeCalculator(timeElapsed2.toNanos()));
        } else {
            System.out.println("No agruements specified\nPlease use \"Hash\" or \"Tree\"");
        }

        // AliceTree();
    }

    public static String timeCalculator(long t) {
        StringBuilder builder = new StringBuilder();
        // builder.append("Your time is ");
        if (t / Math.pow(10.0, 9.0) > 1) {
            builder.append(t / Math.pow(10.0, 9.0) + " seconds\n");
        } else if (t / Math.pow(10.0, 6.0) > 1) {
            builder.append(t / Math.pow(10.0, 6.0) + " milli seconds\n");
        } else if (t / Math.pow(10.0, 3.0) > 1) {
            builder.append(t / Math.pow(10.0, 3.0) + " micro seconds!!!\n");
        } else {
            builder.append(t + " nano seconds!!!\n");
        }
        return builder.toString();
    }

}
