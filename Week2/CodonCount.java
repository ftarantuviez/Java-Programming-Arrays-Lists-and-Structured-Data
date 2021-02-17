package Week2;
import java.util.*;
import edu.duke.*;
import java.util.Scanner;

public class CodonCount {
    private HashMap<String,Integer> codonCount;
    
    public CodonCount(){
        codonCount = new HashMap<String,Integer>();
    }
    
    private void buildCodonMap(int start, String dna){
        codonCount.clear();
        dna = dna.toUpperCase();
        int firstIndex = start;
        for(int i=start; i<dna.length(); i++){
            int lastIndex = firstIndex+3;
            if(lastIndex>dna.length()) break;
            String key = dna.substring(firstIndex, lastIndex);
            firstIndex += 3;
            int value = 1;
            if(codonCount.containsKey(key)) value = codonCount.get(key)+1;
            
            codonCount.put(key, value);
        }
        
    }
    
    private String getMostCommonCodon(){
        String commonCodon = null;
        for(String k : codonCount.keySet()){
            if(commonCodon == null) commonCodon = k;
            
            if(codonCount.get(k)>codonCount.get(commonCodon)) commonCodon = k;
        }
        
        return commonCodon;
    }
    
    private void printCodonCounts(int start, int end){
        for(String k : codonCount.keySet()){
            int val = codonCount.get(k);
            if(val>=start && val<=end) System.out.println(k + " = " + val);
        }
    }
    
    public void testBuildCodonMap(){
        FileResource fr = new FileResource();
        String dna = "CGTTCAAGTTCAA";
        buildCodonMap(0, dna);
        
        for(String k : codonCount.keySet()){
            System.out.println("The codon " + k + " appears " + codonCount.get(k) + " times.");
        }
        String commonCodon = getMostCommonCodon();
        System.out.println("The most common codon is " + commonCodon + " that appears " + codonCount.get(commonCodon));
        System.out.println("Codons that are between 2 and 5 times are: ");
        printCodonCounts(2, 5);
    }
    
    public void testFramesCodonCounts(){
        String dnaPractice = "ATTAATACTTTGTTTAACAGTAATTATTCAACTATTAAATATTTAAATAATTAAGTTATTAAACTATTAAGTACAGGGCCTGTATCTCTGATGCTGAACTATGATGTGTGACTTAAGCCCCCAAATACATCATGTTATTTGGATCCAAGGTGCTGCACAGAACGCTGACCCTCTCTAAGAGCTGGGTATTACT";
        String dna = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC";
        
        for(int i=0; i<3; i++){
            System.out.println("Reading frame starting with " + i);
            buildCodonMap(i, dna);
            String commonCodon = getMostCommonCodon();
            System.out.println("The quantity of unique codons is: " + codonCount.size());
            System.out.println("The most common codon is " + commonCodon + " that appears " + codonCount.get(commonCodon));
            System.out.println("Codons that are between 1 and 5 times are: ");
            printCodonCounts(6, 7);
        }
    }
    
}
