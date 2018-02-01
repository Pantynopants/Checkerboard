/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author dpleo
 */
public class CheckerBoard extends Board{
    
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private double rectangleWidth;
    private double rectangleHeight;
    private Pane anchorPane = null;
    
   
    
     /**
     * Constructor of CheckerBoard
     * 
     * @param      numRows       number of rectangles of one row
     * @param      numCols       number of rectangles of one column
     * @param      boardWidth    width of checkerboard
     * @param      boardHeight   height of checkerboard
     * @param      lightColor    lightColor of checkerboard, default: RED
     * @param      darkColor     darkColor of checkerboard, default: BLACK
     * 
     */
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        super(numRows, numCols, boardWidth, boardHeight);
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this(numRows,numCols,boardWidth,boardHeight,Color.RED,Color.BLACK);
    }
    
    
    /**
     * Build checkerboard with specific number of rectangles and color pattern
     * 
     * @return     AnchorPane with specific number of rectangles
     */
    public Pane build(double width, double height){
        
        this.rectangleWidth = this.width / this.numCols;
        this.rectangleHeight = this.height / this.numRows;
     
        AnchorPane builtAnchorPane = new AnchorPane();
        int i,j;
        for(i = 0; i < this.numRows; i++){
            for(j = 0; j < this.numCols; j++){
                Rectangle rectangle = new Rectangle(j * this.rectangleWidth, i * this.rectangleHeight, this.rectangleWidth, this.rectangleHeight);
                if((i + j) % 2 == 0){
                    rectangle.setFill(this.lightColor);
                }
                else{
                    rectangle.setFill(this.darkColor);
                }
                builtAnchorPane.getChildren().add(rectangle);
            }
        }
//         // here we position rects (this depends on pane size as well)
//            rectangle.xProperty().bind(recWidthSize.multiply(x).divide(grid_x));
//            rectangle.yProperty().bind(recHeightSize.multiply(y).divide(grid_y));
//            
//            // here we bind rectangle size to pane size 
//            rectangle.heightProperty().bind(recHeightSize.divide(grid_x));
////            rectangle.widthProperty().bind(rectangle.heightProperty());
//            rectangle.widthProperty().bind(recWidthSize.divide(grid_y));
//
//            root.getChildren().add(rectangle);
            
        this.anchorPane = builtAnchorPane;
        
        return this.anchorPane;
    }
    
    ///////////// getters ///////////////
    
    @Override
    public Pane getBoard(){
        return this.anchorPane;
    }  
    public int getNumRows(){ 
        return this.numRows; 
    }
    public int getNumCols(){ 
        return this.numCols; 
    }
    public double getWidth(){ 
        return this.boardWidth; 
    }
    public double getHeight(){ 
        return this.boardHeight; 
    }
    public Color getLightColor(){ 
        return this.lightColor; 
    }
    public Color getDarkColor(){ 
        return this.darkColor; 
    }
    public double getRectangleWidth(){ 
        return this.rectangleWidth; 
    }
    public double getRectangleHeight(){ 
        return this.rectangleHeight; 
    }
    ///////////// setters ///////////////
}
