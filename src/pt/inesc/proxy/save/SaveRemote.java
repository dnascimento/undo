package pt.inesc.proxy.save;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.WritableByteChannel;


public class SaveRemote extends
        SaveThread {

    public SaveRemote(SaveType type, int start, int end, InetAddress address) {
        super(type, start, end);
        // TODO Auto-generated constructor stub
    }

    @Override
    WritableByteChannel getChannel() throws IOException {
        // TODO criar o socket ao servidor remoto
        return null;
    }

    @Override
    void closeChannel() throws IOException {
        // TODO Auto-generated method stub

    }


}
