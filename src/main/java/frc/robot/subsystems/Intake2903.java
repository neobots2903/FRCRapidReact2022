package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;

public class Intake2903 {
    CANSparkMax upperIntake; 
    CANSparkMax otherIntake; 
    CANSparkMax indexer;
    DigitalInput otherIntakeOut;
    DigitalInput otherIntakeIn; 

    public Intake2903(){
        upperIntake = new CANSparkMax(RobotMap.upperIntake,MotorType.kBrushless);
        otherIntake = new CANSparkMax(RobotMap.otherIntake,MotorType.kBrushless);
        indexer = new CANSparkMax(RobotMap.indexer,MotorType.kBrushless);
        otherIntakeOut = new DigitalInput(RobotMap.otherIntakeOut);
        otherIntakeIn = new DigitalInput(RobotMap.otherIntakeIn);
    }
    public void intake(double speed){
        upperIntake.set(-speed);
    }
    public void intakeIn(double speed){ 
        if (!otherIntakeIn.get()){
            otherIntake.set(speed);
        }
        else {
            otherIntake.set(0);
        }
    }
    public void intakeOut(double speed){ 
        if (!otherIntakeOut.get()){
            otherIntake.set(-speed);
        }
        else {
            otherIntake.set(0);
        }
    }
    public void indexer(double speed){
        indexer.set(speed);
    }
}
