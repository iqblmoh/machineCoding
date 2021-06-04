package test;

public class DriverClass {

    public static void main(String[] args) {
        CacheService cacheService= CacheService.getInstance();
        Cache cache = cacheService.init(10,EvictionPolicy.LRU);
        cacheService.put("hey","First Object");
        System.out.println(cacheService.get("hey"));



//        System.out.println("hi");
    }
}
