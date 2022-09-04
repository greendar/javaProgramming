
/*
2022
Challenge 7 along with lightning challenge
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
      fwd(500);
      left(90);
      fwd(200);
      left(55);
      fwd(300);
      right(45);
      fwd(300);
      //END OF DRIVE CODE******************
      while (opModeIsActive()) {
      }
    }
    public float turnMult = 1.4;

    public void fwd(int mWait){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(1);
      motorRight.setPower(1);
      sleep(mWait);
      stop(500);
    }

    public void back(int mWait){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(-1);
      motorRight.setPower(-1);
      sleep(mWait);
      stop(500);
    }

    public void left(int degLeft){
      float turnTime;
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(-1);
      motorRight.setPower(1);
      turnTime = degLeft * turnMult;
      sleep(turnTime);
      stop(500);
    }

    public void right(int degRight){
      float turnTime;
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(1);
      motorRight.setPower(-1);
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
