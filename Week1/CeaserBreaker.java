package Week1;
import edu.duke.*;

public class CeaserBreaker {
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            
            if(dex != -1) counts[dex] += 1;
        }
        
        return counts;
    }
    
    public int maxIndex(int[] freqs){
        int maxIdx = 0;
        for(int i=0; i<freqs.length; i++){
            if(freqs[i]>freqs[maxIdx]){
                maxIdx = i;
            }
        }
        
        return maxIdx;
    }
    
    public String decrypt (String encrypted) {
        CaesarCipher CeasarCipher = new CaesarCipher();
        int [] freqs = countLetters(encrypted);
        int maxIndex = maxIndex(freqs);
        int distanceKey = maxIndex - 4;
        if (maxIndex < 4) {
            distanceKey = 26 - (4 - maxIndex);
        }
        String message = CeasarCipher.encrypt(encrypted, 26 - distanceKey);
        return message;
    }
    
    public void testDecrypt () {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        String decrypted = decrypt(encrypted);
        System.out.println("The decrypted message is " + decrypted);
    }
    
    public String halfOfString(String message, int start){
        StringBuilder ans = new StringBuilder();
        String str = message.substring(start);
        for(int k=0; k<str.length(); k++){
            if(k%2==0) ans.append(message.charAt(k+start));
        }
        
        return ans.toString();
    }
    
    public void testHalfOfString(){
        System.out.println(halfOfString("Qbkm Zgis", 1));
    }
    
    public int getKey(String s){
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        
        int distanceKey = maxDex - 4;
        if (maxDex < 4) {
            distanceKey = 26 - (4 - maxDex);
        }
        
        return distanceKey;
    }

    
    public String decryptTwoKeys (String encrypted) {
        CaesarCipher CeasarCipher = new CaesarCipher();
        
        String half1 = halfOfString(encrypted, 0);
        String half2 = halfOfString(encrypted, 1);
        
        int keyHalf1 = getKey(half1);
        int keyHalf2 = getKey(half2);
        
        System.out.println("Key 1: " + keyHalf1 + ", key 2: " + keyHalf2);
        
        String message = CeasarCipher.encryptTwoKeys(encrypted, 26 - keyHalf1, 26 - keyHalf2);
        return message;
    }
    
    public void testDecryptTwoKeys () {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        String decrypted = decryptTwoKeys(encrypted);
        System.out.println("The decrypted message is " + decrypted);
    }
}

