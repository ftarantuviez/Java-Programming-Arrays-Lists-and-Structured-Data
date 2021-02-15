package Week1;
import edu.duke.*;

public class WordLenghts {

    public void countWordLengths(FileResource fr, int[] counts){
        for(String word : fr.words()){
            int len = 0;
            for(int i=0; i<word.length(); i++){
                if(Character.isLetter(word.charAt(i))) len += 1;
            }
            if(len>30) counts[31] += 1;
            else counts[len] += 1;
        }
    }
    
    public void testCountWordLengths(){
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
        int j = 0;
        for(int i : counts){
            if(i>0) System.out.println("Words with length = " + j + " are: " + i);
            j++;
        }
    }

}
