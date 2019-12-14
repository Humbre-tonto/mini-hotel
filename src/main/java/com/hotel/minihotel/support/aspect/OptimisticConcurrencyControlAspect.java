package com.informatique.gov.helpdesk.support.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import com.informatique.gov.helpdesk.support.annotation.Retry;

import lombok.AllArgsConstructor;

@Aspect
@Component
@AllArgsConstructor
public class OptimisticConcurrencyControlAspect {

	private final Logger logger = LoggerFactory.getLogger(OptimisticConcurrencyControlAspect.class);

	@Pointcut(value = "execution(public * com.informatique.gov.customerservice.service.impl..*(..))")
	public void anyServicePublicMethod() {
	}

	@Around("anyServicePublicMethod() && @annotation(retry)")
	public Object handleRetry(ProceedingJoinPoint pjp, Retry retry) throws Throwable {
		int times = retry.times();
		Class<? extends Throwable>[] retryOn = retry.on();
		Assert.isTrue(times > 0, "@Retry{times} should be greater than 0!");
		Assert.isTrue(retryOn.length > 0, "@Retry{on} should have at least one Throwable!");
		if (retry.failInTransaction() && TransactionSynchronizationManager.isActualTransactionActive()) {
			throw new IllegalTransactionStateException(
					"You shouldn't retry an operation from within an existing Transaction."
							+ "This is because we can't retry if the current Transaction was already rolled back!");
		}
		logger.info("Proceed with {} retries on {}", times, Arrays.toString(retryOn));
		return tryProceeding(pjp, times, retryOn);
	}

	private Object tryProceeding(ProceedingJoinPoint pjp, int times, Class<? extends Throwable>[] retryOn)
			throws Throwable {
		try {
			return pjp.proceed();
		} catch (Throwable throwable) {
			if (isRetryThrowable(throwable, retryOn) && times-- > 0) {
				logger.info("Optimistic locking detected, {} remaining retr{} on {}", times, (times == 1 ? "y" : "ies"),
						Arrays.toString(retryOn));
				return tryProceeding(pjp, times, retryOn);
			}
			throw throwable;
		}
	}

	private boolean isRetryThrowable(Throwable throwable, Class<? extends Throwable>[] retryOn) {
		Throwable cause = throwable;
		do {
			for (Class<? extends Throwable> retryThrowable : retryOn) {
				if (retryThrowable.isAssignableFrom(cause.getClass())) {
					return true;
				}
			}

			if (cause.getCause() == null || cause.getCause() == cause) {
				break;
			} else {
				cause = cause.getCause();
			}
		} while (true);
		return false;
	}
}
