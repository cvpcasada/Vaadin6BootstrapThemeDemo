/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.digitallabs.demos;

import com.digitallabs.demos.theme.Bootstrap;
import com.vaadin.Application;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class Vaadin6BootstrapThemeDemo extends Application
{
    private Window window;

    @Override
    public void init()
    {
        setTheme("bootstrap");



        window = new Window("My Vaadin Application");
        setMainWindow(window);
        Button button = new Button("Click Me");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                window.addComponent(new Label("Thank you for clicking"));
            }
        });

        CssLayout container = new CssLayout();
        container.setWidth("100%");
        container.addStyleName("container");

        typography(container);
        tables(container);
        forms(container);
        buttons(container);

        window.setContent(container);

    }

    private void typography(ComponentContainer container) {
        for (int i = 1; i <= 6; i++) {
            Label header = new Label("Bootstrap heading <h" + i + ">");
            header.addStyleName(Bootstrap.Typography.valueOf("H" + i)
                    .styleName());
            container.addComponent(header);
        }

        Label text = new Label(
                "Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.");
        text.addStyleName(Bootstrap.Typography.BODYCOPY.styleName());
        container.addComponent(text);

        text = new Label(
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec ullamcorper nulla non metus auctor fringilla.");
        text.addStyleName(Bootstrap.Typography.BODYCOPY.styleName());
        container.addComponent(text);

        text = new Label(
                "Maecenas sed diam eget risus varius blandit sit amet non magna. Donec id elit non mi porta gravida at eget metus. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.");
        text.addStyleName(Bootstrap.Typography.BODYCOPY.styleName());
        container.addComponent(text);

        text = new Label(
                "Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus.");
        text.addStyleName(Bootstrap.Typography.LEAD.styleName());
        container.addComponent(text);

        text = new Label(
                "Maecenas sed diam eget risus varius blandit sit amet non magna. Donec id elit non mi porta gravida at eget metus. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.");
        text.addStyleName(Bootstrap.Typography.SMALL.styleName());
        container.addComponent(text);

        text = new Label("Left aligned text");
        text.addStyleName(Bootstrap.Typography.TEXT_LEFT.styleName());
        container.addComponent(text);

        text = new Label("Center aligned text");
        text.addStyleName(Bootstrap.Typography.TEXT_CENTER.styleName());
        container.addComponent(text);

        text = new Label("Right aligned text");
        text.addStyleName(Bootstrap.Typography.TEXT_RIGHT.styleName());
        container.addComponent(text);

        // Colors

        text = new Label(
                "Muted. Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.");
        text.addStyleName(Bootstrap.Typography.TEXT_MUTED.styleName());
        container.addComponent(text);

        text = new Label(
                "Primary. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_PRIMARY.styleName());
        container.addComponent(text);

        text = new Label(
                "Warning. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_WARNING.styleName());
        container.addComponent(text);

        text = new Label(
                "Danger. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_DANGER.styleName());
        container.addComponent(text);

        text = new Label(
                "Success. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_SUCCESS.styleName());
        container.addComponent(text);

        text = new Label(
                "Info. Nullam id dolor id nibh ultricies vehicula ut id elit.");
        text.addStyleName(Bootstrap.Typography.TEXT_INFO.styleName());
        container.addComponent(text);
    }

    private void tables(ComponentContainer container) {
        Table table = getSampleTable("");
        container.addComponent(table);

        table = getSampleTable("Striped");
        table.addStyleName(Bootstrap.Tables.STRIPED.styleName());
        container.addComponent(table);

        table = getSampleTable("Bordered");
        table.addStyleName(Bootstrap.Tables.BORDERED.styleName());
        container.addComponent(table);

        table = getSampleTable("Hover rows");
        table.addStyleName(Bootstrap.Tables.HOVER.styleName());
        container.addComponent(table);

        table = getSampleTable("Condensed");
        table.addStyleName(Bootstrap.Tables.CONDENSED.styleName());
        container.addComponent(table);
    }

    private Table getSampleTable(String caption) {
        Table table = new Table(caption);
        table.setWidth("100%");
        table.setHeight(null);
        table.setPageLength(0);
        table.setRowHeaderMode(Table.ROW_HEADER_MODE_INDEX);

        table.addContainerProperty("First Name", String.class, null);
        table.addContainerProperty("Last Name", String.class, null);
        table.addContainerProperty("Username", String.class, null);

        table.addItem(new Object[] { "Mark", "Otto", "@mdo" }, "mark");
        table.addItem(new Object[] { "Jacob", "Thornton", "@fat" }, "jacob");
        table.addItem(new Object[] { "Larry", "the Bird", "@twitter" }, "larry");
        return table;
    }

    private void forms(ComponentContainer container) {
        VerticalLayout form = new VerticalLayout();
        form.addStyleName(Bootstrap.Forms.FORM.styleName());
        form.setSpacing(true);
        form.setCaption("Legend");

        TextField email = new TextField("Email address");
        email.setInputPrompt("Enter email");
        form.addComponent(email);

        PasswordField password = new PasswordField("Password");
        password.setInputPrompt("Password");
        form.addComponent(password);

        Upload upload = new Upload("File input", null);
        form.addComponent(upload);

        Label help = new Label("Example block-level help text here.");
        help.addStyleName("help-block");
        form.addComponent(help);

        CheckBox check = new CheckBox("Check me out");
        form.addComponent(check);

        Button submit = new Button("Submit");
        submit.addStyleName(Bootstrap.Buttons.DEFAULT.styleName());
        form.addComponent(submit);

        container.addComponent(form);
    }

    private void buttons(CssLayout container) {
        _HorizontalLayout buttons = new _HorizontalLayout();
        buttons.setSpacing(true);
        buttons.setMargin(true);
        container.addComponent(buttons);

        Button normal = new Button("Default");
        normal.addStyleName(Bootstrap.Buttons.DEFAULT.styleName());

        Button primary = new Button("Primary");
        primary.addStyleName(Bootstrap.Buttons.PRIMARY.styleName());

        Button success = new Button("Success");
        success.addStyleName(Bootstrap.Buttons.SUCCESS.styleName());

        Button info = new Button("Info");
        info.addStyleName(Bootstrap.Buttons.INFO.styleName());

        Button warning = new Button("Warning");
        warning.addStyleName(Bootstrap.Buttons.WARNING.styleName());

        Button danger = new Button("Danger");
        danger.addStyleName(Bootstrap.Buttons.DANGER.styleName());

        Button link = new Button("Link");
        link.addStyleName(Bootstrap.Buttons.LINK.styleName());

        buttons.addComponents(normal, primary, info, success, warning, danger,
                link);
    }

    private class _HorizontalLayout extends HorizontalLayout {
        public void addComponents(Component... components) {
            for (Component c : components) {
                this.addComponent(c);
            }
        }
    }
}
