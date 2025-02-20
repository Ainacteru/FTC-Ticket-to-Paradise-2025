package org.firstinspires.ftc.teamcode.Systems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {

    private final Servo[] servos;

    public enum Type {
        Claw (0),
        Wrist(1);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Servos(HardwareMap hardwareMap) //init the servos
    {
        servos = new Servo[Type.values().length];

        servos[Type.Claw.getValue()] = hardwareMap.get(Servo.class, "claw");
        servos[Type.Wrist.getValue()] = hardwareMap.get(Servo.class, "drop");

    }
    public void setServoPosition(Type servoName, double position) // select a servo and then select a position, you put in 0-360 degrees, and it converts it into 0-1
    {
        double actualPosition = position / 270;

        servos[servoName.getValue()].setPosition(actualPosition);
    }

    public double getServoPosition(Type servoName)
    {
        return servos[servoName.getValue()].getPosition() * 270;
    }

}
