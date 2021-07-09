package bot;

import bot.listeners.VideoListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;


import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        JDABuilder builder = JDABuilder.createDefault("ODYyNjg5MTQ4NjEwNjc0NzA5.YOb_4Q.Mvkhp55jj2fNi6BEqXiVZBAliYk");

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setCompression(Compression.NONE);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("\"Never Gonna Give You Up\" on YouTube"));

        builder.addEventListeners(new VideoListener());

        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }


}
