/*
 * Copyright (c) 2013 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.cuba.web.toolkit.ui.client.tokenlistlabel;


import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Label;
import com.vaadin.client.ui.VPanel;

/**
 * @author devyatkin
 * @version $Id$
 */
public class CubaTokenListLabelWidget extends VPanel {

    public static final String CLASSNAME = "cuba-token-list-label";

    private Label label = new Label();

    private boolean editable;
    private boolean canOpen;

    protected TokenListLabelHandler handler;

    public CubaTokenListLabelWidget() {
        super();
        setStyleName(CLASSNAME);
        setWidget(label);
        label.setStyleName("content");

        DOM.sinkEvents(getElement(), Event.ONCLICK);
    }

    @Override
    public void setWidth(String width) {
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        if (!editable) {
            getElement().addClassName("noedit");
        } else {
            getElement().removeClassName("noedit");
        }
    }

    public void setCanOpen(boolean canOpen) {
        this.canOpen = canOpen;
        if (canOpen)
            getElement().addClassName("open");
        else
            getElement().removeClassName("open");
    }

    public void setText(String text) {
        label.setText(text);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (DOM.eventGetType(event) == Event.ONCLICK && handler != null) {
            if (DOM.eventGetTarget(event) != label.getElement() && editable) {
                handler.remove();
            } else if (DOM.eventGetTarget(event) == label.getElement() && canOpen) {
                handler.click();
            }
        }
    }

    public interface TokenListLabelHandler {
        void remove();

        void click();
    }
}
