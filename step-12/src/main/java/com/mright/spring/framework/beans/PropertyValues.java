package com.mright.spring.framework.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(final String propertyName) {
        return propertyValueList.stream().filter(item -> Objects.equals(item.getName(), propertyName)).findFirst().orElse(null);
    }
}
