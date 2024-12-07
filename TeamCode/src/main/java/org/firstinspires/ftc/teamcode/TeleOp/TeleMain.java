package org.firstinspires.ftc.teamcode.TeleOp;

import android.graphics.Color;
import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Systems.Input;
import org.firstinspires.ftc.teamcode.Systems.Motors;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.opencv.ImageRegion;
import org.firstinspires.ftc.vision.opencv.PredominantColorProcessor;

@TeleOp(name="Teleop-Main")

public class TeleMain extends LinearOpMode {

    Motors motors;
    Input input;
//
//    public boolean moveto = false;


    @Override
    public void runOpMode() throws InterruptedException {



        motors = new Motors(hardwareMap); // just needed for debugging, probably comment out and line 32
        input = new Input(hardwareMap);



        waitForStart();

        while (opModeIsActive())
        {
            double armPos = motors.getArmPosition(); // comment out this line when actual probably

            double move = gamepad1.left_stick_y * 100;
            double spin = gamepad1.right_stick_x * 100;
            double strafe = gamepad1.left_stick_x * 100;
            double intake = gamepad2.left_stick_y * 100;

            boolean armHold = (gamepad2.right_trigger * 100) > 0.01;

            double armRaise = gamepad2.right_stick_y * 100;
            boolean dropButton = gamepad2.a;

            input.move(move);
            input.spin(spin);
            input.strafe(strafe);

            //input.intake(intake);
            //input.pickup(armHold);

            input.armMove(-armRaise);
            input.drop(dropButton);



            input.stabalizeArm(gamepad2.left_stick_y);

            telemetry.addData("MOVE:", "left_y (%.2f),", move);
            telemetry.addData("SPIN:", "right_x (%.2f),", spin);
            telemetry.addData("STRAFE:", "left_x (%.2f),", strafe);
            telemetry.addData("ARM:", "arm_x (%.2f),", intake);
            telemetry.addData("ARM position:", "arm_pos (%.2f),", armPos);
            telemetry.update(); // telemtryy
        }
    }
}
