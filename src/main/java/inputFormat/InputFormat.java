package inputFormat;

import java.util.Scanner;

public class InputFormat {
    final static String NEW_LINE = "\n";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //for each token in between \n
        String text = "";
        //the final output
        String output = "";
        int i = 0;
        int maxLength = 0;
//        while (true) {
        while (input.hasNextLine()) {
            //ensure the first line is the number, otherwise stop with error message
            if (i == 0) {
                try {
                    maxLength = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Please input a number for the max length");
                    break;
                }
            } else {
                //clean the line input
                String temp = input.nextLine().trim();
                //break when find the line is stop. otherwise concatenate the line with the process until encountering
                //the new line
                if (temp.equalsIgnoreCase("STOP")) break;
                else if (temp.equals("")) {
                    output += processString(maxLength, text) + NEW_LINE;
                    text = "";
                } else {
                    text += temp + " ";
                }
            }
            i++;
        }
        //add the last line
        output += processString(maxLength, text);
        System.out.println(output);
        input.close();
    }
//    }

    //    private static String process2(int max, String orig) {
//        String newStr = "";// sb = new Strin
//        char curr;
//        for( int i = 0; i < orig.length(); i++ ) {
//            curr = orig.charAt(i);
//            if
//        }
//    }
    private static String processString(int max, String orig ) {

        Scanner s = new Scanner(orig);
        //for each word during the paragraph
        String word = "";
        //the processed string for return
        String newStr = "";
        //hold the words for each line in the final format
        String temp = "";
        int i = 0;
        while(s.hasNext()) {
            word = s.next();
            if (i == 0) {
                temp = word;
                i++;
            } else {
                //if the word has the length > max
                if (temp.length() >= max) {
                    newStr += temp + NEW_LINE;
                    temp = word;
                } else {
                    //if the adding the next word exceeds the length, keep the new word in the temp and add the
                    //existing temp to the output
                    if ((temp + word).length() > max) {
                        newStr += temp + NEW_LINE;
                        temp = word;
                    } else {
                        temp += " " + word;
//                    newStr += temp;
                    }
                }
            }
        }
        s.close();
        return newStr + temp + NEW_LINE;
    }
}
