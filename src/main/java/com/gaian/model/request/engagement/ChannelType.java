package com.gaian.model.request.engagement;

public enum ChannelType {

    EMAIL("EMAIL"), SMS("SMS"), PUSH_NOTIFICATION("PUSH_NOTIFICATION"), CALLBACK_URL(
        "CALLBACK_URL"), FRS("FRS"), BA("BA"), MEF("MEF");

    private final String mode;

    ChannelType(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return mode;
    }
}
