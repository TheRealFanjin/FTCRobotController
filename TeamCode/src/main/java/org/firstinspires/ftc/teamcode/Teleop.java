package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Teleop extends OpMode {

    private final float TRIGGER_DEADZONE = 0.01f;

    private DcMotor frontLeftWheel;
    private DcMotor frontRightWheel;
    private DcMotor backLeftWheel;
    private DcMotor backRightWheel;

    @Override
    public void init() {
        frontLeftWheel = hardwareMap.get(DcMotor.class, "frontLeftWheel");
        frontRightWheel = hardwareMap.get(DcMotor.class, "frontRightWheel");
        backLeftWheel = hardwareMap.get(DcMotor.class, "backLeftWheel");
        backRightWheel = hardwareMap.get(DcMotor.class, "backRightWheel");
    }

    @Override
    public void loop() {
        double power = 0;

        DcMotor[][] motors = {{frontLeftWheel, frontRightWheel}, {backLeftWheel, backRightWheel}};
        if (gamepad1.left_stick_y != 0) {
            power = gamepad1.left_stick_y;
        }

        for (DcMotor[] motor_set : motors) {
            motor_set[0].setPower(power);
            motor_set[1].setPower(-power);
        }
    }

}
