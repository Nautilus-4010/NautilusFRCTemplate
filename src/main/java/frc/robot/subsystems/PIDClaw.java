package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Encoder.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class PIDClaw extends SubsystemBase {
    public Spark pMotor = new Spark(0);
    //puede que el true se cambie a false si se necesita cambiar la direccion
    public Encoder encoderPID = new Encoder(0, 1, true, EncodingType.k4x);
    public final double encoderConstant = 1.0 / 128 * 6 * Math.PI / 12;

    public PIDClaw {
        pMotor.configure()
            new SparkMaxConfig().follow(pMotor),
            ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters);
    }
   
    


    double setpoint = 0;
    final double kP = 0;

    @Override
    public void periodic() {

    //output a motor 

    SmartDashboard.putNumber("encoder val:", encoderPID.get() * encoderConstant);
    
    }

    public void calculatePID() {
            //sensor position
        double sensorPosition = encoderPID.get() * encoderConstant;

        //calc
        double error = setpoint - sensorPosition;
        double output = kP * error;
    }
}

// ╱|、
//(˚ˎ 。7  
// |、˜〵          
// じしˍ,)ノ