package com.topzuqiu.lib_common.utils;

import me.weyye.hipermission.PermissionCallback;

/**
 * Created by rocky on 2018/6/19.
 */

public class PermissionUtil {

   /* public static void requestPermission(List<PermissionItem> permissionItems, PermissionCallback permissionCallback) {

        HiPermission.create(App.getInstance())
                .title("比数权限")
                .permissions(permissionItems)
                .filterColor(ResourcesCompat.getColor(App.getInstance().getResources(), R.color.colorPrimary, App.getInstance().getTheme()))//permission icon color
                .msg(String.format(App.getInstance().getResources().getString(R.string.permission_dialog_msg), App.getInstance().getResources().getString(R.string.app_name)))
                .style(R.style.PermissionDefaultGreenStyle)
                .checkMutiPermission(permissionCallback);
    }*/

    public static class SimplePermissionCallback implements PermissionCallback {

        @Override
        public void onClose() {

        }

        @Override
        public void onFinish() {

        }

        @Override
        public void onDeny(String permission, int position) {

        }

        @Override
        public void onGuarantee(String permission, int position) {

        }

    }
}
