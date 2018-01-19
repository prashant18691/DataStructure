package com.test.prs.designpattern.iterator;

public class IteratorPattern {
    public static void main(String[] args) {
        ChannelCollection channelCollection = populateChannels();
        ChannelIterator baseIterator  = channelCollection.iterator(ChannelType.ALL);
        while(baseIterator.hasNext()){
            System.out.println(baseIterator.next().toString());
        }
        System.out.println("*************************");
        ChannelIterator englishIterator = channelCollection.iterator(ChannelType.ENGLISH);
        while (englishIterator.hasNext()){
            System.out.println(englishIterator.next().toString());
        }
        System.out.println("*************************");
        ChannelIterator hindiIterator = channelCollection.iterator(ChannelType.HINDI);
        while (hindiIterator.hasNext()){
            System.out.println(hindiIterator.next().toString());
        }
    }

    private static ChannelCollection populateChannels() {
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, ChannelType.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelType.HINDI));
        channels.addChannel(new Channel(100.5, ChannelType.FRENCH));
        channels.addChannel(new Channel(101.5, ChannelType.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelType.HINDI));
        channels.addChannel(new Channel(103.5, ChannelType.FRENCH));
        channels.addChannel(new Channel(104.5, ChannelType.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelType.HINDI));
        channels.addChannel(new Channel(106.5, ChannelType.FRENCH));
        return channels;
    }
}

