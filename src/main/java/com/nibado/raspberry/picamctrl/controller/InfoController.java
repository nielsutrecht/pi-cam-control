package com.nibado.raspberry.picamctrl.controller;

import lombok.Data;
import spark.Request;
import spark.Response;

import java.time.ZonedDateTime;

public class InfoController {
    public static InfoResponse info(final Request req, final Response res) {
        res.type("application/json");
        return new InfoResponse(ZonedDateTime.now());
    }

    @Data
    public static class InfoResponse {
        private final ZonedDateTime time;
    }
}
