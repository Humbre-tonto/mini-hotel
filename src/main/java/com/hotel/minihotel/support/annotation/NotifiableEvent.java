package com.informatique.gov.helpdesk.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.informatique.gov.helpdesk.support.dataenum.NotifiableEventEnum;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotifiableEvent {
	NotifiableEventEnum notifiableEvent();
	boolean sms() default false;
	boolean email() default false;
	boolean system() default false;
}
