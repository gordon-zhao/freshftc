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

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Pepe V2", group="TeleOp")  // @Autonomous(...) is the other common choice
public class DankMemes extends OpMode
{

    private int ServoPos = 50;
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private DcMotor clawMotor;
    private Servo clawGrabberL;
    private Servo clawGrabberR;

    @Override
    public void init() {
        rightMotor = hardwareMap.dcMotor.get("drive_right");
        leftMotor = hardwareMap.dcMotor.get("drive_left");
        clawMotor = hardwareMap.dcMotor.get("drive_claw");
        clawGrabberL = hardwareMap.servo.get("drive_grabberl");
        clawGrabberR = hardwareMap.servo.get("drive_grabberr");
    }

    @Override
    public void loop() {
        // TELEMTRY

        telemetry.update();
        telemetry.addData("Gamepad 1 Right Stick", "X: " + gamepad1.right_stick_x + " | Y: " + gamepad1.right_stick_y);
        telemetry.addData("Gamepad 1 Left Stick", "X: " + gamepad1.left_stick_x + " | Y: " + gamepad1.left_stick_y);
        telemetry.addData("Gamepad 1 Right Trigger", gamepad1.right_trigger);
        telemetry.addData("Gamepad 1 Left Trigger", gamepad1.left_trigger);
        telemetry.addData("Gamepad 2 Right Stick", "X: " + gamepad2.right_stick_x + " | Y: " + gamepad2.right_stick_y);
        telemetry.addData("Gamepad 2 Left Stick", "X: " + gamepad2.left_stick_x + " | Y: " + gamepad2.left_stick_y);
        telemetry.addData("Gamepad 2 Right Trigger", gamepad2.right_trigger);
        telemetry.addData("Gamepad 2 Left Trigger", gamepad2.left_trigger);

        // DONE TELEMTRY

        // CHECK FOR FULL STOP COMMAND
        while(gamepad1.x){
            rightMotor.setPower(0);
            leftMotor.setPower(0);
            clawMotor.setPower(0);
            clawGrabberR.setPosition(50);
            clawGrabberL.setPosition(50);
        }

        // SET POWER FOR WHEELS
        rightMotor.setPower(gamepad1.right_stick_y);
        leftMotor.setPower(-gamepad1.left_stick_y);

        // SET POWER FOR CLAW MOVEMENT
        clawMotor.setPower(gamepad1.right_trigger - gamepad1.left_trigger);

        // CLAW GRABBING
        if(gamepad1.right_bumper){
            ServoPos--;
        }else if(gamepad1.left_bumper){
            ServoPos++;
        }
        clawGrabberR.setPosition(ServoPos);
        clawGrabberL.setPosition(ServoPos);

        // DONE GAMEPAD CHECKS
    }
}
