public class StringProcessor {
    //declare a private string variable?
    private String ss;

    //two constructors:
    StringProcessor(){
        //make this constructor
        setString("");
    }

    StringProcessor(String s){
        setString(s);
    }


    //get and set methods (use in constructors..):
    public void setString(String s){
        ss = s;
    }

    public String getString(){
        return ss;
    }


    //other methods
    public int wordCount(){
        String s = getString();
        String[] words = s.split(" ");
        return words.length;
    }

    public int uppercaseCount(){
        String s = getString();
        char[] wordChars = s.toCharArray();
        int upperCt = 0;
        for (char c:wordChars) {
            if(Character.isUpperCase(c)){
                upperCt++;
            }
        }
        return upperCt;
    }

    public int digitCount(){
        String s = getString();
        char[] wordChars = s.toCharArray();
        int digCt = 0;
        for (char c:wordChars) {
            if(Character.isDigit(c)){
                digCt++;
            }
        }
        return digCt;
    }

    public int digitWordCount(){
        String s = getString();
        String[] words = s.split(" ");
        String[] digWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int digwrdCt = 0;
        for (String w: words) {
            for (String n:digWords) {
                if(n.equals(w.toLowerCase())){
                    digwrdCt++;
                }
            }
        }
        return digwrdCt;
    }


    public String getNoSpaceString(){
        //char? or word then mush together
        String s = getString();
        String[] words = s.split(" ");
        String nosp = words[0];
        for (int i=1; i<words.length; i++) {
            nosp = nosp+words[i];
        }
        return nosp;
    }

    public String getNoVowelString(){
        //char
        String s = getString();
        char[] wordChars = s.toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        //ignoring sometimes y
        String novw = "";
        for (char c:wordChars) {
            char ctouse = c;
            for (char v:vowels) {
                if(v==Character.toLowerCase(c)){
                    ctouse='-';
                }
            }
            novw = novw + ctouse;
        }
        return novw;
    }

    public String getNoDigitWordString(){
        //words ->strsplit
        String s = getString();
        String[] words = s.split(" ");
        String[] digWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] digs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String nodw = "";
        for (int j=0; j<words.length; j++) {
            String wordtouse;
            if(j==words.length-1) {
                wordtouse = words[j];
            }
            else {
                wordtouse = words[j] + " ";
            }
            for (int i=0; i<digWords.length; i++) {
                String dw = digWords[i];
                if(dw.equals(words[j].toLowerCase())){
                    wordtouse = digs[i] + " ";
                }
            }
            nodw = nodw + wordtouse;
        }
        return nodw;
    }
}
