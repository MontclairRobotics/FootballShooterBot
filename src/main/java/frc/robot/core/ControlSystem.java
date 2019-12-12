package frc.robot.core;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class ControlSystem{
    
    private Robot robot;

    private Joystick driveStick;
    private Joystick opStick;

    enum Sticks{
        DRIVE_STICK(0), OPERATOR_STICK(1);

        int port;
        private Sticks(int port){
            this.port = port;
        }


        public int getPort(){
            return port;
        } 
    }

    enum Axis{
        X, Y, Z;
    }

    enum DriverButtons{
        TEMP_BUTTON(0);

        int port;
        private DriverButtons(int port){
            this.port = port;
        }


        public int getPort(){
            return port;
        }
    }

    enum OperatorButtons{
        LAUNCH_BUTTON(0);

        int port;
        private OperatorButtons(int port){
            this.port = port;
        }


        public int getPort(){
            return port;
        }
    }

    public ControlSystem(Robot robot){
        this.robot = robot;
    }

    public void init(boolean debug){
        driveStick = new Joystick(Sticks.DRIVE_STICK.getPort());
        opStick = new Joystick(Sticks.OPERATOR_STICK.getPort());
        
        if(debug){
            SmartDashboard.putBoolean("Control System Initialization", true);
        }
    }

    public double getJoystickAxis(Sticks sticks, Axis axis){
        switch(sticks){
            case DRIVE_STICK:
                switch(axis){
                    case X:
                        return driveStick.getX();
                    
                    case Y:
                        return driveStick.getY();

                    case Z:
                        return driveStick.getX();
                }
                
            case OPERATOR_STICK:
                switch(axis){
                    case X:
                        return opStick.getX();
                    
                    case Y:
                        return opStick.getY();

                    case Z:
                        return opStick.getX();
            }

            default:
                return 0;
        }
    }

    public boolean getDriverButton(DriverButtons driverButtons){
        switch(driverButtons){
            case TEMP_BUTTON:
                return driveStick.getRawButton(DriverButtons.TEMP_BUTTON.getPort());

            default: 
                return false;

        }
            
    }

    public boolean getOperatorButton(OperatorButtons operatorButtons){
        switch(operatorButtons){
            case LAUNCH_BUTTON:
                return opStick.getRawButton(OperatorButtons.LAUNCH_BUTTON.getPort());

            default: 
                return false;

        }
            
    }
}