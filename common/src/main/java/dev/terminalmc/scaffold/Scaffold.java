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

import com.mojang.blaze3d.platform.InputConstants;
import dev.terminalmc.scaffold.config.Config;
import dev.terminalmc.scaffold.gui.screen.ConfigScreenProvider;
import dev.terminalmc.scaffold.util.Logging;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static dev.terminalmc.scaffold.util.Localization.translationKey;

public class Scaffold {

    public static final String MOD_ID = "scaffold";
    public static final String MOD_NAME = "Scaffold";
    public static final Logger LOG = Logging.getLogger(MOD_ID);
    public static final Component PREFIX = Component.empty()
            .append(Component.literal("[").withStyle(ChatFormatting.DARK_GRAY))
            .append(Component.literal(MOD_NAME).withStyle(ChatFormatting.GOLD))
            .append(Component.literal("] ").withStyle(ChatFormatting.DARK_GRAY))
            .withStyle(ChatFormatting.GRAY);
    public static final KeyMapping.Category KEY_CATEGORY =
            KeyMapping.Category.register(Identifier.fromNamespaceAndPath(MOD_ID, "group"));
    public static final KeyMapping EXAMPLE_KEY = new KeyMapping(
            translationKey("key", "group.example"),
            InputConstants.Type.KEYSYM,
            InputConstants.UNKNOWN.getValue(),
            KEY_CATEGORY
    );
    public static final List<KeyMapping> KEYBINDS = List.of(
            EXAMPLE_KEY
    );

    private Scaffold() {
        throw new UnsupportedOperationException("This class cannot be instantiated.");
    }

    /**
     * Client initialization.
     */
    public static void init() {
        Config.getAndSave();
    }

    /**
     * Client after-tick event listener.
     */
    public static void afterClientTick(Minecraft mc) {
        // Check mod keybindings
        while (EXAMPLE_KEY.consumeClick()) {
            mc.setScreen(ConfigScreenProvider.getConfigScreen(mc.screen));
        }
    }

    /**
     * Config save listener.
     */
    public static void onConfigSaved(Config config) {
        // If you are maintaining caches based on config, update them here.
    }
}
