package trie;

import java.util.Stack;

public class Trie {

    TrieNode root = new TrieNode();

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
        TrieNode(){
            isEnd = false;
        }
    }

    public void insert(String s){
        TrieNode currRoot = root;
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            if(currRoot.child[index]==null){
                currRoot.child[index] = new TrieNode();
            }
            currRoot = currRoot.child[index];
        }
        currRoot.isEnd = true;
    }

    public boolean search(String s){
        TrieNode currRoot = root;
        for(int i=0;i<s.length();i++){
            int currChar = s.charAt(i)-'a';
            if(currRoot.child[currChar]==null){
                return false;
            }
            currRoot = currRoot.child[currChar];
        }
        return currRoot.isEnd;
    }


    public void delete(String s){
        TrieNode currRoot = root;
        Stack<TrieNode> children = new Stack<>();
        for(int i=0;i<s.length()-1;i++){
            int index = s.charAt(i)-'a';
            if(currRoot.child[index]==null){
                return;
            }
            currRoot = currRoot.child[index];
            children.push(currRoot);
        }


        while (!children.isEmpty()){
            TrieNode currNode = children.pop();
            if(!checkForChildren(currNode)){
                currNode.child = null;
            }
            else{
                currNode.isEnd = false;
                return;
            }
        }
    }

    public boolean checkForChildren(TrieNode node){
        for(int i=0;i<26;i++){
            if(node.child[i]!=null){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String keys[] = {"bad", "bat", "geeks", "geeks", "cat",
                "cut"};

        String output[] = {"NO", "YES"};


        Trie root = new Trie();


        int i;
        for (i = 0; i < keys.length ; i++)
            root.insert(keys[i]);



        if(root.search("bad") == true)
            System.out.println("bad --- " + output[1]);
        else System.out.println("bad --- " + output[0]);

        if(root.search("geeks") == true)
            System.out.println("geeks --- " + output[1]);
        else System.out.println("geeks --- " + output[0]);

        if(root.search("ca") == true)
            System.out.println("ca --- " + output[1]);
        else System.out.println("ca --- " + output[0]);
    }
}
