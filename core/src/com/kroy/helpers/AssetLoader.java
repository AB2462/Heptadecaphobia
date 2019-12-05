package com.kroy.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

    public static Texture texture;

    public static Animation truckAnimation;
    public static Animation truckRightAnimation;
    public static Animation truckLeftAnimation;
    public static TextureRegion truck, truckLeft, truckRight, truck1, truckLeft1, truckRight1;

    public static void load() {

        texture = new Texture(Gdx.files.internal("KroyTexture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        truckLeft = new TextureRegion(texture, 154, 1, 76, 105);
        truckLeft.flip(false, true);
        
        truckLeft1 = new TextureRegion(texture, 230, 1, 76, 105);
        truckLeft1.flip(false, true);

        truck = new TextureRegion(texture, 5, 1, 72, 105);
        truck.flip(false, true);
        
        truck1 = new TextureRegion(texture, 80, 1, 72, 105);
        truck1.flip(false, true);

        truckRight = new TextureRegion(texture, 1, 110, 76, 105);
        truckRight.flip(false, true);
        
        truckRight1 = new TextureRegion(texture, 79, 110, 76, 105);
        truckRight1.flip(false, true);

        TextureRegion[] truckStraight = { truck, truck1 };
        TextureRegion[] truckLeftAni = { truckLeft, truckLeft1 };
        TextureRegion[] truckRightAni = { truckRight, truckRight1 };
        truckAnimation = new Animation(0.1f, truckStraight);
        truckLeftAnimation = new Animation(0.1f, truckLeftAni);
        truckRightAnimation = new Animation(0.1f, truckRightAni);
        truckAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        truckLeftAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        truckRightAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
    }

}