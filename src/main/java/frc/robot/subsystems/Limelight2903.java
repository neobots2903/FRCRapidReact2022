package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight2903 {
    NetworkTable table;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;
    NetworkTableEntry tv;

    public Limelight2903(){
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        tv = table.getEntry("tv");
    }
    public double getTX() {
        double x = tx.getDouble(0.0);
        SmartDashboard.putNumber("LimelightX", x);
        return x;
    }
    public double getTY() {
        double y = ty.getDouble(0.0);
        SmartDashboard.putNumber("LimelightY", y);
        return y; 
    }   
    public double getTA() {
        double area = ta.getDouble(0.0);
        SmartDashboard.putNumber("LimelightArea", area);
        return area; 
    }
    public boolean getTV(){
        boolean valid = tv.getBoolean(false);
        SmartDashboard.putBoolean("LimelightV", valid);
        return valid;
    }
}

