// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.LoadIn;
import frc.robot.commands.ScoreHigh;
import frc.robot.commands.ScoreLow;
import frc.robot.commands.ScoreMid;
import frc.robot.commands.arm.MoveMid;
import frc.robot.commands.arm.MoveOverride;
import frc.robot.commands.drivebase.DriveArcade;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivebaseSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public final static DrivebaseSubsystem m_driveSubsystem = new DrivebaseSubsystem();
  public final static ArmSubsystem m_armSubsystem = new ArmSubsystem();
  public final static IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();

  public static final CommandXboxController m_xboxDriverController =
      new CommandXboxController(OperatorConstants.kXboxControllerPort);

  public static final CommandXboxController m_xboxCoDriverController =
      new CommandXboxController(OperatorConstants.kCoXboxControllerPort);

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_driveSubsystem.setDefaultCommand(new DriveArcade());
    m_armSubsystem.setDefaultCommand(new MoveOverride());

  }
 
  private void configureBindings() {
    m_xboxCoDriverController.rightTrigger(0.2).whileTrue(new LoadIn());

    m_xboxCoDriverController.povUp().onTrue(new ScoreHigh());
    m_xboxCoDriverController.povLeft().onTrue(new ScoreMid());
    m_xboxCoDriverController.povRight().onTrue(new ScoreMid());
    m_xboxCoDriverController.povDown().onTrue(new ScoreLow());

    m_xboxCoDriverController.a().onTrue(RobotContainer.m_driveSubsystem.setCoastMode());
    m_xboxCoDriverController.b().onTrue(RobotContainer.m_driveSubsystem.setBrakeMode());

    }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new ScoreHigh();
  }
}
