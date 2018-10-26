package nekr0s.project.card_users.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AttachmentID")
    private int attatchmentId;

    @Column(name = "Faceshot")
    @NotNull
    private byte[] faceShot;

    @Column(name = "IDShot")
    @NotNull
    private byte[] idShot;

    @Column(name = "Signature")
    @NotNull
    private byte[] signature;

    @Column(name = "DriverLicense")
    @NotNull
    private byte[] driverLicense;

    @Column(name = "PreviousTachCard")
    private byte[] previousTachCard;

    @Column(name = "PreviousEUCard")
    private byte[] previousEuCard;

    public Attachment() {
        // keep empty
    }

    // getters and setters

    public int getAttatchmentId() {
        return attatchmentId;
    }

    public void setAttatchmentId(int attatchmentId) {
        this.attatchmentId = attatchmentId;
    }

    public byte[] getFaceShot() {
        return faceShot;
    }

    public void setFaceShot(byte[] faceShot) {
        this.faceShot = faceShot;
    }

    public byte[] getIdShot() {
        return idShot;
    }

    public void setIdShot(byte[] idShot) {
        this.idShot = idShot;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public byte[] getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(byte[] driverLicense) {
        this.driverLicense = driverLicense;
    }

    public byte[] getPreviousTachCard() {
        return previousTachCard;
    }

    public void setPreviousTachCard(byte[] previousTachCard) {
        this.previousTachCard = previousTachCard;
    }

    public byte[] getPreviousEuCard() {
        return previousEuCard;
    }

    public void setPreviousEuCard(byte[] previousEuCard) {
        this.previousEuCard = previousEuCard;
    }
}
