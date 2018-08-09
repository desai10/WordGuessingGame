import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Dictionary {

    Map<String, ArrayList<String >> dictionary;

    public Dictionary(int size) throws Exception{
        dictionary = new HashMap<>();
        generateDict(size);
        System.out.println(dictionary);
        System.out.println(dictionary.size());
    }

    void generateDict(int size) throws Exception{
        String FILE = "/Users/srdesai/Documents/Bootcamp/WordGuessingGame/src/resources/sowpods.txt";
        BufferedReader br = new BufferedReader(new FileReader(FILE));

        String str;
        while((str=br.readLine())!=null){
            char temp[] = str.toCharArray();
            Arrays.sort(temp);
            String anagram = new String(temp);
            if(!hasRepeatingCharacters(str) && str.length() == size) {
                if(dictionary.containsKey(anagram)){
                    ArrayList<String> as = dictionary.get(anagram);
                    as.add(str);
                    dictionary.put(anagram,as);
                }else{
                    ArrayList<String> as = new ArrayList<>();
                    as.add(str);
                    dictionary.put(anagram,as);
                }
            }
        }
    }

    private boolean hasRepeatingCharacters(String str) {
        Map<Character, Integer> ma = new HashMap<>();
        for(int i=0;i<str.length();i++) {
            if(ma.containsKey(str.charAt(i))) {
                return true;
            }
            ma.put(str.charAt(i), 1);
        }
        return false;
    }

}
