/*
 * Scaffold by TerminalMC
 *
 * To the extent possible under law, the person who associated CC0 with
 * Scaffold has waived all copyright and related or neighboring rights
 * to Scaffold.
 *
 * You should have received a copy of the CC0 legalcode along with this
 * work. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

package dev.terminalmc.scaffold;

import dev.terminalmc.scaffold.command.Commands;
import dev.terminalmc.scaffold.gui.screen.ConfigScreenProvider;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(
        value = Scaffold.MOD_ID,
        dist = Dist.CLIENT
)
@EventBusSubscriber(
        modid = Scaffold.MOD_ID,
        value = Dist.CLIENT
)
public class ScaffoldNeoForge {

    public ScaffoldNeoForge() {
        // Register config screen
        ModLoadingContext.get().registerExtensionPoint(
                IConfigScreenFactory.class,
                () -> (mc, parent) -> ConfigScreenProvider.getConfigScreen(parent)
        );

        // Initialize client
        Scaffold.init();
    }

    /**
     * Registers all keybinds.
     */
    @SubscribeEvent
    static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        Scaffold.KEYBINDS.forEach(event::register);
    }

    @EventBusSubscriber(
            modid = Scaffold.MOD_ID,
            value = Dist.CLIENT
    )
    static class ClientEventHandler {

        /**
         * Registers all client-side commands.
         */
        @SubscribeEvent
        static void registerClientCommands(RegisterClientCommandsEvent event) {
            Commands.register(event.getDispatcher(), event.getBuildContext());
        }

        /**
         * Registers client after-tick event.
         */
        @SubscribeEvent
        public static void registerAfterClientTick(ClientTickEvent.Post event) {
            Scaffold.afterClientTick(Minecraft.getInstance());
        }
    }
}
