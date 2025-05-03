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

package org.prism_mc.prism.bukkit.commands;

import com.google.inject.Inject;

import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.annotations.Command;

import java.io.IOException;

import org.prism_mc.prism.bukkit.services.alerts.BukkitAlertService;
import org.prism_mc.prism.bukkit.services.filters.BukkitFilterService;
import org.prism_mc.prism.bukkit.services.messages.MessageService;
import org.prism_mc.prism.bukkit.services.translation.BukkitTranslationService;
import org.prism_mc.prism.loader.services.configuration.ConfigurationService;
import org.prism_mc.prism.loader.services.logging.LoggingService;

import org.bukkit.command.CommandSender;

@Command(value = "prism", alias = {"pr"})
public class ReloadCommand {
    /**
     * The alert service.
     */
    private final BukkitAlertService alertService;

    /**
     * The logging service.
     */
    private final LoggingService loggingService;

    /**
     * The message service.
     */
    private final MessageService messageService;

    /**
     * The translation service.
     */
    private final BukkitTranslationService translationService;

    /**
     * The configuration service.
     */
    private final ConfigurationService configurationService;

    /**
     * The filter service.
     */
    private final BukkitFilterService filterService;

    /**
     * Construct the reload command.
     *
     * @param alertService The alert service
     * @param messageService The message service
     * @param translationService The translation service
     * @param configurationService The configuration service
     * @param filterService The filter service
     */
    @Inject
    public ReloadCommand(
            BukkitAlertService alertService,
            LoggingService loggingService,
            MessageService messageService,
            BukkitTranslationService translationService,
            ConfigurationService configurationService,
            BukkitFilterService filterService) {
        this.alertService = alertService;
        this.loggingService = loggingService;
        this.messageService = messageService;
        this.translationService = translationService;
        this.configurationService = configurationService;
        this.filterService = filterService;
    }

    /**
     * Reload the config.
     *
     * @param sender The command sender
     */
    @Command("reloadconfig")
    @Permission("prism.admin")
    public void onReloadConfig(final CommandSender sender) {
        configurationService.loadConfigurations();

        filterService.loadFilters();
        alertService.loadAlerts();

        messageService.reloadedConfig(sender);
    }

    /**
     * Reload the locale files.
     *
     * @param sender The command sender
     */
    @Command("reloadlocales")
    @Permission("prism.admin")
    public void onReloadLocales(final CommandSender sender) {
        try {
            translationService.reloadTranslations();

            messageService.reloadedLocales(sender);
        } catch (IOException e) {
            messageService.errorReloadLocale(sender);
            loggingService.handleException(e);
        }
    }
}
