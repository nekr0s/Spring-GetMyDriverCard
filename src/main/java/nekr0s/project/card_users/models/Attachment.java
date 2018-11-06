package nekr0s.project.card_users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AttachmentID")
    private int attachmentId;

    @Column(name = "Faceshot")
    private String faceShot;

    @Column(name = "IDShot")
    private String idShot;

    @Column(name = "Signature")
    private String signature;

    @Column(name = "DriverLicense")
    private String driverLicense;

    @Column(name = "PreviousTachCard")
    private String previousTachCard;

    @Column(name = "PreviousEUCard")
    private String previousEuCard;

    public Attachment() {
        // keep empty
    }

    // getters and setters

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getFaceShot() {
        return faceShot;
    }

    public void setFaceShot(String faceShot) {
        this.faceShot = faceShot;
    }

    public String getIdShot() {
        return idShot;
    }

    public void setIdShot(String idShot) {
        this.idShot = idShot;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getPreviousTachCard() {
        return previousTachCard;
    }

    public void setPreviousTachCard(String previousTachCard) {
        this.previousTachCard = previousTachCard;
    }

    public String getPreviousEuCard() {
        return previousEuCard;
    }

    public void setPreviousEuCard(String previousEuCard) {
        this.previousEuCard = previousEuCard;
    }
}
