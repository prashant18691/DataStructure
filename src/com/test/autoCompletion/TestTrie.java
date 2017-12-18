package com.test.autoCompletion;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class TestTrie {
    public static void main(String[] args) {
       /* Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();*/
        Trie trie = new Trie();
        /*for (int i = 0; i < n; i++) {
            String operation = scan.next();
            String contact   = scan.next();
            if (operation.equals("add")) {
                trie.add(contact);
            } else if (operation.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        scan.close();*/
        trie.add("hackb");
        trie.add("hackerrank");
        trie.add("add");
        trie.add("addii");
        trie.add("hank");
        System.out.println(trie.find("hac"));
        System.out.println(trie.find("hak"));
        System.out.println(trie.find("add"));
        System.out.println(trie.find("ha"));
    }
}

/* Based loosely on tutorial video in this problem */
class TrieNode {
    private Map<Character, TrieNode> children = new HashMap<>();
    public int size;

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    Trie(){} // default constructor

    Trie(String[] words) {
        for (String word : words) {
            add(word);
        }
    }

    public void add(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String prefix) {
        TrieNode curr = root;

        /* Traverse down tree to end of our prefix */
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}
