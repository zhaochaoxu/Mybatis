package com.chaoxu.pojo;

/**
 * Created by dell on 2016/6/29.
 */
public class Topic {
    private Integer id;
    private String title;
    private String text;
    private String createtime;
    private Integer userid;
    private Integer nodeid;
    private Integer viewnum;
    private Integer fanum;
    private Integer likenum;
    private Integer replynum;
    private String replytime;

    private Tuser tuser;
    private Node node;

    public Tuser getTuser() {
        return tuser;
    }

    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createtime='" + createtime + '\'' +
                ", userid=" + userid +
                ", nodeid=" + nodeid +
                ", viewnum=" + viewnum +
                ", fanum=" + fanum +
                ", likenum=" + likenum +
                ", replynum=" + replynum +
                ", replytime='" + replytime + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getNodeid() {
        return nodeid;
    }

    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
    }

    public Integer getViewnum() {
        return viewnum;
    }

    public void setViewnum(Integer viewnum) {
        this.viewnum = viewnum;
    }

    public Integer getFanum() {
        return fanum;
    }

    public void setFanum(Integer fanum) {
        this.fanum = fanum;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getReplynum() {
        return replynum;
    }

    public void setReplynum(Integer replynum) {
        this.replynum = replynum;
    }

    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime;
    }
}
