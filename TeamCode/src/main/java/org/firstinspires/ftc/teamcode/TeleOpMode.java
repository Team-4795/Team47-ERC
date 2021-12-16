package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="main teleop", group = "group1")
public class TeleOpMode extends Robot {
    ElapsedTime runtime = new ElapsedTime();

    public void init() {
        super.init();
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

        if (gamepad1.right_trigger > 0.5) {
            //drive controls
            double x = gamepad1.left_stick_y / 1.5;
            if(Math.abs(x) < 0.05) x = 0;
            double y = gamepad1.right_stick_x / 1.5;
            if(Math.abs(x) < 0.05) x = 0;
            slowDrive(x, y);
        } else {
            //drive controls
            double x = gamepad1.left_stick_y / 1.5;
            if(Math.abs(x) < 0.05) x = 0;
            double y = gamepad1.right_stick_x / 1.5;
            if(Math.abs(x) < 0.05) x = 0;
            drive(x, y);
        }

        //arm controls
        if (gamepad1.right_bumper) {
            dunkArm();
        } else if (gamepad1.left_bumper) {
            resetArm();
        } else {
            stopArm();
        }

        if (gamepad1.b) {
            ElapsedTime time = new ElapsedTime();

            if (time.milliseconds() < 4000) {
                dunkArm();
            } else if (time.milliseconds() < 8000) {
                resetArm();
            } else {
                stopArm();
                time.reset();
            }
        }

        if (gamepad1.right_trigger == 1 && gamepad1.left_trigger == 1 && gamepad1.left_bumper && gamepad1.right_bumper) {
            celebrate();
        }
    }

    @Override
    public void stop() {

    }
}