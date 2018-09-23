/*
 * Copyright (C) 2018 Andrea Binello ("andbin")
 *
 * This file is part of the "Swing JTable Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.jtabledemos.common.resource;

import java.awt.Image;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;

public class Resources {
    public static final String APP_ICON_16_PNG = "app-icon-16.png";
    public static final String APP_ICON_24_PNG = "app-icon-24.png";
    public static final String APP_ICON_32_PNG = "app-icon-32.png";
    public static final String APP_ICON_48_PNG = "app-icon-48.png";
    public static final String APP_ICON_64_PNG = "app-icon-64.png";
    public static final String APP_ICON_96_PNG = "app-icon-96.png";
    public static final String APP_ICON_128_PNG = "app-icon-128.png";

    private Resources() {}   // Prevents instantiation

    public static List<Image> loadWindowIcons() {
        return Arrays.asList(
                loadImage(APP_ICON_16_PNG),
                loadImage(APP_ICON_24_PNG),
                loadImage(APP_ICON_32_PNG),
                loadImage(APP_ICON_48_PNG),
                loadImage(APP_ICON_64_PNG),
                loadImage(APP_ICON_96_PNG),
                loadImage(APP_ICON_128_PNG));
    }

    public static ImageIcon loadLargeIcon() {
        return loadIcon(APP_ICON_128_PNG);
    }

    public static Image loadImage(String resourceName) {
        return loadIcon(resourceName).getImage();
    }

    public static ImageIcon loadIcon(String resourceName) {
        URL resourceUrl = Resources.class.getResource(resourceName);

        if (resourceUrl == null) {
            throw new RuntimeException("Resource not found: " + resourceName);
        }

        return new ImageIcon(resourceUrl);
    }
}
