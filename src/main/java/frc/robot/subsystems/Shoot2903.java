package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;

public class Shoot2903 {
    final int TICKS_PER_REV = 4096; 
    CANSparkMax upperShoot;
    CANSparkMax lowerShoot; 
    public TalonSRX pivot; 
    public TalonSRX pivotf; 
    DigitalInput pivotLimit; 

    public Shoot2903(){
        upperShoot = new CANSparkMax (RobotMap.upperShoot,MotorType.kBrushless);
        lowerShoot = new CANSparkMax (RobotMap.lowerShoot,MotorType.kBrushless);
        pivot = new TalonSRX(RobotMap.pivot);
        pivotf = new TalonSRX(RobotMap.pivot);
        pivotLimit = new DigitalInput(RobotMap.pivotLimit); 
        pivotf.follow(pivot);
        pivot.setInverted(false);
        pivotf.setInverted(InvertType.OpposeMaster);
    }
    public void shoot(double speed){
        upperShoot.set(-speed);
        lowerShoot.set(speed);
    }
    public void shootForTime(int millis, double speed){
        long startTime = System.currentTimeMillis();
        long endTime = startTime + millis; 
        while(System.currentTimeMillis() < endTime){
            Robot.intake2903.indexer(.15); 
            shoot(speed);  
        }
        Robot.intake2903.indexer(0); 
        shoot(0);  
    }
    public void initPivot(){
        while (!pivotLimit.get()){
            pivot.set(ControlMode.PercentOutput, .25);
        }
        pivot.set(ControlMode.PercentOutput, 0);
        pivot.setSelectedSensorPosition(0);
    }
    public void setAngle(double deg){
        pivot.set(ControlMode.Position, deg / 360 * TICKS_PER_REV);
    }
    public double getAngle(){
        return pivot.getSelectedSensorPosition(0) / TICKS_PER_REV * 360; 
    }
}
