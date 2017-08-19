import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class cowGame extends PApplet {

Cow [] cows;

public void setup() {
  
  cows = new Cow[10];

  for (int i = 0; i < cows.length; ++i) {
    cows[i] = new Cow(color(random(240, 255), random(240, 255), random(220, 255)));
  }
   for (int j = 0; j < cows.length; ++j) {
     println("cow x: "+cows[j].x);
   }
}

public void draw() {
  clearBackground();
  for (int i = 0; i < cows.length; ++i) {
    cows[i].update();
    cows[i].checkBoundaries();
    cows[i].display();
  }
  // b0.update();
  // b0.checkBoundaries();
  // b0.display();

  // b1.update();
  // b1.checkBoundaries();
  // b1.display();

  // b2.update();
  // b2.checkBoundaries();
  // b2.display();

  // b3.update();
  // b3.checkBoundaries();
  // b3.display();
  fill(255,0,0);
  rect(mouseX-50,mouseY,100,2);
  rect(mouseX,mouseY-50,2,100);
  noCursor();
}
public void clearBackground() {
  fill(128, 100);
  rect(0, 0, width, height);
}
class Cow {
  //variables
  float x;
  float y;
  float w;
  float h;
  int c;
  float speedX;
  float speedY;
  float footStep;
  float footMove;

  float sx,sy,sw,sh;

  //constructor
  Cow(int cTemp) {
    x = random (1, 599);
    y = random (20, 350);
    w = random (30, 50);
    h = 25;
    c = cTemp;
    speedX = random(1, 3);
    speedY = random(0, 1);
    footStep = 0;
    footMove = speedX;
    
    sw = random(2, w-5);
    sh = random(2,h-5);
    sx = random(5, w-sw);
    sy = random(0, h-sh);
  }
  //methods
  public void update() {
    // y += speedY;
    x += speedX/2;
  }
  public void checkBoundaries() {
    // if (y < 0 || y > 400) {
    //   speedY *= -1;
    // }
    if (x < 0 || x > 600) {
      speedX *= -1;
    }
  }
  public void display() {
    //fill behind legs
    fill(150,90,90);
    //draw left behind
    pushMatrix();
      translate(x+4, y+h);
      rotate(radians(-footStep+12));
      rect(-2, -2, 4, 15);
    popMatrix();
    //draw right behind
    pushMatrix();
      translate(x+w-4, y+h);
      rotate(radians(-footStep+12));
      rect(-2, -2, 4, 15);
    popMatrix();
    //fill body
    fill(c);
    //draw left front
    pushMatrix();
      translate(x+2, y+h);
      rotate(radians(footStep-12));
      rect(-2, 0, 4, 15);
    popMatrix();
    //draw right front
    pushMatrix();
      translate(x+w-2, y+h);
      rotate(radians(footStep-12));
      rect(-2, 0, 4, 15);
    popMatrix();

    //draw body
    rect(x, y, w, h);
    fill(50);
    rect(x+sx,y+sy,sw,sh);
    
    //adjust leg position based on speed
    footStep = (footStep+footMove)%24;
    fill(c);
    //flip head
    if (speedX>0) {
      rect(x+w-6,y-15,3,5);
      rect(x+w-8, y-10, 18, 10);
    } else {
      rect(x+2,y-15,3,5);
      rect(x-10, y-10, 18, 10);
    }
  }
}
  public void settings() {  size(600, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "cowGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
