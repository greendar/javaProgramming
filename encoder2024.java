public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor frontLeft;
    DcMotor frontRight;
    ColorSensor color1;
    DistanceSensor distance1;
    BNO055IMU imu;

var position, power;
    
    // this only goes forward
    public void turnTo(String position, String power){
      motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      motorLeft.setTargetPosition(position);
      motorRight.setTargetPosition(position);
      motorLeft.setPower(power);
      motorRight.setPower(power);
    }
    
    
    @Override
    public void runOpMode() {
      motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
      motorRight = hardwareMap.get(DcMotor.class, "motorRight");
      frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
      frontRight = hardwareMap.get(DcMotor.class, "frontRight");
      color1 = hardwareMap.get(ColorSensor.class, "color1");
      distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
      imu = hardwareMap.get(BNO055IMU.class, "imu");
      motorLeft.setDirection(DcMotor.Direction.REVERSE);
      motorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      motorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      waitForStart();
      turnTo(4000, 1);
    }    
}
