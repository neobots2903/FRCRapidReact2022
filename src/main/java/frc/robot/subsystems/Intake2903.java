package frc.robot.subsystems;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;

public class Intake2903 {
    CANSparkMax upperIntake; 
    VictorSPX otherIntake; 
    CANSparkMax indexer;
    DigitalInput otherIntakeOut;
    DigitalInput otherIntakeIn; 

    public Intake2903(){
        upperIntake = new CANSparkMax(RobotMap.upperIntake,MotorType.kBrushed);
        otherIntake = new VictorSPX(RobotMap.otherIntake);
        indexer = new CANSparkMax(RobotMap.indexer,MotorType.kBrushed);
        otherIntakeOut = new DigitalInput(RobotMap.otherIntakeOut);
        otherIntakeIn = new DigitalInput(RobotMap.otherIntakeIn);
    }
    public void intake(double speed){
        upperIntake.set(-speed);
    }
    public void intakeRev(double speed){
        upperIntake.set(speed);
    }
    public void intakeIn(double speed){ 
        if (otherIntakeIn.get()){
            otherIntake.set(ControlMode.PercentOutput, speed);
        }
        else {
            otherIntake.set(ControlMode.PercentOutput, 0);
        }
    }
    public void intakeOut(double speed){ 
        if (otherIntakeOut.get()){
            otherIntake.set(ControlMode.PercentOutput, -speed);
        }
        else {
            otherIntake.set(ControlMode.PercentOutput, 0);
        }
    }
    public void indexer(double speed){
        indexer.set(speed);
    }
}
