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

package dev.terminalmc.scaffold.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.terminalmc.scaffold.gui.screen.ConfigScreenProvider;

@SuppressWarnings("unused")
public class ModMenuImpl implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ConfigScreenProvider::getConfigScreen;
    }
}
