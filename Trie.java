import sun.reflect.generics.tree.Tree;

import java.util.*;

class TrieNode {
    public char content;
    public boolean isEnd;
    public int count;
    LinkedList<TrieNode> childList;

    TrieNode(char c) {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;
    }

    TrieNode subNode(char c) {               // Ищет у родителя дочернюю ветку с входным параметром char и выводит дочернюю ветку или null если ее нет
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}

class Trie {
    public TrieNode root;

    Trie() {
        root = new TrieNode(' ');
    }

    // Addition
    void insert(String word) {
        if (search(word))
            return;
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.subNode(ch); // есть ли последующая буква в дереве, если нет то добавить в childList.add ниже написано если нет то родительский элемент равен дочернему
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
    boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }
        return current.isEnd;
    }

    // Removing
    void remove(String word) {
        if (!search(word)) throw new IllegalArgumentException("Element isnt found");
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.subNode(ch);
            if (child.count == 1) {
                current.childList.remove(child);
                return;
            } else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }


    // Prefix Searching
    public String prefixSearch(String pref) {
        TrieNode current = root;
        for (char ch : pref.toCharArray()) {
            TrieNode child = current.subNode(ch);
            current = child;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < current.count; i++) {
            TrieNode child = current.childList.get(i);
            char[] word = new char[50];
            int j=0;
            do {
                word[j] = child.content;
                j++;
                child = child.childList.getFirst();
            } while (!child.childList.isEmpty());
            word[j] = child.content;
            result.append(", ").append(pref).append(word);
            if (result.length() > 1) result.delete(0, 2);
        }
        return result.toString();
    }

  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trie trie = (Trie) o;

        return root != null ? root.equals(trie.root) : trie.root == null;

    }

    @Override
    public int hashCode() {
        return root != null ? root.hashCode() : 0;
    }*/
}