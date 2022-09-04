
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
    ColorSensor color1;
    DistanceSensor distance1;
    BNO055IMU imu;
    

var dist;

    // Describe this function...
    public void fwd(String dist){
      motorLeft.setTargetPosition(dist * -1);
      motorRight.setTargetPosition(dist);
    }

    public void left(){
      motorLeft.setTargetPosition(6);
      motorRight.setTargetPosition(6);
    }


    public void right(){
      motorLeft.setTargetPosition(-6);
      motorRight.setTargetPosition(-6);
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
      right();
      while (opModeIsActive()) {
      }
    }

}
