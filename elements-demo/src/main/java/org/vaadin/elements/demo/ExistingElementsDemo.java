package org.vaadin.elements.demo;

import java.util.Optional;

import org.vaadin.elements.Element;
import org.vaadin.elements.ElementIntegration;
import org.vaadin.elements.Root;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

public class ExistingElementsDemo extends AbstractElementsDemo {

    @Override
    protected String getDemoDescription() {
        return "This demo shows how to access elements created by some other source (e.g. a Vaadin component).";
    }

    @Override
    protected Component getDemoView() {
        Button button = new Button("Click to modify my styles");
        Root root = ElementIntegration.getRoot(button);

        button.addClickListener(e -> {
            Optional<Element> span = root.querySelector("span.v-button-wrap");
            span.ifPresent(element -> {
                if (element.hasAttribute("style")) {
                    element.removeAttribute("style");
                } else {
                    element.setAttribute("style", "color: red");
                }
            });
        });

        // Fetch dom so that it's available when clicking the button
        root.fetchDom(null);

        return button;
    }

}
