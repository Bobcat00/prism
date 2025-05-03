/*
 * prism
 *
 * Copyright (c) 2022 M Botsko (viveleroi)
 *                    Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.prism_mc.prism.core.actions.types;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.prism_mc.prism.api.actions.types.ActionType;
import org.prism_mc.prism.api.actions.types.ActionTypeRegistry;

public class AbstractActionTypeRegistry implements ActionTypeRegistry {
    /**
     * Cache of action types by key.
     */
    private final Map<String, ActionType> actionsTypes = new HashMap<>();

    @Override
    public Collection<ActionType> actionTypes() {
        return actionsTypes.values();
    }

    @Override
    public Collection<ActionType> actionTypesInFamily(String family) {
        return actionsTypes.values().stream().filter(
            a -> a.familyKey().equalsIgnoreCase(family)).collect(Collectors.toList());
    }

    @Override
    public void registerAction(ActionType actionType) {
        if (actionsTypes.containsKey(actionType.key())) {
            throw new IllegalArgumentException("Registry already has an action type with that key.");
        }

        actionsTypes.put(actionType.key(), actionType);
    }

    @Override
    public Optional<ActionType> actionType(String key) {
        if (actionsTypes.containsKey(key)) {
            return Optional.of(actionsTypes.get(key));
        }

        return Optional.empty();
    }
}
