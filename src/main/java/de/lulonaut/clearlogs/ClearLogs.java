package de.lulonaut.clearlogs;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;

@Mod(modid = "clearlogs", name = "ClearLogs", version = "1.0")
public class ClearLogs {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        File logsFolder = new File(Minecraft.getMinecraft().mcDataDir, "logs");
        if (logsFolder.exists()) {
            File[] logFiles = logsFolder.listFiles();
            if (logFiles != null) {
                for (File file : logFiles) {
                    if (file.getName().endsWith("log.gz")) {
                        file.delete();
                    }
                }
            }
        }
    }
}
