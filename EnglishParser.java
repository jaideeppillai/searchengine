/**
 * 
 */
/**
 * @author Jaideep
 *
 */
package com.jaideep.search.parse.lang;

import com.jaideep.search.parse.AbstractParser;
import com.jaideep.search.parse.Parser;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.util.logging.Redwood;


public class EnglishParser extends AbstractParser {

	public String[] parse(String args[]) {
		  
			    String modelPath = DependencyParser.DEFAULT_MODEL;
			    String taggerPath = "edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger";
			    int  argIndex;
			    for (argIndex = 0; argIndex < args.length; ) {
			      switch (args[argIndex]) {
			        case "-tagger":
			          taggerPath = args[argIndex + 1];
			          argIndex += 2;
			          break;
			        case "-model":
			          modelPath = args[argIndex + 1];
			          argIndex += 2;
			          break;
			        default:
			          throw new RuntimeException("Unknown argument " + args[argIndex]);
			      }
			    }

			    String text = "I can almost always tell when movies use fake dinosaurs.";

			    MaxentTagger tagger = new MaxentTagger(taggerPath);
			    DependencyParser parser = DependencyParser.loadFromModelFile(modelPath);

			    DocumentPreprocessor tokenizer = new DocumentPreprocessor(new StringReader(text));
			    for (List<HasWord> sentence : tokenizer) {
			      List<TaggedWord> tagged = tagger.tagSentence(sentence);
			      GrammaticalStructure gs = parser.predict(tagged);

			      // Print typed dependencies
			      System.out.println(gs);
			      return null;
			    }
	}

