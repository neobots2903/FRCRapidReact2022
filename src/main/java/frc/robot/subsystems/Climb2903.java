package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;

public class Climb2903 {
    TalonSRX climb; 
    public Climb2903(){
        climb = new TalonSRX(RobotMap.climb); 
    }
 

}
