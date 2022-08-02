package com.company.sds.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9202 {
    static char[] word;
    static TrieNode root;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

    }

    static class TrieNode {
        boolean isWord = false;  //단어의 끝인지 검사
        boolean isHit = false;   //보글판에서 이미 탐색한 단어인지 여부

        TrieNode[] child = new TrieNode[26];

        void clearHit() {
            isHit = true;
        }
    }

    static void insertTrieNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            int index = a - 'A';
            if (current.child[index] == null) {
                current.child[index] = new TrieNode();
            }
            current = current.child[index];
        };
        current.isWord = true;
    }

}
