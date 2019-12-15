package frc.team555.FootballShooter;


import frc.robot.core.RobotLikeComponent;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class RobotLauncher implements RobotLikeComponent {


    //Defining motors and joystick
    private TalonSRX leftLaunchWheel;
    private TalonSRX rightLaunchWheel;
    private TalonSRX rightAngle;
    private TalonSRX leftAngle;

    //Defining Joysticks
    private JoystickButton launchButton;
    private Joystick opStick;

    //Defining Pneumatics
    private Compressor compressor;
    private Solenoid solenoid;


    @Override
    public void robotInit()
    {
        //sets variables to motors (PORTS/DEVICE NUMBERS NOT FINAL)
        leftLaunchWheel = new TalonSRX(4);
        rightLaunchWheel = new TalonSRX(5);
        rightAngle = new TalonSRX(6);
        leftAngle = new TalonSRX(7);

        compressor = new Compressor(0);
        solenoid = new Solenoid(0);
    }

    @Override
    public void teleopInit()
    {

        //Sets variables to joystick/button
        opStick = new Joystick(1);
        launchButton = new JoystickButton(opStick, 2);
    }

    @Override
    public void teleopPeriodic() {


        leftAngle.set(ControlMode.PercentOutput, opStick.getY() /2);//sets angle to the joystick value divided by 2
        rightAngle.set(ControlMode.PercentOutput, opStick.getX() /2);
        if (compressor.getPressureSwitchValue()) {
            compressor.start();
        } else {
            compressor.stop();
        }

        if (launchButton.get()) {

            leftLaunchWheel.set(ControlMode.PercentOutput, 0.5);//motors on
            rightLaunchWheel.set(ControlMode.PercentOutput, 0.5);
            solenoid.set(true);// Fires solenoid
            try {
                solenoid.wait(500);
            }
            catch (Exception e) {
                solenoid.set(false);
            }
            solenoid.set(false);
            leftLaunchWheel.set(ControlMode.PercentOutput, 0);  // motors off
            rightLaunchWheel.set(ControlMode.PercentOutput, 0);
        } else {
            leftLaunchWheel.set(ControlMode.PercentOutput, 0); // Turns off motors if not pressed
            rightLaunchWheel.set(ControlMode.PercentOutput, 0);
        }

    }

}
