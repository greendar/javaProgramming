//ftcEncoders.java

/*
Base program for solving challenges using encoders.
*/

public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    ColorSensor color1;
    DistanceSensor distance1;
    BNO055IMU imu;


var dist, leftME, rightME;

    // Describe this function...
    public void fwd(String dist){
      motorLeft.setTargetPosition(dist * -1);
      motorRight.setTargetPosition(dist);
      sleep(500);
    }

    public void left(){// Left 90 degrees
      leftME = motorLeft.getTargetPosition();
      rightME = motorRight.getTargetPosition();
      motorLeft.setTargetPosition(leftME + 6);
      motorRight.setTargetPosition(rightME + 6);
      sleep(500);
    }


    public void right(){// Right 90 degrees
      leftME = motorLeft.getTargetPosition();
      rightME = motorRight.getTargetPosition();
      motorLeft.setTargetPosition(leftME - 6);
      motorRight.setTargetPosition(right - 6);
      sleep(500);
    }


    @Override
    public void runOpMode() {
      motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
      motorRight = hardwareMap.get(DcMotor.class, "motorRight");
      color1 = hardwareMap.get(ColorSensor.class, "color1");
      distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
      imu = hardwareMap.get(BNO055IMU.class, "imu");
      motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      waitForStart();
// BEGIN ONE TIME CODE







// END ONE TIME CODE
      while (opModeIsActive()) {
      }
    }

}
