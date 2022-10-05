
public class MyFIRSTJavaOpMode extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor crane;
    DcMotor carousel;
    Servo claw;
    BNO055IMU imu;
    VuforiaCurrentGame vuforiaTensorFlow;
    TfodCurrentGame tensorFlowObjectDetection;

var recognitions;


    @Override
    public void runOpMode() {
      motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
      motorRight = hardwareMap.get(DcMotor.class, "motorRight");
      crane = hardwareMap.get(DcMotor.class, "crane");
      carousel = hardwareMap.get(DcMotor.class, "carousel");
      claw = hardwareMap.get(Servo.class, "claw");
      imu = hardwareMap.get(BNO055IMU.class, "imu");
      vuforiaTensorFlow = new VuforiaCurrentGame();
      tensorFlowObjectDetection = new TfodCurrentGame();
      vuforiaTensorFlow.initialize("", VuforiaLocalizer.CameraDirection.BACK, true, false, VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES, 0, 0, 0, 0, (-90), 0, true);
      tensorFlowObjectDetection.initialize(vuforiaTensorFlow, 0.4f, true, true);
      telemetry.addData(">", "Press Play to Start");
      telemetry.update();
      waitForStart();
      if (opModeIsActive()) {
        tensorFlowObjectDetection.activate();
        while (opModeIsActive()) {
          recognitions = tensorFlowObjectDetection.getRecognitions();
          telemetry.addData("# Objects Recognized", (recognitions.size()));
        }
      }
      vuforiaTensorFlow.close();
      tensorFlowObjectDetection.close();
    }

}
