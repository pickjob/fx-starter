package fx.starter.service.impl

import fx.starter.service.Transform
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets


class UrlTransform: Transform {
    override fun transfrom(src: String): String {
        return URLEncoder.encode(src, Charsets.UTF_8)
    }

    override fun reverse(dest: String): String {
        return URLDecoder.decode(dest, Charsets.UTF_8)
    }
}
