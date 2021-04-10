package com.sapient.productcatalogue.util;

public enum GroupBy {
    BRAND("brand"), COLOR("color"), SIZE("size"), CATEGORY("category");
    String value;

    GroupBy(String name) {
        value = name;
    }

    String getValue() {
        return value;
    }
}
