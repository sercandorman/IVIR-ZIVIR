package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;


/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */


public class GameCanvas extends BaseCanvas {


    private Bitmap tileset, cowboy, bullet, enemy, enemylaser;
    private Rect tilesrc, tiledst, cowboysrc, cowboydst, bulletsrc, enemysrc, enemydst, enemylasersrc, enemylaserdst, enemylaserdst2;
    private int cowboyx, cowboyy;
    private int speedx, speedy, speed, enemyspeed;
    private int touchx, touchy;
    private int cowboydirection;
    private int frameno;
    private int bulletx, bullety, bulletssize;
    private List<Rect> bullets;
    private List<Integer[]> bulletsspeed;
    private int enemyx, enemyy, enemydirection;
    private Boolean laserisfired, laserLeft, laserRight;
    private int SOUND_EXPLOSION;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        Log.i(TAG, "setup");
        loadImages();
        loadSounds();
        tilesrc = new Rect(0, 0, 64, 64);
        tiledst = new Rect(0, 0, 128, 128);
        speedx=0; cowboyy=0;
        speed=10;
        speedx=0; speedy=0;
        cowboydirection=0;
        frameno=0;
        cowboysrc = new Rect(0, 0, 128, 128);
        cowboydst = new Rect(getWidthHalf()-128, getHeightHalf()-128, getWidthHalf()+128, getHeightHalf()+128);
        touchx = 0; touchy = 0;

        bulletx=245;
        bullety=92;
        bullets=new ArrayList<>();
        bulletsspeed=new ArrayList<>();
        bulletsrc=new Rect(0,0,70,70);
        //bulletdst=new Rect(bulletx,bullety,bulletx+32,bullety+32);
        bulletssize=40;

        enemysrc = new Rect(0,0,170,260);
        enemyspeed = 20; enemydirection = 0;
        enemyx = getWidth()-170;
        enemyy = getHeight()-260;
        enemylasersrc= new Rect(0, 0, 64, 128);
        laserisfired=false; laserLeft=false; laserRight=false;
        SOUND_EXPLOSION=1;
    }

    void loadImages(){
        tileset = Utils.loadImage(root, "images/tilea2.png");
        cowboy = Utils.loadImage(root, "images/cowboy.png");
        bullet = Utils.loadImage(root,"images/bullet.png");
        enemy = Utils.loadImage(root,"images/enemy.png");
        enemylaser = Utils.loadImage(root,"images/beams1.png");
    }

    void loadSounds(){
        try{
            SOUND_EXPLOSION=root.soundManager.load("sounds/se2.wav");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    void collisionControl(){
        cowboydst.set(cowboyx, cowboyy, cowboyx+256, cowboyy+256);
        if(laserisfired) {
            if(laserLeft && cowboydst.intersect(enemylaserdst)){
                laserLeft=false;
                root.soundManager.play(SOUND_EXPLOSION);
            }
            if(laserRight && cowboydst.intersect(enemylaserdst2)){
                laserRight=false;
                root.soundManager.play(SOUND_EXPLOSION);
            }
            if(!laserLeft && !laserRight){
                laserisfired=false;
            }
        }
    }

    void addBullet(int direction) {

        int offsetx = 0;
        int offsety=0;

        if(direction==0){
            offsetx=240;
            offsety=95;
        }
        else if (direction==1){
            offsetx=16;
            offsety=95;
        }
        else if (direction==9){
            offsetx=108;
            offsety=240;
        }
        else if (direction==5){
            offsetx=108;
            offsety=16;
        }
        bullets.add(new Rect((cowboyx+offsetx), (cowboyy+offsety), (cowboyx+offsetx+bulletssize), (cowboyy+offsety+bulletssize)));
        switch (direction){
            case 0: bulletsspeed.add(new Integer []{20,0}); break;
            case 1: bulletsspeed.add(new Integer []{-20,0}); break;
            case 9: bulletsspeed.add(new Integer []{0,20}); break;
            case 5: bulletsspeed.add(new Integer []{0,-20}); break;
        }

    }

    void bulletDestroy(){
        for(int i=0;i<bullets.size();i++){
            if(bullets.get(i).left>getWidth() || bullets.get(i).right<0 || bullets.get(i).top>getHeight() || bullets.get(i).bottom<0){
                bullets.remove(i);
                bulletsspeed.remove(i);
                i--;
            }
        }
    }
    public void update() {
        collisionControl();
        Log.i(TAG, "update");
        cowboyx += speedx;
        cowboyy += speedy;

        if (cowboyx>getWidth()-256 /*|| cowboyx<0*/){
            cowboyx=getWidth()-256;
            speedx=0;
        }
        if(cowboyx<0){
            cowboyx=0;
            speedx=0;
        }
        if (cowboyy>getHeight()-256 /*|| cowboyy<0*/){
            cowboyy=getHeight()-256;
            speedy=0;
        }
        if(cowboyy<0){
            cowboyy=0;
            speedy=0;
        }

        if(speedx!=0 || speedy!=0){
            frameno++;
            if(frameno>9){
                frameno=1;
            }
        }
        else{
            frameno=11;
        }
        cowboysrc.set(frameno*128, cowboydirection*128, (frameno+1)*128, (cowboydirection+1)*128);
        cowboydst.set(cowboyx, cowboyy, cowboyx+256, cowboyy+256);
        for (int i=0;i<bullets.size();i++) {
            bullets.get(i).left+=bulletsspeed.get(i)[0];
            bullets.get(i).right+=bulletsspeed.get(i)[0];
            bullets.get(i).top+=bulletsspeed.get(i)[1];
            bullets.get(i).bottom+=bulletsspeed.get(i)[1];

        }
        bulletDestroy();
        Log.i("gc",""+bullets.size());

        if(enemyx<0) {
            enemydirection=1;
        }
        else if(enemyx+170>getWidth()) {
            enemydirection=0;
        }
        if (enemydirection==0){
            enemyx -= enemyspeed;
        }
        else if(enemydirection==1){
            enemyx += enemyspeed;
        }
        enemydst = new Rect(enemyx, enemyy, enemyx+170, enemyy+260);
        if(!laserisfired){
            enemylaserdst= new Rect(enemydst.left+10, enemydst.top-15, enemydst.left+50, enemydst.top+55);
            enemylaserdst2= new Rect(enemydst.right-55, enemydst.top-15, enemydst.right-15, enemydst.top+55);
            laserisfired=true;
            laserLeft=true;
            laserRight=true;
        }
        else if(laserisfired){
            enemylaserdst.top-=20;
            enemylaserdst.bottom-=20;

            enemylaserdst2.top-=20;
            enemylaserdst2.bottom-=20;
        }
        if(enemylaserdst2.bottom<0 || enemylaserdst.bottom<0){
            laserisfired=false;
        }
    }

    public void draw(Canvas canvas) {
        Log.i(TAG, "draw");
        //canvas.drawBitmap(tileset, tilesrc, tiledst, null);
        for (int i = 0; i < getWidth(); i += 128) {
            for (int j = 0; j < getHeight(); j += 128) {
                tiledst.set(i, j, i + 128, j + 128);
                canvas.drawBitmap(tileset, tilesrc, tiledst, null);
            }
        }

        for (Rect dst : bullets) {
            canvas.drawBitmap(bullet,bulletsrc,dst,null);
        }

        canvas.drawBitmap(cowboy, cowboysrc, cowboydst, null);
        canvas.drawBitmap(enemy, enemysrc, enemydst, null);
        if(laserLeft) {
            canvas.drawBitmap(enemylaser, enemylasersrc, enemylaserdst, null);
        }
        if(laserRight) {
            canvas.drawBitmap(enemylaser, enemylasersrc, enemylaserdst2, null);
        }
    }
    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void touchDown(int x, int y) {
        touchx = x;
        touchy = y;
    }

    public void touchMove(int x, int y) {
    }

    public void touchUp(int x, int y) {
        if(x>touchx+100){
            speedx=speed;
            speedy=0;
            cowboydirection=0;
        }
        else if(x<touchx-100){
            speedx= -speed;
            speedy=0;
            cowboydirection=1;
        }
        else if(y>touchy+100){
            speedy=speed;
            speedx=0;
            cowboydirection=9;
        }
        else if(y<touchy-100){
            speedy=-speed;
            speedx=0;
            cowboydirection=5;
        }
        else{
            speedx=0;
            speedy=0;
            addBullet(cowboydirection);
        }
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
