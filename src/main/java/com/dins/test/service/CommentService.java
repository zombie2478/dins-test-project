package com.dins.test.service;

import com.dins.test.model.Comment;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface CommentService {
    @GET("/comments")
    Call<List<Comment>> getComments(@Query("postId") int postId);

}
