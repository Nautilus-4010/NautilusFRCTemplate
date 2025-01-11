package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.SwerveDriveJoystick;
import frc.robot.utils.Constants;
import frc.robot.subsystems.PIDClaw;

public class TeleOp {
    final Joystick driverJoystick = new Joystick(Constants.OperatorConstants.DRIVER_PORT);
    final Joystick codriverJoystick = new Joystick(Constants.OperatorConstants.CODRIVER_PORT);

    final JoystickButton zeroHdgBtn = new JoystickButton(driverJoystick, Constants.OperatorConstants.ZERO_HDG);

    final JoystickButton spinIn = new JoystickButton (codriverJoystick, Constants.OperatorConstants.SPIN_IN);
    final JoystickButton spinOut = new JoystickButton (codriverJoystick, Constants.OperatorConstants.SPIN_OUT);
    
    final Joystick pidJoy = new Joystick(codriverJoystick, Constants.OperatorConstants.P_CLAW);

    

    public TeleOp() {
        RobotContainer.swerve.setDefaultCommand(new SwerveDriveJoystick(
            RobotContainer.swerve,
            () -> -driverJoystick.getRawAxis(Constants.OperatorConstants.DRIVER_X),
            () -> -driverJoystick.getRawAxis(Constants.OperatorConstants.DRIVER_Y),
            () -> -driverJoystick.getRawAxis(Constants.OperatorConstants.DRIVER_Z),
            () -> driverJoystick.getRawButton(Constants.OperatorConstants.ROBOT_ORIENTED)));
        zeroHdgBtn.onTrue(new InstantCommand(() -> RobotContainer.swerve.zeroHeading()));
<<<<<<< HEAD
=======

        spinIn.toggleOnTrue(new InstantCommand(() -> RobotContainer.claw.setMotors(1)))
        spinIn.toggleOnFalse(new InstantCommand(() -> RobotContainer.claw.setMotors(0)))

        spinOut.toggleOnTrue(new InstantCommand(() -> RobotContainer.claw.setMotors(-1)))
        spinOut.toggleOnFalse(new InstantCommand(() -> RobotContainer.claw.setMotors(0)))
>>>>>>> parent of d4d1246 (Added claw and conection to the vision library)
    }

    
}

