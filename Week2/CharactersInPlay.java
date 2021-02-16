package Week2;
import java.util.ArrayList;
import edu.duke.FileResource;

public class CharactersInPlay {
    private ArrayList<String> myChars;
    private ArrayList<Integer> myFreqs; 
    
    public CharactersInPlay(){
        myChars = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void update(String person){
        int index = myChars.indexOf(person);
        if(index == -1) {
            myChars.add(person);
            myFreqs.add(1);
        } else {
            int val = myFreqs.get(index);
            myFreqs.set(index, val + 1);
        }
    }
    
    public void findAllCharacters(){
        myChars.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            int periodIndex = line.indexOf(".");
            if(periodIndex != -1){
                String possibleChar = line.substring(0, periodIndex);
                update(possibleChar);
            }
        }
    }
    
    public void testFindAllCharacters(){
        findAllCharacters();
        int num1 = 2;
        int num2 = 1000;
        charactersWithNumParts(num1, num2);
        
        //for(int k=0; k<myChars.size(); k++){
            //System.out.println(myChars.get(k) + " = " + myFreqs.get(k));
        //}
    }
    
    public void charactersWithNumParts(int num1, int num2){
        for(int i=0; i<myChars.size(); i++){
            String charac = myChars.get(i);
            int freq = myFreqs.get(i);
            
            if(freq>=num1 && freq<=num2){
                System.out.println(charac + " talks " + freq + " times ");
            }
        }
    }
}
