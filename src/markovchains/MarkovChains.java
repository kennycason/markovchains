package markovchains;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import markovchains.ngram.INGram;
import markovchains.ngram.ITokenizer;

public class MarkovChains {
	
	private static final int MAX_SIZE = 15;
	
	private Map<INGram, List<INGram>> stats;
	
	private List<INGram> starts;
	
	private Set<INGram> terminals;
	
	private Set<Sentence> all;
	
	private ITokenizer tokenizer;
	
	private String file;
	
	private Random rand;
	
	public MarkovChains(String file, ITokenizer tokenizer) {
		stats = new HashMap<INGram, List<INGram>>();
		starts = new LinkedList<INGram>();
		terminals = new HashSet<INGram>();
		all = new HashSet<Sentence>();

		rand = new Random();
		this.file = file;
		this.tokenizer = tokenizer;
		load();
	}
	
	public List<Sentence> generate(int num, int minSize) {
		List<Sentence> sentences = new LinkedList<Sentence>();
		while(sentences.size() < num) {
			List<INGram> ngrams = new LinkedList<INGram>();
			INGram ngram = choose(starts);
			ngrams.add(ngram);
			for(int j = 0; j < MAX_SIZE || j >= minSize; j++) {
				ngram = choose(stats.get(ngram));
				if(ngram == null) { break; }
				ngrams.add(ngram);
				if(terminals.contains(ngram) && j <= minSize) { break; }		
			}
			
			Sentence sentence = new Sentence(ngrams.toArray(new INGram[ngrams.size()]));
			if(!all.contains(sentence)) {
				sentences.add(sentence);
			}
			
		}
		return sentences;
	}
	
	private INGram choose(List<INGram> words) {
		if(words == null) {
			return null;
		}
		return words.get(rand.nextInt(words.size()));
	}
	
	private void load() {
		// load sentences
		try {
			// load/build sentences
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				Sentence sentence = new Sentence(tokenizer.tokenize(line));
				all.add(sentence);
			}
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// build stats
		for(Sentence sentence : all) {
			if(sentence.grams().length == 0) { continue; }
			
			starts.add(sentence.grams()[0]);
			terminals.add(sentence.grams()[sentence.grams().length - 1]);
			
			INGram[] ngrams = sentence.grams();
			for(int i = 0; i < ngrams.length - 1; i++) {
				if(!stats.containsKey(ngrams[i])) {
					stats.put(ngrams[i], new LinkedList<INGram>());
				} 
				stats.get(ngrams[i]).add(ngrams[i + 1]);
			}
		}
	}

}
