package org.me.isdcm.video.SearchPatternsClasses;

public class AutorPattern implements IVideoQuery {

    private String pattern;

    public AutorPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getQuery() {
        String sqlByAutor = "SELECT * FROM VIDEOS WHERE autor ='" + pattern + "'";
        return sqlByAutor;
    }

    @Override
    public String getToString() {
       return pattern;}
}
