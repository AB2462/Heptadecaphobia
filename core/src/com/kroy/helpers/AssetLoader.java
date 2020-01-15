package com.kroy.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

    public static Texture texture;

    public static Animation truckAnimation;
    public static TextureRegion truck, truckLeft, truckRight, truck1, truckLeft1, truckRight1;
    public static BitmapFont font, shadow;

    public static void load() {

        texture = new Texture(Gdx.files.internal("KroyTexture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        truck = new TextureRegion(texture, 5, 1, 72, 105);
        truck.flip(false, true);
        
        truck1 = new TextureRegion(texture, 80, 1, 72, 105);
        truck1.flip(false, true);

        TextureRegion[] truckStraight = { truck, truck1 };
        truckAnimation = new Animation(0.1f, truckStraight);
        truckAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        
        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        font.getData().setScale(.75f, -.75f);
        shadow = new BitmapFont(Gdx.files.internal("shadow.fnt"));
        shadow.getData().setScale(.75f, -.75f);
    }

    public static void dispose() {
        texture.dispose();
        font.dispose();
        shadow.dispose();
    }

}