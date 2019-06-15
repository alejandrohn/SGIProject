package org.me.isdcm.video.SearchPatternsClasses;

public class TitlePattern implements IVideoQuery {

    private String pattern;

    public TitlePattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getQuery() {
        String sqlByTitle = "SELECT * FROM VIDEOS WHERE title ='" + pattern + "'";
        return sqlByTitle;
    }

    @Override
    public String getToString() {
        return pattern;
    }

}
