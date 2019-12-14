package com.informatique.gov.helpdesk.support.validator;
//package com.informatique.gov.helpdesk.support.validator;
//
//import java.io.Serializable;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import com.informatique.gov.helpdesk.domain.Role;
//import com.informatique.gov.helpdesk.exception.HelpdeskException;
//import com.informatique.gov.helpdesk.exception.HelpdeskExceptionEnum;
//import com.informatique.gov.helpdesk.rest.dto.TicketCreationDto;
//import com.informatique.gov.helpdesk.service.InternalSecurityService;
//import com.informatique.gov.helpdesk.support.dataenum.UserRoleEnum;
//
//import lombok.AllArgsConstructor;
//
//@Component
//@AllArgsConstructor
//public class TicketDtoValidator implements Validator, Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -2737829559590624524L;
//	private InternalSecurityService securityService;
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return TicketCreationDto.class.isAssignableFrom(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		TicketCreationDto ticketCreationDto = (TicketCreationDto) target;
//		// TicketDto ticketDto = (TicketDto) target;
//		try {
//			Role role = securityService.getUser().getRole();
//			// if (ticketDto.getId() == null) {
//			if (role.getCode().equals(UserRoleEnum.DEPARTMENT_HEAD.getCode())
//					|| role.getCode().equals(UserRoleEnum.HELPDESK_AGENT.getCode())) {
//				if (ticketCreationDto.getOwner().getId() == null) {
//					errors.rejectValue("Owner.id", HelpdeskExceptionEnum.OWNER_NULL.getCode(), null, null);
//				}
//			}
//			if (ticketCreationDto.getQueue().getCode() == null) {
//				errors.rejectValue("Queue.code", HelpdeskExceptionEnum.QUEUE_NULL.getCode(), null, null);
//			}
//			if (ticketCreationDto.getSeverityLevel().getCode() == null) {
//				errors.rejectValue("SeverityLevel.code", HelpdeskExceptionEnum.BLANK_VALUE.getCode(), null, null);
//			}
//			if (ticketCreationDto.getCommunicationChannel().getCode() == null) {
//				errors.rejectValue("CommunicationChannel.code", HelpdeskExceptionEnum.BLANK_VALUE.getCode(), null,
//						null);
//			}
//			if (ticketCreationDto.getIssueCategory().getId() == null) {
//				errors.rejectValue("IssueCategory.id", HelpdeskExceptionEnum.BLANK_VALUE.getCode(), null, null);
//			}
//			if (ticketCreationDto.getMobileNumber() == null) {
//				errors.rejectValue("ticket.mobileNumber", HelpdeskExceptionEnum.BLANK_VALUE.getCode(), null, null);
//			}
//			// } else {
//			// if
//			// (ticketDto.getCurrentStatus().getCode().equals(TicketStatusEnum.OPEN.getCode()))
//			// {
//			// if
//			// (!ticketDto.getAssignedTo().equals(securityService.getUser().getLoginName()))
//			// {
//			// errors.rejectValue("ticket.AssignedTo",
//			// HelpdeskExceptionEnum.EXCEPTION_IN_VALIDATION.getCode(),
//			// null, null);
//			// }
//			// }
//
//			// }
//		} catch (HelpdeskException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//}
