package com.informatique.gov.helpdesk.support.annotation;

import java.lang.annotation.*;

/**
 * Retry - mark a given method for retrying.
 *
 * @author Vlad Mihalcea
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Retry {

    /**
     * Declare the exception types the retry will be issued on.
     *
     * @return exception types causing a retry
     */
    Class<? extends Exception>[] on();

    /**
     * The number of retry attempts
     *
     * @return retry attempts
     */
    int times() default 1;

    /**
     * Fail if the current thread is enlisted in a running transaction.
     *
     * @return fail in case of a running transaction
     */
    boolean failInTransaction() default true;
}
