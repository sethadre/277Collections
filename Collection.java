import java.util.*;
import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class Collection {
    public static void main(String[] args) {
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        Map<Character, Integer> pointMap = new HashMap<Character,Integer>();
        if (args[0].equals("Tree")) {
            System.out.println("Using TreeMap as data structure");
            wordMap = new TreeMap<String, Integer>();
            pointMap = new TreeMap<Character,Integer>();
        } else if (args[0].equals("Hash")) {
            System.out.println("Using HashMap as data structure");
            wordMap = new HashMap<String, Integer>();
            pointMap = new HashMap<Character,Integer>();
        }
        Scanner in = new Scanner(System.in);
        try {
            in = new Scanner(new File("QNoU.txt"));
            System.out.println("Creating Map from file");
            Instant start = Instant.now();
            while (in.hasNext()) {
                wordMap.put(in.nextLine(), 0);
            }
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("Time taken: " + timeCalculator(timeElapsed.toNanos()));
            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect in.next has occured, either wrong amount or wrong .nextXXXX");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unknown error has occured");
            e.printStackTrace();
        }

        try {
            in = new Scanner(new File("Scrabble.txt"));
            while (in.hasNext()) {
                pointMap.put(Character.toUpperCase(in.next().charAt(0)), in.nextInt()) ;
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open Scrabble file");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Error with accessing data in file with in.next, check syntax");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unknown error has occured");
            e.printStackTrace();
        }

        Iterator<Map.Entry<String, Integer>> wordIt = wordMap.entrySet().iterator();
        System.out.println("Updating point values");
        Instant start = Instant.now();
        while (wordIt.hasNext()) {
            Map.Entry<String, Integer> pair = wordIt.next();
            int pointTotal = 0;
            for (char c : pair.getKey().toCharArray()) {
                c = Character.toUpperCase(c);
                pointTotal += pointMap.get(c);
            }
            wordMap.replace(pair.getKey(), 0, pointTotal);
        }
        Instant end = Instant.now();
        Iterator<Map.Entry<String, Integer>> it = wordMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();
            System.out.printf("key: %-15s", pair.getKey());
            System.out.println(" value: " + pair.getValue());
        }
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeCalculator(timeElapsed.toNanos()));
        in.close();
    }
	public static String timeCalculator(long t) {
		StringBuilder builder = new StringBuilder();
		// builder.append("Your time is ");
		if (t/Math.pow(10.0, 9.0) > 1) {
			builder.append(t/Math.pow(10.0, 9.0) + " seconds\n");
		} else if (t/Math.pow(10.0, 6.0) > 1) {
			builder.append(t/Math.pow(10.0, 6.0) + " milli seconds\n");
		} else if (t/Math.pow(10.0, 3.0) > 1) {
			builder.append(t/Math.pow(10.0, 3.0) + " micro seconds!!!\n");
		} else {
			builder.append(t + " nano seconds!!!\n");
		}
		return builder.toString();
	}
}
