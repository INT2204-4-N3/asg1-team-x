package cmd0;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();


    public void insertFromCommandline() {
        Scanner output = new Scanner(System.in);
        String word_target = output.nextLine();
        String word_explain = output.nextLine();
        Word word = new Word(word_target, word_explain);

        dictionary.Push(word);
    }



    public String dictionaryLookup(String a ) {
        ArrayList<Word> words = dictionary.getWords();
        String data=null;
        int size = words.size();
        int i=0;
        for ( i=0;i<size;i++) {
            if (a.equals(words.get(i).getWord_target())) {
                data=words.get(i).getWord_explain();
            }
        }
        return data;


    }


    public void insertFromFile(String path) {
        String[] wordonline;
        String textInALine;

        try {
            FileInputStream fileInPutStream = new FileInputStream(path);
            Reader reader = new java.io.InputStreamReader(fileInPutStream, "UTF8");
            BufferedReader br = null;
            br = new BufferedReader(reader);
            while ((textInALine = br.readLine()) != null) {
                int posSplit = textInALine.indexOf("<html>");
                if (posSplit > 0 && posSplit < textInALine.length()) {
                    String spelling = textInALine.substring(0, posSplit);
                    String explain = textInALine.substring(posSplit);
                    Word word = new Word(spelling, explain);
                    dictionary.Push(word);
                }
            }


        }
        catch (Exception e) {}

    }

    public void dictionaryExportToFile( ArrayList<Word> words,String path) {
        words=dictionary.getWords();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (Word word : words) {
                bufferedWriter.write(word.getWord_target() + word.getWord_explain());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            System.setProperty("file.encoding","utf-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
