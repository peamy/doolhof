/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.LinkedList;
import javax.imageio.ImageIO;

/**
 *
 * @author Remco
 */
public class Helper extends GameObject{
    
    public Helper(int x, int y) {
        setX(x);
        setY(y);
        
        try{
            setPathImage(ImageIO.read(new File("src/doolhoftwee/images/path.png")));
            setImage(ImageIO.read(new File("src/doolhoftwee/images/sign.png")));            
        }
        catch(Exception e) {
            System.out.println(e + " fout bij inladen mage in Frame klasse.");
        } 
    }
    
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.BLUE);        
        g.fillRect((getX()-beginX) * Drawing.PIXEL_VERTICAL, (getY()-beginY) * Drawing.PIXEL_HORIZONTAL, Drawing.PIXEL_VERTICAL, Drawing.PIXEL_HORIZONTAL);
    }
    
    /**
     * Path finding algorithm breadth first
     * Finds the shortest path to the finish (if its there)
     * Shows the shortest path on the map
     * @SOURCE  http://www.dsalgo.com/2013/02/find-shortest-path-in-maze.html
     */
    public boolean findShortestPath(Map map) { 
        
        GameObject[][] objects  = map.getMap();
        Finish finish           = map.getFinish();
        
        //creates a matrix according to where player can walk.
        int[][] levelMatrix = new int[objects.length][objects[0].length];
        for (int i = 0; i < objects.length; ++i) {
            for (int j = 0; j < objects[0].length; ++j) {        
                levelMatrix[i][j] = objects[i][j].canWalkThrough() == false ? -1 : 0;
            }
        }
        LinkedList < Cell > queue = new LinkedList < Cell >();
        Cell start = new Cell(getY(), getX());
        Cell end = new Cell(finish.getY(), finish.getX());
        queue.add(start);
        levelMatrix[start.row][start.col] = 1;
        //looks for the finish breadth first
        while (!queue.isEmpty()) {    
            Cell cell = queue.poll();
            if (cell == end) {
                break;   
            }

            int level = levelMatrix[cell.row][cell.col];
            Cell[] nextCells = new Cell[4];
            nextCells[3] = new Cell(cell.row, cell.col - 1);
            nextCells[2] = new Cell(cell.row - 1, cell.col);
            nextCells[1] = new Cell(cell.row, cell.col + 1);
            nextCells[0] = new Cell(cell.row + 1, cell.col);

            for (Cell nextCell : nextCells) {        
                if (nextCell.row < 0 || nextCell.col < 0)
                 continue;
                if (nextCell.row == objects.length
                  || nextCell.col == objects[0].length)
                 continue;
                if (levelMatrix[nextCell.row][nextCell.col] == 0) {         
                   queue.add(nextCell);
                   levelMatrix[nextCell.row][nextCell.col] = level + 1;
                }
            }
        }
        //if theres no path possible
        if (levelMatrix[end.row][end.col] == 0) {
            return false;
        }
        //adds pieces of path to a list, starting from the end, to the start.
        LinkedList <Cell> path = new LinkedList <Cell>();
        Cell cell = end;
        while (!cell.equals(start)) {    
            path.push(cell);
            int level = levelMatrix[cell.row][cell.col];
            Cell[] nextCells = new Cell[4];
            nextCells[0] = new Cell(cell.row + 1, cell.col);
            nextCells[1] = new Cell(cell.row, cell.col + 1);
            nextCells[2] = new Cell(cell.row - 1, cell.col);
            nextCells[3] = new Cell(cell.row, cell.col - 1);
            for (Cell nextCell : nextCells) {        
                if (nextCell.row < 0 || nextCell.col < 0) {
                    continue;
                }          
                if (nextCell.row == objects.length || nextCell.col == objects[0].length) {
                    continue;
                }          
                if (levelMatrix[nextCell.row][nextCell.col] == level - 1) {
                   cell = nextCell;
                   break;
                }
            }
        }
        //sets the shortest path into the map, so player can see.
        map.resetShortestPath();
        for (Cell c : path) {            
            map.setShortestPath(c.row, c.col);
        }
        return true;
     }
    
    /**
     * inner class used to find the shortest path
     */
    private static class Cell {

        private int row;
        private int col;

        public Cell(int row, int column) {        
         this.row = row;
         this.col = column;
        }

        @Override
        public boolean equals(Object obj) {        
            if (this == obj) {
                return true;
            }
            if ((obj == null) || (obj.getClass() != this.getClass())) {
                return false;
            }
            Cell cell = (Cell) obj;
            if (row == cell.row && col == cell.col) {
                return true;
            }
            return false;
        }

   }
    
}
