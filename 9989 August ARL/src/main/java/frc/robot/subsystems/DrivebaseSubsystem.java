// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

//Sparkmax Imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class DrivebaseSubsystem extends SubsystemBase {
  /** Creates a new DrivebaseSubsystem. */
  CANSparkMax frontLeft = new CANSparkMax(MotorConstants.kFrontLeft, MotorType.kBrushless);
  CANSparkMax backLeft = new CANSparkMax(MotorConstants.kBackLeft, MotorType.kBrushless);
  CANSparkMax frontRight = new CANSparkMax(MotorConstants.kFrontRight, MotorType.kBrushless);
  CANSparkMax backRight = new CANSparkMax(MotorConstants.kBackRight, MotorType.kBrushless);

  public DrivebaseSubsystem() {
    configMotors();
    initDashboard();
    setCoastMode();
  }

  private void initDashboard() {
    SmartDashboard.putNumber("Left Speed", 0);
    SmartDashboard.putNumber("Right Speed", 0);
    
  }

  public void configMotors() {
    frontLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();
    frontRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();

    frontLeft.setInverted(true);
    frontRight.setInverted(false);

    frontLeft.setOpenLoopRampRate(MotorConstants.kDriveRampRate);
    backLeft.setOpenLoopRampRate(MotorConstants.kDriveRampRate);
    frontRight.setOpenLoopRampRate(MotorConstants.kDriveRampRate);
    backRight.setOpenLoopRampRate(MotorConstants.kDriveRampRate);

    frontRight.setSmartCurrentLimit(MotorConstants.kDriveSmartCurrent);
    backLeft.setSmartCurrentLimit(MotorConstants.kDriveSmartCurrent);
    backRight.setSmartCurrentLimit(MotorConstants.kDriveSmartCurrent);
    backRight.setSmartCurrentLimit(MotorConstants.kDriveSmartCurrent);

    // frontRight.burnFlash();  
    // frontLeft.burnFlash();
    // backRight.burnFlash();
    // backRight.burnFlash();

    backLeft.follow(frontLeft, false);
    backRight.follow(frontRight, false);
    
  }

  public void DriveTank(double leftSpeed, double rightSpeed){
    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);

    SmartDashboard.putNumber("Left Speed", leftSpeed);
    SmartDashboard.putNumber("Right Speed", rightSpeed);
  }

  public void DriveArcade(double ySpeed, double xRotation) {
    double leftSpeed = ySpeed*(0.8) + xRotation*(0.7);
    double rightSpeed = ySpeed*(0.8) - xRotation*(0.7);
    frontLeft.set(leftSpeed*0.9);
    frontRight.set(rightSpeed);

    SmartDashboard.putNumber("Left Speed", leftSpeed);
    SmartDashboard.putNumber("Right Speed", rightSpeed);
  }

  public CommandBase setBrakeMode() {
    return runOnce( () -> {
      frontRight.setIdleMode(IdleMode.kBrake);
      frontLeft.setIdleMode(IdleMode.kBrake);
      backRight.setIdleMode(IdleMode.kBrake);
      backLeft.setIdleMode(IdleMode.kBrake);
    });
  }

  public CommandBase setCoastMode() {
    return runOnce( () -> {
      frontRight.setIdleMode(IdleMode.kCoast);
      frontLeft.setIdleMode(IdleMode.kCoast);
      backRight.setIdleMode(IdleMode.kCoast);
      backLeft.setIdleMode(IdleMode.kCoast);
    });
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Drivetrain Brake Mode", (frontRight.getIdleMode().equals(IdleMode.kCoast)));
  }
}
