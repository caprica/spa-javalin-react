/*
 * This file is part of Spa.
 *
 * Copyright (C) 2019
 * Caprica Software Limited (capricasoftware.co.uk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.caprica.spa.controller;

import io.javalin.http.Handler;
import uk.co.caprica.spa.domain.User;
import uk.co.caprica.spa.repository.MemoryUserRepository;
import uk.co.caprica.spa.service.UserService;
import uk.co.caprica.spa.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

/**
 * An example web service API controller.
 */
public class UserController {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private static UserService userService = new UserServiceImpl();

    public static Handler users = ctx -> {
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
        ctx.json(userService.users());
    };

    public static Handler user = ctx -> {
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
        userService.user(ctx.pathParam("username")).ifPresentOrElse(ctx::json, () -> ctx.status(404));
    };

}
