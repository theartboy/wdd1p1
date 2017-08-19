var cows = new Array(10);
var img

function setup() {
    createCanvas(600, 400);
    //cows = new Cow[10];

    for (var i = 0; i < cows.length; ++i) {
        cows[i] = new Cow();
    }
    img = loadImage("pinkunicorn.png");
    //  for (var j = 0; j < cows.length; ++j) {
    //   //  println("cow x: "+cows[j].x);
    //  }
}

function draw() {
    clearBackground();
    for (var i = 0; i < cows.length; ++i) {
        cows[i].update();
        cows[i].checkBoundaries();
        cows[i].display();
    }

    //draw the crosshairs
    fill(255, 0, 0);
    rect(mouseX - 50, mouseY, 100, 2);
    rect(mouseX, mouseY - 50, 2, 100);
    noCursor();
}

function clearBackground() {
    fill(128,200,150, 100);
    rect(0, 0, width, height);
    image(img, 150, 50);
}

//constructor
function Cow() {
    this.x = random(1, 599);
    this.y = random(20, 350);
    this.w = random(30, 50);
    this.h = 25;
    this.c = (random(255), random(255), random(255));
    this.speedX = random(1, 3);
    this.speedY = random(0, 1);
    this.footStep = 0;
    this.footMove = this.speedX;

    this.sw = random(2, this.w - 5);
    this.sh = random(2, this.h - 5);
    this.sx = random(5, this.w - this.sw);
    this.sy = random(0, this.h - this.sh);

    //methods
    this.update = function() {
        // y += speedY;
        this.x += this.speedX / 2;
    }
    this.checkBoundaries = function() {
        // if (y < 0 || y > 400) {
        //   speedY *= -1;
        // }
        if (this.x < 0 || this.x > 600) {
            this.speedX *= -1;
        }
    }
    this.display = function() {
        //fill behind legs
        fill(150, 90, 90);
        //draw left behind
        push();
        translate(this.x + 4, this.y + this.h);
        rotate(radians(-this.footStep + 12));
        rect(-2, -2, 4, 15);
        pop();
        //draw right behind
        push();
        translate(this.x + this.w - 4, this.y + this.h);
        rotate(radians(-this.footStep + 12));
        rect(-2, -2, 4, 15);
        pop();
        //fill body
        fill(this.c);
        //draw left front
        push();
        translate(this.x + 2, this.y + this.h);
        rotate(radians(this.footStep - 12));
        rect(-2, 0, 4, 15);
        pop();
        //draw right front
        push();
        translate(this.x + this.w - 2, this.y + this.h);
        rotate(radians(this.footStep - 12));
        rect(-2, 0, 4, 15);
        pop();

        //draw body
        rect(this.x, this.y, this.w, this.h);
        fill(50);
        rect(this.x + this.sx, this.y + this.sy, this.sw, this.sh);

        //adjust leg position based on speed
        this.footStep = (this.footStep + this.footMove) % 24;
        fill(this.c);
        //flip head
        if (this.speedX > 0) {
            rect(this.x + this.w - 6, this.y - 15, 3, 5);
            rect(this.x + this.w - 8, this.y - 10, 18, 10);
        } else {
            rect(this.x + 2, this.y - 15, 3, 5);
            rect(this.x - 10, this.y - 10, 18, 10);
        }
    }
}
