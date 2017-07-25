package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by noyan on 27.06.2016.
 * Nitra Games Ltd.
 */

public class MenuCanvas extends BaseCanvas {

    private Bitmap background;
    private Rect backgroundsrc, backgrounddst;

    public MenuCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        background = Utils.loadImage(root, "images/bg.jpg");
        backgroundsrc = new Rect(0, 0, 1080, 1920);
        backgrounddst = new Rect(0, 0, getWidth(), getHeight());
    }

    public void update() {
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(background, backgroundsrc, backgrounddst, null);
    }

    public void keyPressed(int key) {
    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return false;
    }

    public void touchDown(int x, int y) {
    }

    public void touchMove(int x, int y) {
    }

    public void touchUp(int x, int y) {
    }

    public void surfaceChanged(int width, int height) {
        Log.i("MC", "surfaceChanged");
    }

    public void surfaceCreated() {
        Log.i("MC", "surfaceCreated");
    }

    public void surfaceDestroyed() {
        Log.i("MC", "surfaceDestroyed");
    }

    public void pause() {
        Log.i("MC", "pause");
    }

    public void resume() {
        Log.i("MC", "resume");
    }

    public void reloadTextures() {
        Log.i("MC", "reloadTextures");
    }

    public void showNotify() {
        Log.i("MC", "showNotify");
    }

    public void hideNotify() {
        Log.i("MC", "hideNotify");
    }

}
