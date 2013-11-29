package markovchains;

import markovchains.ngram.BigramTokenizer;
import markovchains.ngram.UnigramTokenizer;

public class MarkovChainsGenerator {

	public static void main(String[] args) {
		System.out.println("Unigram:\n--------------------");
		MarkovChains mc = new MarkovChains("texts/tide_pods.txt", new UnigramTokenizer());
		for(Sentence gen : mc.generate(30, 5)) {
			System.out.println(gen);
		}
		
		System.out.println("Bigram:\n--------------------");
		mc = new MarkovChains("texts/tide_pods.txt", new BigramTokenizer());
		for(Sentence gen : mc.generate(30, 5)) {
			System.out.println(gen);
		}
		
		System.out.println("Unigram:\n--------------------");
		mc = new MarkovChains("texts/hn_top.txt", new UnigramTokenizer());
		for(Sentence gen : mc.generate(30, 5)) {
			System.out.println(gen);
		}
		
		System.out.println("Bigram:\n--------------------");
		mc = new MarkovChains("texts/hn_top.txt", new BigramTokenizer());
		for(Sentence gen : mc.generate(30, 5)) {
			System.out.println(gen);
		}
	
	}
	
}
