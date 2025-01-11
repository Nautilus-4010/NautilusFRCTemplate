package frc.robot.subsystems;

public class Claw {
    final CANSparkMax rMotor = new CANSparkMax(Constants.HardwareMap.CLAW_R_MOTOR, MotorType.kBrushless);
    final CANSparkMax lMotor = new CANSparkMax(Constants.HardwareMap.CLAW_L_MOTOR, MotorType.kBrushless);


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

// ╱|、
//(˚ˎ 。7  
// |、˜〵          
// じしˍ,)ノ    