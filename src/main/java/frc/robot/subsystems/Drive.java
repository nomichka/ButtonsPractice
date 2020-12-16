/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  // Motor stuff
  private Spark rightMotor1 = new Spark(1);
  private Spark rightMotor2 = new Spark(2);
  private Spark leftMotor1 = new Spark(3);
  private Spark leftMotor2 = new Spark(4);
  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMotor1, leftMotor2);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMotor1, rightMotor2);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotors, rightMotors);

  // Encoder stuff
  private final Encoder leftEncoder = new Encoder(0, 1, false);
  private final Encoder rightEncoder = new Encoder(2, 3, true);

  /**
   * Creates a new Drive.
   */
  public Drive() {
    leftEncoder.setDistancePerPulse(0.152 * Math.PI / 1050);
    rightEncoder.setDistancePerPulse(0.152 * Math.PI / 1050);
    leftMotors.setInverted(false);
    rightMotors.setInverted(false);
  }

  public void tankDrive(double leftPower, double rightPower, boolean squareInputs) {
    diffDrive.tankDrive(leftPower, rightPower, squareInputs);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
