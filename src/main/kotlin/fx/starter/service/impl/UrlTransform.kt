package fx.starter.service.impl

import fx.starter.service.Transform
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.Charset


class UrlTransform: Transform {
    override fun transfrom(src: String): String {
        return URLEncoder.encode(src, Charset.defaultCharset())
    }

    override fun reverse(dest: String): String {
        return URLDecoder.decode(dest, Charset.defaultCharset())
    }
}
