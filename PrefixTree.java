import java.util.List;
/**
 * Created by Денис on 08.02.2017.
 */
public class PrefixTree {
    public static void main(List[] wordList) {
        for (int i = 1; i < wordList.length; i++){
            String word = wordList[i].toString();
            String letters = word.split("").toString();
            if (letters.equals(" ")) break;
        }
    }
    public static void insert(String[] args) {

    }
}
