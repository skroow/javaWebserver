package com.Webserver.javaWebserver.WebView.PythonWebAPI;

public class App {

    private String id;
    private String icon;

    public App(String id, String icon) {
        this.id = id;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "id= " + id + "\n" +
                "icon= " + icon;
    }
}
