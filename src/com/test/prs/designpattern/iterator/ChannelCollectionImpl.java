package com.test.prs.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {

    private List<Channel> channelList;

    public ChannelCollectionImpl() {
        this.channelList = new ArrayList<>();
    }

    @Override
    public void addChannel(Channel c) {
        this.channelList.add(c);
    }

    @Override
    public void removeChannel(Channel c) {
        this.channelList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelType type) {
        return new ChannelIteratorImpl(type,this.channelList);
    }

    private class ChannelIteratorImpl implements ChannelIterator{

        private ChannelType type;
        private List<Channel> channelList;
        private int position;

        public ChannelIteratorImpl(ChannelType type, List<Channel> channelList) {
            this.type = type;
            this.channelList = channelList;
        }

        @Override
        public boolean hasNext() {
            while (position<channelList.size()){
                Channel c = channelList.get(position);
                if(c.getType().equals(type) || this.type.equals(ChannelType.ALL))
                    return true;
                else
                    position++;
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel c = channelList.get(position);
            position++;
            return c;
        }
    }
}
