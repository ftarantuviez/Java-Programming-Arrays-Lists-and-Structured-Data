package Week2.GladLib;

import edu.duke.*;
import java.util.*;

public class GladLib {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> fruitList;
    private ArrayList<String> verbList;
    
    private Random myRandom;
    private ArrayList<String> wordsAlreadyUsedList;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "Week2/GladLib/data";
    
    public GladLib(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        adjectiveList= readIt(source+"/adjective.txt"); 
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");      
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");     
        verbList = readIt(source+"/verb.txt");
        fruitList = readIt(source+"/fruit.txt");
        wordsAlreadyUsedList = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        String word = null;

        switch(label){
            case "country":
                word = randomFrom(countryList);
            break;
            case "color":
                word = randomFrom(colorList);
            break;
            case "noun":
                word = randomFrom(nounList);
            break;
            case "name":
                word = randomFrom(nameList);
            break;
            case "adjective":
                word = randomFrom(adjectiveList);
            break;
            case "animal":
                word = randomFrom(animalList);
            break;
            case "timeframe":
                word = randomFrom(timeList);
            break;
            case "verb":
                word = randomFrom(verbList);
            break;
            case "fruit":
                word = randomFrom(fruitList);
            break;
            case "number":
                word = ""+myRandom.nextInt(50)+5;
            break;
            default:
                word = "**UNKNOWN**";
        }
        
        if(wordsAlreadyUsedList.contains(word)) getSubstitute(label);
        wordsAlreadyUsedList.add(word);
        return word;
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("Week2/GladLib/data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("Were replaced = " + wordsAlreadyUsedList.size());
    }
    


}
