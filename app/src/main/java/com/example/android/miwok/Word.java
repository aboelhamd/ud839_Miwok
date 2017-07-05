package com.example.android.miwok;

/**
 * Created by hp on 02/07/2017.
 */

public class Word {
    private String miwokTranslation;
    private String defaultTranslation;
    private int imageId;
    private int audioId;

    public Word(String miwokTranslation, String defaultTranslation, int audioId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.audioId = audioId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageId, int audioId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imageId = imageId;
        this.audioId = audioId;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }


    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public int getImageId() {
        return imageId;
    }

    public int getAudioId() {
        return audioId;
    }
}