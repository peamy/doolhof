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
    
    public GameObject getGameObject(int y, int x) {
        if(y < getXBounds() && x < getYBounds() && x >= 0 && y >= 0) {
            return map[y][x];
        }
        return new Wall(x, y);
    }
    
    public void setPath(Path p, int x, int y) {
        map[y][x] = p;
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
    
    public GameObject[][] getMap() {
        return map;
    }
    
    public Finish getFinish() {
        for(int i = 0; i < getXBounds(); i++) {
            for(int j = 0; j < getYBounds(); j++) {
                if(map[i][j] instanceof Finish) {
                    return (Finish) map[i][j];
                }
            }
        }
        return null;
    }
    
    public void setMap(GameObject[][] map) {
        this.map = map;
    }
    
    public void resetShortestPath() {
         for(int i = 0; i < getXBounds(); i++) {
            for(int j = 0; j < getYBounds(); j++) {
                if(map[i][j] instanceof Path) {
                    ((Path) map[i][j]).setShortestPath(false);
                }
            }
        }
    }
    
    public void setShortestPath(int x, int y) {
        GameObject object = map[x][y];
        if(object instanceof Path) {
            ((Path)object).setShortestPath(true);
        }
    }
}
