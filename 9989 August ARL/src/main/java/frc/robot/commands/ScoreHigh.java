// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.IntakeConstants;
import frc.robot.commands.arm.MoveHigh;
import frc.robot.commands.intake.Intake;
import frc.robot.commands.intake.Outtake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ScoreHigh extends SequentialCommandGroup {
  /** Creates a new ScoreHigh. */
  public ScoreHigh() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new MoveHigh().withTimeout(1).raceWith(new Intake(0.1)), new Outtake(IntakeConstants.kHighSpeed).withTimeout(0.25));
  }
}
