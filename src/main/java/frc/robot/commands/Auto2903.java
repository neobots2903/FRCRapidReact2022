// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Auto2903 extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    boolean running = true; 

 

  public Auto2903() {

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    running = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.drive2903.distanceDrive(43,-.4);
    while(running){
        Robot.limelight2903.getTV();
        Robot.limelight2903.getTX(); 
    }
    cancel(); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      running = false; 
    Robot.drive2903.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
