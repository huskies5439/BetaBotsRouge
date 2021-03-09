// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Bras extends SubsystemBase {
  private TalonSRX brasHauteur = new TalonSRX(2);
  private TalonSRX brasLongueur = new TalonSRX(3);
  private Encoder encoderHauteur = new Encoder(0, 1);
  private Encoder encoderLongueur = new Encoder(2, 3);
  public Bras() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveHauteur(double vitesse){
    brasHauteur.set(ControlMode.PercentOutput, vitesse);
  }
  public void driveLongueur(double vitesse){
    brasLongueur.set(ControlMode.PercentOutput, vitesse);
  }
  public void resetEncoders(){
    encoderHauteur.reset();
    encoderLongueur.reset();
  }
  public double getEncoderHauteurPosition(){
    return encoderHauteur.get();
  }
  public double getEncoderLongueurPosition(){
    return encoderLongueur.get();
  }
}
