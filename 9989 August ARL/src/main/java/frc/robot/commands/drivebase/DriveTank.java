// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveTank extends CommandBase {
  /** Creates a new DriveTank. */
  private double leftSpeed;
  private double rightSpeed;

  public DriveTank(double left, double right) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveSubsystem);
    leftSpeed = left;
    rightSpeed = right;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Driving Tank");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_driveSubsystem.DriveTank(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("End Driving Tank");
    RobotContainer.m_driveSubsystem.DriveTank(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
