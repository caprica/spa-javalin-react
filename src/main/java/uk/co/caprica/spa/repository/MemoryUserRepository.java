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

package uk.co.caprica.spa.repository;

import uk.co.caprica.spa.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements UserRepository {

    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("boss", new User("boss", "Sword Saint Isshin"));
        users.put("emma", new User("emma", "The Gentle Blade"));
        users.put("emo", new User("emo", "Genichiro"));
        users.put("dad", new User("dad", "Great Shinobi Owl"));
        users.put("bananas", new User("bananas", "Guardian Ape"));
        users.put("granny", new User("granny", "Lady Butterfly"));
        users.put("horseguy", new User("horseguy", "Gyoubu Masataka Oniwa"));
        users.put("scorchio", new User("scorchio", "Demon of Hatred"));
    }

    @Override
    public List<User> readUsers() {
        return Collections.unmodifiableList(new ArrayList<>(users.values()));
    }

    @Override
    public Optional<User> readUser(String username) {
        User user = users.get(username);
        return Optional.ofNullable(user);
    }

}
