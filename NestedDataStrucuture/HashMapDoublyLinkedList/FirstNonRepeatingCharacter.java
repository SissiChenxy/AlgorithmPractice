package NestedDataStrucuture.HashMapDoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    static class Node{
        Node next;
        Node prev;
        Character ch;
        Node(Character c){
            this.ch = c;
        }
    }

    private Node head;
    private Node tail;
    private Map<Character, Node> map;

    public FirstNonRepeatingCharacter() {
        // Initialize the class.
        this.map = new HashMap<>();
    }

    public void read(char ch) {
        // Implement this method here.
        Node node = null;
        if(!map.containsKey(ch)){
            node = new Node(ch);
            append(node);
        }else if(map.get(ch) == null){
            return;
        }else{
            node = map.get(ch);
            remove(node);
        }
    }

    public Character firstNonRepeating() {
        // Implement this method here.
        if(head == null){
            return null;
        }
        return head.ch;
    }

    private Node append(Node node){
        map.put(node.ch, node);
        if(head == null){
            head = tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        return node;
    }

    private Node remove(Node node){
        map.put(node.ch, null);
        if(node.prev != null){
            node.prev.next = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        if(node == head){
            head = head.next;
        }
        if(node == tail){
            tail = tail.prev;
        }
        node.next = node.prev = null;
        return node;
    }

    public void test1(){
        read('a');
        System.out.println(firstNonRepeating());
        read('a');
        System.out.println(firstNonRepeating());
        read('a');
        System.out.println(firstNonRepeating());
        read('b');
        System.out.println(firstNonRepeating());
        read('c');
        System.out.println(firstNonRepeating());
        read('d');
        System.out.println(firstNonRepeating());
        read('a');
        System.out.println(firstNonRepeating());
        read('c');
        System.out.println(firstNonRepeating());
        read('b');
        System.out.println(firstNonRepeating());
        read('d');
        System.out.println(firstNonRepeating());
    }

}
