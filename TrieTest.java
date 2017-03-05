import static org.junit.Assert.*;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrieTest {
    static Trie prefTree;
    @BeforeClass
    public static void initial(){
        prefTree = new Trie();
        prefTree.insert("House");
        prefTree.insert("Mum");
        prefTree.insert("Board");
    }

    @Test
    public void search1(){
        assertEquals(true, prefTree.search("House"));
        assertEquals(false, prefTree.search("Home"));
        assertEquals(true, prefTree.search("Mum"));
        assertEquals(true, prefTree.search("Board"));
    }

    @After
    public void remove(){
        prefTree.remove("House");
        prefTree.remove("Mum");
        prefTree.remove("Board");
        prefTree.insert("Home");
        prefTree.insert("Car");
        prefTree.insert("Dad");
    }

    @Test
    public void search2(){
        assertEquals(false, prefTree.search("House"));
        assertEquals(true, prefTree.search("Home"));
        assertEquals(true, prefTree.search("Car"));
        assertEquals(true, prefTree.search("Dad"));
    }
}