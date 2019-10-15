package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawArm {

    public DcMotor armMotor;
    public Servo leftClawServo;
    public Servo rightClawServo;

    int armGrabPosition = 0;
    int armLiftPosition = 1000;

    public ClawArm(DcMotor aM, Servo lCS, Servo rCS) {
        this.armMotor = aM;
        this.leftClawServo = lCS;
        this.rightClawServo = rCS;
        //armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setDirection(DcMotor.Direction.FORWARD);
        //armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        stop();
    }

    public void controls(Gamepad gp) {
        if(gp.dpad_down) {
            //if(!armMotor.isBusy()) {
                liftDown();
            //}

        }
        else if(gp.dpad_up) {
            //if(!armMotor.isBusy()) {
                liftUp();
            //}
        }
        else {
            armMotor.setPower(0.0);
        }

        if(gp.left_bumper) {
            release();
        }
        if(gp.right_bumper) {
            grab();
        }
    }

    public void liftDown() {
        //armMotor.setTargetPosition(armGrabPosition);
        //armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(-0.2);
    }

    public void liftUp() {
        //armMotor.setTargetPosition(armLiftPosition);
        //armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(0.2);
    }


    public void grab() {
        leftClawServo.setPosition(1.0);
        rightClawServo.setPosition(0.0);
    }

    public void release() {
        leftClawServo.setPosition(0.0);
        rightClawServo.setPosition(1.0);
    }

    public void stop() {
        armMotor.setPower(0.0);
    }
}
