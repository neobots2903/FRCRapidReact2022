// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.RobotMap;

public class Drive2903 {
  CANSparkMax frontLeftMotor;
  CANSparkMax frontRightMotor;
  CANSparkMax backLeftMotor;
  CANSparkMax backRightMotor;
  /** Creates a new ExampleSubsystem. */
  public Drive2903() {
    frontLeftMotor = new CANSparkMax (RobotMap.frontLeftMotor,MotorType.kBrushless);
    frontRightMotor = new CANSparkMax (RobotMap.frontRightMotor,MotorType.kBrushless);
    backLeftMotor = new CANSparkMax (RobotMap.backLeftMotor,MotorType.kBrushless);
    backRightMotor = new CANSparkMax (RobotMap.backRightMotor,MotorType.kBrushless);
  }

  public void tankDrive (double left,double right) {
    frontLeftMotor.set(left);
    frontRightMotor.set(-right);
    backLeftMotor.set(left);
    backRightMotor.set(-right);
  }

  public void arcadeDrive (double forward,double turn) {
    frontLeftMotor.set(forward+turn);
    frontRightMotor.set(-forward+turn);
    backLeftMotor.set(forward+turn);
    backRightMotor.set(-forward+turn);
  }
}
