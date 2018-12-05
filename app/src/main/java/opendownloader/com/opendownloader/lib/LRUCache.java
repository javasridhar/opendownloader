package opendownloader.com.opendownloader.lib;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

public class LRUCache {
    private LruCache<String, Bitmap> mMemoryCache;
    private final int MAX_MEMORY = (int) (Runtime.getRuntime().maxMemory() / 1024);
    private final int DEFAULT_CACHE_SIZE = MAX_MEMORY / 8;
    private static LRUCache instance;

    private LRUCache() {
        mMemoryCache = new LruCache<String, Bitmap>(DEFAULT_CACHE_SIZE) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };

    }

    public static LRUCache getInstance() {
        if (instance == null) {
            instance = new LRUCache();
        }
        return instance;
    }

    public Bitmap getBitmapFromMemCache(String key) {
//        System.out.println("Fetching" + key);
        Log.i("Fetching" , key);
        return mMemoryCache.get(key);
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
//        System.out.println("Adding" + key);
        Log.i("Adding", key);
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

}
