/**
 * Date: March 10, 2023
 * <p> 
 * 		The Driver class for the several ArrayList assignments assigned (Bridge, Sentences, AIPoem)
 * </p>
 * <h2>
 * 		Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 * 
 * @version 23.03.10
 * @author: Lexi Han (Bridge), Ethan Andrew (Sentences), Jayden Xue (AIPoem)
 */


public class Driver {
	public static void main(String[] args) {
		//Testing Bridge method
		LexiHanBridge b = new LexiHanBridge();
		
		System.out.println("Up for a game of Bridge?");
		System.out.println();
		b.fillDeck();
		
		System.out.println("Shuffling!");
		b.shuffleDeck();
		
		System.out.println("Dealing...");
		b.dealDeck();
		
		System.out.println("Let the round begin!");
		System.out.println();
		
		for (int i = 1; i <= 4; i++) {
			System.out.println("Player " + i + " has the following hand:");
			b.displayHand(b.getHand(i));
			System.out.println("Player " + i + " has a score of " + b.calcScore(b.getHand(i)) + ".");
			System.out.println();
		}
		
		System.out.println("The winner is: Player " + b.getWinner() + "!");
		
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println();
		
		//Testing Sentence Maker
		System.out.println("Time to make some wacky sentences!");
		System.out.println("Generating 5 random sentences: ");
		EthanAndrewSentences s = new EthanAndrewSentences();
		for (int i = 0; i < 5; i++) {
			System.out.println("\""+s.randomSentence()+"\"");
		}
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println();
		
		//Testing AI Poem
		JaydenXueAIPoem p = new JaydenXueAIPoem();
		System.out.println("A poet in the making :)");
		System.out.println("Observe the following verse: ");
		System.out.println("\"" + p.generateVerse() + "\"");

	}
}
