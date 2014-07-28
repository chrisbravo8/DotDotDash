package cBravo_dotDash;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.neumont.nlp.DecodingDictionary;

public class ExhaustiveDecoder {
	DecodingDictionary dd;
	List<String> possibilities = new ArrayList<String>();
	String beforeWord = null;
	boolean runonce = true;
	String sentance;

	public ExhaustiveDecoder(DecodingDictionary _dd, int i) {
		// TODO Auto-generated constructor stub
		dd = _dd;

	}

	public List<String> decode(String message) {
		Set<String> codes = dd.getCodes();
		for (int i = 1; i < message.length(); i++) {
			if (codes.contains(message.substring(i))) {
				Set<String> words = dd.getWordsForCode((message.substring(i)));
				for (String word : words) {
					if ((runonce)
							|| (dd.frequencyOfFollowingWord(beforeWord, word) > 0)) {
						System.out.println(word);
						beforeWord = word;
						decode(message.substring(0, i));
						runonce = false;
					}
				}
			}
		}

		return possibilities;
	}
}
