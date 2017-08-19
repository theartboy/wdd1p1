Cow [] cows;

void setup() {
  size(600, 400);
  cows = new Cow[10];

  for (int i = 0; i < cows.length; ++i) {
    cows[i] = new Cow(color(random(240, 255), random(240, 255), random(220, 255)));
  }
   for (int j = 0; j < cows.length; ++j) {
     println("cow x: "+cows[j].x);
   }
}

void draw() {
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
void clearBackground() {
  fill(128, 100);
  rect(0, 0, width, height);
}
