package com.chuckiefan.architecturecomponentdemo.net.model.resp;

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/24 11:17
 * 内容 ：
 */

public class Cast implements IResp{

    private String alt;
    private Avatar avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Avatar getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatar avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}