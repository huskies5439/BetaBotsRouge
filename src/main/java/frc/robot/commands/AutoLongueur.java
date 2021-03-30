// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BrasLongueur;

public class AutoLongueur extends CommandBase {
  
  BrasLongueur brasLongueur;
  int cible;
  int marge;
  boolean stop;

  public AutoLongueur(int cible, BrasLongueur brasLongueur) {
    this.cible = cible;
    this.brasLongueur = brasLongueur;
    marge = 10;
    stop = false;
    addRequirements(brasLongueur);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (brasLongueur.getEncoderLongueurPosition() > cible + marge){
    brasLongueur.driveLongueur(-1);
    }
    else if (brasLongueur.getEncoderLongueurPosition() < cible - marge){
      brasLongueur.driveLongueur(1);
    }
    else 
    {
      brasLongueur.stop();
      stop = true;
    }
  }

  
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stop;
  }
}
