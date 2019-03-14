package ie.dit;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{

    int selected1 = -1;
    int selected2 = -1;

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        loadData();
        printStars();
        border = width * 0.05f;
        
        System.out.println("Our map is: " + map1(5, 0, 100, 0, 200));
        System.out.println("Their map is: " + map(5, 0, 100, 0, 200));

        System.out.println("Our map is: " + map1(-5, -10, 1, -100, 1));
        System.out.println("Their map is: " + map(-5, -10, 1, -100, 1));
    }

    public void loadData()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
        
        /*
        for(int i = 0 ; i < table.getRowCount() ; i ++)
        {
            TableRow row = table.getRow(i);
            System.out.println(row.getString("Display Name"));
            System.out.println(row.getString("Hab?"));            
        }
        */

        for(TableRow row:table.rows())
        {
            Star star = new Star(row);
            stars.add(star);     
        }
    }

    public void printStars()
    {
        for(Star star:stars)
        {
            System.out.println(star);
        }
    }

    float border;

    private void drawGrid()
    {
        textAlign(CENTER, CENTER);
        for(int i = -5 ; i <= 5 ; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            stroke(0, 0, 255);
            line(x, border, x, height - border);
            fill(255);
            text(i, x, border / 2);
            stroke(0, 0, 255);
            line(border, x, width - border, x);
            fill(255);            
            text(i, border / 2, x);
        }
    }

    public void drawStars()
    {
        textAlign(LEFT, CENTER);
        for(Star s:stars)
        {
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            stroke(255, 255, 0);
            noFill();
            ellipse(x, y, s.getAbsMag(), s.getAbsMag());

            stroke(0, 255, 255);
            line(x, y - 5, x, y + 5);
            line(x - 5, y, x + 5, y);
            fill(255);
            text(s.getDisplayName(), x + 20, y);
            
            

        }
    } 

    public void mouseClicked()
    {
        if 
    }

    public void draw()
    {
        background(0);
        drawGrid();
        drawStars();
    }

    /*
        @val: Value to be converted
        @start1: Lower bound of range 1
        @stop1: Upper bound of range 1
        @start2: Lower bound of range 2
        @stop2: Upper bound of range 2
    */
    public float map1(float val, float start1, float stop1, float start2, float stop2){
        return (start2 + (stop2 - start2) * ((val - start1) / (stop1 - start1)));
    }

    private ArrayList<Star> stars = new ArrayList<Star>();

}