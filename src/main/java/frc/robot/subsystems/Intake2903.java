package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake2903 {
    CANSparkMax upperIntake; 
    CANSparkMax lowerIntake;
    CANSparkMax indexer;

    public Intake2903(){
        upperIntake = new CANSparkMax(RobotMap.upperIntake,MotorType.kBrushless);
        lowerIntake = new CANSparkMax(RobotMap.lowerIntake,MotorType.kBrushless);
        indexer = new CANSparkMax(RobotMap.indexer,MotorType.kBrushless);
    }
    public void intake(double speed){
        upperIntake.set(-speed);
        lowerIntake.set(speed);
    }
    public void indexer(double speed){
        indexer.set(-speed);
        indexer.set(speed);
    }
}
