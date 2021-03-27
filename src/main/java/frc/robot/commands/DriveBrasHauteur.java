// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BrasHauteur;

public class DriveBrasHauteur extends CommandBase {
  Double hauteur;
  BrasHauteur bras;


  public DriveBrasHauteur(BrasHauteur bras, Double hauteur) {
    this.bras = bras;
    this.hauteur = hauteur;
    addRequirements(bras);
  }


  @Override
  public void initialize() {}

  @Override
  public void execute() {
    bras.driveHauteur(hauteur.doubleValue());
  }

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}