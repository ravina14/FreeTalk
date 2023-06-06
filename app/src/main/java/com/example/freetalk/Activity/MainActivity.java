package com.example.freetalk.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import com.example.freetalk.Adapter.CommentListAdapter;
import com.example.freetalk.Adapter.SliderViewImageAdapter;
import com.example.freetalk.viewmodel.AppViewModel;
import com.example.freetalk.Helper.Utilities;
import com.example.freetalk.R;
import com.example.freetalk.Response.ResponseCommentList;
import com.example.freetalk.Response.ResponseCommentReply;
import com.example.freetalk.Response.ResponseFreeTalk;
import com.example.freetalk.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;
    private Utilities utilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        AppViewModel appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        appViewModel.setFreeTalkData(setFreeTalkDetails());

        appViewModel.getFreeTalkData()
                .observe(this, responseData -> new Handler().postDelayed(() -> {

                    utilities.progressDialogHide();

                    setTagView(responseData.getTagList());

                    setImageSlider(responseData.getImageList());

                    setCommentAdapter(responseData.getCommentList());

                }, 2000L));

        viewBinding.setViewModel(appViewModel);
    }

    private void init(){
        utilities = new Utilities(this);

        //utilities.setLanguage("en");
        utilities.setLanguage("ko");
    }

    private ResponseFreeTalk setFreeTalkDetails() {
        utilities.progressDialogShow();

        ResponseFreeTalk responseFreeTalk = new ResponseFreeTalk();
        responseFreeTalk.setUserName(getString(R.string.user_name));
        responseFreeTalk.setUserDays(getString(R.string.user_days));
        responseFreeTalk.setUserCM(getString(R.string.user_cm));
        responseFreeTalk.setUserKG(getString(R.string.user_kg));
        responseFreeTalk.setUserQuestion(getString(R.string.user_question));
        responseFreeTalk.setUserAnswer(getString(R.string.user_answer));
        responseFreeTalk.setUserFavouriteCount(getString(R.string._5));
        responseFreeTalk.setUserTalkCount(getString(R.string._5));

        List<String> tagList = new ArrayList<>();
        tagList.add("#2023");
        tagList.add("#TODAYISMONDAY");
        tagList.add("#TOP");
        tagList.add("#POPS!");
        tagList.add("#WOW");
        tagList.add("#ROW");
        responseFreeTalk.setTagList(tagList);

        List<String> imageList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            imageList.add("https://wjddnjs754.cafe24.com/web/product/small/202303/5b9279582db2a92beb8db29fa1512ee9.jpg");
        }
        responseFreeTalk.setImageList(imageList);

        List<ResponseCommentList> commentList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ResponseCommentList responseComment = new ResponseCommentList();
            responseComment.setCommentUserName(getString(R.string.user_name));
            responseComment.setCommentDays(getString(R.string.user_days));
            responseComment.setComment(getString(R.string.user_comment));
            responseComment.setCommentFavouriteCount(getString(R.string._5));
            responseComment.setCommentTalkCount(getString(R.string._5));

            List<ResponseCommentReply> replyList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                ResponseCommentReply reply = new ResponseCommentReply();
                reply.setReplyUserName(getString(R.string.reply_user_name));
                reply.setReplyDays(getString(R.string.user_days));
                reply.setReply(getString(R.string.comment_reply));
                reply.setReplyFavouriteCount(getString(R.string._5));
                reply.setReplyTalkCount(getString(R.string._5));

                replyList.add(reply);
            }
            responseComment.setCommentReplyList(replyList);

            commentList.add(responseComment);
        }
        responseFreeTalk.setCommentList(commentList);

        return responseFreeTalk;
    }

    private void setTagView(List<String> tagList) {
        viewBinding.tagView.setTags(tagList);
    }

    private void setImageSlider(List<String> imageList) {
        SliderViewImageAdapter imageAdapter = new SliderViewImageAdapter(MainActivity.this, imageList);
        viewBinding.sliderView.setSliderAdapter(imageAdapter);
        viewBinding.sliderView.startAutoCycle();
    }

    private void setCommentAdapter(List<ResponseCommentList> commentList) {
        CommentListAdapter imageAdapter = new CommentListAdapter(MainActivity.this, commentList);
        viewBinding.rvComment.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
        viewBinding.rvComment.setAdapter(imageAdapter);
    }
}