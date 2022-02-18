
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
      motorRight = hardwareMap.get(DcMotor.class, "motorRight");
      servo1 = hardwareMap.get(Servo.class, "servo1");
      color1 = hardwareMap.get(ColorSensor.class, "color1");
      distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
      fwd(600);
      while (opModeIsActive()) {
        sensedColor = Color.rgb(color1.red(), (color1.green()), (color1.blue()));
        telemetry.addData("hue", (JavaUtil.colorToHue(sensedColor)));
        if (JavaUtil.colorToHue(sensedColor) > 210 && (JavaUtil.colorToHue(sensedColor)) < 275) {
          motorLeft.setPower(-1);
          motorRight.setPower(1);
          sleep(420);
          motorLeft.setPower(1);
          motorRight.setPower(1);
          sleep(700);
          motorLeft.setPower(0);
          motorRight.setPower(0);
        }
        if (JavaUtil.colorToHue(sensedColor) > 330) {
          motorLeft.setPower(1);
          motorRight.setPower(-1);
          sleep(420);
          motorLeft.setPower(1);
          motorRight.setPower(1);
          sleep(700);
          motorLeft.setPower(0);
          motorRight.setPower(0);
        }
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
