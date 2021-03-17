// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Bras;

public class DriveBras extends CommandBase {
  Double hauteur;
  Double longueur;
  Bras bras;


  public DriveBras(Bras bras, Double hauteur, Double longueur) {
    this.bras = bras;
    this.hauteur = hauteur;
    this.longueur = longueur;
    addRequirements(bras);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    bras.driveHauteur(hauteur.doubleValue());
    bras.driveLongueur(longueur.doubleValue());
  }
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
