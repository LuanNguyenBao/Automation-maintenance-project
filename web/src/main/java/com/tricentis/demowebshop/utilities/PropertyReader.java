package com.tricentis.demowebshop.utilities;

import java.util.ResourceBundle;

public class PropertyReader {

    private final ResourceBundle resourceBundle;

    public PropertyReader(String propertyFileName) {
        resourceBundle = ResourceBundle.getBundle(propertyFileName);
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }

}
