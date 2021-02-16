package Week2;
import java.util.*;
import edu.duke.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        for(String word : fr.words()){
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if(index == -1){
                myWords.add(word);
                myFreqs.add(1);
            } else {
                int freq = myFreqs.get(index);
                myFreqs.set(index, freq + 1);
            }
            
        }
    }
    
    public void testFindUnique(){
        findUnique();
        int maxIndex = findIndexOfMax();
        System.out.println("The number of unique words is: "+ myWords.size());
        for(int k=0; k<myWords.size(); k++){
            System.out.println(myWords.get(k) + " = " + myFreqs.get(k) );
        }
            System.out.println("The largest frequency is the word = " + myWords.get(maxIndex) + "(" + myFreqs.get(maxIndex) + ")");
    }
    
    public int findIndexOfMax(){
        int maxIndex = 0;
        int maxVal = 0;
        for(int i=0; i<myFreqs.size(); i++){
            if(maxVal<myFreqs.get(i)) {
                maxIndex = i;
                maxVal = myFreqs.get(i);
            };
        }
        return maxIndex;
    }
   
    
}
