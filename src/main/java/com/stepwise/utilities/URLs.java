package com.stepwise.utilities;

public enum URLs {
    BASE_URL("https://www.stepwise.ch/"),
    CONTACT_PAGE(BASE_URL.url + "kontakt/");


    private final String url;

    URLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
} 