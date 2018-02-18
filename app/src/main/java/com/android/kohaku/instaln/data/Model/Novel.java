package com.android.kohaku.instaln.data.Model;

import lombok.Data;

/**
 * Created by monis.q on 04-02-2018.
 */

@Data
public class Novel {

    public Novel(String novelName, String novelUrl) {
        this.novelName = novelName;
        this.novelUrl = novelUrl;
    }

    String novelName;

    String novelUrl;
}
