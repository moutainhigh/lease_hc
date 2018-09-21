package com.hc.lease.common.core.file;

import java.io.InputStream;
import java.net.URL;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/10/9<br/>
 * 说明：
 */
public final class ResourceLoader {
    private ResourceLoader() {
    }

    public static String getResourcePath(String src) {
        URL url = ResourceLoader.class.getClassLoader().getResource(src);
        return url == null ? null : url.getPath();
    }

    public static InputStream getResourceInputStream(String src) {
        return ResourceLoader.class.getClassLoader().getResourceAsStream(src);
    }
}
