import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//class to store words details
class Item{
    String word; 
    int frequency;

    public Item(String word, int frequency){
        this.word = word;
        this.frequency = frequency;
    }
}

public class Main{
    //ArrayList to store all words in memory
    static ArrayList<Item> dictionary = new ArrayList<>();

    //add word function
    public static void addWord(String word){
        word = word.toLowerCase().trim();

        //if word already exists in list
        for (int i = 0; i < dictionary.size(); i++){
            if (dictionary.get(i).word.equals(word)){
                System.out.println("already exists");
                return;
            }
        }
        // Add new word
        Item newItem = new Item(word, 1);
        dictionary.add(newItem);
        System.out.println("Word added successfully");
    }

    //search word
    public static void searchWord(String word){
        word = word.toLowerCase().trim();

        for (int i = 0; i < dictionary.size(); i++){
            Item item = dictionary.get(i);
            if (item.word.equals(word)){
                item.frequency = item.frequency + 1; // Increase frequency count by 1
                System.out.println("FOUND");
                return;
            }
        }
        System.out.println("NOT FOUND");
    }

    //get prefix suggestions
    public static void suggest(String prefix, int k){
        prefix = prefix.toLowerCase().trim();
        ArrayList<Item> matches = new ArrayList<>();

        // Find all words starting with prefix
        for (int i = 0; i < dictionary.size(); i++){
            Item item = dictionary.get(i);
            if (item.word.startsWith(prefix)){
                matches.add(item);
            }
        }
        // Sort
        Collections.sort(matches, new Comparator<Item>(){
            @Override
            public int compare(Item a, Item b){
                if (b.frequency!=a.frequency){
                    return b.frequency-a.frequency; // Descending frequency
                } else{
                    return a.word.compareTo(b.word); // Alphabetical
                }
            }
        });

        // Print k suggestions
        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i<matches.size();i++){
            if (count < k) {
                result.add(matches.get(i).word);
                count++;
            }
        }
        System.out.println("Suggestions:"+result);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //sample data
        addWord("apple");
        addWord("apply");
        addWord("application");
        addWord("banana");
        addWord("band");
        System.out.println("\n*Simple Dictionary System*");

        while (true){
            System.out.println("\n1. Add Word");
            System.out.println("2. Search Word");
            System.out.println("3. Suggest Words");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = 0;
            try{
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 1){
                System.out.print("Enter word: ");
                String w = sc.nextLine();
                addWord(w);
            } else if (choice == 2){
                System.out.print("Enter word: ");
                String w = sc.nextLine();
                searchWord(w);
            } else if (choice == 3){
                System.out.print("Enter prefix: ");
                String p = sc.nextLine();
                System.out.print("Enter k: ");
                int k = Integer.parseInt(sc.nextLine());
                suggest(p, k);
            } else if (choice == 4){
                System.out.println("Exiting program.");
                break;
            } else{
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
