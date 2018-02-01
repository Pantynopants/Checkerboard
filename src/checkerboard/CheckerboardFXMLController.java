/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import board.CheckerBoard;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author dpleo
 */
public class CheckerboardFXMLController implements Initializable, Startable {


    @FXML private Pane boardPane;


    private int paneWidth;
    private int paneHeight;
    private CheckerBoard checkerBoard;
    
    /**
     * Override method of interface Initializable
     * @param      url     
     * @param      rb   
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    /**
     * Create checkerboard, display and bind listener to boardPane
     */    
    public void start() {
        
        this.updatePaneProperty();
        this.checkerBoard = new CheckerBoard(8,8,this.paneWidth,this.paneHeight);
        
        this.refresh();
        boardPane.widthProperty().addListener((Observable observable) -> resizeHandler());
        boardPane.heightProperty().addListener((Observable observable) -> resizeHandler());
    }
    
    /**
     * When menu item for changing size are clicked, i.e. change to 16x16
     * Then bind this method to menu item 16.
     * After event, this method create a new CheckerBoard.
     * 
     * @param      event     ActionEvent, for mouse click the menu item
     */
    @FXML
    private void numChangeFromMenuItem(ActionEvent event) {
        MenuItem node = (MenuItem) event.getSource() ;
        String data = (String) node.getUserData();
        int value = Integer.parseInt(data);
        this.checkerBoard = new CheckerBoard(value,
                                            value,
                                            this.paneWidth,
                                            this.paneHeight,
                                            this.checkerBoard.getLightColor(),
                                            this.checkerBoard.getDarkColor());
        this.refresh();
    }
    
    /**
     * When menu item for changing color are clicked, i.e. change to blue
     * Then bind this method to menu item blue.
     * After event, this method create a new CheckerBoard.
     * 
     * @param      event     ActionEvent, for mouse click the menu item
     */
    @FXML
    private void colorChangeFromMenuItem(ActionEvent event) {
        MenuItem node = (MenuItem) event.getSource() ;
        String data = (String) node.getUserData();
        int value = Integer.parseInt(data);
        if (value == 0){
            this.checkerBoard = new CheckerBoard(this.checkerBoard.getNumRows(),
                                                 this.checkerBoard.getNumCols(),
                                                 this.paneWidth,
                                                 this.paneHeight);
        }else if(value == 1){
            this.checkerBoard = new CheckerBoard(this.checkerBoard.getNumRows(),
                                                this.checkerBoard.getNumCols(),
                                                this.paneWidth,
                                                this.paneHeight,
                                                Color.SKYBLUE,
                                                Color.DARKBLUE);
        }
        this.refresh();
    }

    
    
    ///////////////// listener ///////////////////
  
    
    /**
     * Event handler
     * When board resized, this method will create a new checkerboard and replace the old one
     */
    private void resizeHandler() {
        
        this.updatePaneProperty();

        this.checkerBoard = new CheckerBoard(   this.checkerBoard.getNumRows(),
                                                this.checkerBoard.getNumCols(),
                                                this.paneWidth,
                                                this.paneHeight,
                                                this.checkerBoard.getLightColor(),
                                                this.checkerBoard.getDarkColor());
        this.refresh();
    }
    

    //////////////// tools ////////////////////
    
    /**
     * When the board resized, update Pane width and height
     */
    private void updatePaneProperty(){
        this.paneWidth = (int)boardPane.getWidth();
        this.paneHeight = (int)boardPane.getHeight();
    }
    
    /**
     * When a new event occurred, create new board and call this method to replace the old one
     */
    private void refresh(){
        this.boardPane.getChildren().clear();
        this.boardPane.getChildren().add(checkerBoard.build(this.paneWidth, this.paneHeight));
    }
    
    
    

}
