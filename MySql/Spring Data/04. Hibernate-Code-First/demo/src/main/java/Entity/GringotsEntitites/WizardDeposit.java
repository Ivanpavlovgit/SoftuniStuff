package Entity.GringotsEntitites;
import Entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit extends BaseEntity {
    private String firstName;
    private String lastName;
    private String notes;
    private Integer age;
    private String magicWandCreator;
    private Short magicWandSize;
    private String depositGroup;
    private LocalDateTime depositStartDate;
    private BigDecimal depositAmount;
    private Float depositInterest;
    private Float depositCharge;
    private LocalDateTime depositExpirationDate;
    private Boolean isDepositExpired;

    @Column(name = "firs_name", nullable = false, length = 50)
    public String getFirstName () {
        return this.firstName;
    }

    public WizardDeposit setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false, length = 60)
    public String getLastName () {
        return this.lastName;
    }

    public WizardDeposit setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(name = "notes")
    public String getNotes () {
        return this.notes;
    }

    public WizardDeposit setNotes (String notes) {
        this.notes = notes;
        return this;
    }

    @Column(name = "age", nullable = false)
    public Integer getAge () {
        return this.age;
    }

    public WizardDeposit setAge (Integer age) {
        this.age = age;
        return this;
    }

    @Column(name = "magic_wand_createator", length = 100)
    public String getMagicWandCreator () {
        return this.magicWandCreator;
    }

    public WizardDeposit setMagicWandCreator (String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
        return this;
    }

    @Column(name = "magic_wand_size", nullable = false)
    public Short getMagicWandSize () {
        return this.magicWandSize;
    }

    public WizardDeposit setMagicWandSize (Short magicWandSize) {
        this.magicWandSize = magicWandSize;
        return this;
    }

    @Column(name = "deposit_group", length = 20)
    public String getDepositGroup () {
        return this.depositGroup;
    }

    public WizardDeposit setDepositGroup (String depositGroup) {
        this.depositGroup = depositGroup;
        return this;
    }

    @Column(name = "deposit_start_date")
    public LocalDateTime getDepositStartDate () {
        return this.depositStartDate;
    }

    public WizardDeposit setDepositStartDate (LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
        return this;
    }

    @Column(name = "deposit_ammount", precision = 10, scale = 3)
    public BigDecimal getDepositAmount () {
        return this.depositAmount;
    }

    public WizardDeposit setDepositAmount (BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
        return this;
    }

    @Column(name = "deposit_interest")
    public Float getDepositInterest () {
        return this.depositInterest;
    }

    public WizardDeposit setDepositInterest (Float depositInterest) {
        this.depositInterest = depositInterest;
        return this;
    }

    @Column(name = "deposit_charge")
    public Float getDepositCharge () {
        return this.depositCharge;
    }

    public WizardDeposit setDepositCharge (Float depositCharge) {
        this.depositCharge = depositCharge;
        return this;
    }

    @Column(name = "deposit_expiration_date")
    public LocalDateTime getDepositExpirationDate () {
        return this.depositExpirationDate;
    }

    public WizardDeposit setDepositExpirationDate (LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
        return this;
    }

    @Column(name = "deposit_expired")
    public Boolean getDepositExpired () {
        return this.isDepositExpired;
    }

    public WizardDeposit setDepositExpired (Boolean depositExpired) {
        isDepositExpired = depositExpired;
        return this;
    }

    public WizardDeposit () {
        super ();
    }
}
