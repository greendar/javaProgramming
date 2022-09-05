//puz2Bridge.java
/*
put only two blocks in. sloppy but it works
*/


public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    Servo servo1;
    ColorSensor color1;
    DistanceSensor distance1;

@Override
    public void runOpMode() {
      motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
      motorRight = hardwareMap.get(DcMotor.class, "motorRight");
      servo1 = hardwareMap.get(Servo.class, "servo1");
      color1 = hardwareMap.get(ColorSensor.class, "color1");
      distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
      //DRIVE CODE HERE********************

      right(90);
      fwd(1200);
      left(90);
      fwd(1700);
      left(90);
      fwd(1100);
      fwd(300);
      back(700);
      left(90);
      fwd(1700);
      right(90);
      fwd(2100);
      right(90);
      fwd(2400);
      right(90);
      fwd(1100);
      fwd(600);
      left(90);
      fwd(400);

      //END OF DRIVE CODE******************
      while (opModeIsActive()) {
      }
    }
    public float turnMult = 4.33;
    public float power = 0.3;

    public void fwd(int mWait){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(power);
      motorRight.setPower(power);
      sleep(mWait);
      stop(500);
    }

    public void back(int mWait){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(-1 * power);
      motorRight.setPower(-1 * power);
      sleep(mWait);
      stop(500);
    }

    public void left(int degLeft){
      float turnTime;
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(-1 * power);
      motorRight.setPower(power);
      turnTime = degLeft * turnMult;
      sleep(turnTime);
      stop(500);
    }

    public void right(int degRight){
      float turnTime;
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(power);
      motorRight.setPower(-1 * power);
      turnTime = degRight * turnMult;
      sleep(turnTime);
      stop(500);
    }

    public void powerTurn(float left, float right, int mTime){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(left);
      motorRight.setPower(right);
      sleep(mTime);
      stop(500);
    }

    public void stop(int mTime){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(0);
      motorRight.setPower(0);
      sleep(mTime);
    }

}
