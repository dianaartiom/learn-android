package com.example.diana.retrtest;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by diana on 7/12/16.
 */
public interface GitHubService {

    @GET("posts/1")
    Call<Post> getAllPosts();
}
/home/diana/RetrTest/app