/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author dpleo
 */
public abstract class Board {
    protected double width;
    protected double height;
    protected int rows;
    protected int columns;
    protected double rectangleWidth;
    protected double rectangleHeight;
    
    protected Pane pane;
     
    
    public Board(int rows, int columns, double width, double height){
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.columns = columns;
        this.pane = new Pane();
        // can the grid class have a static method that produces instance of grid
        // can the static method of grid be a factory for gtid objects
        // when would I use a factory
        // And when would I choose to create an instance from a class using now
        // Is there a way to keep instance of a class from being created outside of the class
    }
    public Pane build(double width, double height){
        clear();
        this.width = width;
        this.height = height;
        rectangleWidth = Math.ceil(width / (double)columns);
        rectangleHeight = Math.ceil(width / (double)rows);
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        
        return pane;
    }

    private void clear() {
        if (pane != null)
        this.pane.getChildren().clear();
    }
    
    public Pane getBoard(){
        return this.pane;
    }
}