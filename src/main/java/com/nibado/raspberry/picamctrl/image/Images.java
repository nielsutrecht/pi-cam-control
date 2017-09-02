package com.nibado.raspberry.picamctrl.image;

import com.nibado.raspberry.picamctrl.Application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Images {
    public static InputStream capture() throws IOException {
        if (!Application.RASPBERRY) {
            return duke();
        }

        Runtime.getRuntime().exec(new String[]{"raspistill", "-o", "tstimg.jpg", "-t", "100", "-md", "4"});

        return new FileInputStream("tstimg.jpg");
    }

    private static InputStream duke() {
        return Images.class.getResourceAsStream("/duke.jpg");
    }
}
