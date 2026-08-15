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
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;

@SuppressWarnings("unused")
public class ScaffoldFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register keybinds
        Scaffold.KEYBINDS.forEach(KeyMappingHelper::registerKeyMapping);

        // Register client commands
        ClientCommandRegistrationCallback.EVENT.register(Commands::register);

        // Register client after-tick event
        ClientTickEvents.END_CLIENT_TICK.register(Scaffold::afterClientTick);

        // Initialize client
        Scaffold.init();
    }
}
