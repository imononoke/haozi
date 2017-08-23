package com.isa.haozi.ui;

/**
 * Created by Izumi on 17/8/21.
 */

public interface FreshImageCallback {

    // 预览图片
    void previewImage(int position);

    // 刷新GridView图片
    void updateGridImage(int position);

    // 打开相册
    void openGallery();
}
