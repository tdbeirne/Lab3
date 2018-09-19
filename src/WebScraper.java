import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    //helper code
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(final String input) {
        return (input.split("\\s+")).length;
    }

    public static int specificWordCount(final String inputText, final String wordMatch) {
        return (inputText.split(wordMatch + "|" + wordMatch.toLowerCase() + "|" + wordMatch.toUpperCase())).length;
    }

    public static void main(String[] args) {
       // System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(specificWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Hamlet"));
    }
}
