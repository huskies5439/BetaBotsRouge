// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BrasLongueur extends SubsystemBase {
  private TalonSRX brasLongueur = new TalonSRX(16);//Comentaire des bleus: vérifier si 15 ou 16 est le bon
  private Encoder encoderLongueur = new Encoder(2, 3);
  public BrasLongueur() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveLongueur(double vitesse){
    brasLongueur.set(ControlMode.PercentOutput, vitesse);
  }
  public void resetEncoders(){
    encoderLongueur.reset();
  }

  public double getEncoderLongueurPosition(){
    return encoderLongueur.get();
  }
}
