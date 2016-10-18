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

@TeleOp(name="Main|Version - 0.01", group="TeleOp")  // @Autonomous(...) is the other common choice
public class DankMemes extends OpMode
{

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
        telemetry.addData("DC Motor : Right Motor", rightMotor.getMaxSpeed());
        telemetry.addData("DC Motor : Left Motor", leftMotor.getMaxSpeed());
        telemetry.addData("DC Motor : Arm Motor", clawMotor.getMaxSpeed());
        telemetry.addData("Servo : Right Claw", clawGrabberR.getPosition());
        telemetry.addData("Servo : Left Claw", clawGrabberL.getPosition());

        // DONE TELEMTRY

        // SET POWER FOR WHEELS - WORKING
        rightMotor.setPower(gamepad1.right_stick_y);
        leftMotor.setPower(-gamepad1.left_stick_y);

        // SET POWER FOR CLAW MOVEMENT - WORKING
        clawMotor.setPower(gamepad1.right_trigger - gamepad1.left_trigger);

        // CLAW GRABBING - NEEDS HELP - THIS FIX SHOULD WORK
        if(gamepad1.right_bumper){
            clawGrabberR.setPosition(clawGrabberR.getPosition()+0.1);
            clawGrabberL.setPosition(clawGrabberL.getPosition()+0.1);
        }else if(gamepad1.left_bumper){
            clawGrabberR.setPosition(clawGrabberR.getPosition()-0.1);
            clawGrabberL.setPosition(clawGrabberL.getPosition()-0.1);
        }

        // DONE GAMEPAD CHECKS
    }
}
