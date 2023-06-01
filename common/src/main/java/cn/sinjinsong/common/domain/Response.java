package cn.sinjinsong.common.domain;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by SinjinSong on 2017/5/23.
 */
public class Response {
    private ResponseHeader header;
    private byte[] body;

    public Response(ResponseHeader header, byte[] body) {
        this.header = header;
        this.body = body;
    }

    public Response() {
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Response{" +
            "header=" + header +
            ", body=" + new String(body, StandardCharsets.UTF_8) +
            '}';
    }
}
