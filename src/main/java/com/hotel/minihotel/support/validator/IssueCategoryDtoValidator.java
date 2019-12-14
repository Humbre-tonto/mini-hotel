package com.informatique.gov.helpdesk.support.validator;
//package com.informatique.gov.helpdesk.support.validator;
//
//import java.io.Serializable;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import com.informatique.gov.helpdesk.HelpdeskVersion;
//import com.informatique.gov.helpdesk.exception.HelpdeskExceptionEnum;
//import com.informatique.gov.helpdesk.persistence.repository.IssueCategoryRepository;
//import com.informatique.gov.helpdesk.rest.dto.IssueCategoryDto;
//
//import lombok.AllArgsConstructor;
//
//@Component
//@AllArgsConstructor
//public class IssueCategoryDtoValidator implements Validator, Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = HelpdeskVersion.serialVersionUID;
//	private IssueCategoryRepository issueCategoryRepository;
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return IssueCategoryDto.class.isAssignableFrom(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		IssueCategoryDto issueCategoryDto = (IssueCategoryDto) target;
//		if (issueCategoryRepository.findByArabicName(issueCategoryDto.getArabicName()) != null) {
//			errors.rejectValue(null, HelpdeskExceptionEnum.ARABIC_NAME_EXISTS.getCode(), null, null);
//			return;
//		}
//
//		if (issueCategoryRepository.findByEnglishName(issueCategoryDto.getEnglishName()) != null) {
//			errors.rejectValue(null, HelpdeskExceptionEnum.ENGLISH_NAME_EXISTS.getCode(), null, null);
//			return;
//		}
//		if (issueCategoryDto.getArabicName() == null) {
//			errors.rejectValue("IssueCategory.arabicName", HelpdeskExceptionEnum.BLANK_VALUE.getCode(), null, null);
//		}
//
//	}
//
//}
