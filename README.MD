# Dictionary Search & Auto-Suggestion System

A beginner-friendly Java backend program to store words, search them, and provide auto-suggestions.

# 1. Data Structures Used
* ArrayList: Used to store all the word records in memory.
* Custom Class (Item): To hold each word text and its search frequency.
* Comparator: Used to sort matching suggestions based on higher frequency first and alphabetical order second.

# 2. Logic and Approach
* Add Word: Loops through the ArrayList. If found, outputs "already exists". Otherwise, adds the word with frequency 1.
* Search Word: Loops through the list. If an exact match is found, increments frequency by 1 and prints "FOUND". If loop finishes with no match, prints "NOT FOUND".
* Suggest: Loops through the list using .startsWith(prefix) to collect matches, sorts them with a custom comparator, and prints the top k items.

# 3. How to Run
1. Open terminal in the project directory.
2. Compile the Java file:
   javac Main.java