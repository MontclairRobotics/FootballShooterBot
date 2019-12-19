package frc.robot.core;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.core.ControlSystem.Axis;
import frc.robot.core.ControlSystem.OperatorButtons;
import frc.robot.core.ControlSystem.Sticks;

public class Launcher implements RobotLikeComponent
{

    private Robot robot;
    private ControlSystem controlSystem;

    private TalonSRX leftLaunchMotor;
    private TalonSRX rightLaunchMotor; 
    private TalonSRX rightAngleMotor;
    private TalonSRX leftAngleMotor;

    Compressor compressor;
    Solenoid solenoid;

    public Launcher(Robot robot){
        this.robot = robot;
    }

    @Override
    public void robotInit(boolean debug){

        controlSystem = robot.getControlSystem();

        leftLaunchMotor  = new TalonSRX(4);
        rightLaunchMotor = new TalonSRX(5);
        rightAngleMotor  = new TalonSRX(6);
        leftAngleMotor   = new TalonSRX(7);

        compressor       = new Compressor(0);
        solenoid         = new Solenoid(0);

        if(debug){
            SmartDashboard.putBoolean("Launcher Initalization", true);
        }
    }

    @Override
    public void teleopPeriodic(boolean debug){

        leftAngleMotor.set(ControlMode.PercentOutput, 
            controlSystem.getJoystickAxis(Sticks.OPERATOR_STICK, Axis.Y)/2);

        rightAngleMotor.set(ControlMode.PercentOutput,
            controlSystem.getJoystickAxis(Sticks.OPERATOR_STICK, Axis.X)/2);

        if (compressor.getPressureSwitchValue()) {
            compressor.start();
        } else {
            compressor.stop();
        }
    
        if (controlSystem.getOperatorButton(OperatorButtons.LAUNCH_BUTTON)) {

            leftLaunchMotor.set(ControlMode.PercentOutput, 0.5);//motors on
            rightLaunchMotor.set(ControlMode.PercentOutput, 0.5);
            solenoid.setPulseDuration(0.5);// Fires solenoid for half a second then turns it off
            leftLaunchMotor.set(ControlMode.PercentOutput, 0);  // motors off
            rightLaunchMotor.set(ControlMode.PercentOutput, 0);
        } else {
            leftLaunchMotor.set(ControlMode.PercentOutput, 0); // Turns off motors if not pressed 
            rightLaunchMotor.set(ControlMode.PercentOutput, 0);
        }

        if(debug){
            SmartDashboard.putBoolean("Compressor Status", compressor.enabled());
            SmartDashboard.putBoolean("Solenoid Status", solenoid.get());
            // TODO fix my CTRE libs so i can debug status of motors.

    
        }
    }
}
