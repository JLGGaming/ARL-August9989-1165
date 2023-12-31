// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveArcade extends CommandBase {
  /** Creates a new DriveArcade. */
  public DriveArcade() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Driving Arcade");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = RobotContainer.m_xboxDriverController.getLeftY()*-1;
    double rotateSpeed = RobotContainer.m_xboxDriverController.getRightX();
    // if (Math.abs(moveSpeed) < 0.05){
    //   moveSpeed = 0;
    // }
    // if (Math.abs(ro))
    RobotContainer.m_driveSubsystem.DriveArcade(moveSpeed, rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("End Driving Arcade");
    RobotContainer.m_driveSubsystem.DriveArcade(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
