class Cow {
  //variables
  float x;
  float y;
  float w;
  float h;
  color c;
  float speedX;
  float speedY;
  float footStep;
  float footMove;

  float sx,sy,sw,sh;

  //constructor
  Cow(color cTemp) {
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
  void update() {
    // y += speedY;
    x += speedX/2;
  }
  void checkBoundaries() {
    // if (y < 0 || y > 400) {
    //   speedY *= -1;
    // }
    if (x < 0 || x > 600) {
      speedX *= -1;
    }
  }
  void display() {
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