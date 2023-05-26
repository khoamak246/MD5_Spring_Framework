package com.simpleplaymusic.simpleplaymusicapp.services;

import com.simpleplaymusic.simpleplaymusicapp.models.Audio;

import java.util.List;

public interface IAudioService {
    List<Audio> findAll();

    Audio findById(Long id);

    void deleteById(Long id);

    void save(Audio audio);
}
