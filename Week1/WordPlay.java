package Week1;

public class WordPlay {
    public boolean isVowel(Character ch){
        String vowels = "aeiou";
        
        return vowels.indexOf(Character.toLowerCase(ch)) != -1;
    }
    
    public String replaceVowels(String phrase, Character ch){
        StringBuilder str = new StringBuilder(phrase);
        StringBuilder ans = new StringBuilder("");
        for(int i=0; i<phrase.length(); i++){
            char character = str.charAt(i);
            if(isVowel(character)) ans.insert(i, ch);
            else ans.insert(i, character);
        }
        
        return ans.toString();
    }
    
    public void testReplaceVowels(){
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    public String emphasize(String phrase, Character ch){
        StringBuilder ans = new StringBuilder("");
        StringBuilder str = new StringBuilder(phrase);
        
        for(int i=0; i<phrase.length(); i++){
            char character = phrase.charAt(i);
            if(Character.toLowerCase(character) == Character.toLowerCase(ch)){
                if(i % 2 == 0) ans.insert(i, "*");
                else ans.insert(i, "+");
            } else ans.insert(i,character);
        }
        
        return ans.toString();
    }
    
    public void testEmphasize(){
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
