package markovchains.ngram;

import java.util.StringTokenizer;

public class UnigramTokenizer implements ITokenizer {

	public INGram[] tokenize(String s) {
		StringTokenizer tokenizer = new StringTokenizer(clean(s), " ");
		int numTokens = tokenizer.countTokens();
		INGram[] unigrams = new INGram[numTokens];
		
		int i = 0;
		while(tokenizer.hasMoreTokens()) {
			unigrams[i] = new NGram(tokenizer.nextToken());
			i++;
		}
		return unigrams;
	}
	
	private String clean(String s) {
		return s.replace("/\"/", "");
	}
	
}
