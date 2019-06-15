package org.me.isdcm.video.SearchPatternsClasses;

public class CreatedDatePattern implements IVideoQuery {

    private String pattern;

    public CreatedDatePattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getQuery() {
        String sqlByCreatedDate = "select * from VIDEOS where CREATEDDATE = '" + pattern + "'";
        return sqlByCreatedDate;
    }

    @Override
    public String getToString() {
        return pattern;
    }

}
