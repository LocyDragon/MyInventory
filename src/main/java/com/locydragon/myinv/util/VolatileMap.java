package com.locydragon.myinv.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class VolatileMap<K,V> {
	private volatile AtomicReference<ConcurrentHashMap<K,V>> object = new AtomicReference<>();
	public VolatileMap() {
		object.set(new ConcurrentHashMap<>());
	}

	public void put(K k, V v) {
		ConcurrentHashMap<K,V> mapObject = object.get();
		mapObject.put(k, v);
		object.set(mapObject);
	}

	public ConcurrentHashMap<K,V> get() {
		return this.object.get();
	}

	public boolean containsKey(Object object) {
		return this.object.get().containsKey(object);
	}

	public void remove(Object key) {
		ConcurrentHashMap<K,V> mapObject = object.get();
		mapObject.remove(key);
		object.set(mapObject);
	}

	public void replace(K key, V value) {
		ConcurrentHashMap<K,V> mapObject = object.get();
		mapObject.replace(key, value);
		object.set(mapObject);
	}

	public V get(Object key) {
		return this.object.get().get(key);
	}
}
