package cmd0;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    DictionaryManagement dictionarymanagement= new DictionaryManagement();
    private ArrayList<Word> words = new ArrayList<>();
    public void showAllWords(){
        ArrayList<Word>words=dictionarymanagement.dictionary.getWords();

        System.out.println("No\t"+" | English\t\t"+"| Vietnamese");
        int size=words.size();
        for(int i=0;i<size;i++){
            System.out.println((i+1)+"\t| "+words.get(i).getWord_target()+"\t\t"+"| "+words.get(i).getWord_explain());
        }
    }
    public void dictionaryBasic() {
        dictionarymanagement.insertFromCommandline();
        dictionarymanagement.insertFromCommandline();

       // dictionarymanagement.insertFromFile();
        showAllWords();
    }
    //public void dictionaryAdvanced(){
    public String dictionaryAdvanced(String word_target){
        dictionarymanagement.insertFromFile();
        return "FUCK";
        // dictionarymanagement.dictionaryLookup();
    }
    public void dictionarySearcher(String word_target){
        ArrayList<Word> words =dictionarymanagement.dictionary.getWords();
        int size = words.size();
        int i=0;
        for ( i=0;i<size;i++) {
            if (words.get(i).getWord_target().startsWith(word_target)) {
                System.out.println("ket qua :" + words.get(i).getWord_target() + "\t\t" + words.get(i).getWord_explain());

            }


    }



  }}


