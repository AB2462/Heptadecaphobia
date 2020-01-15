# Heptadecaphobia
package com.kroy.gameworld;

import com.kroy.helpers.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.kroy.gameobjects.Firetruck;
import com.kroy.helpers.AssetLoader;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class GameRenderer {
	
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private InputHandler inputHandler;
	private SpriteBatch batcher;
	
	private Firetruck truck;
    private Animation truckAnimation, truckLeftAnimation, truckRightAnimation;
    private TextureRegion truckStraight, truckLeft, truckRight, truckStraight1, truckLeft1, truckRight1;
	
    private Texture backgroundTexture;
    private Sprite background;
    
    
	public GameRenderer(GameWorld world) {
        myWorld = world;
        InputHandler inputHandler = new InputHandler(myWorld);
        
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
        
        cam = new OrthographicCamera(1000, 1000*(h/w));
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        cam.translate(500f, 500f, 0);
        
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
        
        backgroundTexture = AssetLoader.map;
        background = new Sprite(backgroundTexture);
    }
	
	public void render(float runTime) {

        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batcher.setProjectionMatrix(cam.combined);
        
        if (myWorld.isReady()) {
        	shapeRenderer.begin(ShapeType.Filled);

            // Draw Background colour
            shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
            shapeRenderer.rect(0, 0, 500, Gdx.graphics.getHeight());

            shapeRenderer.end();
        } else {
        	batcher.begin();
        	background.draw(batcher);
        	batcher.end();
        }
        
        
        // Begin SpriteBatch
        batcher.begin();
        //batcher.enableBlending();
        
        
        
        if (myWorld.isReady()) {
            startMenu();
        } else if (myWorld.isGameOver()) {
        	gameOver();
        } else if (myWorld.isRunning()) {
        	gameRunning(runTime);
        	moveCamera();
        }
        
        // End SpriteBatch
        batcher.end();
        
        

    }
	
	public void startMenu() {
		AssetLoader.shadow.draw(batcher, "Click to Start", 50, 100);
        AssetLoader.font.draw(batcher, "Click to Start", 50, 100);
	}
	
	public void gameOver() {
		AssetLoader.shadow.draw(batcher, "Game Over", 25, 56);
        AssetLoader.font.draw(batcher, "Game Over", 24, 55);	
	}
	
	public void gameRunning(float runTime) {
		batcher.draw((TextureRegion) truckAnimation.getKeyFrame(runTime),  truck.getX(),
        		truck.getY(), 0,
        		0, truck.getWidth(), truck.getHeight(),
        		1, 1, truck.getRotation());
	}
	
	public void moveCamera() {
		cam.translate(1f,1f);
		System.out.println(cam.position.x);
		System.out.println();
		cam.update();
	}
}
