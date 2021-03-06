package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

   private static final Logger LOG = Logger.getLogger(Utils.class.getName());

   /**
    * This method looks for the next new line separators (\r, \n, \r\n) to extract
    * the next line in the string passed in arguments.
    *
    * @param lines a string that may contain 0, 1 or more lines
    * @return an array with 2 elements; the first element is the next line with the
    * line separator, the second element is the remaining text. If the argument does
    * not contain any line separator, then the first element is an empty string.
    */
   public static String[] getNextLine(String lines) {

      String[] strArray = new String[2];

      // Initializes the array with empty strings
      strArray[0] = strArray[1] = "";

      int lineIndex = 0;

      lineIndex = lines.indexOf("\n");

      // No \n was found
      if (lineIndex == -1) {
         lineIndex = lines.indexOf("\r");
         // No \r was found
         if (lineIndex == -1) {
            strArray[1] = lines;
         }
      }

      int length = lineIndex + 1;
      // Stores the next line
      strArray[0] = lines.substring(0, length);
      
      // Remaining text
      if (lines.length() >= length) {
         strArray[1] = lines.substring(length);
      } 

      return strArray;
   }

}
