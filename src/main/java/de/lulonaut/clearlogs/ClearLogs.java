package de.lulonaut.clearlogs;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
                    //Delete all but the latest log
                    if (file.getName().endsWith("log.gz")) {
                        file.delete();
                    }
                }
            }
        }
        File crashReportsFolder = new File(Minecraft.getMinecraft().mcDataDir, "crash-reports");
        if (crashReportsFolder.exists()) {
            File[] reports = crashReportsFolder.listFiles();
            if (reports != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                String formattedDate = dateFormat.format(new Date());
                for (File report : reports) {
                    //Delete all reports that are not from today
                    if (!report.getName().startsWith("crash-" + formattedDate)) {
                        report.delete();
                    }
                }
            }
        }
    }
}
