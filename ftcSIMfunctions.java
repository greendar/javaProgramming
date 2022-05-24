
/***********************************************************************
*                                                                      *
* OnbotJava Editor is still : beta! Please inform us of any bugs      *
* on our discord channel! https://discord.gg/e7nVjMM                   *
* Only BLOCKS code is submitted when in Arena                          *
*                                                                      *
***********************************************************************/


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
      
      // put code here

      while (opModeIsActive()) {
      }
    }

    public void fwd(int mWait){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(1);
      motorRight.setPower(1);
      sleep(mWait);
      motorLeft.setPower(0);
      motorRight.setPower(0);
    }

    public void back(int mWait){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(-1);
      motorRight.setPower(-1);
      sleep(mWait);
      motorLeft.setPower(0);
      motorRight.setPower(0);
    }

    public void left(int degLeft){
      float turnTime;
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(-1);
      motorRight.setPower(1);
      turnTime = degLeft * 4.64;
      sleep(turnTime);
      motorLeft.setPower(0);
      motorRight.setPower(0);
    }

    public void right(int degRight){
      float turnTime;
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(1);
      motorRight.setPower(-1);
      turnTime = degRight * 4.64;
      sleep(turnTime);
      motorLeft.setPower(0);
      motorRight.setPower(0);
    }

    public void powerTurn(float left, float right, int mTime){
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      motorLeft.setPower(left);
      motorRight.setPower(right);
      sleep(mTime);
      motorLeft.setPower(0);
      motorRight.setPower(0);
    }

}
