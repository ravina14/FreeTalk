package com.example.freetalk.Response;

import java.util.List;

public class ResponseFreeTalk {

    String userName;
    String userDays;
    String userCM;
    String userKG;
    String userQuestion;
    String userAnswer;
    List<String> tagList;
    List<String> imageList;
    String userFavouriteCount;
    String userTalkCount;
    List<ResponseCommentList> commentList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDays() {
        return userDays;
    }

    public void setUserDays(String userDays) {
        this.userDays = userDays;
    }

    public String getUserCM() {
        return userCM;
    }

    public void setUserCM(String userCM) {
        this.userCM = userCM;
    }

    public String getUserKG() {
        return userKG;
    }

    public void setUserKG(String userKG) {
        this.userKG = userKG;
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getUserFavouriteCount() {
        return userFavouriteCount;
    }

    public void setUserFavouriteCount(String userFavouriteCount) {
        this.userFavouriteCount = userFavouriteCount;
    }

    public String getUserTalkCount() {
        return userTalkCount;
    }

    public void setUserTalkCount(String userTalkCount) {
        this.userTalkCount = userTalkCount;
    }

    public List<ResponseCommentList> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<ResponseCommentList> commentList) {
        this.commentList = commentList;
    }

}
