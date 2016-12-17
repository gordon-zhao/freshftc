package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftcrobotcontroller.R;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.matrices.MatrixF;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

@Autonomous(name="Bot Version: 0.10", group ="Main")
public class AutoRobot extends LinearOpMode {

    // DcMotor IntakeWheel = null;
    // Servo BallHolder = null;
    DcMotor FrontRight = null;
    DcMotor FrontLeft = null;
    DcMotor BackRight = null;
    DcMotor BackLeft = null;

    @Override public void runOpMode() {
        // IntakeWheel = hardwareMap.dcMotor.get("IntakeWheel");
        // BallHolder = hardwareMap.servo.get("BallHolder");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        telemetry.addData("Robot Status","Initialized");
        telemetry.update();
        // Drive Forward // Inversed to work with on field issue
        FrontRight.setPower(1);
        FrontLeft.setPower(-1);
        BackRight.setPower(1);
        BackLeft.setPower(-1);
        sleepSeconds(1.5);

    }
    public void sleepSeconds(double time){
        long seconds = (long)(time * 1000);
        try {
            Thread.sleep(seconds);
        }catch (InterruptedException EX){

        }
    }
}
