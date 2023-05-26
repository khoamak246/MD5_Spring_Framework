package com.uploadmusic.upload_music.service;

import com.uploadmusic.upload_music.model.Audio;

import java.util.List;

public interface IAudioService {
    List<Audio> findAll();

    void save(Audio audio);

    Audio findById(int id);

    void update(int id, Audio audio);

    void remove(int id);
}


