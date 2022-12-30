package fx.starter.service.impl

import fx.starter.service.Transform
import java.util.*
import java.util.Base64.Decoder
import java.util.Base64.Encoder

abstract class AbstractBase64 constructor(val type: String): Transform {
    val encoder: Encoder = when(type) {
        "url" -> Base64.getUrlEncoder()
        else -> Base64.getEncoder()
    }
    val decoder: Decoder = when(type) {
        "url" -> Base64.getUrlDecoder()
        else -> Base64.getDecoder()
    }

    override fun transfrom(src: String): String {
        return encoder.encodeToString(src.encodeToByteArray())
    }

    override fun reverse(dest: String): String {
        return decoder.decode(dest.encodeToByteArray()).decodeToString()
    }
}
