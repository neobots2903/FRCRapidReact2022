package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto2903 extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    boolean running = true; 
    int error = 5; 
  public Auto2903() {
  }
  @Override
  public void initialize() {
    running = true;
  }

  @Override
  public void execute() {
    Robot.drive2903.distanceDrive(43,-.4);
  
    while(running){
      if (Robot.limelight2903.getTV()){
        if (Robot.limelight2903.getTX() > error){
          Robot.drive2903.arcadeDrive(0, .15);
        }
        else if(Robot.limelight2903.getTX() < -error){
            Robot.drive2903.arcadeDrive(0, -.15);
        }
        else {
          Robot.drive2903.arcadeDrive(0, 0);
          running = false; 
        }
        
      } 
      else {
        Robot.shoot2903.setAngle(75);
      }
    }
    Robot.shoot2903.shootForTime(4000, .85);
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
