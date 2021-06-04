package inMemCache;
import java.util.HashMap;
import java.util.LinkedList;

public class CacheDao {
    private static CacheDao cacheDao=null;
    private Cache cache=null;
    private CacheDao(){

    }
    public static CacheDao getInstance(){
        if(cacheDao==null){
            cacheDao=new CacheDao();
        }
        return cacheDao;
    }
    public Cache createCache(int size, EvictionPolicy evictionPolicy){
        cache= new Cache(size,evictionPolicy);
        return cache;
    }
    public Object get(Object obj){
        Object result= cache.getHashMap().get(obj);
        if(result==null) return  null;
        cache.getLinkedList().remove(obj);
        cache.getLinkedList().addFirst(obj);
        return result;
    }
    public Boolean put(Object key, Object val){
        try {
            if (cache.getSize() == cache.getLinkedList().size()) {
                Object last = cache.getLinkedList().removeLast();
                cache.getHashMap().remove(last);
            }
            cache.getLinkedList().remove(key);
            cache.getLinkedList().addFirst(key);
            cache.getHashMap().put(key, val);
            return true;
        }
        catch (Exception e){
            System.out.println("Something went wrong while adding element");
        }
        return false;
    }
    public Boolean delete(Object obj){
        if(cache.getLinkedList().size()==0 ) return true;
        try {
            cache.getLinkedList().remove(obj);
            cache.getHashMap().remove(obj);
            return true;
        }
        catch (Exception e){
            System.out.println("Something went wrong while removing element");
        }
        return false;
    }
    public  Boolean clear(){
        return cache.clear();
    }
}
