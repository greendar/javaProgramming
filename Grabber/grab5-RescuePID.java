//grab5-RescuPIDe.java
/* NOT FINISHED
  -changed motor type to DcMotorEx


*/

public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotorEx driveLeft;
    DcMotorEx driveRight;
    DcMotorEx sideways;
    Servo grabber;
    ColorSensor color1;
    DistanceSensor distance1;
    BNO055IMU imu;

    double integralSum = 0;
    double Kp = 1.8;
    double Ki = 0.15;
    //double Kd = 0;

    int target = 45;

    //ElapsedTime timer = new ElapsedTime();
    private double lastError = 0;


var IMUparamaters, state, power;


    public void initIMU(){
      IMUparamaters = (new BNO055IMU.Parameters());
      BNO055IMU.Parameters.setSensorMode(IMUparamaters, BNO055IMU.SensorMode.IMU);
      BNO055IMU.Parameters.setAngleUnit(IMUparamaters, BNO055IMU.AngleUnit.DEGREES);
      telemetry.addData("Status", "Init IMU...Please Wait");
      telemetry.update();
      imu.initialize(IMUparamaters);
      telemetry.addData("Status", "IMU Initialized");
      telemetry.update();
    }

    //trying something new here

    public float pidPower(){
      double error = target - state;
      integralSum += error;
      if(integralSum > 45){
          integralSum = 45;

      }
      if(integralSum < -45){
          integralSum = -45;
      }
      double output = (error * Kp) + (integralSum * Ki);
      telemetry.addData("Power", output/500);
      telemetry.update();
      return output/300;

    }


    @Override
    public void runOpMode() {
      driveLeft = hardwareMap.get(DcMotor.class, "driveLeft");
      driveRight = hardwareMap.get(DcMotor.class, "driveRight");
      sideways = hardwareMap.get(DcMotor.class, "sideways");
      grabber = hardwareMap.get(Servo.class, "grabber");
      color1 = hardwareMap.get(ColorSensor.class, "color1");
      distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
      imu = hardwareMap.get(BNO055IMU.class, "imu");
      driveLeft.setDirection(DcMotor.Direction.REVERSE);
      initIMU();
      waitForStart();
      while (opModeIsActive()) {
        state = (imu.getAngularOrientation());
        telemetry.addData("State", state);
        telemetry.update();
        power = pidPower();
        driveLeft.setPower(power);
        driveRight.setPower(-power);
      }
    }

}
