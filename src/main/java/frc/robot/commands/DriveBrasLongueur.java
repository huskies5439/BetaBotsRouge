// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BrasLongueur;

public class DriveBrasLongueur extends CommandBase {
  Double longueur;
  BrasLongueur bras;


  public DriveBrasLongueur(BrasLongueur bras, Double longueur) {
    this.bras = bras;
    this.longueur = longueur;
    addRequirements(bras);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

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
