import java.util.List;
/**
 * Created by Денис on 08.02.2017.
 */
public class PrefixTree {
    public static void main(List[] List) {
        for (int i = 1; i < List.length; i++){
            String word = List[i].toString();
            String letters = word.split("").toString();
            if (letters.equals(" ")) break;
        }
    }
}