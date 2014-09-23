/*
 * Copyright (C) 2014 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.ehviewer.util;

import java.io.File;

public final class EhUtils {

    public static final String EH_DOWNLOAD_FILENAME = ".ehviewer";

    /**
     * Get gallery for read and download
     * @param gid
     * @param title
     * @return
     */
    public static File getGalleryDir(int gid, String title) {
        return new File(Config.getDownloadPath(),
                Utils.standardizeFilename(gid + "-" + title));
    }

    public static int getGidFromDirname(String dirname) {
        int index = dirname.indexOf('-');
        if (index == -1)
            return 0;
        else
            return Utils.parseIntSafely(dirname.substring(0, index), 0);
    }

    /**
     * Index start from 0
     *
     * @param index
     * @param extension
     * @return
     */
    public static String getImageFilename(int index, String extension) {
        return String.format("%08d.%s", index + 1, extension);
    }


    public static String[] getPossibleImageFilenames(int index) {
        String prefix = String.format("%08d.", index + 1);
        return new String[]{prefix + "jpg", prefix + "jpeg", prefix + "png", prefix + "gif"};
    }

}
