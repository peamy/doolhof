package doolhoftwee;

import java.util.LinkedList;
import java.util.Queue;

public class LevelHandler {
    private Queue<String> maps = new LinkedList<>();
    
    public LevelHandler() {
        init();
    }
    
    public void init() {
        maps.add("testlevel1");
        maps.add("testlevel2");
        maps.add("testlevel3");
    }
    
    public String getCurrentLevel() {
        return maps.peek();
    }
    
    public void nextLevel() {
        maps.remove();
    }
    
    public boolean hasNextLevel() {
        if(!maps.isEmpty()) {
            return true;
        }
        return false;
    }
}
