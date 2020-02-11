package io.zipcoder;


import java.util.ArrayList;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        String[] splitted = input.split(" ");
        int amt = 0;
        char y = 'Y';
        char x = 'Z';
        char yL = 'y';
        char xL = 'z';
        ArrayList<Character> countChars = new ArrayList<>();
        countChars.add(x); countChars.add(y);
        countChars.add(xL); countChars.add(yL);
        for (String s : splitted) {
            for (char cha : countChars) {
                if (s.charAt(s.length() - 1) == cha) {
                    amt++;
                    System.out.println(s.charAt(s.length() - 1));
                    break;
                }
            }
        }

        return amt;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String toRet = base.replace(remove, "");
        return toRet;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int isAmt = 0;
        int notAmt = 0;
        for (String s : input.split(" ")) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'i') {
                    if (i + 1 < arr.length && i + 1 >= 0) {
                        if (arr[i + 1] == 's') {
                            isAmt++;
                        }
                    }
                }

                else if (arr[i] == 'n') {
                    if (i + 1 < arr.length && i + 1 >= 0) {
                        if (arr[i + 1] == 'o' && i + 2 < arr.length) {
                            if (arr[i + 2] == 't') {
                                notAmt++;
                            }
                        }
                    }
                }
            }
        }

        return isAmt == notAmt;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        char[] arr = input.toCharArray();
        boolean allHappyG = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'g') {
                if (i - 1 >= 0 && arr[i-1] == 'g') {
                    allHappyG = true;
                }
                else if (i + 1 < arr.length && arr[i + 1] == 'g') {
                    allHappyG = true;
                }
                else {
                    allHappyG = false;
                }
            }
        }
        return allHappyG;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int triples = 0;

        char[] arr = input.toCharArray();
        char lastChar = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i - 1 >= 0 && i - 1 < arr.length && i < arr.length) {
                if (arr[i - 1] == arr[i] && arr[i] == arr[i+1]) {
                    triples++;
                }
            }
        }
        return triples;
    }
}
