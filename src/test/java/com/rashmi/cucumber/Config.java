package com.rashmi.cucumber;

public class Config {
    private String environment;
    private String baseUrl;

    public Config(){
        environment = System.getProperty("rashmi.environment", "test");
        switch(environment)
        {
            case "test":
                baseUrl = "https://desidutchstore.nl";
                break;

            case "dev":
                baseUrl = "https://www.google.com";
                break;

            default:
                baseUrl = "https://desidutchstore.nl";
        }

    }
    public String getBaseUrl(){
        return baseUrl;
    }
}
