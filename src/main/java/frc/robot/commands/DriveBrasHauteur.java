// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BrasHauteur;

public class DriveBrasHauteur extends CommandBase {
  DoubleSupplier hauteur;
  BrasHauteur bras;


  public DriveBrasHauteur(BrasHauteur bras, DoubleSupplier hauteur) {
    this.bras = bras;
    this.hauteur = hauteur;
    addRequirements(bras);
  }


  @Override
  public void initialize() {}

  //(bras.getPositionL() > 85000 && vitesse.getAsDouble() > 0) || (bras.getPositionL() < 0 && vitesse.getAsDouble() < 0)

  @Override
  public void execute() {
    if ((bras.getEncoderHauteurPosition() > 650 && hauteur.getAsDouble() > 0) || (bras.getEncoderHauteurPosition() < 0 && hauteur.getAsDouble() < 0))
    {
      bras.driveHauteur(0);
      SmartDashboard.putNumber("test2", hauteur.getAsDouble());
    } 
    else
    {
      bras.driveHauteur(hauteur.getAsDouble());
      SmartDashboard.putNumber("test2", hauteur.getAsDouble());

    }
  }

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
