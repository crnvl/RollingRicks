package bot.listeners;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import processing.VideoProcessor;
import processing.VideoRuntime;

import java.io.File;
import java.util.Objects;

public class VideoListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if(event.getAuthor().isBot())
            return;

        if (event.getMessage().getAttachments().size() != 1)
            return;

        if (!event.getMessage().getAttachments().get(0).isVideo())
            return;


        VideoProcessor.cleanUp();
        Message.Attachment video = event.getMessage().getAttachments().get(0);

        if(!Objects.equals(video.getFileExtension(), "mp4"))
            return;

        video.downloadToFile(new File("./processing/input." + video.getFileExtension()));

        if (VideoRuntime.processInput()) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getChannel().sendFile(new File("./processing/out.mp4")).queue();
        }
    }
}
