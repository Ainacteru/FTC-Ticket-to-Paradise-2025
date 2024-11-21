package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Systems.IMU;
import org.firstinspires.ftc.teamcode.Systems.Input;
import org.firstinspires.ftc.teamcode.Systems.Motors;

@Autonomous(name="Main")

public class aUtOnOmOuS extends LinearOpMode {

    Motors motor;
    IMU imu;
    Input input;

    public void runOpMode() throws InterruptedException {

        motor = new Motors(hardwareMap);
        imu = new IMU(hardwareMap);
        input = new Input(hardwareMap);

        imu.SetYaw();



        int step = 0;

        waitForStart();
        //run once

        while (opModeIsActive())
        {
            double yaw = imu.getAngle('y');


            if(step == 0)
            {
                if (yaw < 85 && yaw > 105 ) {
                    input.Spin(50);
                }
                else {
                    step++;
                }
            }



            telemetry.addData("IMU YAW:", "yaw (%.2f),", yaw);
            telemetry.update(); // telemtryy
        }
    }
}
