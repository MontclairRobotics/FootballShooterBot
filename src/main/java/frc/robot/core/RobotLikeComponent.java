package frc.robot.core;

public interface RobotLikeComponent {
    default public void robotInit() {}
    default public void teleopInit() {}
    default public void autonomousInit() {}

    default public void roboticPeriodic() {}
    default public void teleopPeriodic() {}
    default public void autonomousPeriodic() {}
    default public void testPeriodic() {}
}
