package markovchains.gen;

import markovchains.MarkovChains;
import markovchains.Sentence;
import markovchains.ngram.BigramTokenizer;
import markovchains.ngram.UnigramTokenizer;

public class TidePodTweets {

	public static void main(String[] args) {
		System.out.println("Unigram:\n--------------------");
		MarkovChains mc = new MarkovChains("texts/tide_pods.txt", new UnigramTokenizer());
		for(Sentence gen : mc.generate(30, 10)) {
			System.out.println(gen);
		}
		
		System.out.println("Bigram:\n--------------------");
		mc = new MarkovChains("texts/tide_pods.txt", new BigramTokenizer());
		for(Sentence gen : mc.generate(30, 10)) {
			System.out.println(gen);
		}
	
	}
	
}
