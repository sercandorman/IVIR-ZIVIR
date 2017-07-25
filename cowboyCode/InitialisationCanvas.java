package com.ngdroidapp;

import android.graphics.Canvas;

import istanbul.gamelab.ngdroid.base.BaseCanvas;

/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */

public class InitialisationCanvas extends BaseCanvas {

    public InitialisationCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
    }


    public void update() {
        //GameCanvas mc = new GameCanvas(root);
        MenuCanvas mc = new MenuCanvas(root);
        root.canvasManager.setCurrentCanvas(mc);
    }

    public void draw(Canvas canvas) {

    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void touchDown(int x, int y) {

    }

    public void touchMove(int x, int y) {

    }

    public void touchUp(int x, int y) {

    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void reloadTextures() {

    }

    public void showNotify() {

    }

    public void hideNotify() {

    }

}
