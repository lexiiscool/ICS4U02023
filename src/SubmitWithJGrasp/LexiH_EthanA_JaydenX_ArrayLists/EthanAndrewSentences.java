import java.util.*;

/**
 * This class creates 6 ArrayLists that each store a multitude of words with different types.
 * It then uses these words to generate random sentences that follow a predetermined structure.
 * These sentences are properly capitalized and follow proper article conventions.
 *
 * <p>Date: March 7, 2023</p>
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 23.03.07
 * @author Lexi Han: Bridge, Ethan Andrew: Sentences, Jayden Xue: AIPoem
 */
public class EthanAndrewSentences {
    private final ArrayList<String> articles;
    private final ArrayList<String> nouns;
    private final ArrayList<String> verbs;
    private final ArrayList<String> prepositions;
    private final ArrayList<String> adjectives;
    private final ArrayList<String> adverbs;

    /**
     * The constructor class that initializes the word bank.
     */
    public EthanAndrewSentences() {
        articles = new ArrayList<>();
        articles.addAll(List.of(new String[]{"a", "an", "the"}));
        nouns = new ArrayList<>();
        nouns.addAll(List.of(new String[]{"person", "thing", "hand", "child", "eye", "dog", "cat", "apple", "plant", "assignment"}));
        verbs = new ArrayList<>();
        verbs.addAll(List.of(new String[]{"jumped", "scattered", "flew", "slept", "walked", "ate", "drank", "saw", "ran", "hunted"}));
        prepositions = new ArrayList<>();
        prepositions.addAll(List.of(new String[]{"at", "by", "for", "from", "in", "of", "on", "to", "with"}));
        adjectives = new ArrayList<>();
        adjectives.addAll(List.of(new String[]{"beautiful", "merciful", "new", "long", "little", "old", "bad", "important", "used", "delicious"}));
        adverbs = new ArrayList<>();
        adverbs.addAll(List.of(new String[]{"briefly", "merrily", "unnecessarily", "boldly", "anxiously", "easily", "immediately", "mysteriously", "slowly", "voluntarily"}));
    }

    /**
     * Takes a word and capitalizes it by making the first letter an uppercase letter.
     * @param s The word that should be capitalized.
     * @return The capitalized word.
     */
    public String capitalizeWord(String s) {
        String firstLetter = s.substring(0,1);
        String rest = s.substring(1);
        firstLetter = firstLetter.toUpperCase();
        return firstLetter + rest;
    }

    /**
     * Uses the word bank to create a random sentence with a predetermined structure in the form
     * Article | noun | verb | adjective | preposition | article | adjective | noun.
     * @return The random sentence.
     */
    public String randomSentence() {
        String article1;
        String noun1;
        String verb;
        String adverb;
        String preposition;
        String article2;
        String adjective;
        String noun2;

        Collections.shuffle(nouns);
        noun1 = nouns.get(0);
        noun2 = nouns.get(1);

        Collections.shuffle(verbs);
        verb = verbs.get(0);

        Collections.shuffle(adverbs);
        adverb = adverbs.get(0);

        Collections.shuffle(prepositions);
        preposition = prepositions.get(0);

        Collections.shuffle(adjectives);
        adjective = adjectives.get(0);

        Collections.shuffle(articles);
        article1 = articles.get(0);
        boolean b = noun1.charAt(0) == 'a' || noun1.charAt(0) == 'e' || noun1.charAt(0) == 'i' || noun1.charAt(0) == 'o' || noun1.charAt(0) == 'u';
        if (article1.equals("a") && b) {
            article1 = "an";
        } else if (article1.equals("an") && !b) {
            article1 = "a";
        }
        article1 = capitalizeWord(article1);

        article2 = articles.get(1);
        boolean c = adjective.charAt(0) == 'a' || adjective.charAt(0) == 'e' || adjective.charAt(0) == 'i' || adjective.charAt(0) == 'o' || adjective.charAt(0) == 'u';
        if (article2.equals("a") && c) {
            article2 = "an";
        } else if (article2.equals("an") && !c) {
            article2 = "a";
        }

        return article1 + " " + noun1 + " " + verb + " " + adverb + " " + preposition + " " + article2 + " " + adjective + " " + noun2 + ".";
    }
}