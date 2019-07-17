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

package uk.co.caprica.spa.service;

import uk.co.caprica.spa.domain.User;
import uk.co.caprica.spa.repository.MemoryUserRepository;
import uk.co.caprica.spa.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private UserRepository userRepository = new MemoryUserRepository();

    @Override
    public Optional<User> user(String username) {
        return userRepository.readUser(username);
    }

    @Override
    public List<User> users() {
        return userRepository.readUsers();
    }

}
