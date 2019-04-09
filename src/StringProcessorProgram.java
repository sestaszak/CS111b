import java.util.Scanner;

public class StringProcessorProgram {

    public static void main(String[] args){
        //String teststring = "One for the money, two for the show";
        //hardcodeStrings(teststring);
        //String teststring2 = "3 Blind Mice is one of my favorite songs.";
        //hardcodeStrings(teststring2);

        userInputStrings();
    }

    public static void userInputStrings(){

        do{
            Scanner input = new Scanner(System.in);
            //get string and make StringProcessor object
            System.out.print("Enter a line of text: ");
            String text = input.nextLine();
            StringProcessor ui = new StringProcessor(text);
            //print info about string
            System.out.println("words: " + ui.wordCount());
            System.out.println("uppercase: " + ui.uppercaseCount());
            System.out.println("digits: " + ui.digitCount());
            System.out.println("digit words: " + ui.digitWordCount());
            System.out.println("line with whitespace removed: \"" + ui.getNoSpaceString() + "\"");
            System.out.println("line with vowels replaced: \"" + ui.getNoVowelString() + "\"");
            System.out.println("line with digits replaced: \"" + ui.getNoDigitWordString() +"\"");

        }while(shouldPlayAgain());
    }

    public static boolean shouldPlayAgain() {
        //ask if play again, read character, return boolean based on character
        Scanner input = new Scanner(System.in);
        System.out.print("do you want to enter another? (y/n): ");
        char response = input.next().charAt(0);
        boolean playAgain = (response == 'y');
        return playAgain;
    }

    public static void hardcodeStrings(String hc){
        StringProcessor ui = new StringProcessor(hc);
        //print info about string
        System.out.println("words: " + ui.wordCount());
        System.out.println("uppercase: " + ui.uppercaseCount());
        System.out.println("digits: " + ui.digitCount());
        System.out.println("digit words: " + ui.digitWordCount());
        System.out.println("line with whitespace removed: \"" + ui.getNoSpaceString() + "\"");
        System.out.println("line with vowels replaced: \"" + ui.getNoVowelString() + "\"");
        System.out.println("line with digits replaced: \"" + ui.getNoDigitWordString() +"\"");
    }
}
