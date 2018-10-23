package cmd0;


import sample.Translator.Translator2;

import java.util.ArrayList;

public class DictionaryCommandline {
    DictionaryManagement dictionarymanagement = new DictionaryManagement();

    public DictionaryCommandline(String path) {
        this.dictionarymanagement.insertFromFile(path);

    }
    public DictionaryCommandline() {
    }


    private ArrayList<Word> words = new ArrayList<>();


    public String dictionaryAdvanced(String a) {
        return dictionarymanagement.dictionaryLookup(a);
    }

    public ArrayList<String> dictionarySearcher(String word_target) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Word> words = dictionarymanagement.dictionary.getWords();
        System.out.println(words.size());
        int size = words.size();
        int i = 0;
        for (i = 0; i < size; i++) {
            if (words.get(i).getWord_target().startsWith(word_target)) {
                result.add(words.get(i).getWord_target());

            }

        }
        return result;


    }

    public String api(String lang, String to, String e) {
        String data = "";
        Translator2 translator2 = new Translator2();
        try {
            data = translator2.callUrlAndParseResult(lang, to, e);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return data;
    }


    public String addfile(String E, String V,String path) {
        ArrayList<Word> words = dictionarymanagement.dictionary.getWords();
        int i;
        int dem = 0;
        String test = null;
        int index = 0;
        int size = words.size();
        for (i = 0; i < size; i++) {
            if (E.equals(words.get(i).getWord_target())) {
                index = i;
                dem = 1;
            }
        }
        if(E.equals("")||V.equals(""))test="Điền đủ từ và nghĩa!!!";
        else if (dem == 1) test = "Từ đã tồn tại!!!";
        else {
            test = "Success";
            String edit = "<i>" + E + "</i><br/><ul><li><font color='#cc0000'><b>" + V + "</b></font></li></ul></html>";
            if (!edit.startsWith("<html>") || !edit.contains("</html>")) {
                edit = "<html>" + edit + "</html>";
            }
            Word word = new Word(E, edit);
            dictionarymanagement.dictionary.Push(word);
            dictionarymanagement.dictionaryExportToFile(dictionarymanagement.dictionary.getWords(),path);


        }
        return test;
    }

    public String edit(String E, String V,String path) {
        String test="";
        if(E.equals("")||V.equals(""))test="Điền từ !!!";
        else if(delete(E,path).equals("Không có từ để xóa...."))test="Không có từ để sửa";
        else test="Success";
        String edit = "<i>" + E + "</i><br/><ul><li><font color='#cc0000'><b>" + V + "</b></font></li></ul></html>";
        addfile(E, edit,path);
        return test;


    }

    public String delete(String E,String path) {
        String test = "";
        //System.out.println("Start remove word...");
        ArrayList<Word> words = dictionarymanagement.dictionary.getWords();
        int i;
        boolean isExistWord = false;
        int index = -1;
        int size = words.size();    // Fuck
        for (i = 0; i < words.size(); i++) {
            if (E.equals(words.get(i).getWord_target())) {
                //System.out.println("Remove: " + words.get(i).getWord_target());
                index = i;
                test = "Done";
                words.remove(index);
                break;
            }
        }

        //if(index!=-1) words.remove(index);
        dictionarymanagement.dictionaryExportToFile(words,path);
        if (!test.equals("Done")) test = "Không có từ để xóa....";
        return test;

    }

}



