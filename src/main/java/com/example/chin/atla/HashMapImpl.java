package com.practice.chin.atla;

import java.util.Objects;

public class HashMapImpl<K,V> {
	Entry<K, V>[] arr;
	int size;
	int capacity=1 << 4;
	
	HashMapImpl(){
		this.arr=new Entry[capacity];
		this.size=0;
	}
	
	public V get(K key) {
		int hashCode=Objects.hashCode(key);
		int bucket=hashCode & (capacity-1);
		Entry<K,V> curr=this.arr[bucket];
		if(curr.getKey().equals(key)) {
			return curr.getValue();
		}else {
			while(curr.getNext()!=null) {
				curr=curr.getNext();
				if(curr.getKey().equals(key)) {
					return curr.getValue();
				}
			}
		}
		return null;
	}
	
	public void put(K key, V value) {
		Entry<K,V> entry= new Entry<K,V>(key,value);
		if(this.size<(3/4)*arr.length) {
			resize();
		}
		putInBucket(entry);
	}

	private void putInBucket(Entry<K, V> entry) {
		int hashCode=Objects.hashCode(entry.getKey());
		int bucket=hashCode & (capacity-1);
		
		if(this.arr[bucket]==null) {
			this.arr[bucket]=entry;
		}else {
			Entry<K,V> curr=this.arr[bucket];
			if(curr.getNext()==null) {
				curr.setNext(entry);
			}
			while(curr.getNext()!=null) {
				curr=curr.getNext();
			}
			curr.setNext(entry);
		}
		
	}

	private void resize() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
	}

}

class Entry<K,V>{
	K key;
	V value;
	Entry<K,V> next;
	
	public Entry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Entry<K, V> getNext() {
		return next;
	}
	public void setNext(Entry<K, V> next) {
		this.next = next;
	}
}
