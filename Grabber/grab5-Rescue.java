//grab5-Rescue.java
/* NOT FINISHED
  -added grabberUp() and grabberDown() functions


*/
public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor driveLeft;
    DcMotor driveRight;
    DcMotor sideways;
    Servo grabber;
    ColorSensor color1;
    DistanceSensor distance1;
    BNO055IMU imu;

@Override
    public void runOpMode() {
      driveLeft = hardwareMap.get(DcMotor.class, "driveLeft");
      driveLeft.setDirection(DcMotor.Direction.REVERSE);
      driveRight = hardwareMap.get(DcMotor.class, "driveRight");
      sideways = hardwareMap.get(DcMotor.class, "sideways");
      grabber = hardwareMap.get(Servo.class, "grabber");
      color1 = hardwareMap.get(ColorSensor.class, "color1");
      distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
      imu = hardwareMap.get(BNO055IMU.class, "imu");
      // Put initialization blocks here
      waitForStart();
      // Put run blocks here
      grabberUp();
      fwd(500);
      right(60);
      fwd(1000);
      grabberDown();
      back(1000);
      grabberUp();
      back(100);
      right(115);
      fwd(1000);
      grabberDown();
      back(500);
      right(70);
      fwd(600);
      right(70);
      fwd(1000);
      grabberUp();




      while (opModeIsActive()) {
        // Put loop blocks here
      }
    }
    public float turnMult = 4.33;
    public float power = 0.3;

    public void grabberUp(){
      grabber.setPosition(1);
      sleep(500);
    }

    public void grabberDown(){
      grabber.setPosition(0);
      sleep(500);
    }

    public void fwd(int mWait){
      waitForStart();
      driveLeft.setPower(power);
      driveRight.setPower(power);
      sleep(mWait);
      stop(500);
    }

    public void back(int mWait){
      waitForStart();
      driveLeft.setPower(-1 * power);
      driveRight.setPower(-1 * power);
      sleep(mWait);
      stop(500);
    }

    public void left(int degLeft){
      float turnTime;
      waitForStart();
      driveLeft.setPower(-1 * power);
      driveRight.setPower(power);
      turnTime = degLeft * turnMult;
      sleep(turnTime);
      stop(500);
    }

    public void right(int degRight){
      float turnTime;
      waitForStart();
      driveLeft.setPower(power);
      driveRight.setPower(-1 * power);
      turnTime = degRight * turnMult;
      sleep(turnTime);
      stop(500);
    }

    public void powerTurn(float left, float right, int mTime){
      waitForStart();
      driveLeft.setPower(left);
      driveRight.setPower(right);
      sleep(mTime);
      stop(500);
    }

    public void stop(int mTime){
      waitForStart();
      driveLeft.setPower(0);
      driveRight.setPower(0);
      sleep(mTime);
    }

}
