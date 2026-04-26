package com.management.golf_management.utils;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PlayerNormalizer {

    public String name(String v) {
        return v == null ? null : v.trim();
    }

    public String email(String v) {
        return v == null ? null : v.trim().toLowerCase(Locale.ROOT);
    }

    public String phone(String v) {
        return v == null ? null : v.trim();
    }

    public String optional(String v) {
        if (v == null) return null;
        String t = v.trim();
        return t.isEmpty() ? null : t;
    }
}
