package pt.inesc.proxy.save;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.WritableByteChannel;

public class SaveFile extends
        SaveThread {
    private final String FOLDER = "requests/";
    private final String EXTENSION = ".txt";
    SaveType type;
    int end;
    WritableByteChannel channel;

    public SaveFile(SaveType type, int start, int end) {
        super(type, start, end);
        this.type = type;
        this.end = end;
    }

    @SuppressWarnings("resource")
    @Override
    WritableByteChannel getChannel() throws IOException {
        File temp = new File(FOLDER + type + end + EXTENSION);
        RandomAccessFile file;
        file = new RandomAccessFile(temp, "rw");
        channel = file.getChannel();
        return channel;
    }

    @Override
    void closeChannel() throws IOException {
        channel.close();
    }


}
