/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Collection;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.team555.FootballShooter.RobotLikeComponent;

import java.util.HashSet;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Components
  Collection<RobotLikeComponent>   componentsForDelegation;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    componentsForDelegation.forEach((component) -> component.robotInit());


  }

  @Override
  public void teleopInit() {

    componentsForDelegation.forEach((component) -> component.teleopInit());

  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    componentsForDelegation.forEach((component) -> component.roboticPeriodic());
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {

    componentsForDelegation.forEach((component) -> component.autonomousInit());

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    componentsForDelegation.forEach((component) -> component.autonomousPeriodic());

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    componentsForDelegation.forEach((component) -> component.teleopPeriodic());


  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    componentsForDelegation.forEach((component) -> component.testPeriodic());

  }


  Robot() {
    componentsForDelegation = new HashSet<RobotLikeComponent>(); // An initially empty set of components

  }
}
