package inMemCache;

import java.util.HashMap;
import java.util.LinkedList;

public class Cache {
    private int size;
    private EvictionPolicy evictionPolicy;
    private LinkedList<Object> linkedList;
    private HashMap<Object,Object> hashMap;
    public Cache(int size, EvictionPolicy evictionPolicy){
        this.size=size;
        this.evictionPolicy=evictionPolicy;
        this.linkedList=new LinkedList<>();
        this.hashMap=new HashMap<>();
    }

    public  Boolean clear(){
        try {
            this.linkedList=new LinkedList<>();
            this.hashMap=new HashMap<>();
            return true;
        }
        catch (Exception e){
            System.out.println("Something went wrong while Clearing cache");

        }
        return false;
    }
    public int getSize() {
        return size;
    }

    public EvictionPolicy getEvictionPolicy() {
        return evictionPolicy;
    }

    public LinkedList<Object> getLinkedList() {
        return linkedList;
    }

    public HashMap<Object, Object> getHashMap() {
        return hashMap;
    }

}

