package com.kbjay.decompile.hook.log;

public class HookMsgBean {
    User user;
    Video video;

    static class User {
        String profileUrl = "";
        String thumbUrl = "";
        String userId = "";
        String userName = "";
    }

    static class Video {
        // 视频源
        String attributedUrl = "";
        String videoCompressedPostUrl = "";
        String videoPostUrl = "";

        // 视频id
        String postId = "";
        // 视频title + tag  tag 以# 开头
        String caption = "";
        // 封面
        String thumbPostUrl = "";

        long likeCount = 0;
        long shareCount = 0;
        long viewCount = 0;
        long commentCount = 0;
    }
}
