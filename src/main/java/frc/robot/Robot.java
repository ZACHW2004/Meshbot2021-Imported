// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.motorcontrol.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  //private final DifferentialDrive m_myRobot = new DifferentialDrive(m_leftMotor, m_rightMotor);
  //private final Joystick m_stick = new Joystick(0);
  private XboxController xbox0;
  final MotorControllerGroup m_right = new MotorControllerGroup(new CANSparkMax(14, MotorType.kBrushless), new CANSparkMax(15, MotorType.kBrushless));;;
  final MotorControllerGroup m_left = new MotorControllerGroup(new CANSparkMax(13, MotorType.kBrushless), new CANSparkMax(16, MotorType.kBrushless));;
  


@Override
public void robotInit() {
  // TODO Auto-generated method stub
  xbox0 = new XboxController(0);
xbox0.getLeftY();
m_myRobot = new DifferentialDrive(m_left, m_right);
m_myRobot.setMaxOutput(0.4);
  super.robotInit();
}


  @Override
  public void teleopPeriodic() {
    
    SmartDashboard.putNumber("Left", xbox0.getLeftY());
    SmartDashboard.putNumber("Right", xbox0.getRightY());
    m_myRobot.tankDrive(
      xbox0.getLeftY(), 
      xbox0.getRightY()
      );


    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_myRobot.arcadeDrive(
      xbox0.getRightY(),
      xbox0.getRightX()
    );
  }
}
