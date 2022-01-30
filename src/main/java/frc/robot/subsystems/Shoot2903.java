package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Shoot2903 {
    CANSparkMax leftShoot;
    CANSparkMax rightShoot; 
    TalonSRX pivot; 
    public Shoot2903(){
        leftShoot = new CANSparkMax (RobotMap.leftShoot,MotorType.kBrushless);
        rightShoot = new CANSparkMax (RobotMap.rightShoot,MotorType.kBrushless);
        pivot = new TalonSRX(RobotMap.pivot);
    }
    public void shoot(double speed){
        leftShoot.set(-speed);
        rightShoot.set(speed);
    }
    public void setAngle(){
        // pivot.setposition
    }


}
