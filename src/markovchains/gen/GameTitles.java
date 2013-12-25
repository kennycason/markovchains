package markovchains.gen;

import markovchains.MarkovChains;
import markovchains.Sentence;
import markovchains.ngram.BigramTokenizer;
import markovchains.ngram.UnigramTokenizer;

/**
 * full list of games: http://www.gamerevolution.com/game/all/all/long_name/asc
 * @author kenny
 *
 */
public class GameTitles {

	public static void main(String[] args) {		
		System.out.println("Unigram:\n--------------------");
		MarkovChains mc = new MarkovChains("texts/game_titles.txt", new UnigramTokenizer());
		for(Sentence gen : mc.generate(30, 5)) {
			System.out.println(gen);
		}
		
		System.out.println("Bigram:\n--------------------");
		mc = new MarkovChains("texts/game_titles.txt", new BigramTokenizer());
		for(Sentence gen : mc.generate(50, 5)) {
			System.out.println(gen);
		}
	
	}
	
}
