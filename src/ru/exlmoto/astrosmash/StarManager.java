package ru.exlmoto.astrosmash;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class StarManager {

	public static final int NUMBER_OF_STARS = 50;
	public static final int BLACKCOLOR = 0;
	public static final int WHITECOLOR = 16777215;
	private int m_numStars;
	private int m_width;
	private int m_height;
	private Bitmap m_image;
	private int[] m_xPos;
	private int[] m_yPos;

	public StarManager(int paramInt1, int paramInt2, int paramInt3, int color) {
		AstroSmashActivity.toDebug("Star Manager: " + paramInt1 + "x" + paramInt2);
		this.m_numStars = paramInt3;
		this.m_width = paramInt1;
		this.m_height = paramInt2;
		this.m_image = Bitmap.createBitmap(this.m_width, this.m_height, Bitmap.Config.ARGB_8888); // TODO: Check Config
		// this.m_image = Image.createImage(this.m_width, this.m_height);
		this.m_xPos = new int[this.m_numStars];
		this.m_yPos = new int[this.m_numStars];
		generateStars();
		generateStarImage(color);
	}

	public StarManager(int paramInt1, int paramInt2, int paramInt3) {
		this(paramInt1, paramInt2, 50, paramInt3);
	}

	public void paint(Canvas canvas, Paint paint) {
		// TODO: 20 ?
		// paramGraphics.drawImage(this.m_image, 0, 0, 20);
		canvas.drawBitmap(this.m_image, 0, 0, paint);
	}

	public void generateStars() {
		for (int i = 0; i < this.m_numStars; i++) {
			this.m_xPos[i] = (AstroSmashView.getAbsRandomInt() % this.m_width);
			this.m_yPos[i] = (AstroSmashView.getAbsRandomInt() % this.m_height);
		}
	}

	public void generateStarImage(int color) {
		Canvas canvas = new Canvas(this.m_image);
		Paint paint = new Paint();
		canvas.drawColor(color);
		paint.setColor(AstroSmashVersion.WHITECOLOR);
		for (int i = 0; i < this.m_numStars; i++) {
			canvas.drawPoint(this.m_xPos[i], this.m_yPos[i], paint);
		}
	}

	public Bitmap getStarImage() {
		return this.m_image;
	}
}


/* Location:              /home/exl/Projects/Java/MIDlets-JARs/astrosmash-full.jar!/com/lavastorm/astrosmash/StarManager.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       0.7.1
 */
