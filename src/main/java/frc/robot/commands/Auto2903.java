package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto2903 extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    boolean running = true; 

 

  public Auto2903() {
  }
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
  @Override
  public void end(boolean interrupted) {
      running = false; 
    Robot.drive2903.arcadeDrive(0,0);
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}
