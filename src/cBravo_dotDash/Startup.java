package cBravo_dotDash;

import java.util.List;

import edu.neumont.nlp.DecodingDictionary;

public class Startup {

	public static void main(String[] args) {
		
		DecodingDictionary dd = new DecodingDictionary();
		ExhaustiveDecoder decoder = new ExhaustiveDecoder(dd, 100);
		List<String> possibilities = decoder.decode(".-......-........-....-.-...--...----..----..-.-.-.....----.-.---.-...--....");
		for ( int i = 0; i < possibilities.size(); i++ ) {
			System.out.println(i + ": " + possibilities.get(i));
		}


		
	}

}
