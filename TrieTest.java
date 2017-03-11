import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TrieTest{
    static Trie prefTree;
    @Test
    public void initial(){
        prefTree = new Trie();
        prefTree.insert("House");
        prefTree.insert("Mum");
        prefTree.insert("Board");

        assertEquals(true, prefTree.search("House"));
        assertEquals(false, prefTree.search("Home"));
        assertEquals(true, prefTree.search("Mum"));
        assertEquals(true, prefTree.search("Board"));
        assertEquals(true, prefTree.search("Board"));
    }

    @Test
    public void remove(){
        prefTree = new Trie();
        prefTree.insert("House");
        prefTree.insert("Mum");
        prefTree.insert("Board");
        prefTree.remove("House");
        prefTree.remove("Mum");
        prefTree.remove("Board");
        prefTree.insert("Home");
        prefTree.insert("Car");
        prefTree.insert("Dad");

        assertEquals(false, prefTree.search("House"));
        assertEquals(true, prefTree.search("Home"));
        assertEquals(true, prefTree.search("Car"));
        assertEquals(true, prefTree.search("Dad"));
    }
    @Test
    public void prefixSearch(){
        prefTree = new Trie();
        prefTree.insert("Home");
        prefTree.insert("Car");
        prefTree.insert("Dad");
        prefTree.insert("House");
        prefTree.insert("Mum");
        prefTree.insert("Board");
        prefTree.insert("Homework");
        prefTree.insert("Holiday");
        assertEquals("Home, House, Homework, Holiday", prefTree.prefixSearch("Ho"));
    }
}