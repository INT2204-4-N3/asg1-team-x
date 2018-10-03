package cmd0;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();


    public void insertFromCommandline() {
        Scanner output = new Scanner(System.in);
        String word_target = output.nextLine();
        String word_explain = output.nextLine();
        Word word = new Word(word_target, word_explain);

        dictionary.Push(word);
    }

    public void insertFromFile() {

        BufferedReader br = null;
        String[] wordonline;
        String textInALine;
        try {
            br = new BufferedReader(new FileReader("dic.txt"));
            while ((textInALine = br.readLine()) != null) {
                wordonline = textInALine.split("\t");
                Word word = new Word(wordonline[0], wordonline[1]);
                dictionary.Push(word);

            }
        } catch (Exception e) {}
            /*e.printStackTrace();
        }/* finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }

    public void dictionaryLookup( ) {
        ArrayList<Word> words = dictionary.getWords();
        System.out.println("nhập từ tìm kiếm");
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
        int size = words.size();
        int i=0;
        for ( i=0;i<size;i++) {
            if (word_target.equals(words.get(i).getWord_target())) {
                System.out.println("ket qua :" + words.get(i).getWord_target() + "\t\t" + words.get(i).getWord_explain());

            }
        }


    }


    public Dictionary getDictionary() {
        return dictionary;
    }
}