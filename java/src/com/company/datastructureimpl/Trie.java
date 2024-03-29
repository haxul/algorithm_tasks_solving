package com.company.datastructureimpl;

import java.util.HashMap;
import java.util.Map;

// trie node
class TNode {
    public final Map<Character, TNode> children =
            new HashMap<>();
    public boolean endOfString = false;
}

public class Trie {

    private final TNode root = new TNode();

    public void delete(String word) {
        if (exists(word)) delete(root, word, 0);
    }

    // time O(L), space O(log H)
    private boolean delete(TNode parent, String word, int idx) {
        char letter = word.charAt(idx);
        var curNode = parent.children.get(letter);

        if (curNode.children.size() > 1) {
            delete(curNode, word, idx + 1);
            return false;
        }

        if (idx == word.length() - 1) {
            if (curNode.children.size() >= 1) {
                curNode.endOfString = false;
                return false;
            }
            parent.children.remove(letter);
            return true;
        }
        if (curNode.endOfString) {
            delete(curNode, word, idx + 1);
            return false;
        }

        boolean canThisNodeBeDeleted = delete(curNode, word, idx + 1);

        if (canThisNodeBeDeleted) {
            parent.children.remove(letter);
            return true;
        }

        return false;
    }

    // time O(L), space O(1)
    public boolean exists(final String word) {
        var cur = root;
        for (var letter : word.toCharArray()) {
            if (!cur.children.containsKey(letter)) return false;
            cur = cur.children.get(letter);
        }
        return cur.endOfString;
    }

    // time O(L), space O(L)
    public void insert(final String word) {
        var cur = root;
        for (int i = 0; i < word.length(); i++) {

            var letter = word.charAt(i);

            if (!cur.children.containsKey(letter)) cur.children.put(letter, new TNode());

            cur = cur.children.get(letter);

        }
        cur.endOfString = true;
    }

    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("app");
        trie.insert("api");
        trie.insert("apis");
        trie.insert("s");

        assert trie.exists("app");
        trie.delete("app");
        assert !trie.exists("app");
        assert trie.exists("api");
        assert trie.exists("apis");
        assert trie.exists("s");
        assert !trie.exists("ap");
        assert !trie.exists("apiss");
        assert !trie.exists("a");
        assert !trie.exists("");
        System.out.println("tests passed");
    }
}

