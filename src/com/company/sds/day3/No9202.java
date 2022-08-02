package com.company.sds.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9202 {
    static int N;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 0, 1, -1};
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    static char[][] map;
    static boolean[][] visited;
    static String answer;
    static int sum;
    static int count;
    static TrieNode root = new TrieNode();

    static StringBuilder sb;
    static int b;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            insertTrieNode(br.readLine());
        }

        br.readLine();
        b = Integer.parseInt(br.readLine());
        StringBuilder resultSb = new StringBuilder();

        for (int n = 0; n < b; n++) {
            map = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            sum = 0;
            count = 0;
            sb = new StringBuilder();

            for (int i = 0; i < 4; i++) {
                String in = br.readLine();
                for (int k = 0; k < 4; k++) {
                    map[i][k] = in.charAt(k);
                }
            }
            br.readLine();
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if(root.hasChild(map[y][x])){
                        search(y, x, root.getChild(map[y][x]));
                    }
                }
            }
            root.clearHit();
            resultSb.append(sum+" " + answer + " " + count + '\n');
        }
        System.out.println(resultSb.toString());
    }

    static void search(int y, int x, TrieNode node) {
        //1. 체크인 --> visited
        visited[y][x] = true;
        sb.append(map[y][x]);

        //2. 목적지에 도달했는가? --> isWord ==true, isHit == false
        if (node.isWord == true && node.isHit == false) {
            node.isHit = true;
            count++;
            //답 작업 --> 길이, 단어
            String foundWord = sb.toString();
            int length = foundWord.length();
            sum += score[length];
            if(answer.length() == length){
                if(answer.compareTo(foundWord) > 0){
                    answer = foundWord;
                }
            }else{
                answer = answer.length() > length ? answer : foundWord;
            }

        }
        //3. 연결된 곳을 순회 --> 8방향
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            //4. 가능한가?  --> map 경계, 방문했는지, node가 해당 자식을 가지고 있는지
            if (0 <= ny && ny < 4 && 0 <= nx && nx < 4) {
                if(visited[ny][nx] == false && node.hasChild(map[ny][nx])){
                    //5. 간다
                    search(ny, nx, node.getChild(map[ny][nx]));
                }
            }
        }
        //6. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length() - 1);
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
        }
        current.isWord = true;
    }
    static class TrieNode{
        boolean isWord = false;
        boolean isHit = false;

        TrieNode[] child = new TrieNode[26];

        void clearHit() {
            isHit = false;
            for (int i = 0; i < child.length; i++) {
                if (child[i] != null) {
                    child[i].clearHit();
                }
            }
        }

        boolean hasChild(char c) {
            return child[c - 'A'] != null;
        }

        TrieNode getChild(char c) {
            return child[c - 'A'];
        }
    }
}
