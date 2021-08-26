package in.mohalla.sharechat.mojvideoplayer;
import com.kbjay.decompile.hook.log.InjectLog;
import java.util.ArrayList;
import java.util.List;

import kotlin.h0.d.n;
import moj.core.model.post.b;
import sharechat.library.cvo.PostEntity;

public final class VideoListPreloadModelProvider {
    private final ArrayList<b> entities = new ArrayList<>();


    public final void addUrls(List<? extends b> list) {
        n.g(list,"entities");
        InjectLog.printPostData(list);
        this.entities.addAll(list);
    }
}