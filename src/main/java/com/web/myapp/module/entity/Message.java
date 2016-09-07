package com.web.myapp.module.entity;

import java.util.Date;

public class Message {
    private Long id;

    private Integer senderid;

    private Integer receiverid;

    private String copyerid;

    private String secreterid;

    private String title;

    private String content;

    private String icon;

    private String url;

    private Date createtime;

    private Date updatetime;

    private Boolean issend;

    private Date sendtime;

    private Integer sendtype;

    private Boolean isread;

    private Date readtime;

    private Integer isreceiverdelete;

    private Date receiverdeletetime;

    private Integer issenderdelete;

    private Date senderdeletetime;

    private Boolean isdraft;

    private Boolean istag;

    private Boolean isreply;

    private Integer replyid;

    private Integer ordernum;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public String getCopyerid() {
        return copyerid;
    }

    public void setCopyerid(String copyerid) {
        this.copyerid = copyerid == null ? null : copyerid.trim();
    }

    public String getSecreterid() {
        return secreterid;
    }

    public void setSecreterid(String secreterid) {
        this.secreterid = secreterid == null ? null : secreterid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Boolean getIssend() {
        return issend;
    }

    public void setIssend(Boolean issend) {
        this.issend = issend;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getSendtype() {
        return sendtype;
    }

    public void setSendtype(Integer sendtype) {
        this.sendtype = sendtype;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public Date getReadtime() {
        return readtime;
    }

    public void setReadtime(Date readtime) {
        this.readtime = readtime;
    }

    public Integer getIsreceiverdelete() {
        return isreceiverdelete;
    }

    public void setIsreceiverdelete(Integer isreceiverdelete) {
        this.isreceiverdelete = isreceiverdelete;
    }

    public Date getReceiverdeletetime() {
        return receiverdeletetime;
    }

    public void setReceiverdeletetime(Date receiverdeletetime) {
        this.receiverdeletetime = receiverdeletetime;
    }

    public Integer getIssenderdelete() {
        return issenderdelete;
    }

    public void setIssenderdelete(Integer issenderdelete) {
        this.issenderdelete = issenderdelete;
    }

    public Date getSenderdeletetime() {
        return senderdeletetime;
    }

    public void setSenderdeletetime(Date senderdeletetime) {
        this.senderdeletetime = senderdeletetime;
    }

    public Boolean getIsdraft() {
        return isdraft;
    }

    public void setIsdraft(Boolean isdraft) {
        this.isdraft = isdraft;
    }

    public Boolean getIstag() {
        return istag;
    }

    public void setIstag(Boolean istag) {
        this.istag = istag;
    }

    public Boolean getIsreply() {
        return isreply;
    }

    public void setIsreply(Boolean isreply) {
        this.isreply = isreply;
    }

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}