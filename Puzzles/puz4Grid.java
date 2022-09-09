//puz4Grid.java
/*
this is all cheese.
*/


public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    Servo servo1;
    ColorSensor color1;
    DistanceSensor distance1;

    double sensedColor;

@Override
    public void runOpMode() {
      motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      motorRight = hardwareMap.get(DcMotor.class, "motorRight");
      servo1 = hardwareMap.get(Servo.class, "servo1");
      color1 = hardwareMap.get(ColorSensor.class, "color1");
      distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
      //DRIVE CODE HERE********************
      telemetry.addData("hue", 998);
      telemetry.addData("Colour", "?");
      right(90);
      fwd(2500);
      left(87);
      power = 1;
      fwd(3600);



      //END OF DRIVE CODE******************
      while (opModeIsActive()) {
        sensedColor = Color.rgb(color1.red(), (color1.green()), (color1.blue()));
        telemetry.addData("hue", (JavaUtil.colorToHue(sensedColor)));
        if (JavaUtil.colorToHue(sensedColor) > 210 ) {
          telemetry.addData("Colour", "Blue");
          goBlue();

        }
        if (JavaUtil.colorToHue(sensedColor) < 50) {
          telemetry.addData("Colour", "Red");
          goRed();
        }
      }
    }
    public float turnMult = 4.33;
    public float power = 0.3;

    public void goRed(){
      back(1250);
      right(90);
      fwd(1600);
      back(50);
      fwd(1600);
    }

    public void fwd(int mWait){
      waitForStart();
      motorLeft.setPower(power);
      motorRight.setPower(power);
      sleep(mWait);
      stop(500);
    }

    public void back(int mWait){
      waitForStart();
      motorLeft.setPower(-1 * power);
      motorRight.setPower(-1 * power);
      sleep(mWait);
      stop(500);
    }

    public void left(int degLeft){
      float turnTime;
      waitForStart();
      motorLeft.setPower(-1 * power);
      motorRight.setPower(power);
      turnTime = degLeft * turnMult;
      sleep(turnTime);
      stop(500);
    }

    public void right(int degRight){
      float turnTime;
      waitForStart();
      motorLeft.setPower(power);
      motorRight.setPower(-1 * power);
      turnTime = degRight * turnMult;
      sleep(turnTime);
      stop(500);
    }

    public void powerTurn(float left, float right, int mTime){
      waitForStart();
      motorLeft.setPower(left);
      motorRight.setPower(right);
      sleep(mTime);
      stop(500);
    }

    public void stop(int mTime){
      waitForStart();
      motorLeft.setPower(0);
      motorRight.setPower(0);
      sleep(mTime);
    }

}
