package com.uploadmusic.upload_music.service;

import com.uploadmusic.upload_music.model.Audio;

import java.util.ArrayList;
import java.util.List;

public class AudioServiceIMPL implements IAudioService{
    private List<Audio> audios = new ArrayList<>();

    @Override
    public List<Audio> findAll() {
        return audios;
    }

    @Override
    public void save(Audio audio) {
        audios.add(audio);
    }

    @Override
    public Audio findById(int id) {
        return audios.get(id);
    }

    @Override
    public void update(int id, Audio audio) {
        for (Audio p : audios) {
            if (p.getId() == id) {
                p = audio;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i).getId() == id) {
                audios.remove(i);
                break;
            }
        }
    }

}
