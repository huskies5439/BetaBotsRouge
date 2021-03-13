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

public class BasePilotable extends SubsystemBase {


    private boolean changementRampe = false;

    private Gyro gyro = new ADXRS450_Gyro();

    private CANSparkMax neoGauche = new CANSparkMax(34, MotorType.kBrushless);
    private CANSparkMax neoDroit = new CANSparkMax(37, MotorType.kBrushless);

    private DifferentialDrive drive = new DifferentialDrive(neoDroit, neoGauche);

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
        setRamp(1);
        changementRampe = true;
      }

      SmartDashboard.putNumber("Angle du Gyro", getGyroAngle());
      SmartDashboard.putNumber("Vitesse du Gyro", getGyroVitesse());
      SmartDashboard.putNumber("Position Moyenne", getPosition());
      SmartDashboard.putNumber("Position Gauche", getEncoderGauchePosition());
      SmartDashboard.putNumber("Position Droite", getEncoderDroitPosition());
      SmartDashboard.putNumber("Vitesse Moyenne", getVitesse());
      SmartDashboard.putNumber("Vitesse Gauche", getEncoderGaucheVitesse());
      SmartDashboard.putNumber("Vitesse Droit", getEncoderDroitVitesse());
    }

    public void drive(double joystickX, double joystickY) {
        drive.arcadeDrive(0.5 * joystickX, 0.5 * joystickY);
    }

    private void resetEncoder() {
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
    public double getGyroAngle() {
        return gyro.getAngle();
    }

    public double getGyroVitesse() {
        return gyro.getRate();
    }

    public void resetGyro(){
        gyro.reset();
    }
    public void setRamp(double rampValue) {
        neoDroit.setOpenLoopRampRate(rampValue);
        neoGauche.setOpenLoopRampRate(rampValue);
    }
    public void setIdleMode(boolean isBrake) {
        if(isBrake) {
            neoDroit.setIdleMode(IdleMode.kBrake);
            neoGauche.setIdleMode(IdleMode.kBrake);
        } else {
            neoDroit.setIdleMode(IdleMode.kCoast);
            neoGauche.setIdleMode(IdleMode.kCoast);
        }
    }
}