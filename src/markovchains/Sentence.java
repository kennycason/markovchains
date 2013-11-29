package markovchains;

import markovchains.ngram.INGram;

public class Sentence {

	private INGram[] ngrams;
	
	public Sentence(INGram[] ngrams) {
		this.ngrams = new INGram[ngrams.length];
		for(int i = 0; i < ngrams.length; i++) {
			this.ngrams[i] = ngrams[i];
		}
	}
	
	public INGram[] grams() {
		return ngrams;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o instanceof Sentence) {
			Sentence s = (Sentence) o;
			if(s.grams().length != this.grams().length) {
				return false;
			}
			for(int i = 0; i < this.grams().length; i++) {
				if(!this.grams()[i].equals(s.grams()[i])) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(INGram ngram : ngrams) {
			sb.append(ngram + " ");
		}
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
}
