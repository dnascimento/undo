/*
 * Author: Dario Nascimento (dario.nascimento@tecnico.ulisboa.pt)
 * 
 * Instituto Superior Tecnico - University of Lisbon - INESC-ID Lisboa
 * Copyright (c) 2014 - All rights reserved
 */
package pt.inesc.redo.core.handlers;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

import pt.inesc.proxy.save.CassandraClient;
import pt.inesc.redo.core.RedoChannelPool;


public class ChannelPack {
    public AsynchronousSocketChannel channel;
    public int bytesToProcess;
    public ByteBuffer buffer;
    public AtomicInteger sentCounter;
    public CassandraClient cassandra;
    public long reqId;
    public RedoChannelPool pool;

    public ChannelPack(AsynchronousSocketChannel channel,
            ByteBuffer buffer,
            CassandraClient cassandra,
            RedoChannelPool redoChannelPool) {
        this.channel = channel;
        this.buffer = buffer;
        this.cassandra = cassandra;
        this.pool = redoChannelPool;
    }

    public void reset(int bytesToProcess, AtomicInteger sentCounter, long reqId) {
        this.bytesToProcess = bytesToProcess;
        this.sentCounter = sentCounter;
        this.reqId = reqId;
    }

    public void renew() {
        buffer.clear();
        pool.returnChannel(this);
    }



}