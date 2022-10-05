public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    ColorSensor color1;
    DistanceSensor distance1;
    BNO055IMU imu;

var code;

    // Describe this function...
    public void telemWrite(String code){
      if (code == 1) {
        telemetry.addData("Code", "1");
      } else if (code == 2) {
        telemetry.addData("Code", "2");
      } else if (code == 3) {
        telemetry.addData("Code", "3");
      } else {
        telemetry.addData("Code", "No Code");
      }
      telemetry.update();
    }


    @Override
    public void runOpMode() {
      motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
      motorRight = hardwareMap.get(DcMotor.class, "motorRight");
      color1 = hardwareMap.get(ColorSensor.class, "color1");
      distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
      imu = hardwareMap.get(BNO055IMU.class, "imu");
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      waitForStart();
      telemWrite(1);
      sleep(1000);
      telemWrite(2);
      sleep(1000);
      telemWrite(3);
      sleep(1000);
      telemWrite(4);
    }

}
