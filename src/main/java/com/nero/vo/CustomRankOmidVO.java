package com.nero.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-09-03
 * Time: 14:13
 */
public class CustomRankOmidVO {


    String mediaType;

    String omid;

    List<CustomRankOmidFilterVO> list = new ArrayList();

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getOmid() {
        return omid;
    }

    public void setOmid(String omid) {
        this.omid = omid;
    }

    public List<CustomRankOmidFilterVO> getList() {
        return list;
    }

    public void setList(List<CustomRankOmidFilterVO> list) {
        this.list = list;
    }
}
