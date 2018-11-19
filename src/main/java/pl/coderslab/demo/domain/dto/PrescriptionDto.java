package pl.coderslab.demo.domain.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PrescriptionDto {

    @NotNull
    private String drugName;

    @NotNull
    private Integer drugQuantity;

    @NotNull
    private String drugDose;

    @NotNull
    private LocalDate timeOfRealization;

    private Long DrugId;

    private String drugs;
    private String drug_name;

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    private boolean filledIn;

    public Long getDrugId() {
        return DrugId;
    }

    public void setDrugId(Long drugId) {
        DrugId = drugId;
    }

    public boolean isFilledIn() {
        return filledIn;
    }

    public void setFilledIn(boolean filledIn) {
        this.filledIn = filledIn;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Integer getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(Integer drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public String getDrugDose() {
        return drugDose;
    }

    public void setDrugDose(String drugDose) {
        this.drugDose = drugDose;
    }

    public LocalDate getTimeOfRealization() {
        return timeOfRealization;
    }

    public void setTimeOfRealization(LocalDate timeOfRealization) {
        this.timeOfRealization = timeOfRealization;
    }
}
