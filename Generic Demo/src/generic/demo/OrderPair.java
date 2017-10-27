/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.demo;


public class OrderPair<K, V> implements Pair<K, V> {
    private final K key;
    private final V value;

    public OrderPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public K getK() {
        return this.key;
    }

    @Override
    public V getV() {
        return this.value;
    }
    
}
