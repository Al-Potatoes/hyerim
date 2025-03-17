package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1991 {

  static class Node {

    char data;
    Node left, right;

    Node(char data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static class Tree {

    Node root;

    Tree() {
      this.root = null;
    }

    void insertNode(Node parent, char leftN, char rightN) {
      if (leftN != '.') {
        parent.left = new Node(leftN);
      }
      if (rightN != '.') {
        parent.right = new Node(rightN);
      }
    }

    void preOrder(Node node) {
      if (node == null) {
        return;
      }
      System.out.print(node.data);
      preOrder(node.left);
      preOrder(node.right);
    }

    void inOrder(Node node) {
      if (node == null) {
        return;
      }
      inOrder(node.left);
      System.out.print(node.data);
      inOrder(node.right);
    }

    void postOrder(Node node) {
      if (node == null) {
        return;
      }
      postOrder(node.left);
      postOrder(node.right);
      System.out.print(node.data);
    }

    Node findNode(Node node, char data) {
      if (node == null) {
        return null;
      }
      if (node.data == data) {
        return node;
      }

      Node found = findNode(node.left, data);
      if (found == null) {
        found = findNode(node.right, data);
      }
      return found;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Tree tree = new Tree();

    StringTokenizer st = new StringTokenizer(br.readLine());
    char root = st.nextToken().charAt(0);
    char left = st.nextToken().charAt(0);
    char right = st.nextToken().charAt(0);

    tree.root = new Node(root);
    tree.insertNode(tree.root, left, right);

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      root = st.nextToken().charAt(0);
      left = st.nextToken().charAt(0);
      right = st.nextToken().charAt(0);

      Node parent = tree.findNode(tree.root, root);
      if (parent != null) {
        tree.insertNode(parent, left, right);
      }
    }

    tree.preOrder(tree.root);
    System.out.println();
    tree.inOrder(tree.root);
    System.out.println();
    tree.postOrder(tree.root);
    System.out.println();
  }
}

// 시간 100ms
