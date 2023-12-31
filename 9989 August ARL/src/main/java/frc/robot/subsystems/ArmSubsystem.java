// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
// import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;


public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  
  CANSparkMax mainArmMotor = new CANSparkMax(MotorConstants.kArmLeft, MotorType.kBrushless);
  CANSparkMax followArmMotor = new CANSparkMax(MotorConstants.kArmRight, MotorType.kBrushless);
  // RelativeEncoder armEncoder = mainArmMotor.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 8192);
  RelativeEncoder armEncoder = mainArmMotor.getEncoder();

  public ArmSubsystem() {
    configMotors();
    initDashboard();
  }

  private void initDashboard() {
    SmartDashboard.putNumber("Arm Position", armEncoder.getPosition());
    SmartDashboard.putNumber("Arm Output", 0);

  }

  public void configMotors() {
    mainArmMotor.restoreFactoryDefaults();
    followArmMotor.restoreFactoryDefaults();

    mainArmMotor.setIdleMode(IdleMode.kBrake);
    followArmMotor.setIdleMode(IdleMode.kBrake);

    mainArmMotor.setInverted(false);

    mainArmMotor.setSmartCurrentLimit(MotorConstants.kArmSmartCurrent);
    followArmMotor.setSmartCurrentLimit(MotorConstants.kArmSmartCurrent);

    followArmMotor.follow(mainArmMotor, true);

    // mainArmMotor.burnFlash();
    // followArmMotor.burnFlash();

    resetArmPosition();
  }

  public void setArmSpeed(double speed){
    mainArmMotor.set(speed);
    SmartDashboard.putNumber("Arm Output", speed);
  }

  public CommandBase resetArmPosition() {
    return runOnce( () -> {
    System.out.println("Arm Zeroed");
    armEncoder.setPosition(0);
    });
  }

  public double getArmPosition() {
    return armEncoder.getPosition();
  }

 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (SmartDashboard.getNumber("Arm Position", -99999999) != armEncoder.getPosition()) {
      SmartDashboard.putNumber("Arm Position", armEncoder.getPosition());
    }

    Shuffleboard.update();
  }
}
