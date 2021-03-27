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
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveBrasHauteur;
import frc.robot.commands.DriveBrasLongueur;
import frc.robot.subsystems.BasePilotable;
import frc.robot.subsystems.BrasHauteur;
import frc.robot.subsystems.BrasLongueur;
import frc.robot.subsystems.DrivePince;
import frc.robot.subsystems.Pince;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private XboxController pilote = new XboxController(0);
  private BasePilotable basePilotable = new BasePilotable();
  private BrasLongueur brasLongueur = new BrasLongueur();
  private BrasHauteur brasHauteur = new BrasHauteur();
  private Pince pince = new Pince();
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    basePilotable.setDefaultCommand(new Drive(pilote.getY(Hand.kLeft), pilote.getX(Hand.kLeft), basePilotable));
    brasHauteur.setDefaultCommand(new DriveBrasHauteur(brasHauteur, ()->pilote.getY(Hand.kRight)));
    brasLongueur.setDefaultCommand(new DriveBrasLongueur(brasLongueur, ()->pilote.getTriggerAxis(Hand.kRight)-pilote.getTriggerAxis(Hand.kLeft)));
    
  }
   //basePilotable.setDefaultCommand(new RunCommand(()-> basePilotable.conduire(pilote.getY(GenericHID.Hand.kLeft), pilote.getX(GenericHID.Hand.kRight)),basePilotable));
  
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new  JoystickButton(pilote, Button.kA.value).toggleWhenPressed(new DrivePince(pince));


    //Fonction Non Limité Pour Se Remettre À 0
    new POVButton(pilote, 0).whenHeld(new RunCommand(()-> brasHauteur.driveHauteur(1), brasHauteur)).whenReleased(new InstantCommand(brasHauteur::stop));
    new POVButton(pilote, 180).whenHeld(new RunCommand(()-> brasHauteur.driveHauteur(-1), brasHauteur)).whenReleased(new InstantCommand(brasHauteur::stop));
    new POVButton(pilote, 90).whenHeld(new RunCommand(()-> brasLongueur.driveLongueur(1), brasLongueur)).whenReleased(new InstantCommand(brasLongueur::stop));
    new POVButton(pilote, 270).whenHeld(new RunCommand(()-> brasLongueur.driveLongueur(-1), brasLongueur)).whenReleased(new InstantCommand(brasLongueur::stop));
    new JoystickButton(pilote, Button.kStart.value).whenHeld(new InstantCommand(brasHauteur::resetEncoder).andThen(new InstantCommand(brasLongueur::resetEncoder)));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new RunCommand(()->basePilotable.conduire(0, 0));
  }
}
