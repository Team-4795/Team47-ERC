package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="auto", group = "group1")
public class Auto extends Robot {
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
        if(runtime.milliseconds() < 2000) {
            drive(0.3, 0);
        } else if (runtime.milliseconds() < 4000) {
            dunkArm();
        } else if (runtime.milliseconds() < 6000) {
            drive(-0.4, 0);
            resetArm();
        } else {
            drive(0, 0);
            stopArm();
        }

    }

    @Override
    public void stop() {

    }
}