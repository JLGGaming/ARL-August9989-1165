// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */

  CANSparkMax mainArmMotor = new CANSparkMax(MotorConstants.kArmLeft, MotorType.kBrushless);
  CANSparkMax followArmMotor = new CANSparkMax(MotorConstants.kArmRight, MotorType.kBrushless);
  RelativeEncoder armEncoder = mainArmMotor.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 8192);

  public ArmSubsystem() {
    configMotors();
  }

  public void configMotors() {
    mainArmMotor.restoreFactoryDefaults();
    followArmMotor.restoreFactoryDefaults();

    mainArmMotor.setIdleMode(IdleMode.kBrake);
    followArmMotor.setIdleMode(IdleMode.kBrake);

    mainArmMotor.setInverted(false);
    followArmMotor.setInverted(true);

    mainArmMotor.setSmartCurrentLimit(MotorConstants.kArmSmartCurrent);
    followArmMotor.setSmartCurrentLimit(MotorConstants.kArmSmartCurrent);

    // mainArmMotor.burnFlash();
    // followArmMotor.burnFlash();

    followArmMotor.follow(mainArmMotor);
    resetArmPosition();
  }

  public void setArmSpeed(double speed){
    mainArmMotor.set(speed);
  }

  public void resetArmPosition() {
    armEncoder.setPosition(0);
  }

  public double getArmPosition() {
    return armEncoder.getPosition();
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
