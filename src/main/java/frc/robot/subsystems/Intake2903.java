package frc.robot.subsystems;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake2903 {
    TalonSRX leftIntake; 
    TalonSRX rightIntake;
    TalonSRX upperBelt;
    TalonSRX lowerBelt; 

    public Intake2903(){
        leftIntake = new TalonSRX(RobotMap.leftIntake);
        rightIntake = new TalonSRX(RobotMap.rightIntake);
        upperBelt = new TalonSRX(RobotMap.upperBelt);
        lowerBelt = new TalonSRX(RobotMap.lowerBelt);
    }
    public void shoot(double speed){
        leftIntake.set(ControlMode.PercentOutput, 0);
        rightIntake.set(ControlMode.PercentOutput, 0);
    }
    
}
