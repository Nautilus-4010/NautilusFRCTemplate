package frc.robot.subsystems;

public class Claw {
    final Servo servo = new Servo(Constants.HardwareMap.SERVO_CLAW);
    final CANSparkMax rMotor = new CANSparkMax(Constants.HardwareMap.CLAW_R_MOTOR, MotorType.kBrushless);
    final CANSparkMax lMotor = new CANSparkMax(Constants.HardwareMap.CLAW_L_MOTOR, MotorType.kBrushless);

    public void setServo(double position) {
        servo.set(position);
    }

    public void setRMotor(double power) {
        rMotor.set(power);

    }

    public void setLMotor(double power) {
        lMotor.set(power);
        
    }

    public void setMotors(double Power) {
       setRMotor(power);
       setLMotor(power);
    }
}