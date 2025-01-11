// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.swerve.Swerve;

public class RobotContainer {
  public static final Swerve swerve = new Swerve();
<<<<<<< HEAD

=======
  public static final Claw claw = new Claw();
  public static final PIDClaw pidClaw = new PIDClaw();
>>>>>>> parent of d4d1246 (Added claw and conection to the vision library)
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
