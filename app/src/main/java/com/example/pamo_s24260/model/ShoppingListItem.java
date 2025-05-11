package com.example.pamo_s24260.model;

public class ShoppingListItem {
    private final String name;
    private boolean isChecked;

    public ShoppingListItem(String name) {
        this.name = name;
        this.isChecked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
