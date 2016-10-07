/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;

/*
TO DO:
1 ) Finish Basic Work | TEST TEST TEST
2 ) Figure Out Purpose of DcMotorController
 */


@TeleOp(name="Template: Iterative OpMode", group="Iterative Opmode")  // @Autonomous(...) is the other common choice
public class DankMemes extends OpMode
{

    private DcMotorController MAIN;
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private DcMotor clawMotor = null;
    private DcMotor clawGrabberL = null;
    private DcMotor clawGrabberR = null;

    @Override
    public void init() {
        MAIN = hardwareMap.dcMotorController.get("drive_controller");
        rightMotor = hardwareMap.dcMotor.get("drive_right");
        leftMotor = hardwareMap.dcMotor.get("drive_left");
        clawMotor = hardwareMap.dcMotor.get("drive_claw");
        clawGrabberL = hardwareMap.dcMotor.get("drive_grabberl");
        clawGrabberR = hardwareMap.dcMotor.get("drive_grabberr");
    }

    @Override
    public void loop() {
        // TELEMTRY

        // REMOVE LATER WHEN APP = WORKING 100000%
        telemetry.update();
        telemetry.addData("Gamepad 1 Right Stick", "X: " + gamepad1.right_stick_x + " | Y: " + gamepad1.right_stick_y);
        telemetry.addData("Gamepad 1 Left Stick", "X: " + gamepad1.left_stick_x + " | Y: " + gamepad1.left_stick_y);
        telemetry.addData("Gamepad 1 Right Trigger", gamepad1.right_trigger);
        telemetry.addData("Gamepad 1 Left Trigger", gamepad1.left_trigger);
        telemetry.addData("Gamepad 2 Right", "X: " + gamepad2.right_stick_x + " | Y: " + gamepad2.right_stick_y);
        telemetry.addData("Gamepad 2 Left", "X: " + gamepad2.left_stick_x + " | Y: " + gamepad2.left_stick_y);
        telemetry.addData("Gamepad 2 Right Trigger", gamepad2.right_trigger);
        telemetry.addData("Gamepad 2 Left Trigger", gamepad2.left_trigger);
        // DONE TELEMTRY

        // GAMEPAD CHECKS
        double rightPower = gamepad1.right_stick_y;
        double leftPower = gamepad1.left_stick_y;


        // INVERSE Y
        rightPower = -rightPower;
        leftPower = -leftPower;

        // SET POWER
        rightMotor.setPower(rightPower);
        leftMotor.setPower(leftPower);
        // DONE GAMEPAD CHECKS
    }
}
