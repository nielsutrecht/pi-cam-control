package com.nibado.raspberry.picamctrl.image;

import com.nibado.raspberry.picamctrl.Application;

import java.io.IOException;
import java.io.InputStream;

public class Images {
    public static InputStream capture() throws IOException {
        if (!Application.RASPBERRY) {
            return duke();
        }

        Process process = Runtime.getRuntime().exec(new String[]{"raspistill", "-o", "-", "-t", "100", "-md", "4"});

        return process.getInputStream();
    }

    private static InputStream duke() {
        return Images.class.getResourceAsStream("/duke.jpg");
    }
}
