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
//import com.informatique.gov.helpdesk.persistence.repository.IssueRepository;
//import com.informatique.gov.helpdesk.rest.dto.IssueDto;
//
//import lombok.AllArgsConstructor;
//
//@Component
//@AllArgsConstructor
//public class IssueDtoValidator implements Validator, Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = HelpdeskVersion.serialVersionUID;
//	private IssueRepository issueRepository;
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return IssueDto.class.isAssignableFrom(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		IssueDto issueDto = (IssueDto) target;
//
//		if (issueRepository.findByArabicIssue(issueDto.getArabicIssue()) != null) {
//			errors.rejectValue(null, HelpdeskExceptionEnum.ARABIC_NAME_EXISTS.getCode(), null, null);
//			return;
//		}
//		if (issueDto.getArabicIssue() == null) {
//			errors.rejectValue("Issue.arabicIssue", HelpdeskExceptionEnum.BLANK_VALUE.getCode(), null, null);
//		}
//		if (issueDto.getCategory().getId() == null) {
//			errors.rejectValue("Issue.category.id", HelpdeskExceptionEnum.BLANK_VALUE.getCode(), null, null);
//		}
//
//	}
//
//}
