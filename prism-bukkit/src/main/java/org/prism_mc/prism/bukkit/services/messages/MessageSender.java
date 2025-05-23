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

package org.prism_mc.prism.bukkit.services.messages;

import com.google.inject.Singleton;
import net.kyori.adventure.text.Component;
import net.kyori.moonshine.message.IMessageSender;
import org.bukkit.command.CommandSender;

@Singleton
public class MessageSender implements IMessageSender<CommandSender, Component> {

    @Override
    public void send(final CommandSender receiver, final Component renderedMessage) {
        receiver.sendMessage(renderedMessage);
    }
}
