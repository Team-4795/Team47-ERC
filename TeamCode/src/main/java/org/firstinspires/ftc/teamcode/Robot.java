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
        leftMotor.setPower(Math.pow(power - turn, 2) * Math.signum(power - turn));
        rightMotor.setPower(Math.pow(power * 0.95 + turn, 2) * Math.signum(power + turn));
    }

    public void celebrate(double power) {
        double rate = power + power;

        leftMotor.setPower(power);
        rightMotor.setPower(power - rate);
    }

    public void dunkArm() {
        bucketArm.setPower(0.7);
    }

    public void resetArm() {
        bucketArm.setPower(-.5);
    }

    public void stopArm() {
        bucketArm.setPower(0);
    }

}