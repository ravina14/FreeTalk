package com.example.freetalk.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetalk.Response.ResponseCommentReply;
import com.example.freetalk.databinding.RowReplyItemBinding;

import java.util.List;

public class CommentReplyAdapter extends RecyclerView.Adapter<CommentReplyAdapter.ViewHolder> {

    private final List<ResponseCommentReply> list;
    private final Activity activity;

    public CommentReplyAdapter(Activity activity, List<ResponseCommentReply> list) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowReplyItemBinding itemBinding = RowReplyItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        RowReplyItemBinding viewBinding;

        public ViewHolder(@NonNull RowReplyItemBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }

        @SuppressLint("SetTextI18n")
        private void setData(ResponseCommentReply data) {
            viewBinding.txtUserName.setText(data.getReplyUserName());
            viewBinding.txtUserDays.setText(data.getReplyDays());
            viewBinding.txtReply.setText(data.getReply());
            viewBinding.txtFavouriteCount.setText(data.getReplyFavouriteCount());
        }
    }
}
