/*
 * This Source Code Form is subject to the terms of the
 * Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.terminalmc.scaffold.mixin;

import dev.terminalmc.scaffold.Scaffold;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {

    @Inject(
            method = "init()V",
            at = @At("HEAD")
    )
    private void init(CallbackInfo info) {
        Scaffold.LOG.info("This line is printed by an example mod mixin from NeoForge!");
        Scaffold.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}
