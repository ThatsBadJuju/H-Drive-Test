package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.ClawArm;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

@TeleOp(name = "TestOPMode", group = "jerW" )
public class Teleop  extends OpMode {
    public Drivetrain drivetrain;
    public ClawArm clawArm;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("leftMotor"), hardwareMap.dcMotor.get("rightMotor"), hardwareMap.dcMotor.get("horizontalMotor"));
        clawArm = new ClawArm(hardwareMap.dcMotor.get("armMotor"), hardwareMap.servo.get("leftClawServo"), hardwareMap.servo.get("rightClawServo"));
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        drivetrain.controls(gamepad1);
        clawArm.controls(gamepad1);
    }

    @Override
    public void stop() {

    }
}
