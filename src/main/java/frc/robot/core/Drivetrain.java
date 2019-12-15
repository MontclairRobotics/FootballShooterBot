package frc.robot.core;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.core.ControlSystem.Axis;
import frc.robot.core.ControlSystem.Sticks;

public class Drivetrain implements RobotLikeComponent
{

    private Robot robot;

    private ControlSystem controlSystem;

    private CANSparkMax driveFL;
    private CANSparkMax driveFR;
    private CANSparkMax driveBL;
    private CANSparkMax driveBR;

    private double leftPower;
    private double rightPower;
    
    public Drivetrain(Robot robot){
        this.robot = robot;
    }

    public void robotInit(boolean debug){
        controlSystem = robot.getControlSystem();
        
        driveFL = new CANSparkMax(0, MotorType.kBrushless);
        driveFR = new CANSparkMax(1, MotorType.kBrushless);
        driveBL = new CANSparkMax(2, MotorType.kBrushless);
        driveBR = new CANSparkMax(3, MotorType.kBrushless);

        if(debug){
            SmartDashboard.putBoolean("Drivetrain Initialization", true);
        }
        
    }

    public void teleopPeriodic(boolean debug){
        leftPower = controlSystem.getJoystickAxis(Sticks.DRIVE_STICK, Axis.X) 
            + controlSystem.getJoystickAxis(Sticks.DRIVE_STICK, Axis.Y);

        rightPower = controlSystem.getJoystickAxis(Sticks.DRIVE_STICK, Axis.Y) 
            - controlSystem.getJoystickAxis(Sticks.DRIVE_STICK, Axis.X);

        driveBL.set(leftPower);
        driveFL.set(leftPower);
        driveBR.set(rightPower);
        driveFR.set(rightPower);

        if(debug){
            SmartDashboard.putNumber("DT Left Power", leftPower);
            SmartDashboard.putNumber("DT Right Power", rightPower);
        }
    }
}
