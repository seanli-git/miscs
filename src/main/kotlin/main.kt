import java.util.*

fun main(args: Array<String>) {
    val NEW_LINE = "\n"
    fun processString(max: Int, orig: String): String? {
        val s = Scanner(orig)
        //for each word during the paragraph
        var word = ""
        //the processed string for return
        var newStr = ""
        //hold the words for each line in the final format
        var temp = ""
        var i = 0
        while (s.hasNext()) {
            word = s.next()
            if (i == 0) {
                temp = word
                i++
            } else {
                //if the word has the length > max
                if (temp.length >= max) {
                    newStr += temp + NEW_LINE
                    temp = word
                } else {
                    //if the adding the next word exceeds the length, keep the new word in the temp and add the
                    //existing temp to the output
                    if ((temp + word).length > max) {
                        newStr += temp + NEW_LINE
                        temp = word
                    } else {
                        temp += " $word"
                        //                    newStr += temp;
                    }
                }
            }
        }
        s.close()
        return newStr + temp + NEW_LINE
    }
//    @JvmStatic
    fun main(args: Array<String>) {
        val input = Scanner(System.`in`)
        //for each token in between \n
        var text = ""
        //the final output
        var output: String? = ""
        var i = 0
        var maxLength = 0
        //        while (true) {
        while (input.hasNextLine()) {
            //ensure the first line is the number, otherwise stop with error message
            if (i == 0) {
                maxLength = try {
                    input.nextInt()
                } catch (e: Exception) {
                    println("Please input a number for the max length")
                    break
                }
            } else {
                //clean the line input
                val temp = input.nextLine().trim { it <= ' ' }
                //break when find the line is stop. otherwise concatenate the line with the process until encountering
                //the new line
                if (temp.equals("STOP", ignoreCase = true)) break else if (temp == "") {
                    output += processString(maxLength, text) + NEW_LINE
                    text = ""
                } else {
                    text += "$temp "
                }
            }
            i++
        }
        //add the last line
        output += processString(maxLength, text)
        println(output)
        input.close()
    }
//    }

    //    }
    //    private static String process2(int max, String orig) {
    //        String newStr = "";// sb = new Strin
    //        char curr;
    //        for( int i = 0; i < orig.length(); i++ ) {
    //            curr = orig.charAt(i);
    //            if
    //        }
    //    }


}