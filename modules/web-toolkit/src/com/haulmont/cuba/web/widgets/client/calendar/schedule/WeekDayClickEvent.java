/*
 * Copyright (c) 2008-2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.cuba.web.widgets.client.calendar.schedule;

import java.util.Date;

public class WeekDayClickEvent {

    protected final Date date;
    protected final Date from;
    protected final Date to;

    public WeekDayClickEvent(Date date, Date from, Date to) {
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }
}
