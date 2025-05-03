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

package org.prism_mc.prism.api.services.wands;

import java.util.UUID;
import org.prism_mc.prism.api.util.Coordinate;

public interface Wand {
    /**
     * Get the wand mode.
     *
     * @return The wand mode
     */
    WandMode mode();

    /**
     * Sets the owner of this wand.
     *
     * @param owner The player
     */
    void setOwner(Object owner);

    /**
     * Use this wand on the given world/coordinate.
     *
     * @param worldUuid The world uuid
     * @param coordinate The coordinate
     */
    void use(UUID worldUuid, Coordinate coordinate);
}
