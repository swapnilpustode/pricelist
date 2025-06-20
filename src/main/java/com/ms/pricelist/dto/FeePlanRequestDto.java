package com.ms.pricelist.dto;


import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class FeePlanRequestDto {

	private String feeplanId;
	private String name;
	private String description;
	private String longDescription;
	private String effectiveStartDate;
	private String effectiveEndDate;
	private String enrollmentEndDate;
	private Integer validityPeriodDays;
	private String status;
	private String enrollmentStartDate;

//	@NotNull(message = "Feeplan Name can not be null")
//	@Size(max = 10, message = "Feeplan Name must be maximum of 10 character long")
//
//	@NotNull(message = "Description can not be null")
//	@Size(max = 30, message = "Description must be maximum of 30 character long")
//
//	@Size(max = 200, message = "Long Description must be maximum of 200 character long")
//
//
//	@NotNull(message = "Effective Start Date can not be null")
//	@Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "Invalid date format. Expected format: yyyy-mm-dd")
//
//	@Pattern(
//		    regexp = "^$|^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$",
//		    message = "Invalid date format for Effective End Date. Expected format: yyyy-mm-dd or empty"
//		)
//
//	@NotNull(message = "Enrollment Start Date can not be null")
//	@Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "Invalid date format. Expected format: yyyy-mm-dd")
//
//	@Pattern(
//		    regexp = "^$|^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$",
//		    message = "Invalid date format for Enrollment End Date. Expected format: yyyy-mm-dd or empty"
//		)
//
//	@Min(value = 1, message = "Validity Period must be at least 1")
//	@Max(value = 99999, message = "Validity Period Days must be at most 99999")
//	
//	
	private Integer version;
	private Boolean isGlobal;
	private Boolean forNewCustomersOnly;
	private String previousVersionId;
	private String createdDate;
	private String updatedDate;
	private String updatedBy;
	private String createdBy;
//	@Size(min = 1, max = 36, message = "Rule Id must be between 1 and 36 characters long")
	private String ruleId; 
	List<String> deletedDiffValues;
//    @Valid
//	private List<DifferntiatorRequest> differntiators;
//    
//    private List<FeePlanEligibilityCriteriaRequest> feePlanEligCriteria;

}