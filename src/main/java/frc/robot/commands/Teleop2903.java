// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Teleop2903 extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  int leftY = 1;
  int rightX = 4;
  int lt = 2;
  int rt = 3; 
  int buttonA = 0; 
  int buttonX = 2; 
  int buttonB = 1;
  int buttonRB = 5;
  int buttonLB = 4; 
  int pivotDegrees = 0; 
  int maxPivotDegrees = 90; 

  public Teleop2903() {

  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    boolean indexerPressed = Robot.opJoy.getRawButton(buttonLB);
    boolean intakePressed = Robot.opJoy.getRawButton(buttonRB);
    boolean intakeInPressed = Robot.opJoy.getRawButton(buttonX);
    boolean intakeOutPressed = Robot.opJoy.getRawButton(buttonB);
    boolean shootPressed = Robot.opJoy.getRawButton(buttonA);
    boolean upPress = Robot.opJoy.getDirectionDegrees() == 90;
    boolean downPress = Robot.opJoy.getDirectionDegrees() == 270;
    if (upPress){
      pivotDegrees += 1;
      if (pivotDegrees > maxPivotDegrees){
        pivotDegrees = maxPivotDegrees; 
      }
    }
    else if (downPress){
      pivotDegrees -= 1;
      if (pivotDegrees < 0){
        pivotDegrees = 0; 
      }
    }
    if (shootPressed){
      Robot.shoot2903.shoot(.75);
    }
    else {
      Robot.shoot2903.shoot(0);
    }
    if (indexerPressed){
      Robot.intake2903.indexer(.6);
    }
    else {
      Robot.intake2903.indexer(0);
    }
    if (intakeInPressed){
      Robot.intake2903.intakeIn(.25);
    } else if (intakeOutPressed){
      Robot.intake2903.intakeOut(.25);
    }
    else {
      Robot.intake2903.intakeIn(0);
    }
    if (intakePressed){
      Robot.intake2903.intake(.6);
    }
    else {
      Robot.intake2903.intake(0);
    }
    
    double climbUp = Robot.opJoy.getRawAxis(rt);
    double climbDown = Robot.opJoy.getRawAxis(lt);
    Robot.climb2903.setPower(climbUp - climbDown);
    Robot.shoot2903.setAngle(pivotDegrees);
    double drivePower = Robot.driveJoy.getRawAxis(leftY);
    double turnPower = Robot.driveJoy.getRawAxis(rightX);
    Robot.drive2903.arcadeDrive(drivePower,turnPower);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.drive2903.arcadeDrive(0,0);
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
