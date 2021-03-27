package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BasePilotable extends SubsystemBase {


    private boolean changementRampe = false;

    private Gyro gyro = new ADXRS450_Gyro();

    private WPI_TalonSRX neoGauche = new WPI_TalonSRX(27);
    private WPI_TalonSRX neoDroit = new WPI_TalonSRX(34);

    private DifferentialDrive drive = new DifferentialDrive( neoGauche, neoDroit);

    public BasePilotable() {
        resetEncoder();
        setRamp(0);
        setIdleMode(false);
        neoGauche.setInverted(true);
        neoDroit.setInverted(true);
    }

    @Override
    public void periodic() {
    //Changement de du ramp sur les NEO entre le mode autonome et téléop
    if (!changementRampe && RobotState.isOperatorControl()){
        setRamp(0.25);
        changementRampe = true;
      }

      SmartDashboard.putNumber("Angle du Gyro", getGyroAngle());
      SmartDashboard.putNumber("Vitesse du Gyro", getGyroVitesse());
     // SmartDashboard.putNumber("Position Moyenne", getPosition());
     // SmartDashboard.putNumber("Position Gauche", getEncoderGauchePosition());
     // SmartDashboard.putNumber("Position Droite", getEncoderDroitPosition());
     // SmartDashboard.putNumber("Vitesse Moyenne", getVitesse());
     // SmartDashboard.putNumber("Vitesse Gauche", getEncoderGaucheVitesse());
     // SmartDashboard.putNumber("Vitesse Droit", getEncoderDroitVitesse());
    }

    public void conduire(double joystickX, double joystickY) {
        drive.arcadeDrive(joystickX, joystickY);
 
    }

    /*private void resetEncoder() {
        neoDroit.getEncoder().setPosition(0);
        neoGauche.getEncoder().setPosition(0);
    }
    public double getEncoderDroitPosition() {
        return neoDroit.getEncoder().getPosition();
    }
    public double getEncoderGauchePosition() {
        return neoGauche.getEncoder().getPosition();
    }

    public double getPosition() {
        return (getEncoderGauchePosition() + getEncoderDroitPosition()) / 2;
    }

    public double getEncoderDroitVitesse() {
        return neoDroit.getEncoder().getVelocity();
    }
    public double getEncoderGaucheVitesse() {
        return neoGauche.getEncoder().getVelocity();
    }
    public double getVitesse() {
        return (getEncoderGaucheVitesse() + getEncoderDroitVitesse()) / 2;
    }
   */public double getGyroAngle() {
        return gyro.getAngle();
    }

    public double getGyroVitesse() {
        return gyro.getRate();
    }

    public void resetGyro(){
        gyro.reset();
    }
    public void setRamp(double rampValue) {
        neoDroit.configOpenloopRamp(rampValue);
        neoGauche.configOpenloopRamp(rampValue);
    }
    public void setIdleMode(boolean isBrake) {
        if(isBrake) {
            neoDroit.setNeutralMode(NeutralMode.Brake);
            neoGauche.setNeutralMode(NeutralMode.Brake);
        } else {
            neoDroit.setNeutralMode(NeutralMode.Coast);
            neoGauche.setNeutralMode(NeutralMode.Coast);
        }
    }
}