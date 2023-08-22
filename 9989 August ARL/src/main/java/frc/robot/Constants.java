// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kXboxControllerPort = 0;
    public static final int kCoXboxControllerPort = 1;

  }

  public static class MotorConstants {
    public static final int kFrontLeft = 1;
    public static final int kFrontRight = 2;    
    public static final int kBackLeft = 3;
    public static final int kBackRight = 4;

    public static final int kIntakeRight = 5;
    public static final int kIntakeLeft = 6;

    public static final int kArmRight = 7;
    public static final int kArmLeft = 8;

    public static final int kDriveSmartCurrent = 40;
    public static final int kIntakeSmartCurrent = 40;
    public static final int kArmSmartCurrent = 40;

    public static final double kDriveRampRate = 0.25;
  }


  public static class ArmPIDConstants {
    public static final int kZeroPosition = 0;

    public static final int kSetpointGround = 0;
    public static final int kSetpointLow = 0;
    public static final int kSetpointMid = 0;
    public static final int kSetpointHigh = 0;

    public static final double kP = 0;
    public static final double kI = 0;
    public static final double kD = 0;

    public static final double kSpeedMax = 0.8;
    public static final double kSpeedMin = -0.8;

    public static final double kVelocityMax = 0;
    public static final double kVelocityMin = 0;

  }

  public static class IntakeConstants {
    public static final double kHighSpeed = 1.0;
    public static final double kMidSpeed = 0.8;
    public static final double kLowSpeed = 0.5;

    public static final double kIntakeSpeed = 0.5;
  }

}
