/*
 * Copyright (c) 2013 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */
package com.haulmont.cuba.web.log;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.RemoteException;
import com.haulmont.cuba.core.global.TimeSource;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.util.Date;

/**
 * @author krivopustov
 * @version $Id$
 */
public class LogItem {

    private Date timestamp;
    private LogLevel level;
    private String message;
    private String stacktrace;

    public LogItem(LogLevel level, String message, Throwable throwable) {
        this.timestamp = AppBeans.get(TimeSource.class).currentTimestamp();
        this.level = level;
        this.message = message;
        if (throwable != null) {
            if (throwable instanceof RemoteException) {
                RemoteException re = (RemoteException) throwable;
                for (int i = re.getCauses().size() - 1; i >= 0; i--) {
                    if (re.getCauses().get(i).getThrowable() != null) {
                        throwable = re.getCauses().get(i).getThrowable();
                        break;
                    }
                }
            }
            Throwable rootCause = ExceptionUtils.getRootCause(throwable);
            if (rootCause == null)
                rootCause = throwable;
            this.stacktrace = ExceptionUtils.getStackTrace(rootCause);
        }
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
