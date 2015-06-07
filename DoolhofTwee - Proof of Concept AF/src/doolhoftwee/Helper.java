/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhoftwee;

import static doolhoftwee.GameObject.PIXEL_VERTICAL;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Remco
 */
public class Helper extends GameObject{
    private List<Cell> path;
    private Map map;
    
    public Helper(int x, int y, Map m) {
        setX(x);
        setY(y);
        this.map = m;
    }
    @Override
    public void paintComponent(Graphics g, int beginX, int beginY) {
        g.setColor(Color.BLUE);        
        g.fillRect((getX()-beginX) * PIXEL_VERTICAL, (getY()-beginY) * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);        
        g.fillRect(getX() * PIXEL_VERTICAL, getY() * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
        
        
    }
    
    public void drawPath(Graphics g) {
        g.setColor(Color.BLUE);
        if(path != null) {
            for (Cell cell : path) {
                g.fillOval(cell.col * PIXEL_VERTICAL, cell.row * PIXEL_HORIZONTAL, PIXEL_VERTICAL, PIXEL_HORIZONTAL);
            }
        }
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }
    
    /**
     * @SOURCE  http://www.dsalgo.com/2013/02/find-shortest-path-in-maze.html
     */
    public boolean findShortestPath() { 
        
        GameObject[][] objects  = map.getMap();
        Finish finish           = map.getFinish();
        
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
        if (levelMatrix[end.row][end.col] == 0) {
            return false;
        }

        LinkedList < Cell > path = new LinkedList < Cell >();
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
        this.path = path;
        return true;
     }
    
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

        @Override
        public String toString() {        
            return "(" + row + "," + col + ")";
        }
   }
    
}
