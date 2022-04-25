//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            if (closeBracket == - 1) break;
            if (markdown.charAt(closeBracket + 1) == ':') {
                //System.out.println("found a :");
                int escape = markdown.indexOf("\r\n", closeBracket + 3);
                int space = markdown.indexOf(" ", closeBracket + 3);
                String link = "";
                if (space > escape || space == -1) {
                    if (escape == -1) {
                        link = markdown.substring(closeBracket + 3);
                        toReturn.add(link);
                        break;
                    }
                    else link = markdown.substring(closeBracket + 3, escape);
                    currentIndex = escape + 1;
                }
                else {
                    link = markdown.substring(closeBracket + 3, space);
                    currentIndex = space + 1;
                }        
                toReturn.add(link);
                continue;
            }
            if (markdown.charAt(closeBracket + 1) != '(') {
                currentIndex = markdown.indexOf("[", closeBracket + 1);
                continue;
            }
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            //System.out.println(openBracket + " " + closeBracket + " " + openParen + " " + closeParen);
            currentIndex = closeParen + 1;
            //System.out.println(currentIndex);
        }

        return toReturn;
    }
    
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        //System.out.println(content + '\n');
        //System.out.println("Part 2 of Lab 4");
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
