package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "Bot Version: 0.24", group = "Main")
public class Robot extends OpMode {

  // DcMotor IntakeWheel = null;
  //
  // Servo BallHolder = null;
  DcMotor FrontRight = null;
  DcMotor FrontLeft = null;
  DcMotor BackRight = null;
  DcMotor BackLeft = null;

  @Override
  public void init() {
    // IntakeWheel = hardwareMap.dcMotor.get("IntakeWheel");
    // BallHolder = hardwareMap.servo.get("BallHolder");
    FrontRight = hardwareMap.dcMotor.get("FrontRight");
    FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
    BackRight = hardwareMap.dcMotor.get("BackRight");
    BackLeft = hardwareMap.dcMotor.get("BackLeft");
    telemetry.addData("Robot Status","Initialized");
    telemetry.update();
  }
  @Override
  public void loop() {
    // TELEMETRY
    telemetry.addData("Gamepad 1 Right Joystick", gamepad1.right_stick_y);
    telemetry.addData("Gamepad 1 Left Joystick", gamepad1.left_stick_y);
    telemetry.addData("Gamepad 1 Up Dpad", gamepad1.dpad_up);
    telemetry.addData("Gamepad 1 Down Dpad", gamepad1.dpad_down);
    telemetry.addData("Gamepad 1 Right Dpad", gamepad1.dpad_right);
    telemetry.addData("Gamepad 1 Left Dpad", gamepad1.dpad_left);
    telemetry.update();
    // DONE TELEMETRY
    // CODE

    // PICKER UPPER CODE UP HERE

    // MECANUM DRIVING
    if(gamepad1.dpad_left){
      FrontRight.setPower(-1);
      FrontLeft.setPower(-1);
      BackRight.setPower(1);
      BackLeft.setPower(1);
      return;
    } else if(gamepad1.dpad_right){
      FrontRight.setPower(1);
      FrontLeft.setPower(1);
      BackRight.setPower(-1);
      BackLeft.setPower(-1);
      return;
    }

    // INTAKE HERE
    /*
    if(gamepad1.dpad_up){
      IntakeWheel.setPower(1);
    }else if(gamepad1.dpad_down){
      IntakeWheel.setPower(-1);
    }else{
      IntakeWheel.setPower(0);
    }
    */

    // TANK DRIVING // Inversed to work with on field issue
    FrontRight.setPower(-gamepad1.left_stick_y);
    FrontLeft.setPower(gamepad1.right_stick_y);
    BackRight.setPower(-gamepad1.left_stick_y);
    BackLeft.setPower(gamepad1.right_stick_y);

    // DONE CODE
  }
}