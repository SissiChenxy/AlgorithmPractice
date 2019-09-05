package NestedDataStrucuture.HashMapDoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    /*
    data structure:
        hashtable: <key = Q, value = ListNode>
        doubly linked list
            listnode: question, answer, prev, next

    use cases:
        1. search existed question's answer
            get listnode reference from hashtable, find the answer in listnode
            update the order:
                node.prev.next = node.next;
                node.next.prev = node.prev;
                tail.next = node;
                node.next = null;
        2. search nonexistent question's answer
             calculate answer
             save into hashtable and linked list
                if cache is not full:
                    hashtable.put(Q, listnode);
                    tail.next = new node
                if cache is full:
                    hashtable.put(Q, listnode);
                    tail.next = new node
                    delete the oldest one:
                        head.next = null;
     */

    static class Node<K, V> {
        Node<K, V> prev;
        Node<K, V> next;
        K key;
        V value;

        Node(K k, V v){
            this.key = k;
            this.value = v;
        }

        void update(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private final int limit;
    private Node<K, V> head;
    private Node<K, V> tail;
    private Map<K, Node<K, V>> map;

    public LRUCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<K, Node<K, V>>();
    }

    public void set(K key, V value) {
        Node<K, V> node = null;
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            remove(node);
        }else if(map.size() < limit){
            node = new Node<K, V>(key, value);
        }else{
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if(node == null){
            return null;
        }
        remove(node);
        append(node);
        return node.value;
    }

    private Node<K, V> remove(Node<K, V> node){
        map.remove(node.key);
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

    private Node<K, V> append(Node<K, V> node){
        map.put(node.key, node);
        if(head == null){
            head = tail = node;
        }else{
            //为什么要加在头
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }
}
