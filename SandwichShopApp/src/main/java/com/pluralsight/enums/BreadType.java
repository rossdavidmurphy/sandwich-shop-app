package com.pluralsight.enums;

public enum BreadType {
    WHITE_BREAD,
    WHEAT,
    RYE,
    WRAP;

    @Override
    public String toString() {
        String[] words = name().toLowerCase().split("_");
        StringBuilder formatted = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                formatted.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return formatted.toString().trim();
    }}
