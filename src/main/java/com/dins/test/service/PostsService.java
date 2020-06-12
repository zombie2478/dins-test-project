package com.dins.test.service;


import com.dins.test.model.Comment;
import com.dins.test.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface PostsService {
    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/posts/{postId}")
    Call<Post> getPost(@Path("postId") int postId);

    @GET("/posts/{postId}/comments")
    Call<List<Comment>> getPostComments(@Path("postId") int postId);

    @GET("/posts")
    Call<List<Post>> getPosts(@Query("userId") int userId);

}
