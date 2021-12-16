package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Robot extends OpMode {
    //drivebase
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    //bucket arm
    private DcMotor bucketArm;

    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        bucketArm = hardwareMap.dcMotor.get("bucketArm");
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

    }

    public void drive(double power, double turn) {
        leftMotor.setPower(Math.pow(power - turn * 0.7, 2) * Math.signum(power - turn * 0.7));
        rightMotor.setPower(Math.pow(power * 0.95 + turn * 0.7, 2) * Math.signum(power + turn * 0.7));
    }

    public void slowDrive(double power, double turn) {
        leftMotor.setPower(Math.pow(power * 0.3 - turn * 0.3, 2) * Math.signum(power - turn));
        rightMotor.setPower(Math.pow(power * 0.25 + turn * 0.3, 2) * Math.signum(power + turn));
    }

    public void celebrate() {
        ElapsedTime celTime = new ElapsedTime();

        if (celTime.milliseconds() < 3000) {
            rightMotor.setPower(-0.7);
            leftMotor.setPower(0.7);
            bucketArm.setPower(0.7);
        } else if (celTime.milliseconds() < 6000) {
            rightMotor.setPower(0.7);
            leftMotor.setPower(-0.7);
            bucketArm.setPower(-0.7);
        } else {
            leftMotor.setPower(0);
            leftMotor.setPower(0);
            bucketArm.setPower(0);
        }

    }

    public void dunkArm() {
        bucketArm.setPower(0.1);
    }

    public void resetArm() {
        bucketArm.setPower(-1);
    }

    public void stopArm() {
        bucketArm.setPower(0);
    }

}