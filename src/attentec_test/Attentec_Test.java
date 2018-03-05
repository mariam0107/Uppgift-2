//Uppgift 2
package attentec_test;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author maria
 */
public class Attentec_Test {

    public static void main(String[] args) {
        String s;
        ArrayList<String> aListNames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE STRING");  //Read the String
        s = sc.nextLine();

        aListNames = replaceCharacters(s);//store the result to a new arrayList

        String strNames[] = new String[aListNames.size()];//create a string array

        //iterate ArrayList and add elements to an array
        for (int i = 0; i < aListNames.size(); i++) {
            strNames[i] = aListNames.get(i);
        }

        //print array
        System.out.println("New String is: ");
        for (String strName : strNames) {
            System.out.print(strName);
        }
        System.out.println();
    }

    public static ArrayList<String> replaceCharacters(String s) {
        ArrayList<String> newString = new ArrayList<>();
        String s3;
        char c;
        //takes for each character in the string and checks for the condition
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'y') {
                newString.add("om");
            } else if (s.charAt(i) == 'z') {
                newString.add("och");
            } else if (s.charAt(i) == 'o') {
                if (i == 0) {               //if 'o' happens to be the first character
                    newString.add("poe");
                } else if (i != 0) {        //if 'o' is not the first character
                    if (s.charAt(i - 1) == 'b' || s.charAt(i - 1) == 'B' || s.charAt(i - 1) == 'T' || s.charAt(i - 1) == 't') {
                        newString.add("od");

                    } else {
                        int vc = vowelOrConsonant(s.charAt(i - 1));//pass the character to a function to check if it is vowel or others
                        if (vc == 1) {//if character is a vowel
                            newString.add("n");
                        } else if (vc == 2) {//if character is not a vowel
                            //checks if the character is a alphabet(consonant) or not
                            if ((s.charAt(i - 1) >= 'a' && s.charAt(i - 1) <= 'z') || (s.charAt(i - 1) >= 'A' && s.charAt(i - 1) <= 'Z')) {
                                newString.add("oden");//if consonant add 'oden' to arraylist newstring
                            } else {
                                newString.add("poe");//if characters other than vowel/consonat add 'poe' to arraylist newstring
                            }

                        }
                    }
                }

            } else {
                // keep all the other characters in the original String same
                c = s.charAt(i);
                s3 = String.valueOf(c);
                newString.add(s3);
            }
        }
        return newString;
    }
//function to check for vowel or others

    public static int vowelOrConsonant(char c) {
        int a;
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                a = 1;    //
                break;
            default:
                a = 2;

        }
        return a;   //returns 1 if vowel else returns 2 for consonants/other characters/digits

    }

}
