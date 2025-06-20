package com.ms.pricelist.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="FEEPLAN")
//@NamedQuery(name="get_All_Feeplans",query = "select f from feeplan f")
public class Feeplan {
	@Id
	@Column(name = "FEEPLAN_ID")
	private String feeplanId;
	
	public String getFeeplanId() {
		return feeplanId;
	}

	public void setFeeplanId(String feeplanId) {
		this.feeplanId = feeplanId;
	}

	public String getFeeplanName() {
		return feeplanName;
	}

	public void setFeeplanName(String feeplanName) {
		this.feeplanName = feeplanName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getFeePlanStatus() {
		return feePlanStatus;
	}

	public void setFeePlanStatus(String feePlanStatus) {
		this.feePlanStatus = feePlanStatus;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getEnrollmentStartDate() {
		return enrollmentStartDate;
	}

	public void setEnrollmentStartDate(Date enrollmentStartDate) {
		this.enrollmentStartDate = enrollmentStartDate;
	}

	public Date getEnrollmentEndDate() {
		return enrollmentEndDate;
	}

	public void setEnrollmentEndDate(Date enrollmentEndDate) {
		this.enrollmentEndDate = enrollmentEndDate;
	}

	public Boolean getIsGlobal() {
		return isGlobal;
	}

	public void setIsGlobal(Boolean isGlobal) {
		this.isGlobal = isGlobal;
	}

	public Boolean getForNewCustomersOnly() {
		return forNewCustomersOnly;
	}

	public void setForNewCustomersOnly(Boolean forNewCustomersOnly) {
		this.forNewCustomersOnly = forNewCustomersOnly;
	}

	public Integer getValidityPeriodDays() {
		return validityPeriodDays;
	}

	public void setValidityPeriodDays(Integer validityPeriodDays) {
		this.validityPeriodDays = validityPeriodDays;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getPreviousVersionId() {
		return previousVersionId;
	}

	public void setPreviousVersionId(String previousVersionId) {
		this.previousVersionId = previousVersionId;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	@Column(name = "FEEPLAN_NAME")
	private String feeplanName;

	@Column(name = "SHORT_DESC")
	private String description;

	@Column(name = "LONG_DESC")
	private String longDescription;

//	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private String feePlanStatus;

	@Column(name = "EFF_START_DT")
	private Date effectiveStartDate;

	@Column(name = "EFF_END_DT")
	private Date effectiveEndDate;

	@Column(name = "VERSION")
	private Integer version;

	@Column(name = "ENROLLMENT_START_DT")
	private Date enrollmentStartDate;

	@Column(name = "ENROLLMENT_END_DT")
	private Date enrollmentEndDate;

	@Column(name = "IS_GLOBAL")
	private Boolean isGlobal;
	
	@Column(name = "FOR_NEW_CUSTOEMRS_ONLY")
	private Boolean forNewCustomersOnly;

	@Column(name = "VALIDITY_PERIOD_DAYS")
	private Integer validityPeriodDays;

	@Column(name = "CREATED_DT")
	private LocalDateTime createdDate;

	@Column(name = "UPDATED_DT")
	private LocalDateTime updatedDate;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "PREVIOUS_VERSION_ID")
	private String previousVersionId;     
	
	@Column(name = "RULE_ID")
	private String ruleId; 

	@PrePersist
	public void generateFeeplanId() {
		if (feeplanId == null) {
			this.feeplanId = UUID.randomUUID().toString();
		}
	}
	
//	@OneToMany(mappedBy = "feePlanEntity" , cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<FeePlanEligibilityCriteria> feePlanEligibilityCriteria; 
//
//	@OneToMany(mappedBy = "feePlanEntity", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<DifferntiatorEntity> differntiatorEntity;
//	
//	@OneToMany(mappedBy = "feePlanEntity", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<AssignmentEntity> feeplanAssignmentEntity;

}
