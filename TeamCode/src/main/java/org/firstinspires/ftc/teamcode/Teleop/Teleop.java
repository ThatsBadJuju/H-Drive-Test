package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

@TeleOp(name = "TestOPMode", group = "jerW" )
public class Teleop  extends OpMode {
    public Drivetrain drivetrain;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("leftMotor"), hardwareMap.dcMotor.get("rightMotor"), hardwareMap.dcMotor.get("horizontalMotor"));
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        drivetrain.controls(gamepad1);
    }

    @Override
    public void stop() {

    }
}
