package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

public class Drivetrain {
    public DcMotor leftDrive;   //3 drivetrain motors
    public DcMotor rightDrive;
    public DcMotor horizontalDrive; //controls horizontal motion
    public static final int TICKS_PER_ROTATION = 1000; //how fast motor turns?

    public Drivetrain(DcMotor lD, DcMotor rD, DcMotor hD) { //constructor: what does it do
        this.leftDrive = lD;
        this.rightDrive = rD;
        this.horizontalDrive = hD;
    }

    public void controls(Gamepad gamepad) { //creates method controls to use in teleop?
        float speed = gamepad.left_stick_y * -1;
        float direction = gamepad.left_stick_x;

        float leftDrivePower = speed + direction;
        float rightDrivePower = speed - direction;

        leftDrivePower = Range.clip(leftDrivePower, -1, 1);
        rightDrivePower = Range.clip(rightDrivePower, -1, 1);
        leftDrive.setPower(leftDrivePower);
        rightDrive.setPower(-rightDrivePower);

        float horizontalSpeed = gamepad.right_stick_x;
        float horizontalDrivePower = horizontalSpeed;

        horizontalDrive.setPower(horizontalDrivePower);
    }
}
