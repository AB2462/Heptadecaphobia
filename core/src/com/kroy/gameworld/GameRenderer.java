package com.kroy.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.kroy.gameobjects.Firetruck;
import com.kroy.helpers.AssetLoader;
import com.badlogic.gdx.graphics.g2d.Animation;

public class GameRenderer {
	
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	
	private SpriteBatch batcher;
	
	private int midPointY;
	private int gameHeight;
	
	private Firetruck truck;
    private Animation truckAnimation, truckLeftAnimation, truckRightAnimation;
    private TextureRegion truckStraight, truckLeft, truckRight, truckStraight1, truckLeft1, truckRight1;
	
	public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;
        
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;
        
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 500, gameHeight);
        
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        
        initGameObjects();
        initAssets();
        
    }
	
	private void initGameObjects() {
        truck = myWorld.getFiretruck();
    }
	
	private void initAssets() {
        truckAnimation = AssetLoader.truckAnimation;
        truckLeftAnimation = AssetLoader.truckLeftAnimation;
        truckRightAnimation = AssetLoader.truckRightAnimation;
        truckStraight = AssetLoader.truck;
        truckLeft = AssetLoader.truckLeft;
        truckRight = AssetLoader.truckRight;
        truckStraight1 = AssetLoader.truck1;
        truckLeft1 = AssetLoader.truckLeft1;
        truckRight1 = AssetLoader.truckRight1;
    }
	
	public void render(float runTime) {

        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeType.Filled);

        // Draw Background colour
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 500, this.gameHeight);

        // End ShapeRenderer
        shapeRenderer.end();

        // Begin SpriteBatch
        batcher.begin();
        batcher.enableBlending();
        
        
        
        if (myWorld.isReady()) {
            AssetLoader.shadow.draw(batcher, "Click to Start", 50, 100);
            AssetLoader.font.draw(batcher, "Click to Start", 50, 100);
        } else if (myWorld.isGameOver()) {
                AssetLoader.shadow.draw(batcher, "Game Over", 25, 56);
                AssetLoader.font.draw(batcher, "Game Over", 24, 55);
        } else if (myWorld.isRunning()) {
        	batcher.draw((TextureRegion) truckAnimation.getKeyFrame(runTime),  truck.getX(),
            		truck.getY(), truck.getWidth() / 2.0f,
            		truck.getHeight() / 2.0f, truck.getWidth(), truck.getHeight(),
            		1, 1, truck.getRotation());
        }
        
        // End SpriteBatch
        batcher.end();

    }
}
