//package com.oracle.fsgbu.ormb.feeplan.mapper;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.oracle.fsgbu.ormb.feeplan.constant.FeePlanConstant;
//import com.oracle.fsgbu.ormb.feeplan.entity.DifferntiatorEntity;
//import com.oracle.fsgbu.ormb.feeplan.entity.FeePlanEligibilityCriteria;
//import com.oracle.fsgbu.ormb.feeplan.entity.FeePlanEntity;
//import com.oracle.fsgbu.ormb.feeplan.enums.FeePlanStatus;
//import com.oracle.fsgbu.ormb.feeplan.request.DifferntiatorRequest;
//import com.oracle.fsgbu.ormb.feeplan.request.FeePlanEligibilityCriteriaRequest;
//import com.oracle.fsgbu.ormb.feeplan.request.FeePlanRequest;
//import com.oracle.fsgbu.ormb.feeplan.response.FeePlanEligCriteriaResponse;
//import com.oracle.fsgbu.ormb.feeplan.response.FeePlanResponse;
//import com.oracle.fsgbu.ormb.rate.entity.EligibilityCriteria;
//import com.ormb.fsgbu.ormb.rate.dto.EligibilityCriteriaRequestDTO;
//import com.ormb.fsgbu.ormb.rate.dto.EligibilityCriteriaResponseDTO;
//
//import jakarta.enterprise.context.ApplicationScoped;
//
//@ApplicationScoped
//public class FeePlanMapper {
//
//	public FeePlanEntity mapRequestToEntity(FeePlanRequest feePlanRequest) {
//		FeePlanEntity feePlanEntity = new FeePlanEntity();
//
//		feePlanEntity.setFeePlanStatus(FeePlanStatus.DRAFT);
//		feePlanEntity.setVersion(FeePlanConstant.FL_VERSION);
//		feePlanEntity.setPreviousVersionId(null);
//		feePlanEntity.setCreatedDate(LocalDateTime.now());
//		feePlanEntity.setCreatedBy(FeePlanConstant.admin);
//		feePlanEntity.setDescription(feePlanRequest.getDescription());
//		feePlanEntity.setLongDescription(feePlanRequest.getLongDescription());
//		feePlanEntity.setFeeplanName(feePlanRequest.getName());
//		feePlanEntity.setValidityPeriodDays(feePlanRequest.getValidityPeriodDays());
//		feePlanEntity.setIsGlobal(feePlanRequest.getIsGlobal());
//		feePlanEntity.setForNewCustomersOnly(feePlanRequest.getForNewCustomersOnly());
//		feePlanEntity.setRuleId(feePlanRequest.getRuleId());
//		// Parse and set effective and enrollment dates
//		if (feePlanRequest.getEffectiveStartDate() != null && feePlanRequest.getEnrollmentStartDate() != null) {
//			LocalDate effStart = LocalDate.parse(feePlanRequest.getEffectiveStartDate(), FeePlanConstant.dateFormatter);
//			LocalDate enrstart = LocalDate.parse(feePlanRequest.getEnrollmentStartDate(), FeePlanConstant.dateFormatter);
//			feePlanEntity.setEffectiveStartDate(java.sql.Date.valueOf(effStart));
//			feePlanEntity.setEnrollmentStartDate(java.sql.Date.valueOf(enrstart));
//		}
//		if(feePlanRequest.getEffectiveEndDate() != null && ! feePlanRequest.getEffectiveEndDate().isEmpty()) {
//			LocalDate end = LocalDate.parse(feePlanRequest.getEffectiveEndDate(), FeePlanConstant.dateFormatter);
//			feePlanEntity.setEffectiveEndDate(java.sql.Date.valueOf(end));
//		}
//		if(feePlanRequest.getEnrollmentEndDate() != null && ! feePlanRequest.getEnrollmentEndDate().isEmpty()) {
//			LocalDate end = LocalDate.parse(feePlanRequest.getEnrollmentEndDate(), FeePlanConstant.dateFormatter);
//			feePlanEntity.setEnrollmentEndDate(java.sql.Date.valueOf(end));
//		}
//		
//		if(feePlanRequest.getEffectiveEndDate() == null || feePlanRequest.getEffectiveEndDate().isEmpty()) {
//			feePlanEntity.setEffectiveEndDate(null);
//		}
//		
//		if(feePlanRequest.getEnrollmentEndDate() == null || feePlanRequest.getEnrollmentEndDate().isEmpty()) {
//			feePlanEntity.setEnrollmentEndDate(null);
//		}
//		
//		
//		List<DifferntiatorEntity> differntiatorEntityList = new ArrayList<>();
//		if(! feePlanRequest.getDifferntiators().isEmpty() && feePlanRequest.getDifferntiators() != null) {
//			if(feePlanEntity.getIsGlobal() == false) {
//				for (DifferntiatorRequest req : feePlanRequest.getDifferntiators()) {
//					DifferntiatorEntity entity = new DifferntiatorEntity();
//					entity.setName(req.getName());
//					entity.setValue(req.getValue());
//					entity.setType(req.getType());
//					entity.setOperator(req.getOperator());
//					entity.setEntity(req.getEntity());
//					entity.setFeePlanEntity(feePlanEntity);
//					differntiatorEntityList.add(entity);
//				}
//				feePlanEntity.setDifferntiatorEntity(differntiatorEntityList);		
//			}
//		}
//		return feePlanEntity;
//	}
//
//	public List<DifferntiatorEntity> mapDifferentiatorsToEntity(List<DifferntiatorRequest> differntiatorRequestList,
//			FeePlanEntity feePlanEntity) {
//		List<DifferntiatorEntity> differntiatorEntityList = new ArrayList<>();
//		if (differntiatorRequestList != null) {
//			for (DifferntiatorRequest req : differntiatorRequestList) {
//				DifferntiatorEntity entity = new DifferntiatorEntity();
//				entity.setName(req.getName());
//				entity.setValue(req.getValue());
//				entity.setType(req.getType());
//				entity.setOperator(req.getOperator());
//				entity.setEntity(req.getEntity());
//				entity.setFeePlanEntity(feePlanEntity);
//				differntiatorEntityList.add(entity);
//			}
//		}
//		return differntiatorEntityList;
//	}
//
//	public FeePlanResponse mapEntityToResponse(FeePlanEntity feePlanEntity,
//			List<DifferntiatorEntity> differntiatorEntityList) {
//		FeePlanResponse feePlanResponse = new FeePlanResponse();
//		feePlanResponse.setFeeplanId(feePlanEntity.getFeeplanId());
//		feePlanResponse.setName(feePlanEntity.getFeeplanName());
//		feePlanResponse.setDescription(feePlanEntity.getDescription());
//		feePlanResponse.setLongDescription(feePlanEntity.getLongDescription());
//		feePlanResponse.setFeePlanStatus(feePlanEntity.getFeePlanStatus());
//		feePlanResponse.setEffectiveStartDate(feePlanEntity.getEffectiveStartDate().toString());
//		feePlanResponse.setEnrollmentStartDate(feePlanEntity.getEnrollmentStartDate().toString());
//		if (feePlanEntity.getEffectiveEndDate() != null && !feePlanEntity.getEffectiveEndDate().toString().isEmpty()) {
//			feePlanResponse.setEffectiveEndDate(feePlanEntity.getEffectiveEndDate().toString());
//		}
//		if (feePlanEntity.getEnrollmentEndDate() != null
//				&& !feePlanEntity.getEnrollmentEndDate().toString().isEmpty()) {
//			feePlanResponse.setEnrollmentEndDate(feePlanEntity.getEnrollmentEndDate().toString());
//		}
//		feePlanResponse.setIsGlobal(feePlanEntity.getIsGlobal());
//		feePlanResponse.setForNewCustomersOnly(feePlanEntity.getForNewCustomersOnly());
//		feePlanResponse.setValidityPeriodDays(feePlanEntity.getValidityPeriodDays());
//		feePlanResponse.setVersion(feePlanEntity.getVersion());
//		feePlanResponse.setPreviousVersionId(feePlanEntity.getPreviousVersionId());
//		feePlanResponse.setRuleId(feePlanEntity.getRuleId());
//
//		List<DifferntiatorRequest> differntiatorRequestList = new ArrayList<>();
//		for (DifferntiatorEntity differentiatorEntity : differntiatorEntityList) {
//			DifferntiatorRequest differntiatorRequest = new DifferntiatorRequest();
//			differntiatorRequest.setName(differentiatorEntity.getName());
//			differntiatorRequest.setValue(differentiatorEntity.getValue());
//			differntiatorRequest.setOperator(differentiatorEntity.getOperator());
//			differntiatorRequest.setType(differentiatorEntity.getType());
//			differntiatorRequest.setEntity(differentiatorEntity.getEntity());
//			differntiatorRequest.setDifferentiatorId(differentiatorEntity.getDifferentiatorId());
//			differntiatorRequestList.add(differntiatorRequest);
//		}
//		feePlanResponse.setDifferntiators(differntiatorRequestList);
//		
//		//Fee Plan Eligibility mapping'
//		
//		 List<FeePlanEligCriteriaResponse> eligibilityCriteriaList = new ArrayList<FeePlanEligCriteriaResponse>();
//         if (feePlanEntity.getFeePlanEligibilityCriteria() != null) {
//             for (FeePlanEligibilityCriteria criteria : feePlanEntity.getFeePlanEligibilityCriteria() ) {
//                 //EligibilityCriteriaRequestDTO criteriaDto = toDTO(criteria);
//            	 FeePlanEligCriteriaResponse criteriaDto = toDTO(criteria);
//                 eligibilityCriteriaList.add(criteriaDto);
//             }
//         }
//         feePlanResponse.setEligCriterias(eligibilityCriteriaList);
//		
//		return feePlanResponse;
//	}
//	
//	 public static FeePlanEligCriteriaResponse toDTO(FeePlanEligibilityCriteria entity) {
//	        if (entity == null) {
//	            return null;
//	        }
//	        FeePlanEligCriteriaResponse dto = new FeePlanEligCriteriaResponse();
//	        dto.setCriteriaId(entity.getCriteriaId());
//	        dto.setAttributeName(entity.getAttributeName());
//	        dto.setAttributeValue(entity.getAttributeValue());
//	        dto.setMatchType(entity.getMatchType());
//	        dto.setOperator(entity.getOperator());
//	        dto.setSequence(entity.getSequence());
//
//	        return dto;
//	    }
//
//	public FeePlanResponse mapEntityToResponse(FeePlanEntity feePlanEntity) {
//		FeePlanResponse feePlanResponse = new FeePlanResponse();
//		SimpleDateFormat sdf = new SimpleDateFormat(FeePlanConstant.dateFormat);
//
//		// Mapping FeePlanEntity to FeePlanResponse
//		feePlanResponse.setFeeplanId(feePlanEntity.getFeeplanId());
//		feePlanResponse.setName(feePlanEntity.getFeeplanName());
//		feePlanResponse.setDescription(feePlanEntity.getDescription());
//		feePlanResponse.setLongDescription(feePlanEntity.getLongDescription());
//		feePlanResponse.setFeePlanStatus(feePlanEntity.getFeePlanStatus());
//		feePlanResponse.setVersion(feePlanEntity.getVersion());
//		feePlanResponse.setIsGlobal(feePlanEntity.getIsGlobal());
//		feePlanResponse.setForNewCustomersOnly(feePlanEntity.getForNewCustomersOnly());
//		feePlanResponse.setValidityPeriodDays(feePlanEntity.getValidityPeriodDays());
//		feePlanResponse.setPreviousVersionId(feePlanEntity.getPreviousVersionId());
//		feePlanResponse.setRuleId(feePlanEntity.getRuleId());
//
//		// Format dates
//		feePlanResponse.setEffectiveStartDate(formatDate(feePlanEntity.getEffectiveStartDate(), sdf));
//		feePlanResponse.setEffectiveEndDate(formatDate(feePlanEntity.getEffectiveEndDate(), sdf));
//		feePlanResponse.setEnrollmentStartDate(formatDate(feePlanEntity.getEnrollmentStartDate(), sdf));
//		feePlanResponse.setEnrollmentEndDate(formatDate(feePlanEntity.getEnrollmentEndDate(), sdf));
//
//		// Map Differentiators
//		if (feePlanEntity.getDifferntiatorEntity() != null) {
//			List<DifferntiatorRequest> differentiatorDtosList = mapDifferentiatorsToRequest(
//					feePlanEntity.getDifferntiatorEntity());
//			feePlanResponse.setDifferntiators(differentiatorDtosList);
//		}
//		
//		//Map Eligibility criteria
//		if(feePlanEntity.getFeePlanEligibilityCriteria() != null) {
//			
//			List<FeePlanEligCriteriaResponse> eligResponseList = new ArrayList<>();
//			
//			for(FeePlanEligibilityCriteria criteria : feePlanEntity.getFeePlanEligibilityCriteria()) {
//				  FeePlanEligCriteriaResponse  response = toDTO(criteria);
//				  eligResponseList.add(response);
//			}
//			feePlanResponse.setEligCriterias(eligResponseList);
//		}
//
//		return feePlanResponse;
//	}
//
//	private String formatDate(java.sql.Date date, SimpleDateFormat sdf) {
//		return date != null ? sdf.format(date) : "";
//	}
//
//	public List<DifferntiatorRequest> mapDifferentiatorsToRequest(List<DifferntiatorEntity> differentiatorEntities) {
//		List<DifferntiatorRequest> differentiatorRequests = new ArrayList<>();
//		if (differentiatorEntities != null) {
//			for (DifferntiatorEntity entity : differentiatorEntities) {
//				DifferntiatorRequest request = new DifferntiatorRequest();
//				request.setDifferentiatorId(entity.getDifferentiatorId());
//				request.setEntity(entity.getEntity());
//				request.setName(entity.getName());
//				request.setOperator(entity.getOperator());
//				request.setValue(entity.getValue());
//				request.setType(entity.getType());
//				differentiatorRequests.add(request);
//			}
//		}
//		return differentiatorRequests;
//	}
//
//	public List<FeePlanEligibilityCriteria> mapFeePlanEligCriteria(
//			List<FeePlanEligibilityCriteriaRequest> feePlanEligCriteria, FeePlanEntity feePlanEntity) {
//		
//		
//		   List<FeePlanEligibilityCriteria> feePlanEligibilityCriteriaList = new ArrayList<>();
//	        if (feePlanEligCriteria != null) {
//	            for (FeePlanEligibilityCriteriaRequest criteriaReq : feePlanEligCriteria) {
//	            	FeePlanEligibilityCriteria criteria = toEntity(criteriaReq);
//	            	if(null != criteria) {
//	                criteria.setFeePlanEntity(feePlanEntity);
//	            	}
//	                feePlanEligibilityCriteriaList.add(criteria);
//	            }
//	        }
//	        feePlanEntity.setFeePlanEligibilityCriteria(feePlanEligibilityCriteriaList);
//		
//		return feePlanEligibilityCriteriaList;
//	}
//	
//	  public static FeePlanEligibilityCriteria toEntity(FeePlanEligibilityCriteriaRequest dto) {
//	        if (dto == null) {
//	            return null;
//	        }
//
//	        FeePlanEligibilityCriteria entity = new FeePlanEligibilityCriteria();
//	        entity.setAttributeName(dto.getAttributeName());
//	        entity.setAttributeValue(dto.getAttributeValue());
//	        entity.setMatchType(dto.getMatchType());
//	        entity.setOperator(dto.getOperator());
//	        entity.setSequence(dto.getSequence());
//
//			/*
//			 * List<EligibilityCriteria> nestedCriteria = new ArrayList<>(); if
//			 * (dto.getNestedCriteria() != null) { for (EligibilityCriteriaRequestDTO
//			 * nestedDto : dto.getNestedCriteria()) {
//			 * nestedCriteria.add(toEntity(nestedDto)); } }
//			 * entity.setNestedCriteria(nestedCriteria);
//			 */
//
//	        return entity;
//	    }
//	  
//		public static DifferntiatorEntity mapDifferentiatorsToEntity(DifferntiatorRequest differntiatorReques) {
//			if (differntiatorReques == null) {
//				return null;
//			}
//			DifferntiatorEntity differntiatorEntity = new DifferntiatorEntity();
//			differntiatorEntity.setName(differntiatorReques.getName());
//			differntiatorEntity.setValue(differntiatorReques.getValue());
//			differntiatorEntity.setType(differntiatorReques.getType());
//			differntiatorEntity.setOperator(differntiatorReques.getOperator());
//			differntiatorEntity.setEntity(differntiatorReques.getEntity());
//			return differntiatorEntity;
//		}
//
//}
//package com;


