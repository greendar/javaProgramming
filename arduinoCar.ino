// C++ code
//
int e12 = 9;
int e34 = 10;
int inp1 = 5;
int inp2 = 4;
int inp3 = 7;
int inp4 = 6;

void setup(){
  pinMode(e12, OUTPUT);
  pinMode(e34, OUTPUT);
  pinMode(inp1, OUTPUT);
  pinMode(inp2, OUTPUT);
  pinMode(inp3, OUTPUT);
  pinMode(inp4, OUTPUT);
}

void loop(){
  fwd(100);
  delay(10);
}

void fwd(int speedPerc){
  // function that takes in a percent value and goes forward at that percent speed
  int speed = map(speedPerc, 0, 100, 0, 255);
  analogWrite(e12, speed);
  analogWrite(e34, speed);
  digitalWrite(inp1, HIGH);
  digitalWrite(inp2, LOW);
  digitalWrite(inp3, HIGH);
  digitalWrite(inp4, LOW);
}

void back(int speedPerc){
  // function that takes in a percent value and goes backward at that percent speed
  int speed = map(speedPerc, 0, 100, 0, 255);
  analogWrite(e12, speed);
  analogWrite(e34, speed);
  digitalWrite(inp1, LOW);
  digitalWrite(inp2, HIGH);
  digitalWrite(inp3, LOW);
  digitalWrite(inp4, HIGH);
}

void powerTurn(int leftPerc, int rightPerc){
  // function that takes in a percent value and goes forward at that percent speed
  int left = map(leftPerc, 0, 100, 0, 255);
  int right = map(rightPerc, 0, 100, 0, 255);
  analogWrite(e12, left);
  analogWrite(e34, right);
  digitalWrite(inp1, HIGH);
  digitalWrite(inp2, LOW);
  digitalWrite(inp3, HIGH);
  digitalWrite(inp4, LOW);
}
