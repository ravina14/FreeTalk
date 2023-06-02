package com.example.freetalk.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.freetalk.Response.ResponseCommentList;
import com.example.freetalk.Response.ResponseCommentReply;
import com.example.freetalk.databinding.RowCommentItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.ViewHolder> {

    private final List<ResponseCommentList> list;
    private final Activity activity;

    public CommentListAdapter(Activity activity, List<ResponseCommentList> list) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowCommentItemBinding itemBinding = RowCommentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowCommentItemBinding viewBinding;

        public ViewHolder(@NonNull RowCommentItemBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }

        @SuppressLint("SetTextI18n")
        private void setData(ResponseCommentList data) {

            viewBinding.txtUserName.setText(data.getCommentUserName());
            viewBinding.txtUserDays.setText(data.getCommentDays());
            viewBinding.txtComment.setText(data.getComment());
            viewBinding.txtFavouriteCount.setText(data.getCommentFavouriteCount());
            viewBinding.txtCommentCount.setText(data.getCommentTalkCount());

            setCommentReplyAdapter(data.getCommentReplyList());
        }

        private void setCommentReplyAdapter(List<ResponseCommentReply> commentReplyList) {

            CommentReplyAdapter imageAdapter = new CommentReplyAdapter(activity, commentReplyList);
            viewBinding.rvCommentReply.setLayoutManager(new LinearLayoutManager(activity, RecyclerView.VERTICAL, false));
            viewBinding.rvCommentReply.setAdapter(imageAdapter);
        }
    }
}
