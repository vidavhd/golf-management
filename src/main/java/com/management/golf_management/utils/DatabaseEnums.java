package com.management.golf_management.utils;

public final class DatabaseEnums {

    private DatabaseEnums() { }

    public enum Gender {
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        private final String display;

        Gender(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }

    public enum SkillLevel {
        BEGINNER("Beginner"),
        INTERMEDIATE("Intermediate"),
        ADVANCED("Advanced"),
        PRO("Pro");

        private final String display;
        SkillLevel(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }

    public enum CourseType {
        PUBLIC("Public"),
        PRIVATE("Private");

        private final String display;
        CourseType(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }

    public enum Difficulty {
        EASY("Easy"),
        MEDIUM("Medium"),
        HARD("Hard");

        private final String display;
        Difficulty(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }

    public enum Season {
        SPRING("Spring"),
        SUMMER("Summer"),
        FALL("Fall"),
        WINTER("Winter");

        private final String display;
        Season(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }

    public enum MembershipType {
        HOME("Home"),
        AWAY("Away");

        private final String display;
        MembershipType(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }

    public enum MembershipStatus {
        ACTIVE("Active"),
        INACTIVE("Inactive");

        private final String display;
        MembershipStatus(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }

    public enum MatchType {
        STROKE_PLAY("Stroke Play"),
        MATCH_PLAY("Match Play"),
        SKINS("Skins"),
        STABLEFORD("Stableford");

        private final String display;
        MatchType(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }

    public enum MatchResult {
        PLAYER1("Player1"),
        PLAYER2("Player2"),
        TIE("Tie");

        private final String display;
        MatchResult(String display) { this.display = display; }
        public String getDisplay() { return display; }
        @Override public String toString() { return display; }
    }
}