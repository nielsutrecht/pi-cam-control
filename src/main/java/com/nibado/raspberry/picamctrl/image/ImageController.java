package com.nibado.raspberry.picamctrl.image;

import spark.Request;
import spark.Response;
import spark.utils.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class ImageController {
    public static HttpServletResponse info(final Request req, final Response res) throws IOException {
        InputStream ins = Images.capture();

        HttpServletResponse raw = res.raw();
        res.type("image/png");
        try {
            IOUtils.copy(ins, raw.getOutputStream());
            ins.close();
            raw.getOutputStream().flush();
            raw.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return raw;
    }
}
