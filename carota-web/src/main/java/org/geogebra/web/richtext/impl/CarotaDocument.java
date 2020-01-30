package org.geogebra.web.richtext.impl;

import com.google.gwt.canvas.dom.client.Context2d;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class CarotaDocument {

	public native void draw(Context2d canvasElement);

	public native void select(int start, int end);

	public native void select(int start, int end, boolean takeFocus);

	public native CarotaNode byCoordinate(int x, int y);

	public native CarotaRange selectedRange();

	public native CarotaRange documentRange();

	public native void insertHyperlink(String url, String text);

	public native void setWidth(int width);

	@JsProperty
	public native CarotaFrame getFrame();
}