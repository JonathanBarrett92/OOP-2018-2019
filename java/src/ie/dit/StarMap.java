package ie.dit;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    int selected1 = -1;
    int selected2 = -1;

    public void settings() {
        size(500, 500);
    }

    public void setup() {

        // Testing an array list
        /*
         * Star s = new Star(); s.setDisplayName("DIT"); stars.add(s); Star s1 =
         * stars.get(0);
         * 
         * s1.setDisplayName("TU Dublin");
         * 
         * System.out.println(s); System.out.println(stars.get(0));
         * System.out.println(s1);
         */

        loadData();
        printStars();
<<<<<<< HEAD
        border = width * 0.05f;
        
        System.out.println("Our map is: " + map1(5, 0, 100, 0, 200));
        System.out.println("Their map is: " + map(5, 0, 100, 0, 200));

        System.out.println("Our map is: " + map1(-5, -10, 1, -100, 1));
        System.out.println("Their map is: " + map(-5, -10, 1, -100, 1));
=======
        border = width * 0.1f;

        // Testing the map function
        System.out.println(map1(-20, -15, -20, 0, 100));
        System.out.println(map(25, 20, 30, 30, 40));
        System.out.println(map1(25, 20, 30, 30, 40));
        System.out.println(map(0, -100, 200, 100, 500));
        System.out.println(map1(0, -100, 200, 100, 500));
>>>>>>> eddb58ad50b5d817ff156fb2f95a377429e72cbc
    }

    public void loadData() {
        Table table = loadTable("HabHYG15ly.csv", "header");

        // This will also work!
        /*
         * for(int i = 0 ; i < table.getRowCount() ; i ++) { TableRow row =
         * table.getRow(i); System.out.println(row.getString("Display Name"));
         * System.out.println(row.getString("Hab?")); }
         */

        for (TableRow row : table.rows()) {
            Star star = new Star(row);
            stars.add(star);
        }
    }

    public void printStars() {
        for (Star star : stars) {
            System.out.println(star);
        }
    }

    float border;

    private void drawGrid() {
        textAlign(CENTER, CENTER);
        for (int i = -5; i <= 5; i++) {
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

    public void drawStars() {
        textAlign(LEFT, CENTER);
        for (Star s : stars) {
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

    // This is how the map function works!
    private float map1(float a, float b, float c, float d, float e) {
        float range1 = c - b;
        float howFar = a - b;

        float range2 = e - d;

        return d + (howFar / range1) * range2;
    }

    public void mouseClicked() {
        for (int i = 0; i < stars.size(); i++) {
            Star s = stars.get(i);

<<<<<<< HEAD
    public void mouseClicked()
    {
        if 
=======
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            if (dist(mouseX, mouseY, x, y) < s.getAbsMag() / 2) {
                if (selected1 == -1) {
                    selected1 = i;
                } else if (selected2 == -1) {
                    selected2 = i;
                } else {
                    selected1 = i;
                    selected2 = -1;
                }
            }
        }
>>>>>>> eddb58ad50b5d817ff156fb2f95a377429e72cbc
    }

    public void draw() {
        background(0);
        drawGrid();
        drawStars();

        // If I have selected one of the stars
        if (selected1 != -1 && selected2 == -1) {
            Star star1 = stars.get(selected1);
            stroke(255, 255, 0);
            float x = map(star1.getxG(), -5, 5, border, width - border);
            float y = map(star1.getyG(), -5, 5, border, height - border);

            line(x, y, mouseX, mouseY);
        } else if (selected1 != -1 && selected2 != -1) {
            Star star1 = stars.get(selected1);
            float x1 = map(star1.getxG(), -5, 5, border, width - border);
            float y1 = map(star1.getyG(), -5, 5, border, height - border);

            Star star2 = stars.get(selected2);
            float x2 = map(star2.getxG(), -5, 5, border, width - border);
            float y2 = map(star2.getyG(), -5, 5, border, height - border);

            stroke(255, 255, 0);
            line(x1, y1, x2, y2);
            fill(255);
            float dist = dist(star1.getxG(), star1.getyG(), star1.getzG(), star2.getxG(), star2.getyG(), star2.getzG());
            text("Distance from " + star1.getDisplayName() + " to " + star2.getDisplayName() + " is " + dist + " parsecs", border,
                    height - 25);
        }

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