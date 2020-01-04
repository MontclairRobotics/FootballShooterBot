package frc.robot.core;

public interface RobotLikeComponent {
    default public void robotInit() {robotInit(false);}
    default public void robotInit(boolean debug) {}

    default public void teleopInit() {teleopInit(false);}
    default public void teleopInit(boolean debug) {}

    default public void autonomousInit() {}

    default public void roboticPeriodic() {}

    default public void teleopPeriodic() {teleopPeriodic(false);}
    default public void teleopPeriodic(boolean debug) {}

    default public void autonomousPeriodic() {}
    default public void testPeriodic() {}
}
