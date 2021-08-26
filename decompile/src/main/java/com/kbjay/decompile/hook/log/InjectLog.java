package com.kbjay.decompile.hook.log;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import org.json.JSONObject;

import java.util.List;

import moj.core.model.post.b;
import sharechat.library.cvo.PostEntity;
import sharechat.library.cvo.UserEntity;

public class InjectLog {
    private static Application application;
    private static String TAG = "InjectLog";

    public static void hookApp(Application app) {
        application = app;
    }

    public static void printFunc() {
        Thread cur_thread = Thread.currentThread();
        StackTraceElement stack[] = cur_thread.getStackTrace();
        Log.d(TAG, "printFunc: " + stack[3].toString() + "[" + cur_thread.getId() + "]");
    }

    public static void printLong(long a) {
        Log.d(TAG, "printLong: " + a);
    }

    public static void printString(String a) {
        Log.d(TAG, "printString: " + a);
    }

    public static void printPostData(List<? extends b> list) {
        for (int i = 0; i < list.size(); i++) {
            PostEntity post = list.get(i).getPost();
            UserEntity user = list.get(i).getUser();
            HookMsgBean hookMsgBean = new HookMsgBean();
            HookMsgBean.User hookUser = new HookMsgBean.User();
            HookMsgBean.Video hookVideo = new HookMsgBean.Video();

            if (user != null) {
                if (user.getProfileUrl() != null) {
                    hookUser.profileUrl = user.getProfileUrl();
                }
                if (user.getThumbUrl() != null) {
                    hookUser.thumbUrl = user.getThumbUrl();
                }
                if (user.getUserId() != null) {
                    hookUser.userId = user.getUserId();
                }
                if (user.getUserName() != null) {
                    hookUser.userName = user.getUserName();
                }
            }

            if (post != null) {
                if (post.getVideoPostUrl() != null) {
                    hookVideo.videoPostUrl = post.getVideoPostUrl();
                }
                if (post.getVideoCompressedPostUrl() != null) {
                    hookVideo.videoCompressedPostUrl = post.getVideoCompressedPostUrl();
                }
                if (post.getAttributedUrl() != null) {
                    hookVideo.attributedUrl = post.getAttributedUrl();
                }
                if (post.getCaption() != null) {
                    hookVideo.caption = post.getCaption();
                }

                if (post.getPostId() != null) {
                    hookVideo.postId = post.getPostId();
                }
                hookVideo.commentCount = post.getCommentCount();
                hookVideo.likeCount = post.getLikeCount();
                hookVideo.viewCount = post.getViewCount();
                hookVideo.shareCount = post.getShareCount();
                if (post.getThumbPostUrl() != null) {
                    hookVideo.thumbPostUrl = post.getThumbPostUrl();
                }
            }

            hookMsgBean.user = hookUser;
            hookMsgBean.video = hookVideo;

            try {
                JSONObject data = new JSONObject();
                data.put("profileUrl", hookUser.profileUrl);
                data.put("thumbUrl", hookUser.thumbUrl);
                data.put("userId", hookUser.userId);
                data.put("userName", hookUser.userName);

                data.put("videoCompressedPostUrl", hookVideo.videoCompressedPostUrl);
                data.put("attributedUrl", hookVideo.attributedUrl);
                data.put("videoPostUrl", hookVideo.videoPostUrl);
                data.put("thumbPostUrl", hookVideo.thumbPostUrl);
                data.put("commentCount", hookVideo.commentCount);
                data.put("likeCount", hookVideo.likeCount);
                data.put("shareCount", hookVideo.shareCount);
                data.put("viewCount", hookVideo.viewCount);
                data.put("postId", hookVideo.postId);
                data.put("caption", hookVideo.caption);

                Intent intent = new Intent();
                intent.putExtra("data", data.toString());
                intent.setAction("com.kbjay.fragment.reciever.MyBroadCastReceive");
                application.sendBroadcast(intent);

                printString("-------------------------------");
            } catch (Exception e) {

            }
        }
    }
}
