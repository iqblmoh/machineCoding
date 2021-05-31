package test;

public class CacheService {
    private static CacheService instance=null;
    private CacheService(){

    }
    public static CacheService getInstance(){
        if(instance ==null){
            instance=new CacheService();
        }
        return instance;
    }

    private CacheDao cacheDao=CacheDao.getInstance();
    public Cache init(int size, EvictionPolicy evictionPolicy){
        return cacheDao.createCache(size,evictionPolicy);
    }
    public Object get(Object obj){
        return cacheDao.get(obj);
    }
    public Boolean put(Object key, Object val){
        return cacheDao.put( key, val);
    }
    public Boolean delete(Object key){
        return  cacheDao.delete( key);
    }
    public Boolean clear(){
        return cacheDao.clear();
    }
}
