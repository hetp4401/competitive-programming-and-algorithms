package dataStructures;

import java.util.ArrayList;

class TrieNode {
    char c;
    TrieNode[] children = new TrieNode[128];
    boolean isWord = false;

    TrieNode() {
    }

    TrieNode(char c) {
        this.c = c;
    }
}

class Trie {

    TrieNode root = new TrieNode();

    Trie() {
    }

    void insert(String word) {
        TrieNode t = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (t.children[c] == null) {
                t.children[c] = new TrieNode(c);
            }
            t = t.children[c];
        }
        t.isWord = true;
    }

    ArrayList<String> search_prefix(String word) {
        ArrayList<String> p = new ArrayList<String>();
        TrieNode t = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (t.children[c] != null) {
                t = t.children[c];
            } else {
                return p;
            }
        }
        find_words(word, t, p);
        return p;
    }

    void find_words(String word, TrieNode t, ArrayList<String> p) {
        if (t.isWord) {
            p.add(word);
        }
        for (TrieNode i : t.children) {
            if (i != null) {
                find_words(word + i.c, i, p);
            }
        }
    }
}

class sample {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("they");
        trie.insert("there");
        trie.insert("the");
        trie.insert("that");
        trie.insert("thaeosf");

        System.out.println(trie.search_prefix("the"));
        // [the, there, they]
    }
}
