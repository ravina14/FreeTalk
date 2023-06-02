package com.example.freetalk.Response;

import java.util.List;

public class ResponseCommentList {
    String commentUserName;
    String commentDays;
    String comment;
    String commentFavouriteCount;
    String commentTalkCount;
    List<ResponseCommentReply> commentReplyList;

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentDays() {
        return commentDays;
    }

    public void setCommentDays(String commentDays) {
        this.commentDays = commentDays;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentFavouriteCount() {
        return commentFavouriteCount;
    }

    public void setCommentFavouriteCount(String commentFavouriteCount) {
        this.commentFavouriteCount = commentFavouriteCount;
    }

    public String getCommentTalkCount() {
        return commentTalkCount;
    }

    public void setCommentTalkCount(String commentTalkCount) {
        this.commentTalkCount = commentTalkCount;
    }

    public List<ResponseCommentReply> getCommentReplyList() {
        return commentReplyList;
    }

    public void setCommentReplyList(List<ResponseCommentReply> commentReplyList) {
        this.commentReplyList = commentReplyList;
    }
}
