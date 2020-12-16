/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class ManualDrive extends CommandBase {
  private final Drive drive;
  private final Joystick leftJoystick;
  private final Joystick rightJoystick;

  /**
   * Creates a new ManualDrive.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ManualDrive(final Drive drive, final Joystick leftJoystick, final Joystick rightJoystick) {
    this.drive = drive;
    this.leftJoystick = leftJoystick;
    this.rightJoystick = rightJoystick;
 
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.tankDrive(leftJoystick.getY(), rightJoystick.getY(), true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
