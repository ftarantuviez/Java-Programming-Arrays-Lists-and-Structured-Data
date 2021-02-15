package Week1;
import edu.duke.*;


public class CaesarCipher {
    
    public String encrypt(String input, int key){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        StringBuilder encrypted = new StringBuilder(input);
        
        for(int i=0; i<input.length(); i++){
            char character = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toLowerCase(character));
            
            if (idx != -1){
                char newChar = shiftAlphabet.charAt(idx);
                if(Character.isLowerCase(character)) encrypted.setCharAt(i, newChar);
                else encrypted.setCharAt(i, Character.toUpperCase(newChar));
            }
        }
        
        return encrypted.toString();
    }
    
    public void testEncrypt(){
        int key = 15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        StringBuilder encrypted = new StringBuilder(input);
        
        for(int i=0; i<input.length(); i++){
            char character = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toLowerCase(character));
            
            if (idx != -1){
                String alphabetToUse = shiftedAlphabet1;
                if(i % 2 != 0) alphabetToUse = shiftedAlphabet2;
                char newChar = alphabetToUse.charAt(idx);
                if(Character.isLowerCase(character)) encrypted.setCharAt(i, newChar);
                else encrypted.setCharAt(i, Character.toUpperCase(newChar));
            }
        }
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys(){
        int key1 = 2;
        int key2 = 20;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String encrypted = encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 26-key1, 26-key2);
        System.out.println(encrypted);
    }
}
