public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        //System.out.println(capVowelsLowRest(args[0]));
        System.out.println(camelCase(args[0]));

        /*char c =  args[1].charAt(0);
        int[] arr = (allIndexOf(args[0], c));
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]); 
        }*/
        }
    
    //changes a string such taht vouwels are Capital and other letters appear as lowercase letters.
    public static String capVowelsLowRest (String string) {
       String upperVowels = "AEIOU";
       String lowerVowels = "aeiou";
       String lowerLetters = "bcdfghjklmnpqrstvwxyz";
       String upperLetters = "BCDFGHJKLMNPQRSTWXYZ";
       String res = "";
       for (int i = 0 ; i < string.length(); i++) {
            if (upperVowels.indexOf(string.charAt(i)) != -1 || string.charAt(i) == ' ')
                res += string.charAt(i);
            else if (lowerVowels.indexOf(string.charAt(i)) != -1) 
                res += (char) (string.charAt(i) - 32);
            else if (lowerLetters.indexOf(string.charAt(i)) != -1)
                res += string.charAt(i);
            else if (upperLetters.indexOf(string.charAt(i)) != -1)
                res += (char) (string.charAt(i) + 32);
       } 
        return res;
    }

//fix!!
    public static String camelCase (String string) {
        String res = "";
        boolean inWord = false;
        boolean first = true;
        for (int i = 0; i < string.length(); i++) {
            
            if (string.charAt(i) == ' ') { // is space
                inWord = false;
                continue;
            }

            if (!inWord) { // first letter in word
                res += first ? toLower(string.charAt(i)) : toUpper(string.charAt(i));
                first = false;
                inWord = true;
                continue;
            }
            
            res += toLower(string.charAt(i));
            
        }
        return res;
    }

    public static int[] allIndexOf (String string, char chr) {
        int counter = 0; //count how many time the letter appears.
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) counter++;
        }
        int[] res = new int[counter];
        counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                res[counter] = i;
                counter++;
            }
        }
        return res;
    }

    public static char toLower (char c) {
        if (c >= 'A' && c <= 'Z') return (char) (c + 32);
        return c;
    }

    public static char toUpper (char c) {
        if (c >= 'a' && c <= 'z') return (char) (c - 32);
        return c;
    }
}
