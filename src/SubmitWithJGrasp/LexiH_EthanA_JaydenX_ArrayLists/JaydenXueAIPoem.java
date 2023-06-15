/**
 * Date: March 7, 2023
 * <p>
 *     The class AIPoem, which will shuffle words from the user's categorized word bank,
 *     that is, ArrayLists of articles, nouns, verbs, prepositions, adjectives, pronouns, and rhyming words.
 *     The program will then print out what would be a verse of a couplet poem.
 * </p>
 * <h2>
 *     Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 *
 * @version 23.03.07
 * @author Lexi Han: Bridge, Ethan Andrew: Sentences, Jayden Xue: AIPoem
 */

import java.util.*;
import java.io.*;

/**
 * Class AIPoem. This class will use several ArrayLists, each containing related words for
 * a certain category, for example, prepositions, and will generate two lines of words, representing
 * a couplet poem.
 */
public class JaydenXueAIPoem {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /**
     * Declaration of ArrayList variables that will represent a category of a sentence.
     * Also includes the declaration and initialization of a String variable which will
     * help identify a vowel.
     */
    private final ArrayList<String> articles;
    private final ArrayList<String> nouns;
    private final ArrayList<String> pronouns;
    private final ArrayList<String> verbs;
    private final ArrayList<String> prepositions;
    private final ArrayList<String> adjectives;
    private final ArrayList<String> conjunctions;
    private final ArrayList<String> rhymes;

    private String vowels = "aeiou";

    /**
     * Constructor class that will initialize the word bank.
     */
    public JaydenXueAIPoem() {
        articles = new ArrayList<>();
        articles.addAll(List.of(new String[] {"the", "a", "an"}));
        nouns = new ArrayList<>();
        nouns.addAll(List.of(new String[] {"boy", "girl", "bridge", "river", "flowers", "water", "petals", "tree", "trees", "branch", "branches"}));
        pronouns = new ArrayList<>();
        pronouns.addAll(List.of(new String[] {"his", "her", "their"}));
        verbs = new ArrayList<>();
        verbs.addAll(List.of(new String[] {"skipped", "ran", "flew", "scattered", "walked", "shredded", "looked", "ate", "jumped"}));
        prepositions = new ArrayList<>();
        prepositions.addAll(List.of(new String[] {"at", "over", "by", "from", "on", "in", "to", "with", "across", "against"
                , "after", "along", "toward", "between", "beneath", "near", "on top of", "past"}));
        adjectives = new ArrayList<>();
        adjectives.addAll(List.of(new String[] {"beautiful", "clean", "drab", "elegant", "glamorous", "magnificent"
                , "plain", "sparkling", "ugly", "long", "flaky", "brittle", "rough", "smooth"}));
        conjunctions = new ArrayList<>();
        conjunctions.addAll(List.of(new String[] {"and", "so", "or", "but", "yet"}));
        rhymes = new ArrayList<>();
        rhymes.addAll(List.of(new String[] {"sound round", "fire tire", "guy fly", "bat cat", "owl fowl"
                , "nap lap", "bridge fridge"}));
    }

    /**
     * Method to capitalize the first letter of the first word of the generated sentence.
     * @param s is the word that will have its first letter capitalized.
     * @return the modified word that has its first letter now capitalized.
     */
    public String uppercaseWord (String s) {
        String firstLetter = s.substring(0, 1);
        String remaining = s.substring(1);
        firstLetter = firstLetter.toUpperCase(Locale.ROOT);
        return firstLetter + remaining;
    }

    /**
     * Method that uses the now initialized word bank to generate a verse of a couplet poem.
     * @return two random sentence that represents the verse of an AI poem
     */
    public String generateVerse() {
        String article1, noun1, verb1, preposition1, article2, adjective;
        String article3, noun2, verb2, preposition2, pronoun;
        String rhyme1, rhyme2;

        Collections.shuffle(articles);
        Collections.shuffle(nouns);
        Collections.shuffle(verbs);
        Collections.shuffle(prepositions);
        Collections.shuffle(adjectives);
        Collections.shuffle(pronouns);
        Collections.shuffle(rhymes);

        article1 = articles.get(0); article2 = articles.get(1); article3 = articles.get(2);
        noun1 = nouns.get(0); noun2 = nouns.get(1);
        verb1 = verbs.get(0); verb2 = verbs.get(1);
        preposition1 = prepositions.get(0); preposition2 = prepositions.get(1);
        adjective = adjectives.get(0);
        pronoun = pronouns.get(0);
        String[] rhymeArr = rhymes.get(0).split(" ");
        rhyme1 = rhymeArr[0]; rhyme2 = rhymeArr[1];

        // Check if the articles are an "a" or "an" and whether it should be changed based on
        // the first letter of the noun and adjective succeeding it.
        boolean isVowel = (vowels.indexOf(noun1.substring(0, 1)) >= 0);
        if (article1.equals("a") && isVowel) article1 = "an";
        else if (article1.equals("an") && !isVowel) article1 = "a";
        article1 = uppercaseWord(article1); // Capitalize the first letter of article1 as it's the first word in the sentence

        isVowel = (vowels.indexOf(adjective.substring(0, 1)) >= 0);
        if (article2.equals("a") && isVowel) article2 = "an";
        else if (article1.equals("an") && !isVowel) article2 = "a";

        isVowel = (vowels.indexOf(noun2.substring(0, 1)) >= 0);
        if (article3.equals("a") && isVowel) article3 = "an";
        else if (article3.equals("an") && !isVowel) article3 = "a";
        article3 = uppercaseWord(article3); // Capitalize the first letter of article3 as it's the first word in the sentence

        String sentence1 = String.format("%s %s %s %s %s %s %s.", article1, noun1, verb1,
                preposition1, article2, adjective, rhyme1);
        String sentence2 = String.format("%s %s %s %s %s %s.", article3, noun2, verb2,
                preposition2, pronoun, rhyme2);
        String output = sentence1 + "\n" + sentence2;
        return output;
    }
} // JaydenXueAIPoem class
