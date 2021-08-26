package sharechat.library.cvo;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public final class PostEntity extends BaseEntity<PostEntity>{

    // 视频源
    private String attributedUrl;
    private String videoCompressedPostUrl;
    private String videoPostUrl;

    // 视频id
    private String postId = "";
    // 视频title + tag  tag 以# 开头
    private String caption;
    // 封面
    private String thumbPostUrl;

    private long likeCount;
    private long shareCount;
    private long viewCount;
    private long commentCount;


    public final long getCommentCount() {
        return this.commentCount;
    }

    public final long getViewCount() {
        return this.viewCount;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    public final long getShareCount() {
        return this.shareCount;
    }


    public final String getThumbPostUrl() {
        return this.thumbPostUrl;
    }


    public final String getAttributedUrl() {
        return this.attributedUrl;
    }



    public final String getVideoCompressedPostUrl() {
        return this.videoCompressedPostUrl;
    }

    public final String getVideoPostUrl() {
        return this.videoPostUrl;
    }

    public final String getPostId() {
        return this.postId;
    }


    public final String getCaption() {
        return this.caption;
    }


    @Override
    public PostEntity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}