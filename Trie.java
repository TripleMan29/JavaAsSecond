import java.util.*;

class TrieNode {
    char content;
    boolean isEnd;
    int count;
    LinkedList<TrieNode> childList;

    public TrieNode(char c){
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }
    public TrieNode subNode(char c){
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}

class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode(' ');
    }
    // Insertion
    public void insert(String word){
        if (search(word) == true)
            return;
        TrieNode current = root;
        for (char ch : word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else {
                current.childList.add(new TrieNode(ch));
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    // Searching
    public boolean search(String word){
        TrieNode current = root;
        for (char ch : word.toCharArray()){
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }
        if (current.isEnd == true)
            return true;
        return false;
    }
    // Removing
    public void remove(String word){
        if (search(word) == false){
            System.out.println(word +" does not exist in trie");
            return;
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()){
            TrieNode child = current.subNode(ch);
            if (child.count == 1){
                current.childList.remove(child);
                return;
            }
            else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }
}