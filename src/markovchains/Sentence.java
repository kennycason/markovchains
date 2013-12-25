package markovchains;

import markovchains.ngram.INGram;

import java.util.Arrays;

public class Sentence {

	private INGram[] ngrams;
	
	public Sentence(INGram[] ngrams) {
        this.ngrams = new INGram[ngrams.length];
		System.arraycopy(ngrams, 0, this.ngrams, 0, ngrams.length);
	}
	
	public INGram[] grams() {
		return ngrams;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;

        Sentence sentence = (Sentence) o;

        if (!Arrays.equals(ngrams, sentence.ngrams)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ngrams);
    }
}
