package singleton;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private static volatile CacheManager instance;
    private final Map<String, Object> cache = new HashMap<>();

    private CacheManager() {
        System.out.println("[CACHE] Cache ishga tushdi.");
    }

    public static CacheManager getInstance() {
        if (instance == null) {
            synchronized (CacheManager.class) {
                if (instance == null) {
                    instance = new CacheManager();
                }
            }
        }
        return instance;
    }

    public void put(String key, Object value) {
        cache.put(key, value);
        System.out.println("[CACHE] Saqlandi: " + key);
    }

    public Object get(String key) {
        Object value = cache.get(key);
        if (value != null) {
            System.out.println("[CACHE] Topildi: " + key);
        }
        return value;
    }

    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    public void remove(String key) {
        cache.remove(key);
        System.out.println("[CACHE] O'chirildi: " + key);
    }
}
