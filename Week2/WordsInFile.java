package Week2;
import java.util.*;
import edu.duke.*;
import java.io.File;

public class WordsInFile {
    private HashMap<String, ArrayList<String>> filenamesList;
    
    public WordsInFile(){
        filenamesList = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String fileName = f.getName();
        for(String word : fr.words()){
            ArrayList<String> list = new ArrayList<String>();
            if(filenamesList.containsKey(word)) {
                list = filenamesList.get(word);
                if(list.contains(fileName)) continue;
            }
            
            list.add(fileName);
            filenamesList.put(word, list);
        }
    }
    
    private void buildWordFileMap(){
        filenamesList.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    private int maxNumber(){
        int maxValue = 0;
        for(ArrayList<String> val : filenamesList.values()){
            int filesSize = val.size();
            if(maxValue<filesSize) {
                maxValue = filesSize;
            }
        }
        
        return maxValue;
    }
    
    private ArrayList<String> wordsInNumFiles(int numb){
        ArrayList<String> ans = new ArrayList<String>();
        for(String k : filenamesList.keySet()){
            ArrayList<String> list = filenamesList.get(k);
            if(list.size() == numb) ans.add(k);
        }
        
        return ans;
    }
    
    private void printFilesIn(String word){
        if(filenamesList.containsKey(word)){
            System.out.println(word + " appears in:");
            for(String fileName : filenamesList.get(word)) {
                System.out.println("   -"+fileName);
            }
            System.out.println();
        }
    }
    
    public void tester(){
        buildWordFileMap();
        int maxNumberOfFiles = maxNumber();
        ArrayList<String> wordsInMaxNumberOfFiles = wordsInNumFiles(maxNumberOfFiles);
        System.out.println("Words that appears in " + maxNumberOfFiles + " files are:");
        for(String word : wordsInMaxNumberOfFiles){
            System.out.println(word);
            printFilesIn(word);
        }
        System.out.println("The maximum number of files that any word appears is: " + maxNumberOfFiles);
        System.out.println("The number of words that appears in " + maxNumberOfFiles + " files is:" + wordsInMaxNumberOfFiles.size());
        printFilesIn("tree");
    }
}
