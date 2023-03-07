package com.Webserver.javaWebserver.WebView;


import com.Webserver.javaWebserver.WebView.PythonWebAPI.LGAPI;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("LG")
public class LgWebOSView extends VerticalLayout {

    public LgWebOSView(){

        var horizontalLayout = new HorizontalLayout();
        var lg = new LGAPI();
        var h1 = new H1("hello world");
        var image = new Image("http://192.168.1.81:3000/resources/0d242a9ad55a83f32c5965e8d4edf3a629135cfd/3978980228944972_34877553_80x80_webos.png", "chuj");
        Button button = new Button();
        button.setHeight("400px");
        //button.setStyleName(ValoTheme.BUTTON_LINK);
        button.setIcon(image);
        setPosition(horizontalLayout, 0, 400);
        button.addClickListener(e -> lg.pause());
        for (var app: lg.apps()) {
            Button appButton = new Button();
            var appImage = new Image(app.getIcon(), app.getId());
            appButton.setIcon(appImage);
            appButton.setSizeFull();
            appButton.addClickListener(e -> lg.launchApp(app.getId()));
            horizontalLayout.add(appButton);
        }

        horizontalLayout.add();
        add(button, horizontalLayout, h1);
    }

    public void setPosition(Component component, int x, int y) {
        component.getElement().getStyle().set("position","absolute");
        component.getElement().getStyle().set("top",y+"px");
        component.getElement().getStyle().set("left",x+"px");
    }
}
