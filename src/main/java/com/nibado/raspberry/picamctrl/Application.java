package com.nibado.raspberry.picamctrl;

import com.nibado.raspberry.picamctrl.image.ImageController;
import com.nibado.raspberry.picamctrl.controller.InfoController;
import com.nibado.raspberry.picamctrl.util.Global;
import com.nibado.raspberry.picamctrl.util.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class Application {
    public static final boolean RASPBERRY = System.getProperty("os.arch").equals("arm");

    public Application() {
        staticFileLocation("/static");
        get(Global.Web.HELLO, (req, res) -> "Hello World");
        get(Global.Web.INFO, InfoController::info, new JsonTransformer());
        get(Global.Web.IMAGE, ImageController::info);
    }

    public static void main(String[] args) {
        new Application();
    }
}
