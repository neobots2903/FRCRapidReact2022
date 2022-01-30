/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static final int TBD = 0;
    
    //SparkMax motors 
   public static final int frontLeftMotor = 1;
   public static final int frontRightMotor = 3;
   public static final int backLeftMotor = 2;
   public static final int backRightMotor = 4;
   public static final int leftShoot =  5;
   public static final int rightShoot = 6; 
   
   //TalonSRX motors 
   public static final int climb = 7; 
   public static final int leftIntake = 8;
   public static final int rightIntake = 9;
   public static final int upperBelt = 10; 
   public static final int lowerBelt = 11; 
   public static final int pivot = 12;


    //Controllers
    public static final int driveJoy = 0;
    public static final int opJoy = 1;

}