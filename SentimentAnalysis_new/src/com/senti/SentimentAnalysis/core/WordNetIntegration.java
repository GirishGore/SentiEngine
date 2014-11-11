package com.senti.SentimentAnalysis.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class WordNetIntegration {

    static Set<String> wordstosearch = new HashSet<String>();
    static int wordsearchcount = 0;
    static String myworddic = "Good Bad ";

    private static WordNetDatabase wordnetdb;

    WordNetIntegration()
    {
        System.setProperty("wordnet.database.dir","C:\\Program Files (x86)\\WordNet\\2.1\\dict\\");
        wordnetdb = WordNetDatabase.getFileInstance();
    }


    public void printCollection(Collection collection) {

        for (Object obj : collection) {
            System.out.println(obj);
        }
    }


    private StringBuilder getSynonyms(String inputWordString)
    {
        StringBuilder synonyms = new StringBuilder();
        String[] wordFormArray = inputWordString.split(" ");

        //WordNetDatabase wordnetdb = WordNetDatabase.getFileInstance();

        for (String element : wordFormArray) {
            StringBuilder wordForm = new StringBuilder(element);
            Synset[] synsets1 = wordnetdb.getSynsets(wordForm.toString());

            if (synsets1.length > 0) {
                for (Synset element2 : synsets1) {

                    String[] wordForms = element2.getWordForms();
                    for (String wordForm2 : wordForms) {
                        synonyms.append(wordForm2+ " ");
                    }

                }
            } else {
                System.err.println("No synsets exist that contain "	+ "the word form '" + wordForm + "'");
            }
        }

        this.printCollection(wordstosearch);
        return synonyms;
    }

    //	public static void main(String args[]) {
    //
    //		System.setProperty("wordnet.database.dir","C:\\Program Files (x86)\\WordNet\\2.1\\dict\\");
    //
    //		NounSynset nounSynset;
    //		NounSynset[] hyponyms;
    //
    //		WordNetDatabase database = WordNetDatabase.getFileInstance();
    //
    //
    //		Synset[] synsets = database.getSynsets("fly", SynsetType.NOUN);
    //		for (int i = 0; i < synsets.length; i++) {
    //			nounSynset = (NounSynset) (synsets[i]);
    //			hyponyms = nounSynset.getHyponyms();
    //			System.err.println(nounSynset.getWordForms()[0] + ": "
    //					+ nounSynset.getDefinition() + ") has " + hyponyms.length
    //					+ " hyponyms");
    //		}
    //
    //		// if (args.length > 0)
    //		// {
    //		// Concatenate the command-line arguments
    //		StringBuffer buffer = new StringBuffer();
    //		for (int i = 0; i < args.length; i++) {
    //			buffer.append((i > 0 ? " " : "") + args[i]);
    //		}
    //
    //
    //		// }
    //		// else
    //		// {
    //		// System.err.println("You must specify " +
    //		// "a word form for which to retrieve synsets.");
    //		// }
    //
    //
    //	}


}
