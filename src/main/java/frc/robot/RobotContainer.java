/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveBrasLongueur;
import frc.robot.subsystems.BasePilotable;
import frc.robot.subsystems.BrasLongueur;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private XboxController pilote = new XboxController(0);
  private BasePilotable basePilotable = new BasePilotable();
  private BrasLongueur bras = new BrasLongueur();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //basePilotable.setDefaultCommand(new Drive(pilote.getY(Hand.kLeft), pilote.getX(Hand.kLeft), basePilotable));
    basePilotable.setDefaultCommand(new RunCommand(()-> basePilotable.conduire(pilote.getY(GenericHID.Hand.kLeft), pilote.getX(GenericHID.Hand.kRight)),basePilotable));
    //bras.setDefaultCommand(new DriveBras(bras, pilote.getY(Hand.kRight), pilote.getX(Hand.kRight)));
    //bras.setDefaultCommand(new RunCommand(() -> {bras.driveHauteur(pilote.getRawAxis(2)); bras.driveLongueur(pilote.getRawAxis(2));}, bras));
  }
  
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new RunCommand(()->basePilotable.tankDriveVolts(5,5));
  }
}
