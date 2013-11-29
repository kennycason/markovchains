package markovchains.ngram;

public class NGram implements INGram {
	
	private final String gram;
	
	public NGram(String gram) {
		this.gram = gram;
	}
	
	@Override
	public String gram() {
		return gram;
	}
	
	@Override
	public String toString() { 
		return gram;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o instanceof INGram) {
			return gram.equals(((INGram) o).gram());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return gram.hashCode();
	}

}
