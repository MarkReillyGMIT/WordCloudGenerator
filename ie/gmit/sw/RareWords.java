package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RareWords {
	
	private static ArrayList<String> DicList;
	private static ArrayList<String> wordIgnore;
	private static String[] words;

	private static ArrayList<String> duplicatevalues = new ArrayList<String>();
	private static ArrayList<String> rareValues = new ArrayList<String>();
	private static Map<String, Integer> OccurrMap = new HashMap<>();

	public void createSpecialWords() throws IOException {

		ReadDictionaryFile dictionaryfiles = new ReadDictionaryFile();
		
		ReadIgnoreWordsFile stopFiles = new ReadIgnoreWordsFile();
		
		
		DicList = dictionaryfiles.getTheDictionaryWords();
		wordIgnore = stopFiles .getStopWords();

		for (String itemContain : DicList) {
			if (wordIgnore.contains(itemContain)) {
				duplicatevalues.add(itemContain);
			} else {
				rareValues.add(itemContain);
			}
		}
		for (String itms : rareValues) {

		
			if (itms.length() > 0) {
				if (OccurrMap.get(itms) == null) {
					OccurrMap.put(itms, 1);
				} else {
					int v = OccurrMap.get(itms).intValue();
					v++;
					OccurrMap.put(itms, v);
				}
			}

		}

	
		words = new String[rareValues.size()];
		words = rareValues.toArray(words);

		//
		Set<Map.Entry<String, Integer>> entrySetss = OccurrMap.entrySet();
		
		 List<Map.Entry<String, Integer>> itemList = new ArrayList<Map.Entry<String, Integer>>(entrySetss);
	        Collections.sort(itemList, new Comparator<Map.Entry<String, Integer>>() {
	            public int compare(Map.Entry<String, Integer> zero1,
	                    Map.Entry<String, Integer> zero2) {
	                return zero2.getValue().compareTo(zero1.getValue());
	            }
	        });
	        
	    
	        
	        int count = 0;
			for (Map.Entry<String, Integer> entry : itemList) {

				count++;
				if (count == 100) {
					break;
				}
			

				int fontSize = WordFontSize.getFontSizes(entry.getValue());
				
				WordCloudGen simpleword = new WordCloudGen();
				simpleword.drawWord(entry.getKey(), fontSize);

			}
			WordCloudGen.Write();
			Display.displayArrayListSize(duplicatevalues, words, DicList, wordIgnore);
	}


}
