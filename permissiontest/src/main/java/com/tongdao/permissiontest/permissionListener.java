package com.tongdao.permissiontest;

import java.util.List;

/**
 * 接口回调
 */

public interface permissionListener {
    /**
     * 授权成功
     */
    void onGranted();

    /**
     * 授权失败
     *
     * @param deniedPermissions
     */
    void onDenied(List<String> deniedPermissions);
}
