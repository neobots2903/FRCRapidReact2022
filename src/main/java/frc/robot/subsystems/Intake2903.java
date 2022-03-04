package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake2903 {
    CANSparkMax upperIntake; 
    CANSparkMax otherIntake; 
    CANSparkMax indexer;

    public Intake2903(){
        upperIntake = new CANSparkMax(RobotMap.upperIntake,MotorType.kBrushless);
        otherIntake = new CANSparkMax(RobotMap.otherIntake,MotorType.kBrushless);
        indexer = new CANSparkMax(RobotMap.indexer,MotorType.kBrushless);
    }
    public void intake(double speed){
        upperIntake.set(-speed);
    }
    public void intakeTwo()
    public void indexer(double speed){
        indexer.set(speed);
    }
}
