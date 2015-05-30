/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

/**
 *
 * @author Remco
 */
public class Map {
    GameObject[][] map;
    
    public Map(GameObject[][] map) {
        this.map = map;
    }
    
    public GameObject getGameObject(int y, int x) {
        if(y < getXBounds() && x < getYBounds() && x >= 0 && y >= 0) {
            return map[y][x];
        }
        return new Wall(x, y);
    }
    
    public void setPath(Path p, int x, int y) {
        map[y][x] = p;
    }
    
    public void setBullet(Bullet b, int x, int y) {
        map[y][x] = b;
    }
    
    public int getXBounds() {
        return map.length;
    }
    
    public int getYBounds() {
        return map[0].length;
    }
    
    public void destroy() {
        map = null;
    }
}
